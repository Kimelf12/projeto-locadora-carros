package dataAcess;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import modelo.Aluguel;


/**
 * @author Augusto, Erick e Filipe - INFO 2
 */

public abstract class DaoAluguel {
    private static final String SQL_INSERT   = "INSERT INTO sc_filipe_ramos.tb_aluguel (cliente, carro, funcionario, data_aluguel, data_devolucao, data_previsao, valor, devolvido, pago) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING id;";
    private static final String SQL_DELETE   = "DELETE FROM sc_filipe_ramos.tb_aluguel WHERE id = ?";
    private static final String SQL_UPDATE   = "UPDATE sc_filipe_ramos.tb_aluguel SET data_devolucao = ?, valor = ?, devolvido = ?, pago = ? WHERE id = ?";
    private static final String SQL_SELECT   = "SELECT * FROM sc_filipe_ramos.tb_aluguel";
    private static final String SQL_RETRIEVE = "SELECT * FROM sc_filipe_ramos.tb_aluguel WHERE id = ?";
    
    public static void insert(Aluguel aluguel) throws Exception {
        PreparedStatement stat = Conexao.conexao.prepareStatement(SQL_INSERT);
        stat.setString   (1, aluguel.getCliente().getCpf());
        stat.setString   (2, aluguel.getCarro().getPlaca());
        stat.setString   (3, aluguel.getFuncionario().getCpf());
        stat.setTimestamp(4, Timestamp.valueOf(aluguel.getDataSaida()));
        stat.setTimestamp(5, Timestamp.valueOf(aluguel.getDataChegada()));
        stat.setTimestamp(6, Timestamp.valueOf(aluguel.getDataPrevisao()));
        stat.setFloat    (7, aluguel.getValor());
        stat.setBoolean  (8, aluguel.isDevolvido());
        stat.setBoolean  (9, aluguel.isPago());
        ResultSet resultado = stat.executeQuery();
        resultado.next();
        aluguel.setId(resultado.getInt(1));
        resultado.close();
        stat.close();
    }

    public static void delete(Aluguel aluguel) throws Exception {
        PreparedStatement stat = Conexao.conexao.prepareStatement(SQL_DELETE);
        stat.setInt(1, aluguel.getId());
        stat.execute();
        stat.close();
    }
    
    public static void update (Aluguel aluguel) throws Exception{
        PreparedStatement stat = Conexao.conexao.prepareStatement(SQL_UPDATE);
        stat.setTimestamp(1, Timestamp.valueOf(aluguel.getDataChegada()));
        stat.setFloat    (2, aluguel.getValor());
        stat.setBoolean  (3, aluguel.isDevolvido());
        stat.setBoolean  (4, aluguel.isPago());
        stat.setInt      (5, aluguel.getId());
        stat.execute();
        stat.close();
    }
    
    private static ArrayList<Aluguel> executarSelect (String sql) throws Exception {
        ArrayList<Aluguel> alugueis = new ArrayList<>();
        PreparedStatement stat = Conexao.conexao.prepareStatement(sql);
        ResultSet resultado = stat.executeQuery();
        while (resultado.next()) {
            //Instanciação do Aluguel
            Aluguel aluguel = new Aluguel();
            aluguel.setId          (resultado.getInt("id"));
            aluguel.setPago        (resultado.getBoolean("pago"));
            aluguel.setValor       (resultado.getFloat("valor"));
            aluguel.setDevolvido   (resultado.getBoolean("devolvido"));
            aluguel.setDataChegada (resultado.getTimestamp("data_devolucao").toLocalDateTime());
            aluguel.setDataSaida   (resultado.getTimestamp("data_aluguel").toLocalDateTime());
            aluguel.setDataPrevisao(resultado.getTimestamp("data_previsao").toLocalDateTime());
            aluguel.setCarro       (DaoCarro.retrieve(resultado.getString("carro")));
            aluguel.setCliente     (DaoCliente.retrieve(resultado.getString("cliente")));
            aluguel.setFuncionario (DaoFuncionario.retrieve(resultado.getString("funcionario")));

            //Armazenar o objeto
            alugueis.add(aluguel);
        }
        resultado.close();
        stat.close();
        if (alugueis.isEmpty()){
            throw new Exception ("Nada encontrado");
        }
        //Retorno dos objetos
        return alugueis;
    }
    
    public static ArrayList<Aluguel> getList () throws Exception {
        return executarSelect(SQL_SELECT);
    }
    
    public static ArrayList<Aluguel> getListSemDevolver () throws Exception {
        return executarSelect(SQL_SELECT + " WHERE devolvido = 'False'");
    }
    
    public static ArrayList<Aluguel> getListSemPagar () throws Exception {
        return executarSelect(SQL_SELECT + " WHERE devolvido = 'True' AND pago = 'False'");
    }
    
    public static Aluguel retrieve (int id) throws Exception {
        PreparedStatement stat = Conexao.conexao.prepareStatement(SQL_RETRIEVE);
        stat.setInt(1, id);
        ResultSet resultado = stat.executeQuery();
        if (resultado.next()) {
            //Instanciação do Aluguel
            Aluguel aluguel = new Aluguel();
            aluguel.setId          (resultado.getInt("id"));
            aluguel.setPago        (resultado.getBoolean("pago"));
            aluguel.setValor       (resultado.getFloat("valor"));
            aluguel.setDevolvido   (resultado.getBoolean("devolvido"));
            aluguel.setDataChegada (resultado.getTimestamp("data_devolucao").toLocalDateTime());
            aluguel.setDataSaida   (resultado.getTimestamp("data_aluguel").toLocalDateTime());
            aluguel.setDataPrevisao(resultado.getTimestamp("data_previsao").toLocalDateTime());
            aluguel.setCarro       (DaoCarro.retrieve(resultado.getString("carro")));
            aluguel.setCliente     (DaoCliente.retrieve(resultado.getString("cliente")));
            aluguel.setFuncionario (DaoFuncionario.retrieve(resultado.getString("funcionario")));
            
            //Retorno do objeto
            return aluguel;
        } else {
            resultado.close();
            stat.close();
            throw new Exception ("Nada encontrado");
        }
    }
    
}
