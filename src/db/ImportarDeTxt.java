package src.db;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImportarDeTxt {

    public void executar(Connection connection) {
        System.out.println("Importando dados de TXT...");

        String txtFile = "importar/importar.txt";
        List<String[]> records = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(txtFile))) {
            String header = br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                if (line.length() <= 650) {
                    String gender = line.substring(0, 50).trim();
                    String category = line.substring(51, 100).trim();
                    String media = line.substring(101, 300).trim();
                    String mediatype = line.substring(301, 350).trim();
                    String classification = line.substring(351, 400).trim();
                    String participant = line.substring(401).trim(); // Captura do índice 401 até o

                    if (validateFields(gender, category, media, mediatype, classification, participant)) {
                        records.add(new String[] { gender, category, media, mediatype, classification, participant });
                    } else {
                        System.out.println("Erro na validação dos dados. Importação abortada.");
                        return;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        String query = "INSERT INTO integracao_dados (genero, categoria, midia, tipo_midia, classificacao, participante) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            String sql = "DELETE FROM integracao_dados";
            int linhasAfetadas = statement.executeUpdate(sql);
            System.out.println("Registros excluídos com sucesso: " + linhasAfetadas);

            for (String[] record : records) {
                statement.setString(1, record[0]);
                statement.setString(2, record[1]);
                statement.setString(3, record[2]);
                statement.setString(4, record[3]);
                statement.setString(5, record[4]);
                statement.setString(6, record[5]);

                statement.executeUpdate();
            }
            System.out.println("Importação concluída com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private String extractField(String line, int startIndex, int endIndex) {
        if (startIndex >= line.length() || endIndex > line.length() || startIndex > endIndex) {
            return "";
        }
        return line.substring(startIndex, endIndex).trim();
    }

    private boolean validateFields(String gender, String category, String media, String mediatype,
            String classification, String participant) {
        return !gender.isEmpty() && !category.isEmpty() && !media.isEmpty() && !mediatype.isEmpty()
                && !classification.isEmpty() && !participant.isEmpty();
    }
}
