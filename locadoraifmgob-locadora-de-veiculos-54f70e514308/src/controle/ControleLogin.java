package controle;

import javax.swing.JOptionPane;
import dataAcess.*;
import modelo.*;
import visao.*;

/**
 * @author Augusto
 */

public abstract class ControleLogin {
    
    public static Login            LOGIN;
    public static Menu             MENU;
    public static Locadora         LOCADORA;
    public static Funcionario      FUNCIONARIO;
    public static CRUD_Funcionario CRUDFUNCIONARIO;
    public static CRUD_Cliente     CRUDCLIENTE;
    public static CRUD_Carro       CRUDCARRO;
    public static visao.Aluguel    ALUGUEL;
    
    public static Relatorios       RELATORIOS;
    public static ClientesInadimplentes CLIENTESOFF;
    public static Despesas         DESPESA;
    
    public static PesquisaFuncionario PESQUISAFUNC;
    public static PesquisaCarro       PESQUISACARRO;
    public static PesquisaCliente     PESQUISACLIENTE;
    
    private static int carrosCadastrados = 0, carrosAlugados = 0, carrosDisponiveis = 0;
    private static int funcCadastrados = 0, clientesCadastrados = 0, clientesOFF = 0;
    private static float valor = 0;
    
    public static void iniciarPrograma (Login login) {
        try {
            ControleLogin.LOGIN = login;
            LOCADORA = DaoLocadora.getList().get(0);
            
            carrosCadastrados = DaoCarro.getCadastrados();
            carrosAlugados = DaoCarro.getAlugados();
            carrosDisponiveis = DaoCarro.getDisponiveis();
            
            funcCadastrados = DaoFuncionario.getCadastrados();
            
            clientesCadastrados = DaoCliente.getCadastrados();
            clientesOFF = DaoCliente.getBloqueados();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString() + "\nFoi impossível estabelecer os dados, verifique seu BD por favor", "Erro", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    
    public static void iniciarSessao (Funcionario funcionario) {
        try {
            FUNCIONARIO = funcionario;
            valor = 0;
            
            MENU = new Menu ();
            CRUDCLIENTE = new CRUD_Cliente();
            CRUDFUNCIONARIO = new CRUD_Funcionario();
            CRUDCARRO = new CRUD_Carro();
            ALUGUEL = new visao.Aluguel();
            
            PESQUISAFUNC = new PesquisaFuncionario();
            PESQUISACARRO = new PesquisaCarro();
            PESQUISACLIENTE = new PesquisaCliente();
            
            RELATORIOS = new Relatorios();
            DESPESA = new Despesas();
            CLIENTESOFF = new ClientesInadimplentes();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Foi impossível estabelecer os dados, verifique seu BD por favor", "Erro", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    
    public static void addCarroCadastrado () {
        carrosCadastrados++;
        addCarroDisponivel();
    }
    
    public static void addCarroDisponivel () {
        carrosDisponiveis++;
        MENU.atualizar();
    }
    
    public static void addCarroAlugado () {
        carrosAlugados++;
        carrosDisponiveis--;
        MENU.atualizar();
    }
    
    public static void addFuncionarioCadastrado () {
        funcCadastrados++;
        MENU.atualizar();
    }
    
    public static void addClienteCadastrado () {
        clientesCadastrados++;
        MENU.atualizar();
    }
    
    public static void addClienteOFF () {
        clientesOFF++;
        MENU.atualizar();
    }
    
    public static void addValor (float valor) {
        valor += valor;
        MENU.atualizar();
    }
    
    public static void removerValor () {
        valor -= valor;
        MENU.atualizar();
    }
    
    public static int getCarrosCadastrados () {
        return carrosCadastrados;
    }
    
    public static int getCarrosDisponiveis () {
        return carrosDisponiveis;
    }
    
    public static int getCarrosAlugados () {
        return carrosAlugados;
    }
    
    public static int getFuncionariosCadastrados () {
        return funcCadastrados;
    }
    
    public static int getClientesCadastrados () {
        return clientesCadastrados;
    }
    
    public static int getClientesOFF () {
        return clientesOFF;
    }
    
    public static float getValor () {
        return valor;
    }
}
