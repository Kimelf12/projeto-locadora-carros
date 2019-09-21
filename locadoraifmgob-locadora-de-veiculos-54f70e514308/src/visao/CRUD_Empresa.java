package visao;

/**
 * @author Augusto, Erick e Filipe - INFO 2
 */

public class CRUD_Empresa extends javax.swing.JFrame {

    public CRUD_Empresa() {
        super("Empresa");
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dadosNewLocalizacao = new javax.swing.JPanel();
        newRua = new javax.swing.JLabel();
        inputNewRua = new javax.swing.JTextField();
        newBairro = new javax.swing.JLabel();
        inputNewBairro = new javax.swing.JTextField();
        newCidade = new javax.swing.JLabel();
        inputNewCidade = new javax.swing.JTextField();
        newNumero = new javax.swing.JLabel();
        inputNewNumero = new javax.swing.JTextField();
        newReferencia = new javax.swing.JLabel();
        inputNewReferencia = new javax.swing.JTextField();
        newComplemento = new javax.swing.JLabel();
        inputNewComplemento = new javax.swing.JTextField();
        newUF = new javax.swing.JLabel();
        inputNewUF = new javax.swing.JComboBox<>();
        dadosNewPessoais2 = new javax.swing.JPanel();
        newNomeCompleto2 = new javax.swing.JLabel();
        inputNewNome2 = new javax.swing.JTextField();
        newCPF = new javax.swing.JLabel();
        newNascimento = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jFormattedTextField3 = new javax.swing.JFormattedTextField();
        botao_cadastroLocadora = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dados da Locadora");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dadosNewLocalizacao.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados de Localização", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        newRua.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        newRua.setText("Rua:");

        newBairro.setText("Bairro: ");

        newCidade.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        newCidade.setText("Cidade:");

        newNumero.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        newNumero.setText("Número:");

        newReferencia.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        newReferencia.setText("Referência:");

        newComplemento.setText("Complemento:");

        newUF.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        newUF.setText("UF:");

        inputNewUF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));

        javax.swing.GroupLayout dadosNewLocalizacaoLayout = new javax.swing.GroupLayout(dadosNewLocalizacao);
        dadosNewLocalizacao.setLayout(dadosNewLocalizacaoLayout);
        dadosNewLocalizacaoLayout.setHorizontalGroup(
            dadosNewLocalizacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dadosNewLocalizacaoLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(dadosNewLocalizacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(newCidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(newReferencia, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                    .addComponent(newRua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(dadosNewLocalizacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(dadosNewLocalizacaoLayout.createSequentialGroup()
                        .addGroup(dadosNewLocalizacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(dadosNewLocalizacaoLayout.createSequentialGroup()
                                .addComponent(inputNewCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(newUF, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(dadosNewLocalizacaoLayout.createSequentialGroup()
                                .addComponent(inputNewRua, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(newBairro)))
                        .addGap(18, 18, 18)
                        .addGroup(dadosNewLocalizacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(inputNewBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(dadosNewLocalizacaoLayout.createSequentialGroup()
                                .addComponent(inputNewUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(newNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(inputNewNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(dadosNewLocalizacaoLayout.createSequentialGroup()
                        .addComponent(inputNewReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(newComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(inputNewComplemento)))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        dadosNewLocalizacaoLayout.setVerticalGroup(
            dadosNewLocalizacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dadosNewLocalizacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dadosNewLocalizacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newRua)
                    .addComponent(inputNewRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputNewBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newBairro))
                .addGap(18, 18, 18)
                .addGroup(dadosNewLocalizacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dadosNewLocalizacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(newNumero)
                        .addComponent(inputNewNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dadosNewLocalizacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(newCidade)
                        .addComponent(inputNewCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(newUF)
                        .addComponent(inputNewUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addGroup(dadosNewLocalizacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newReferencia)
                    .addComponent(inputNewReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newComplemento)
                    .addComponent(inputNewComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 40, Short.MAX_VALUE))
        );

        getContentPane().add(dadosNewLocalizacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 175, 764, -1));

        dadosNewPessoais2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados Empresariais", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        newNomeCompleto2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        newNomeCompleto2.setText("Nome da empresa:");

        inputNewNome2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNewNome2ActionPerformed(evt);
            }
        });

        newCPF.setText("CNPJ:");

        newNascimento.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        newNascimento.setText("Data de Fundação: ");

        jLabel1.setText("Conta bancária: ");

        try {
            jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jFormattedTextField2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#### ### ########-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jFormattedTextField3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout dadosNewPessoais2Layout = new javax.swing.GroupLayout(dadosNewPessoais2);
        dadosNewPessoais2.setLayout(dadosNewPessoais2Layout);
        dadosNewPessoais2Layout.setHorizontalGroup(
            dadosNewPessoais2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dadosNewPessoais2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(dadosNewPessoais2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(newCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newNomeCompleto2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(dadosNewPessoais2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dadosNewPessoais2Layout.createSequentialGroup()
                        .addComponent(inputNewNome2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dadosNewPessoais2Layout.createSequentialGroup()
                        .addComponent(jFormattedTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(newNascimento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(dadosNewPessoais2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jFormattedTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                    .addComponent(jFormattedTextField2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dadosNewPessoais2Layout.setVerticalGroup(
            dadosNewPessoais2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dadosNewPessoais2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(dadosNewPessoais2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newNomeCompleto2)
                    .addComponent(inputNewNome2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(dadosNewPessoais2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34)
                .addGroup(dadosNewPessoais2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dadosNewPessoais2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(newCPF)
                        .addComponent(jFormattedTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dadosNewPessoais2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(newNascimento)
                        .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        getContentPane().add(dadosNewPessoais2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 22, 764, -1));

        botao_cadastroLocadora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Empresa.png"))); // NOI18N
        getContentPane().add(botao_cadastroLocadora, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 350, 130, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputNewNome2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNewNome2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputNewNome2ActionPerformed

    public static void main(String args[]) {
        try {
            javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CRUD_Empresa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botao_cadastroLocadora;
    private javax.swing.JPanel dadosNewLocalizacao;
    private javax.swing.JPanel dadosNewPessoais2;
    private javax.swing.JTextField inputNewBairro;
    private javax.swing.JTextField inputNewCidade;
    private javax.swing.JTextField inputNewComplemento;
    private javax.swing.JTextField inputNewNome2;
    private javax.swing.JTextField inputNewNumero;
    private javax.swing.JTextField inputNewReferencia;
    private javax.swing.JTextField inputNewRua;
    private javax.swing.JComboBox<String> inputNewUF;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JFormattedTextField jFormattedTextField3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel newBairro;
    private javax.swing.JLabel newCPF;
    private javax.swing.JLabel newCidade;
    private javax.swing.JLabel newComplemento;
    private javax.swing.JLabel newNascimento;
    private javax.swing.JLabel newNomeCompleto2;
    private javax.swing.JLabel newNumero;
    private javax.swing.JLabel newReferencia;
    private javax.swing.JLabel newRua;
    private javax.swing.JLabel newUF;
    // End of variables declaration//GEN-END:variables
}
