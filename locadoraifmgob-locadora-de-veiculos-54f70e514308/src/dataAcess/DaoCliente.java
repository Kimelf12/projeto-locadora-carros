package dataAcess;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Cliente;
import modelo.Endereco;

/**
 * @author Augusto, Erick e Filipe - INFO 2
 */
public abstract class DaoCliente {

    private static final String SQL_INSERT   = "INSERT INTO sc_filipe_ramos.tb_cliente (cpf, rg, nome, email, endereco, data_nascimento, telefone_fixo, telefone_movel, autorizado, cnh) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_DELETE   = "DELETE FROM sc_filipe_ramos.tb_cliente WHERE cpf = ?";
    private static final String SQL_UPDATE   = "UPDATE sc_filipe_ramos.tb_cliente SET telefone_fixo = ?, telefone_movel = ?, autorizado = ?, cnh = ? WHERE cpf = ?";
    private static final String SQL_SELECT   = "SELECT c.*, e.* FROM sc_filipe_ramos.tb_cliente AS c JOIN sc_filipe_ramos.tb_endereco AS e ON c.endereco = e.id";
    private static final String SQL_RETRIEVE = "SELECT c.*, e.* FROM sc_filipe_ramos.tb_cliente AS c JOIN sc_filipe_ramos.tb_endereco AS e ON c.endereco = e.id WHERE cpf = ?";
    
    
    public static void insert(Cliente cliente) throws Exception {
        DaoEndereco.insert(cliente.getEndereco());
        PreparedStatement stat = Conexao.conexao.prepareStatement(SQL_INSERT);
        stat.setString (1, cliente.getCpf());
        stat.setString (2, cliente.getRg());
        stat.setString (3, cliente.getNome());
        stat.setString (4, cliente.getEmail());
        stat.setInt    (5, cliente.getEndereco().getId());
        stat.setDate   (6, Date.valueOf(cliente.getData_nascimento()));
        stat.setString (7, cliente.getTelefoneFixo());
        stat.setString (8, cliente.getTelefoneMovel());
        stat.setBoolean(9, cliente.isAutorizado());
        stat.setString (10, cliente.getCnh());
        stat.execute();
        stat.close();
    }

    public static void delete(Cliente cliente) throws Exception {
        PreparedStatement stat = Conexao.conexao.prepareStatement(SQL_DELETE);
        stat.setString(1, cliente.getCpf());
        stat.execute();
        stat.close();
    }
    
    public static void update (Cliente cliente) throws Exception{
        DaoEndereco.update(cliente.getEndereco());
        PreparedStatement stat = Conexao.conexao.prepareStatement(SQL_UPDATE);
        stat.setString (1, cliente.getTelefoneFixo());
        stat.setString (2, cliente.getTelefoneMovel());
        stat.setBoolean(3, cliente.isAutorizado());
        stat.setString (4, cliente.getCnh());
        stat.setString (5, cliente.getCpf());
        stat.execute();
        stat.close();
    }
    
    public static ArrayList<Cliente> getList () throws Exception {
        return executarSelect(SQL_SELECT);
    }
    
    public static ArrayList<Cliente> getListWithFilter (String nome, String cpf) throws Exception {
        String sql = SQL_SELECT;
        if (!(nome.equals("") && cpf.equals(""))) {
            if (nome.equals("") && !cpf.equals("")) {
                sql += " WHERE cpf ILIKE '%" + cpf + "%'";
            } else if (!nome.equals("") && cpf.equals("")) {
                sql += " WHERE nome ILIKE '%" + nome + "%'";
            } else if (!nome.equals("") && !cpf.equals("")) {
                sql += " WHERE nome ILIKE '%" + nome + "%' AND cpf ILIKE '%" + cpf + "%'";
            }
        }
        return executarSelect(sql);
    }
    
    public static ArrayList<Cliente> getOFF () throws Exception{
        return executarSelect(SQL_SELECT + " WHERE autorizado = 'False'");
    }
    
    private static ArrayList<Cliente> executarSelect(String sql) throws Exception{
        ArrayList<Cliente> clientes = new ArrayList<>();
        PreparedStatement stat = Conexao.conexao.prepareStatement(sql);
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
            //Instanciação do Cliente
            Cliente cliente = new Cliente();
            cliente.setCpf            (resultado.getString("cpf"));
            cliente.setRg             (resultado.getString("rg"));
            cliente.setCnh            (resultado.getString("cnh"));
            cliente.setNome           (resultado.getString("nome"));
            cliente.setData_nascimento(resultado.getDate("data_nascimento").toLocalDate());
            cliente.setAutorizado     (resultado.getBoolean("autorizado"));
            cliente.setEmail          (resultado.getString("email"));
            cliente.setEndereco       (endereco);
            cliente.setTelefoneFixo   (resultado.getString("telefone_fixo"));
            cliente.setTelefoneMovel  (resultado.getString("telefone_movel"));
            
            //Armazenar o objeto
            clientes.add(cliente);
        }
        resultado.close();
        stat.close();
        if (clientes.isEmpty()){
            throw new Exception ("Nada encontrado");
        }
        //Retorno dos objetos
        return clientes;
    }
    
    public static Cliente retrieve (String cpf) throws Exception {
        PreparedStatement stat = Conexao.conexao.prepareStatement(SQL_RETRIEVE);
        stat.setString(1, cpf);
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
            endereco.setNumero    (resultado.getInt("numero"));
            
            //Instanciação do Cliente
            Cliente cliente = new Cliente();
            cliente.setCpf            (resultado.getString("cpf"));
            cliente.setRg             (resultado.getString("rg"));
            cliente.setCnh            (resultado.getString("cnh"));
            cliente.setNome           (resultado.getString("nome"));
            cliente.setData_nascimento(resultado.getDate("data_nascimento").toLocalDate());
            cliente.setAutorizado     (resultado.getBoolean("autorizado"));
            cliente.setEmail          (resultado.getString("email"));
            cliente.setEndereco       (endereco);
            cliente.setTelefoneFixo   (resultado.getString("telefone_fixo"));
            cliente.setTelefoneMovel  (resultado.getString("telefone_movel"));
            
            //Retorno do objeto
            return cliente;
        } else {
            resultado.close();
            stat.close();
            throw new Exception ("Nada encontrado");
        }
    }

    public static int getBloqueados () throws Exception {
        return getQtd("SELECT COUNT(*) FROM sc_filipe_ramos.tb_cliente WHERE autorizado = 'False'");
    }
    
    public static int getCadastrados () throws Exception {
        return getQtd("SELECT COUNT(*) FROM sc_filipe_ramos.tb_cliente");
    }
    
    private static int getQtd (String sql) throws Exception {
        PreparedStatement stat = Conexao.conexao.prepareStatement(sql);
        ResultSet resultado = stat.executeQuery();
        resultado.next();
        return resultado.getInt(1);
    }
    
}
