package tableModel;

import dataAcess.DaoCarro;
import java.util.ArrayList;
import modelo.Carro;

/**
 * @author Augusto, Erick e Filipe - INFO 2
 */

public class TBMCarro extends javax.swing.table.AbstractTableModel {
    private static final String [] colunas = new String[]{"Placa", "Marca", "Modelo", "Ano", "Cor", "Valor/Hora", "Seguro"};
    private static ArrayList<Carro> dados;
    
    public TBMCarro () {
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
            case 0: return dados.get(linha).getPlaca();
            case 1: return dados.get(linha).getMarca();
            case 2: return dados.get(linha).getModelo();
            case 3: return dados.get(linha).getAno();
            case 4: return dados.get(linha).getCor();
            case 5: return dados.get(linha).getValorHora();
            case 6: return dados.get(linha).isSeguro()? "Sim" : "Não";
            default: return null;
        }
    }
    
    public void atualizar () {
        try {
            dados = DaoCarro.getList();
        } catch (Exception e) {
            dados = new ArrayList<>();
        }
        fireTableDataChanged();
    }
    
    public void filtrar (String modelo, String cor, int ano) {
        try {
            dados = DaoCarro.getListWithFilter(modelo, cor, ano);
            fireTableDataChanged();
        } catch (Exception e) {
            atualizar();
        }
    }
}
