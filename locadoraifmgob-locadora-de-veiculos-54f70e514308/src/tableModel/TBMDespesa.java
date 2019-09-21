package tableModel;

import dataAcess.DaoDespesa;
import java.util.ArrayList;
import modelo.Despesa;

/**
 * @author Augusto, Erick e Filipe - INFO 2
 */

public class TBMDespesa extends javax.swing.table.AbstractTableModel{
    private static final String [] colunas = new String[]{"ID", "Descrição", "Valor", "Data de Vencimento"};
    private static ArrayList<Despesa> dados;
    
    public TBMDespesa () {
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
            case 0: return dados.get(linha).getId();
            case 1: return dados.get(linha).getDescricao();
            case 2: return dados.get(linha).getValor();
            case 3: return dados.get(linha).getVencimento();
            default: return null;
        }
    }
    
    public void atualizar () {
        try {
            dados = DaoDespesa.getList();
        } catch (Exception e) {
            dados = new ArrayList<>();
        }
        fireTableDataChanged();
    }
    
    public void filtrarSemPagar () {
        try {
            dados = DaoDespesa.getListSemPagar();
        } catch (Exception e) {
            dados = new ArrayList<>();
        }
        fireTableDataChanged();
    }
}
