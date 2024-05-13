package src.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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

