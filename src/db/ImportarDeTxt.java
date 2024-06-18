package src.db;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ImportarDeTxt {

    public void executar(Connection connection) {
        System.out.println("Importando dados de TXT...");

        String txtFile = "importar/importar.txt";
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(txtFile))) {
            String header = br.readLine(); // Lendo a primeira linha para ignorá-la, se for um cabeçalho
            String query = "INSERT INTO integracao_dados (genero, categoria, midia, tipo_midia, classificacao, participante) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {

                String sql = "DELETE FROM integracao_dados";
                    int linhasAfetadas = statement.executeUpdate(sql);
                    System.out.println("Registros excluídos com sucesso: " + linhasAfetadas);

                while ((line = br.readLine()) != null) {
                    // Extrair os dados conforme a estrutura fixa do arquivo TXT
                    String gender = extractField(line, 0, 50).trim();
                    String category = extractField(line, 51, 100).trim();
                    String media = extractField(line, 101, 300).trim();
                    String mediatype = extractField(line, 301, 350).trim();
                    String classification = extractField(line, 351, 400).trim();
                    String participant = extractField(line, 401, 650).trim();

                    // Define os valores nos parâmetros do PreparedStatement
                    statement.setString(1, gender);
                    statement.setString(2, category);
                    statement.setString(3, media);
                    statement.setString(4, mediatype);
                    statement.setString(5, classification);
                    statement.setString(6, participant);

                    // Executa a inserção
                    statement.executeUpdate();
                }
                System.out.println("Importação concluída com sucesso!");
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para extrair um campo de uma linha com base na posição inicial e final
    private String extractField(String line, int startIndex, int endIndex) {
        // Verifica se os índices estão dentro do comprimento da linha
        if (startIndex >= line.length() || endIndex > line.length() || startIndex > endIndex) {
            return "";
        }
        return line.substring(startIndex, endIndex).trim();
    }
}
