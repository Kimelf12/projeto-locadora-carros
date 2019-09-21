package dataAcess;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import modelo.Despesa;

/**
 * @author Augusto, Erick e Filipe - INFO 2
 */

public abstract class DaoDespesa {
    private static final String SQL_INSERT   = "INSERT INTO sc_filipe_ramos.tb_despesa (descricao, valor, pago, vencimento, datapagamento) VALUES (?, ?, ?, ?, ?) RETURNING id;";
    private static final String SQL_DELETE   = "DELETE FROM sc_filipe_ramos.tb_despesa WHERE id = ?;";
    private static final String SQL_UPDATE   = "UPDATE sc_filipe_ramos.tb_despesa SET pago = ?, datapagamento = ? WHERE id = ?";
    private static final String SQL_SELECT   = "SELECT * FROM sc_filipe_ramos.tb_despesa";
    private static final String SQL_RETRIEVE = "SELECT * FROM sc_filipe_ramos.tb_despesa WHERE id = ?";
    
    
    public static void insert(Despesa despesa) throws Exception {
        PreparedStatement stat = Conexao.conexao.prepareStatement(SQL_INSERT);
        stat.setString (1, despesa.getDescricao());
        stat.setFloat  (2, despesa.getValor());
        stat.setBoolean(3, despesa.isPago());
        stat.setDate   (4, Date.valueOf(despesa.getVencimento()));
        stat.setDate   (5, Date.valueOf(despesa.getDataPagamento()));
        ResultSet resultado = stat.executeQuery();
        resultado.next();
        despesa.setId(resultado.getInt(1));
        resultado.close();
        stat.close();
    }

    public static void delete(Despesa despesa) throws Exception {
        PreparedStatement stat = Conexao.conexao.prepareStatement(SQL_DELETE);
        stat.setInt(1, despesa.getId());
        stat.execute();
        stat.close();
    }
    
    public static void update (Despesa despesa) throws Exception{
        PreparedStatement stat = Conexao.conexao.prepareStatement(SQL_UPDATE);
        stat.setBoolean(1, despesa.isPago());
        stat.setDate   (2, Date.valueOf(despesa.getDataPagamento()));
        stat.setInt    (3, despesa.getId());
        stat.execute();
        stat.close();
    }
    
    public static ArrayList<Despesa> getList () throws Exception {
        return executarSelect(SQL_SELECT);
    }
    
    public static ArrayList<Despesa> getListSemPagar () throws Exception {
        return executarSelect(SQL_SELECT + " WHERE pago = 'False'");
    }
    
    public static ArrayList<Despesa> getByDia (int dia, int mes, int ano) throws Exception {
        return executarSelect(SQL_SELECT + " WHERE datapagamento = '" + Date.valueOf(LocalDate.now()) + "'"
                           + " OR vencimento = '" + Date.valueOf(LocalDate.now()) + "'");
    }
    
    public static ArrayList<Despesa> getByMes (int mes, int ano) throws Exception {
        return executarSelect(SQL_SELECT + " WHERE DATE_PART('month', datapagamento) = '" + mes + "' AND DATE_PART('year', datapagamento) = '" + ano + "'"
                           + " OR DATE_PART('month', vencimento) = '" + mes + "' AND DATE_PART('year', vencimento) = '" + ano + "'");
    }
    
    public static ArrayList<Despesa> getByAno (int ano) throws Exception {
        return executarSelect(SQL_SELECT + " WHERE DATE_PART('year', datapagamento) = '" + ano + "'"
                           + " OR DATE_PART('year', vencimento) = '" + ano + "'");
    }
    
    private static ArrayList<Despesa> executarSelect (String sql) throws Exception{
        ArrayList<Despesa> despesas = new ArrayList<>();
        PreparedStatement stat = Conexao.conexao.prepareStatement(sql);
        ResultSet resultado = stat.executeQuery();
        while (resultado.next()) {
             //Instanciação da Despesa
            Despesa despesa = new Despesa();
            despesa.setId(resultado.getInt("id"));
            despesa.setDescricao(resultado.getString("descricao"));
            despesa.setValor(resultado.getFloat("valor"));
            despesa.setPago(resultado.getBoolean("pago"));
            despesa.setVencimento(resultado.getDate("vencimento").toLocalDate());
            despesa.setDataPagamento(resultado.getDate("datapagamento").toLocalDate());
            
            //Armazenar o objeto
            despesas.add(despesa);
        }
        resultado.close();
        stat.close();
        if (despesas.isEmpty()){
            throw new Exception ("Nada encontrado");
        }
        //Retorno dos objetos
        return despesas;
    }

    public static Despesa retrieve (int id) throws Exception {
        PreparedStatement stat = Conexao.conexao.prepareStatement(SQL_RETRIEVE);
        stat.setInt(1, id);
        ResultSet resultado = stat.executeQuery();
        if (resultado.next()) {
            //Instanciação do Endereço
            Despesa despesa = new Despesa();
            despesa.setId(resultado.getInt("id"));
            despesa.setDescricao(resultado.getString("descricao"));
            despesa.setValor(resultado.getFloat("valor"));
            despesa.setPago(resultado.getBoolean("pago"));
            despesa.setVencimento(resultado.getDate("vencimento").toLocalDate());
            despesa.setDataPagamento(resultado.getDate("datapagamento").toLocalDate());
            
            //Retorno do objeto
            return despesa;
        } else {
            resultado.close();
            stat.close();
            throw new Exception ("Nada encontrado");
        }
    }
}
