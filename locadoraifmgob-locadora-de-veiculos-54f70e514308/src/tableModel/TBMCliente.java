package tableModel;

import dataAcess.DaoCliente;
import java.util.ArrayList;
import modelo.Cliente;


/**
 * @author Augusto, Erick e Filipe - INFO 2
 */

public class TBMCliente extends javax.swing.table.AbstractTableModel{
    private static final String [] colunas = new String[]{"CPF", "RG", "CNH", "Nome", "Data Nascimento", "Celular", "Telefone", "Email", "Autorizado"};
    private static ArrayList<Cliente> dados;
    
    public TBMCliente () {
        atualizar();
    }
    
    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    
    @Override
    public String getColumnName(int i) {
        return colunas[i];
    }    
    
    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch (coluna) {
            case 0: return dados.get(linha).getCpf();
            case 1: return dados.get(linha).getRg();
            case 2: return dados.get(linha).getCnh();
            case 3: return dados.get(linha).getNome();
            case 4: return dados.get(linha).getData_nascimento().toString();
            case 5: return dados.get(linha).getTelefoneMovel();
            case 6: return dados.get(linha).getTelefoneFixo();
            case 7: return dados.get(linha).getEmail();
            case 8: return dados.get(linha).isAutorizado()? "Sim" : "Não";
            default: return null;
        }
    }
    
    public void atualizar () {
        try {
            dados = DaoCliente.getList();
        } catch (Exception e) {
            dados = new ArrayList<>();
        }
        fireTableDataChanged();
    }
    
    public void filtrar (String nome, String cpf) {
        try {
            dados = DaoCliente.getListWithFilter(nome, cpf);
        } catch (Exception e) {
            dados = new ArrayList<>();
        }
        fireTableDataChanged();
    }
    
    public void clientesOFF () {
        try {
            dados = DaoCliente.getOFF();
        } catch (Exception e) {
            dados = new ArrayList<>();
        }
        fireTableDataChanged();
    }
}
