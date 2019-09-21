package dataAcess;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Endereco;

/**
 * @author Augusto, Erick e Filipe - INFO 2
 */

public abstract class DaoEndereco {
    private static final String SQL_INSERT   = "INSERT INTO sc_filipe_ramos.tb_endereco (rua, bairro, cep_cidade, uf, referencia) VALUES (?, ?, ?, ?, ?) RETURNING id;";
    private static final String SQL_DELETE   = "DELETE FROM sc_filipe_ramos.tb_endereco WHERE id = ?;";
    private static final String SQL_UPDATE   = "UPDATE sc_filipe_ramos.tb_endereco SET rua = ?, bairro = ?, cep_cidade = ?, uf = ?, referencia = ? WHERE id = ?";
    private static final String SQL_SELECT   = "SELECT * FROM sc_filipe_ramos.tb_endereco";
    private static final String SQL_RETRIEVE = "SELECT * FROM sc_filipe_ramos.tb_endereco WHERE id = ?";
    
    
    public static void insert(Endereco endereco) throws Exception {
        PreparedStatement stat = Conexao.conexao.prepareStatement(SQL_INSERT);
        stat.setString(1, endereco.getRua());
        stat.setString(2, endereco.getBairro());
        stat.setString(3, endereco.getCidade());
        stat.setString(4, endereco.getUf());
        stat.setString(5, endereco.getReferencia());
        ResultSet resultado = stat.executeQuery();
        resultado.next();
        endereco.setId(resultado.getInt(1));
        resultado.close();
        stat.close();
    }

    public static void delete(Endereco endereco) throws Exception {
        PreparedStatement stat = Conexao.conexao.prepareStatement(SQL_DELETE);
        stat.setInt(1, endereco.getId());
        stat.execute();
        stat.close();
    }
    
    public static void update (Endereco endereco) throws Exception{
        PreparedStatement stat = Conexao.conexao.prepareStatement(SQL_UPDATE);
        stat.setString(1, endereco.getRua());
        stat.setString(2, endereco.getBairro());
        stat.setString(3, endereco.getCidade());
        stat.setString(4, endereco.getUf());
        stat.setString(5, endereco.getReferencia());
        stat.setInt   (6, endereco.getId());
        System.out.println(stat.toString());
        stat.execute();
        stat.close();
    }
    
    public static ArrayList<Endereco> getList () throws Exception {
        ArrayList<Endereco> enderecos = new ArrayList<>();
        PreparedStatement stat = Conexao.conexao.prepareStatement(SQL_SELECT);
        ResultSet resultado = stat.executeQuery();
        while (resultado.next()) {
            //Instanciação do Endereço
            Endereco endereco = new Endereco();
            endereco.setId        (resultado.getInt("id"));
            endereco.setRua       (resultado.getString("rua"));
            endereco.setBairro    (resultado.getString("bairro"));
            endereco.setCidade    (resultado.getString("cep_cidade"));
            endereco.setUf        (resultado.getString("uf"));
            endereco.setReferencia(resultado.getString("referencia"));
            
            //Armazenar o objeto
            enderecos.add(endereco);
        }
        resultado.close();
        stat.close();
        if (enderecos.isEmpty()){
            throw new Exception ("Nada encontrado");
        }
        //Retorno dos objetos
        return enderecos;
    }

    public static Endereco retrieve (int id) throws Exception {
        PreparedStatement stat = Conexao.conexao.prepareStatement(SQL_RETRIEVE);
        stat.setInt(1, id);
        ResultSet resultado = stat.executeQuery();
        if (resultado.next()) {
            //Instanciação do Endereço
            Endereco endereco = new Endereco();
            endereco.setId        (resultado.getInt("id"));
            endereco.setRua       (resultado.getString("rua"));
            endereco.setBairro    (resultado.getString("bairro"));
            endereco.setCidade    (resultado.getString("cep_cidade"));
            endereco.setUf        (resultado.getString("uf"));
            endereco.setReferencia(resultado.getString("referencia"));
            
            resultado.close();
            stat.close();
            //Retorno do objeto
            return endereco;
        } else {
            resultado.close();
            stat.close();
            throw new Exception ("Nada encontrado");
        }
    }
    
}
