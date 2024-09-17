package br.com.connectionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    String url = "jdbc:postgresql://localhost:5432/projeto_final";
    String user = "postgres";
    String password = "senha";

    private Connection con;

    public Connection getConnection() {
        try {
            con = DriverManager.getConnection(url, user, password);
            if (con != null) {
                System.out.println("Conexão efetuada com sucesso!");
            }
        }catch (SQLException e) {
            System.err.println("Erro ao conectar ao Banco de Dados: " + e.getMessage());
        }
        return con;
    }

    public static void main(String[] args) {
        Connection conexao = new ConnectionFactory().getConnection();
    }
}