package tableModel;

import dataAcess.DaoFuncionario;
import java.util.ArrayList;
import modelo.Funcionario;

/**
 * @author Augusto, Erick e Filipe - INFO 2
 */

public class TBMFuncionario extends javax.swing.table.AbstractTableModel {
    private static final String [] colunas = new String[]{"CPF", "RG", "Nome", "Data Nascimento", "Celular", "Telefone", "Email"};
    private static ArrayList<Funcionario> dados;
    
    public TBMFuncionario() {
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
            case 2: return dados.get(linha).getNome();
            case 3: return dados.get(linha).getData_nascimento();
            case 4: return dados.get(linha).getTelefoneMovel();
            case 5: return dados.get(linha).getTelefoneFixo();
            case 6: return dados.get(linha).getEmail();
            default: return null;
        }
    }
    
    public void atualizar () {
        try {
            dados = DaoFuncionario.getList();
        } catch (Exception e) {
            dados = new ArrayList<>();
        }
        fireTableDataChanged();
    }
    
    public void filtrar (String nome, String telefoneMovel) {
        try {
            dados = DaoFuncionario.getListWithFilter(nome, telefoneMovel);
            fireTableDataChanged();
        } catch (Exception e) {
            atualizar();
        }
    }
}
