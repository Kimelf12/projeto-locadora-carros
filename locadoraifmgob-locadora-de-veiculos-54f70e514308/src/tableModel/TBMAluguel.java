package tableModel;

import dataAcess.DaoAluguel;
import java.util.ArrayList;
import modelo.Aluguel;

/*
 * @author Augusto, Filipe e Augusto - INFO 2
 */

public class TBMAluguel extends javax.swing.table.AbstractTableModel {
    private static final String [] colunas = new String[]{"ID", "Cliente", "Carro", "Funcionário", "Valor", "Devolvido", "Pago"};
    private static ArrayList<Aluguel> dados;
    
    public TBMAluguel () {
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
            case 1: return dados.get(linha).getCliente().getNome();
            case 2: return dados.get(linha).getCarro().getModelo();
            case 3: return dados.get(linha).getFuncionario().getNome();
            case 4: return dados.get(linha).getValor();
            case 5: return dados.get(linha).isDevolvido()? "Sim" : "Não";
            case 6: return dados.get(linha).isPago()? "Sim" : "Não";
            default: return null;
        }
    }
    
    public void atualizar () {
        try {
            dados = DaoAluguel.getList();
        } catch (Exception e) {
            dados = new ArrayList<>();
        }
        fireTableDataChanged();
    }
    
}
