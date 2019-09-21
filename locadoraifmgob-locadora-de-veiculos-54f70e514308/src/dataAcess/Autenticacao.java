package dataAcess;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Usuário
 */

public abstract class Autenticacao {
    private static final String SQL_LOGIN = "SELECT cpf FROM sc_filipe_ramos.tb_funcionario WHERE cpf = ? AND senha = MD5(?);";
    
    public static boolean loginValido (String login, String senha) {
        //Tratamento de Dados - Evitar SQL Injection
        login = login.replaceAll("\"", "");
        login = login.replaceAll("'", "");
        login = login.replaceAll("-", "");
        senha = senha.replaceAll("\"", "");
        senha = senha.replaceAll("'", "");
        senha = senha.replaceAll("-", "");
        
        try {
            PreparedStatement st = Conexao.conexao.prepareStatement(SQL_LOGIN);
            st.setString(1, login);
            st.setString(2, senha);
            ResultSet resultado  = st.executeQuery();
            int quantidade = 0;
            while (resultado.next()) {
                quantidade ++;
            }
            resultado.close();
            st.close();
            return quantidade == 1;
        } catch (SQLException e) {
            return false;
        }
    }
    
}
