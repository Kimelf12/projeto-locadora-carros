package dataAcess;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Endereco;
import modelo.Locadora;

/**
 * @author Augusto, Erick e Filipe - INFO 2
 */

public  abstract class DaoLocadora {
    private static final String SQL_INSERT   = "INSERT INTO sc_filipe_ramos.tb_locadora (cnpj, nome, conta_bancaria, endereco, data_fun) VALUES (?, ?, ?, ?, ?);"; 
    private static final String SQL_DELETE   = "DELETE FROM sc_filipe_ramos.tb_locadora WHERE cnpj = ?;";
    private static final String SQL_UPDATE   = "UPDATE sc_filipe_ramos.tb_locadora SET conta_bancaria = ? WHERE cnpj = ?";
    private static final String SQL_SELECT   = "SELECT l.*, e.* FROM sc_filipe_ramos.tb_locadora AS l JOIN sc_filipe_ramos.tb_endereco AS e ON l.endereco = e.id";
    private static final String SQL_RETRIEVE = "SELECT l.*, e.* FROM sc_filipe_ramos.tb_locadora AS l JOIN sc_filipe_ramos.tb_endereco AS e ON l.endereco = e.id WHERE cnpj = ?";
    
    public static void insert (Locadora locadora) throws Exception{
        DaoEndereco.insert(locadora.getEndereco());
        PreparedStatement stat = Conexao.conexao.prepareStatement(SQL_INSERT);
        stat.setString(1, locadora.getCnpj());
        stat.setString(2, locadora.getNomeLocadora());
        stat.setString(3, locadora.getContaBancaria());
        stat.setInt   (4, locadora.getEndereco().getId());
        stat.setDate  (5, Date.valueOf(locadora.getDataFundacao()));
        stat.execute();
        stat.close();
    }
    
    public static void delete(Locadora locadora) throws Exception {
        PreparedStatement stat = Conexao.conexao.prepareStatement(SQL_DELETE);
        stat.setString(1, locadora.getCnpj());
        stat.execute();
        stat.close();
    }
    
    public static void update (Locadora locadora) throws Exception{
        PreparedStatement stat = Conexao.conexao.prepareStatement(SQL_UPDATE);
        stat.setString (1, locadora.getContaBancaria());
        stat.setString (4, locadora.getCnpj());
        stat.execute();
        stat.close();
    }
    
    public static ArrayList<Locadora> getList () throws Exception {
        ArrayList<Locadora> locadoras = new ArrayList<>();
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
            //Instanciação da Locadora
            Locadora locadora = new Locadora();
            locadora.setCnpj         (resultado.getString("cnpj"));
            locadora.setContaBancaria(resultado.getString("conta_bancaria"));
            locadora.setNomeLocadora (resultado.getString("nome"));
            locadora.setEndereco     (endereco);
            locadora.setDataFundacao (resultado.getDate("data_fun").toLocalDate());
            
            //Armazenar o objeto
            locadoras.add(locadora);
        }
        resultado.close();
        stat.close();
        if (locadoras.isEmpty()){
            throw new Exception ("Nada encontrado");
        }
        //Retorno dos objetos
        return locadoras;
    }
    
    public static Locadora retrieve (String cnpj) throws Exception {
        PreparedStatement stat = Conexao.conexao.prepareStatement(SQL_RETRIEVE);
        stat.setString(1, cnpj);
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
            //Instanciação da Locadora
            Locadora locadora = new Locadora();
            locadora.setCnpj         (resultado.getString("cnpj"));
            locadora.setContaBancaria(resultado.getString("conta_bancaria"));
            locadora.setNomeLocadora (resultado.getString("nome"));
            locadora.setEndereco     (endereco);
            locadora.setDataFundacao (resultado.getDate("data_fun").toLocalDate());
            
            //Retorno do objeto
            return locadora;
        } else {
            resultado.close();
            stat.close();
            throw new Exception ("Nada encontrado");
        }
    }
    
} 
