package src.db;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ImportarDeCsv {

    public void executar(Connection connection) {
        System.out.println("Importando dados de csv...");

        String csvFile = "importar/importar.csv";
        String line;
        String csvSplitBy = ";";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String header = br.readLine(); // Lendo a primeira linha para ignorá-la, se for um cabeçalho
            String query = "INSERT INTO integracao_dados (genero, categoria, midia, tipo_midia, classificacao, participante) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(csvSplitBy);

                    String sql = "DELETE FROM integracao_dados";
                    int linhasAfetadas = statement.executeUpdate(sql);

                    System.out.println("Registros excluídos com sucesso: " + linhasAfetadas);

                    if(data.length != 6) {
                        System.out.println("Erro: Formato inválido!");
                        return;
                    }
                    // Substitua os '?' pelos dados do CSV
                    statement.setString(1, data[0]);
                    statement.setString(2, data[1]);
                    statement.setString(3, data[2]);
                    statement.setString(4, data[3]);
                    statement.setString(5, data[4]);
                    statement.setString(6, data[5]);

                    // Execute a inserção
                    statement.executeUpdate();
                }
                System.out.println("Importação concluída com sucesso!");
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

}
