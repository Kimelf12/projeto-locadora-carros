package dataAcess;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Carro;

/**
 * @author Augusto, Erick e Filipe - INFO 2
 */
public abstract class DaoCarro {

    private static final String SQL_INSERT   = "INSERT INTO sc_filipe_ramos.tb_carro (placa, modelo, ano, cor, valor_hora, acessorio, seguro, marca) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_DELETE   = "DELETE FROM sc_filipe_ramos.tb_carro WHERE placa = ?";
    private static final String SQL_UPDATE   = "UPDATE sc_filipe_ramos.tb_carro SET cor = ?, valor_hora = ?, acessorio = ?, seguro = ? WHERE placa = ?;";
    private static final String SQL_RETRIEVE = "SELECT * FROM sc_filipe_ramos.tb_carro WHERE placa = ?";
    private static final String SQL_SELECT   = "SELECT * FROM sc_filipe_ramos.tb_carro";

    public static void insert (Carro carro) throws Exception {
        PreparedStatement stat = Conexao.conexao.prepareStatement(SQL_INSERT);
        stat.setString (1, carro.getPlaca());
        stat.setString (2, carro.getModelo());
        stat.setInt    (3, carro.getAno());
        stat.setString (4, carro.getCor());
        stat.setFloat  (5, carro.getValorHora());
        stat.setString (6, carro.getAcessorio());
        stat.setBoolean(7, carro.isSeguro());
        stat.setString (8, carro.getMarca());
        stat.execute();
        stat.close();
    }

    public static void delete (Carro carro) throws Exception {
        PreparedStatement stat = Conexao.conexao.prepareStatement(SQL_DELETE);
        stat.setString(1, carro.getPlaca());
        stat.execute();
        stat.close();
    }
    
    public static void update (Carro carro) throws Exception {
        PreparedStatement stat = Conexao.conexao.prepareStatement(SQL_UPDATE);
        stat.setString (1, carro.getCor());
        stat.setFloat  (2, carro.getValorHora());
        stat.setString (3, carro.getAcessorio());
        stat.setBoolean(4, carro.isSeguro());
        stat.setString (5, carro.getPlaca());
        Conexao.conexao.setAutoCommit(false);
        int rows = stat.executeUpdate();
        stat.close();
        if (rows != 1) {
            Conexao.conexao.rollback();
            Conexao.conexao.setAutoCommit(true);
            throw new Exception(carro.getPlaca() + " não foi atualizado!");
        } else {
            Conexao.conexao.commit();
            Conexao.conexao.setAutoCommit(true);
        }
    }

    public static ArrayList<Carro> getList() throws Exception {
        return executarSelect(SQL_SELECT);
    }
    
    public static ArrayList<Carro> getListWithFilter(String modelo, String cor, int ano) throws Exception {
        String sql = SQL_SELECT;
        if (!(modelo.equals("") && cor.equals("") && ano == 0)) {
            if (modelo.equals("") && cor.equals("") && ano > 0) {
                sql += " WHERE ano = '" + ano + "'";
            } else if (modelo.equals("") && !cor.equals("") && ano > 0) {
                sql += " WHERE ano = '" + ano + "' AND cor ILIKE '%" + cor + "%'";
            } else if (!modelo.equals("") && cor.equals("") && ano > 0) {
                sql += " WHERE ano = '" + ano + "' AND modelo ILIKE '%" + modelo + "%'";
            } else if (!modelo.equals("") && !cor.equals("") && ano > 0) {
                sql += " WHERE ano = '" + ano + "' AND modelo ILIKE '%" + modelo + "%' AND cor ILIKE '%" + cor + "%'";
            } else if (!modelo.equals("") && cor.equals("") && ano == 0) {
                sql += " WHERE modelo ILIKE '%" + modelo + "%'";
            } else if (modelo.equals("") && !cor.equals("") && ano == 0) {
                sql += " WHERE cor ILIKE '%" + cor + "%'";
            } else if (!modelo.equals("") && !cor.equals("") && ano == 0) {
                sql += " WHERE cor ILIKE '%" + cor + "%' AND modelo ILIKE '%" + modelo + "%'";
            }
        }
        return executarSelect(sql);
    }
    
    private static ArrayList<Carro> executarSelect (String sql) throws Exception{
        ArrayList<Carro> carros = new ArrayList<>();
        PreparedStatement stat = Conexao.conexao.prepareStatement(sql);
        ResultSet resultado = stat.executeQuery();
        while (resultado.next()) {
            //Instanciação do Carro
            Carro carro = new Carro();
            carro.setPlaca       (resultado.getString("placa"));
            carro.setAno         (resultado.getInt("ano"));
            carro.setModelo      (resultado.getString("modelo"));
            carro.setCor         (resultado.getString("cor"));
            carro.setAcessorio   (resultado.getString("acessorio"));
            carro.setValorHora   (resultado.getFloat("valor_hora"));
            carro.setSeguro      (resultado.getBoolean("seguro"));
            carro.setMarca       (resultado.getString("marca"));
            
            //Armazenar o objeto
            carros.add(carro);
        }
        resultado.close();
        stat.close();
        if (carros.isEmpty()) {
            throw new Exception ("Nada encontrado");
        }
        //Retorno dos objetos
        return carros;
    }
    
    public static Carro retrieve (String placa) throws Exception{
        PreparedStatement stat = Conexao.conexao.prepareStatement(SQL_RETRIEVE);
        stat.setString(1, placa);
        ResultSet resultado = stat.executeQuery();
        if (resultado.next()) {
            //Instanciação do Carro
            Carro carro = new Carro();
            carro.setPlaca       (resultado.getString("placa"));
            carro.setAno         (resultado.getInt("ano"));
            carro.setModelo      (resultado.getString("modelo"));
            carro.setCor         (resultado.getString("cor"));
            carro.setAcessorio   (resultado.getString("acessorio"));
            carro.setValorHora   (resultado.getFloat("valor_hora"));
            carro.setSeguro      (resultado.getBoolean("seguro"));
            carro.setMarca       (resultado.getString("marca"));

            //Retorno do objeto
            return carro;
        } else {
            resultado.close();
            stat.close();
            throw new Exception ("Nada encontrado");
        }
    }
    
    public static int getDisponiveis () throws Exception {
        return getQtd("SELECT COUNT(*) FROM sc_filipe_ramos.tb_carro WHERE placa NOT IN (SELECT carro FROM sc_filipe_ramos.tb_aluguel WHERE devolvido = 'False')");
    }
    
    public static int getAlugados () throws Exception {
        return getQtd("SELECT COUNT(*) FROM sc_filipe_ramos.tb_carro WHERE placa IN (SELECT carro FROM sc_filipe_ramos.tb_aluguel WHERE devolvido = 'False')");
    }
    
    public static int getCadastrados () throws Exception {
        return getQtd("SELECT COUNT(*) FROM sc_filipe_ramos.tb_carro");
    }
    
    private static int getQtd (String sql) throws Exception {
        PreparedStatement stat = Conexao.conexao.prepareStatement(sql);
        ResultSet resultado = stat.executeQuery();
        resultado.next();
        return resultado.getInt(1);
    }
}