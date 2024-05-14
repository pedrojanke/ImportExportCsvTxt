package src.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Conexao {

    public void connectToDatabase() {
        String url = "jdbc:mysql://localhost:3306/alan-08-05";
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
                    Importar importar = new Importar();
                    Exportar exportar = new Exportar();

                    System.out.println("Digite 1 para importar dados");
                    System.out.println("Digite 2 para exportar dados");
                    int resposta = scanner.nextInt();
                    scanner.close();
                    if (resposta == 1) {
                        importar.executar(connection);
                    } else if (resposta == 2) {
                        exportar.executar(connection);
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
