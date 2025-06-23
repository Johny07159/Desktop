package epic.play;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://sql10.freesqldatabase.com:3306/sql10786363";//trocar para online
    private static final String USER = "sql10786363";
    private static final String PASS = "dWXLXg7jML";

    public static Connection conexaoBanco() throws SQLException {
        try {
            Class.forName(DRIVER);
            System.out.println("Conexao 1");
            Connection connection = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Conexao 2");
            return connection;
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver não encontrado: " + ex.getMessage());
        } catch (Exception e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
        }
        return null;
    }

    public static void main(String[] args) throws SQLException {
        Connection conn = conexaoBanco();
        if (conn != null) {
            System.out.println("Conectado com sucesso!");
            conn.close();
        } else {
            System.out.println("Falha na conexão.");
        }
        System.out.println("ola");
    }
}