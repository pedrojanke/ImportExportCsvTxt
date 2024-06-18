package src.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Conexao {

    public void connectToDatabase() {
        String url = "jdbc:mysql://localhost:3306/importexportcsvtxt";
        String user = "root";
        String pass = "root";

        {
            try {
                // Registra o driver JDBC
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Estabelece a conexão com o banco de dados
                Connection connection = DriverManager.getConnection(url, user, pass);

                if (connection != null) {
                    System.out.println("Conexão estabelecida com sucesso!");

                    Scanner scanner = new Scanner(System.in);
                    ImportarDeCsv importarDeCsv = new ImportarDeCsv();
                    ImportarDeTxt importarDeTxt = new ImportarDeTxt();
                    ExportarParaCsv exportarParaCsv = new ExportarParaCsv();
                    ExportarParaTxt exportarParaTxt = new ExportarParaTxt();

                    System.out.println("Digite 1 para importar dados de um arquivo CSV");
                    System.out.println("Digite 2 para importar dados de um arquivo TXT");
                    System.out.println("Digite 3 para exportar dados para um arquivo CSV");
                    System.out.println("Digite 4 para exportar dados para um arquivo TXT");
                    int resposta = scanner.nextInt();
                    scanner.close();
                    if (resposta == 1) {
                        importarDeCsv.executar(connection);
                    } else if (resposta == 2) {
                        importarDeTxt.executar(connection);
                    } else if (resposta == 3) {
                        exportarParaCsv.executar(connection);
                    } else if (resposta == 4 ) {
                        exportarParaTxt.executar(connection);
                    } else {
                        System.out.println("Opção inválida!");
                    }

                    connection.close();
                }
            } catch (ClassNotFoundException e) {
                System.out.println("Erro: Driver JDBC não encontrado!");
                e.printStackTrace();
            } catch (SQLException e) {
                System.out.println("Erro ao conectar com o banco de dados!");
                e.printStackTrace();
            }
        }
    }
}
