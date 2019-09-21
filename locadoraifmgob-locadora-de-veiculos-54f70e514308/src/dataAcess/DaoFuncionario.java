package dataAcess;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Funcionario;
import modelo.Endereco;

/**
 * @author Augusto, Erick e Filipe - INFO 2
 */

public abstract class DaoFuncionario {
    private static final String SQL_INSERT   = "INSERT INTO sc_filipe_ramos.tb_funcionario (cpf, rg, nome, email, data_nascimento, endereco, telefone_fixo, telefone_movel, salario, comissao, usuario, senha) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, MD5(?));";
    private static final String SQL_DELETE   = "DELETE FROM sc_filipe_ramos.tb_funcionario WHERE cpf = ?";
    private static final String SQL_UPDATE   = "UPDATE sc_filipe_ramos.tb_funcionario SET telefone_fixo = ?, telefone_movel = ?, autorizado = ?, salario = ?, comissao = ?, email = ?, senha = MD5(?) WHERE cpf = ?";
    private static final String SQL_SELECT   = "SELECT f.*, e.* FROM sc_filipe_ramos.tb_funcionario AS f JOIN sc_filipe_ramos.tb_endereco AS e ON f.endereco = e.id";
    private static final String SQL_RETRIEVE = "SELECT f.*, e.* FROM sc_filipe_ramos.tb_funcionario AS f JOIN sc_filipe_ramos.tb_endereco AS e ON f.endereco = e.id WHERE cpf = ?";
    
    
    public static void insert(Funcionario funcionario, String senha) throws Exception {
        DaoEndereco.insert(funcionario.getEndereco());
        PreparedStatement stat = Conexao.conexao.prepareStatement(SQL_INSERT);
        stat.setString  (1, funcionario.getCpf());
        stat.setString  (2, funcionario.getRg());
        stat.setString  (3, funcionario.getNome());
        stat.setString  (4, funcionario.getEmail());
        stat.setDate    (5, Date.valueOf(funcionario.getData_nascimento()));
        stat.setInt     (6, funcionario.getEndereco().getId());
        stat.setString  (7, funcionario.getTelefoneFixo());
        stat.setString  (8, funcionario.getTelefoneMovel());
        stat.setFloat   (9, funcionario.getSalario());
        stat.setFloat   (10, funcionario.getComissao());
        stat.setString  (11, funcionario.getUsuario());
        stat.setString  (12, funcionario.getUsuario() + senha);
        stat.execute();
        stat.close();
    }

    public static void delete(Funcionario funcionario) throws Exception {
        PreparedStatement stat = Conexao.conexao.prepareStatement(SQL_DELETE);
        stat.setString(1, funcionario.getCpf());
        stat.execute();
        stat.close();
    }
    
    public static void update (Funcionario funcionario, String senha) throws Exception{
        DaoEndereco.update(funcionario.getEndereco());
        PreparedStatement stat = Conexao.conexao.prepareStatement(SQL_UPDATE);
        stat.setString (1, funcionario.getTelefoneFixo());
        stat.setString (2, funcionario.getTelefoneMovel());
        stat.setBoolean(3, funcionario.isGerente());
        stat.setFloat  (4, funcionario.getSalario());
        stat.setFloat  (5, funcionario.getComissao());
        stat.setString (6, funcionario.getEmail());
        stat.setString (7, senha);
        stat.setString (8, funcionario.getCpf());
        System.out.println(stat.toString());
        stat.execute();
        stat.close();
    }
    
    public static ArrayList<Funcionario> getList () throws Exception {
        return executarSelect(SQL_SELECT);
    }
    
    public static ArrayList<Funcionario> getListWithFilter (String nome, String telefoneMovel) throws Exception {
        String sql = SQL_SELECT;
        if (!(nome.equals("") && telefoneMovel.equals(""))) {
            if (nome.equals("") && !telefoneMovel.equals("")) {
                sql += " WHERE telefoneMovel ILIKE '%" + telefoneMovel + "%'";
            } else if (!nome.equals("") && telefoneMovel.equals("")) {
                sql += " WHERE nome ILIKE '" + nome + "'";
            } else if (!nome.equals("") && !telefoneMovel.equals("")) {
                sql += " WHERE nome ILIKE '%" + nome + "%' AND telefone_movel ILIKE '" + telefoneMovel + "'";
            }
        }
        return executarSelect(sql);
    }
    
    private static ArrayList<Funcionario> executarSelect (String sql) throws Exception {
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
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
     
            //Instanciação do Funcionario
            Funcionario funcionario = new Funcionario();
            funcionario.setCpf            (resultado.getString("cpf"));
            funcionario.setRg             (resultado.getString("rg"));
            funcionario.setNome           (resultado.getString("nome"));
            funcionario.setData_nascimento(resultado.getDate("data_nascimento").toLocalDate());
            funcionario.setEmail          (resultado.getString("email"));
            funcionario.setEndereco       (endereco);
            funcionario.setTelefoneFixo   (resultado.getString("telefone_fixo"));
            funcionario.setTelefoneMovel  (resultado.getString("telefone_movel"));
            funcionario.setComissao       (resultado.getFloat("comissao"));
            funcionario.setSalario        (resultado.getFloat("salario"));

            //Armazenar o objeto
            funcionarios.add(funcionario);
        }
        resultado.close();
        stat.close();
        if (funcionarios.isEmpty()){
            throw new Exception ("Nada encontrado");
        }
        //Retorno dos objetos
        return funcionarios;
    }
    
    public static Funcionario retrieve (String cpf) throws Exception {
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
            
            //Instanciação do Funcionario
            Funcionario funcionario = new Funcionario();
            funcionario.setCpf            (resultado.getString("cpf"));
            funcionario.setRg             (resultado.getString("rg"));
            funcionario.setNome           (resultado.getString("nome"));
            funcionario.setData_nascimento(resultado.getDate("data_nascimento").toLocalDate());
            funcionario.setEmail          (resultado.getString("email"));
            funcionario.setEndereco       (endereco);
            funcionario.setTelefoneFixo   (resultado.getString("telefone_fixo"));
            funcionario.setTelefoneMovel  (resultado.getString("telefone_movel"));
            funcionario.setComissao       (resultado.getFloat("comissao"));
            funcionario.setSalario        (resultado.getFloat("salario"));

            resultado.close();
            stat.close();
            //Retorno do objeto
            return funcionario;
        } else {
            resultado.close();
            stat.close();
            throw new Exception ("Nada encontrado");
        }
    }
    
    public static int getCadastrados () throws Exception {
        return getQtd("SELECT COUNT(*) FROM sc_filipe_ramos.tb_funcionario");
    }
    
    public static int getAlugueis (String cpf) throws Exception{
        return getQtd("SELECT COUNT(*) FROM sc_filipe_ramos.tb_funcionario AS f JOIN sc_filipe_ramos.tb_aluguel AS a ON f.cpf = a.funcionario WHERE f.cpf = '" + cpf + "'");
    }
    
    public static float getLucro (String cpf) throws Exception{
        return getQtd("SELECT SUM(a.valor) FROM sc_filipe_ramos.tb_funcionario AS f JOIN sc_filipe_ramos.tb_aluguel AS a ON f.cpf = a.funcionario WHERE f.cpf = '" + cpf + "'");
    }
    
    private static int getQtd (String sql) throws Exception {
        PreparedStatement stat = Conexao.conexao.prepareStatement(sql);
        ResultSet resultado = stat.executeQuery();
        resultado.next();
        return resultado.getInt(1);
    }
}
