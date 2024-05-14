package src.db;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ExportarParaTxt {

    String filePath = "exportacoes/log.txt";

    public void executar(Connection connection) {
        System.out.println("Exportando dados para txt...");

        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath));
                java.sql.Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM integracao_dados")) {

            ResultSetMetaData metaData = (ResultSetMetaData) resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Escreve os nomes das colunas no arquivo
            for (int i = 1; i <= columnCount; i++) {
                writer.print(metaData.getColumnName(i));
                if (i < columnCount) {
                    writer.print(",");
                } else {
                    writer.println();
                }
            }

            // Escreve os dados da tabela no arquivo
            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    writer.print(resultSet.getString(i));
                    if (i < columnCount) {
                        writer.print(",");
                    } else {
                        writer.println();
                    }
                }
            }

            System.out.println("Exportação concluída com sucesso para " + filePath);
        } catch (SQLException e) {
            System.out.println("Erro ao executar a consulta SQL!");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo!");
            e.printStackTrace();
        }
    }
}
