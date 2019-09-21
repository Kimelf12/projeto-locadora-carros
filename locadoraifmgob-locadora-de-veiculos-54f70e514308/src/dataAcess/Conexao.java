package dataAcess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Augusto, Erick e Filipe - INFO 2
 */

public abstract class Conexao {
    public static Connection conexao;
    private static final String IP        = "200.18.128.55";
    private static final String PORTA     = "5432";
    private static final String DB        = "db_trabalho";
    private static final String USUARIO   = "aula";
    private static final String SENHA     = "aula";
    
    public static boolean conectar () {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://" + IP + ":" + PORTA + "/" + DB;
            conexao = DriverManager.getConnection(url, USUARIO, SENHA);
            return true;
        } catch (ClassNotFoundException | SQLException e) {
            return false;
        }
    }
    
    public static boolean desconectar () {
        try {
            conexao.close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}
