package visao;

import controle.GeradorPDF;
import javax.swing.JOptionPane;

/**
 * @author Augusto, Erick e Filipe - INFO 2
 */

public class Relatorios extends javax.swing.JFrame {

    public Relatorios() {
        //Definição do título do Frame
        super("Relatórios");
        
        //Instanciação e Posicionamento dos componentes
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBotoesTipoArquivoRelatorio = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        comboBoxPeriodoRelatorio = new javax.swing.JComboBox<>();
        botaoGerarRelatorio = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        botao_voltar2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Relatórios");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Período:");

        comboBoxPeriodoRelatorio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Diário", "Mensal", "Anual" }));

        botaoGerarRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/printer.png"))); // NOI18N
        botaoGerarRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoGerarRelatorioActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/PDF.png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Estatisticas.png"))); // NOI18N

        botao_voltar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Voltar.png"))); // NOI18N
        botao_voltar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_voltar2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboBoxPeriodoRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(123, 123, 123))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(botao_voltar2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(botaoGerarRelatorio)
                        .addGap(110, 110, 110))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(196, 196, 196))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxPeriodoRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(37, 37, 37)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botaoGerarRelatorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botao_voltar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botao_voltar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_voltar2ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_botao_voltar2ActionPerformed

    private void botaoGerarRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoGerarRelatorioActionPerformed
        try {
            switch (comboBoxPeriodoRelatorio.getSelectedIndex()) {
                case 0: 
                    GeradorPDF.relatorioDiario(Integer.parseInt(JOptionPane.showInputDialog(this, "Informe o dia")), 
                            Integer.parseInt(JOptionPane.showInputDialog(this, "Informe o mês")), 
                            Integer.parseInt(JOptionPane.showInputDialog(this, "Informe o ano")));
                    break;
                case 1: 
                    GeradorPDF.relatorioMensal(Integer.parseInt(JOptionPane.showInputDialog(this, "Informe o mês")), 
                            Integer.parseInt(JOptionPane.showInputDialog(this, "Informe o ano")));
                    break;
                case 2: 
                    GeradorPDF.relatorioAnual(Integer.parseInt(JOptionPane.showInputDialog(this, "Informe o ano")));
                    break;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao ler os dados", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botaoGerarRelatorioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoGerarRelatorio;
    private javax.swing.JButton botao_voltar;
    private javax.swing.JButton botao_voltar1;
    private javax.swing.JButton botao_voltar2;
    private javax.swing.JComboBox<String> comboBoxPeriodoRelatorio;
    private javax.swing.ButtonGroup grupoBotoesTipoArquivoRelatorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
