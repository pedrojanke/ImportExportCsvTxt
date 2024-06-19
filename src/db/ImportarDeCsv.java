package src.db;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImportarDeCsv {

    public void executar(Connection connection) {
        System.out.println("Importando dados de CSV...");

        String csvFile = "importar/importar.csv";
        String csvSplitBy = ";";
        List<String[]> records = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String header = br.readLine(); // Lendo a primeira linha para ignorá-la, se for um cabeçalho
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);

                if (data.length != 6) {
                    System.out.println("Erro: Formato inválido!");
                    return;
                }

                if (validateFields(data[0], data[1], data[2], data[3], data[4], data[5])) {
                    records.add(data);
                } else {
                    System.out.println("Erro na validação dos dados. Importação abortada.");
                    return;
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

    private boolean validateFields(String gender, String category, String media, String mediatype, String classification, String participant) {
        return !gender.isEmpty() && !category.isEmpty() && !media.isEmpty() && !mediatype.isEmpty() && !classification.isEmpty() && !participant.isEmpty();
    }
}
