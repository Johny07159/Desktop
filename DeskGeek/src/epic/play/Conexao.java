package epic.play;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3307/filme";//trocar para online
    private static final String USER = "senac";
    private static final String PASS = "123";

    public static Connection conexaoBanco() throws SQLException {
        try {
            DebugLoggerSwing.log("Tentando Conexão com o Banco de Dados");
            Class.forName(DRIVER);
          
            Connection connection = DriverManager.getConnection(URL, USER, PASS);
           
            DebugLoggerSwing.log("Conexão com o Sistema Bem Sucessida");
            return connection;
            
        } catch (ClassNotFoundException ex) {
            DebugLoggerSwing.log("Driver do Banco Não Encontrado"+ ex.getMessage());
        } catch (Exception e) {
          DebugLoggerSwing.log("Erro Ao Conectar no Banco de Dados"+e.getMessage());
        }
        return null;
    }

    public static void main(String[] args) throws SQLException {
        Connection conn = conexaoBanco();
        if (conn != null) {
              DebugLoggerSwing.log("Conexão com o Sistema Bem Sucessida segunda mensagem de confirmação");
            conn.close();
        } else {
              DebugLoggerSwing.log("falha na conexão");
        }
           }
}