package visao;

import controle.Formatacao;
import controle.ControleLogin;
import dataAcess.DaoCarro;
import dataAcess.DaoDespesa;
import java.time.LocalDate;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentListener;
import modelo.Carro;
import modelo.Despesa;
import tableModel.TBMCarro;

/**
 * @author Augusto, Erick e Filipe - INFO 2
 */

public class CRUD_Carro extends javax.swing.JFrame {

    private final DefaultComboBoxModel model;
    private TBMCarro tbmCarro;
    
    public CRUD_Carro() {
        //Definição do título do frame
        super("Carro");
        
        //Completando ComboBox com anos do carro
        int anoAtual = LocalDate.now().getYear();
        String[] anos = new String[22];
        int index = 0;
        for (int i = anoAtual - 20; i <= anoAtual + 1; i++) {
            anos[index] = String.valueOf(i);
            index++;
        }
        
        //Definição dos modelos
        model = new DefaultComboBoxModel(anos);
        tbmCarro = new TBMCarro();
        
        //Definição dos componentes e posicionamento
        initComponents();
        this.setLocationRelativeTo(null);
        
        //Eventos de texto mudado
        inputConsultaCor.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent de) {
                filtrar();
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent de) {
                filtrar();
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent de) {
                filtrar();
            }
        });
        inputConsultaAno.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent de) {
                filtrar();
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent de) {
                filtrar();
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent de) {
                filtrar();
            }
        });
        inputConsultaModelo.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent de) {
                filtrar();
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent de) {
                filtrar();
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent de) {
                filtrar();
            }
        });
    }
    
    private void filtrar () {
        //Filtrar pesquisa
        if (!(inputConsultaModelo.getText().equals("") && inputConsultaCor.getText().equals("") && inputConsultaAno.getText().equals(""))) {
            try {
                tbmCarro.filtrar(inputConsultaModelo.getText(), inputConsultaCor.getText(), Integer.parseInt(inputConsultaAno.getText()));
            } catch (Exception e) {
                tbmCarro.filtrar(inputConsultaModelo.getText(), inputConsultaCor.getText(), 0);
            }   
        } else {
            tbmCarro.atualizar();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane_CrudCarro = new javax.swing.JTabbedPane();
        jPanel_ConsultarCarro = new javax.swing.JPanel();
        PlacadoCarro = new javax.swing.JLabel();
        inputConsultaCor = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Carro = new javax.swing.JTable();
        botao_voltar = new javax.swing.JButton();
        PlacadoCarro1 = new javax.swing.JLabel();
        inputConsultaAno = new javax.swing.JTextField();
        PlacadoCarro2 = new javax.swing.JLabel();
        inputConsultaModelo = new javax.swing.JTextField();
        jPanel_CadastrarCarro = new javax.swing.JPanel();
        botaoConfirmarCadastroCarro = new javax.swing.JButton();
        dadosNewConcessionaria1 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jLabel17 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        dadosNewConcessionaria3 = new javax.swing.JPanel();
        inputNewModeloCarro = new javax.swing.JTextField();
        Modelo = new javax.swing.JLabel();
        Ano = new javax.swing.JLabel();
        jComboBox_anoDoCarro = new javax.swing.JComboBox<>();
        checkSeguro = new javax.swing.JCheckBox();
        inputNewCorCarro = new javax.swing.JTextField();
        Placa = new javax.swing.JLabel();
        Cor = new javax.swing.JLabel();
        inputNewValorHora = new javax.swing.JTextField();
        ValorPorHora = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField_marca = new javax.swing.JTextField();
        inputNewPlacaCarro = new javax.swing.JFormattedTextField();
        jPanel_Manutencao = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        inputPlacaCarroManutencao = new javax.swing.JTextField();
        botaoConfirmarManutencao = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        inputProblemasCarro = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jTextField1 = new javax.swing.JTextField();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Veículo");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel_ConsultarCarro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PlacadoCarro.setText("Cor:");
        jPanel_ConsultarCarro.add(PlacadoCarro, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 25, 29, -1));

        inputConsultaCor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputConsultaCorActionPerformed(evt);
            }
        });
        jPanel_ConsultarCarro.add(inputConsultaCor, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 22, 243, -1));

        jTable_Carro.setModel(tbmCarro);
        jTable_Carro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_CarroMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_Carro);

        jPanel_ConsultarCarro.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 700, 290));

        botao_voltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Voltar.png"))); // NOI18N
        botao_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_voltarActionPerformed(evt);
            }
        });
        jPanel_ConsultarCarro.add(botao_voltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 50, 60, 50));

        PlacadoCarro1.setText("Ano:");
        jPanel_ConsultarCarro.add(PlacadoCarro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 62, -1, -1));

        inputConsultaAno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputConsultaAnoActionPerformed(evt);
            }
        });
        jPanel_ConsultarCarro.add(inputConsultaAno, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 59, 243, -1));

        PlacadoCarro2.setText("Modelo:");
        jPanel_ConsultarCarro.add(PlacadoCarro2, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 100, -1, -1));

        inputConsultaModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputConsultaModeloActionPerformed(evt);
            }
        });
        jPanel_ConsultarCarro.add(inputConsultaModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 97, 243, -1));

        jTabbedPane_CrudCarro.addTab("Consultar", jPanel_ConsultarCarro);

        jPanel_CadastrarCarro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botaoConfirmarCadastroCarro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/AddCarro.png"))); // NOI18N
        botaoConfirmarCadastroCarro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoConfirmarCadastroCarroActionPerformed(evt);
            }
        });
        jPanel_CadastrarCarro.add(botaoConfirmarCadastroCarro, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 300, 60, 50));

        dadosNewConcessionaria1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Acessórios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jRadioButton1.setText("Ar-Condicionado");

        jRadioButton5.setText("Câmbio Automático");

        jRadioButton4.setText("Vidro Elétrico");

        jRadioButton3.setText("Teto Solar");

        jRadioButton2.setText("Direção Hidráulica");

        jRadioButton6.setText("Câmera de Ré");

        jLabel17.setText("Outro:");

        javax.swing.GroupLayout dadosNewConcessionaria1Layout = new javax.swing.GroupLayout(dadosNewConcessionaria1);
        dadosNewConcessionaria1.setLayout(dadosNewConcessionaria1Layout);
        dadosNewConcessionaria1Layout.setHorizontalGroup(
            dadosNewConcessionaria1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dadosNewConcessionaria1Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(dadosNewConcessionaria1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dadosNewConcessionaria1Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 49, Short.MAX_VALUE))
                    .addGroup(dadosNewConcessionaria1Layout.createSequentialGroup()
                        .addGroup(dadosNewConcessionaria1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton2)
                            .addComponent(jRadioButton4)
                            .addComponent(jRadioButton1))
                        .addGap(88, 88, 88)
                        .addGroup(dadosNewConcessionaria1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dadosNewConcessionaria1Layout.createSequentialGroup()
                                .addComponent(jRadioButton5)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(dadosNewConcessionaria1Layout.createSequentialGroup()
                                .addGroup(dadosNewConcessionaria1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton6)
                                    .addComponent(jRadioButton3))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        dadosNewConcessionaria1Layout.setVerticalGroup(
            dadosNewConcessionaria1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dadosNewConcessionaria1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(dadosNewConcessionaria1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton6))
                .addGap(18, 18, 18)
                .addGroup(dadosNewConcessionaria1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3))
                .addGap(18, 18, 18)
                .addGroup(dadosNewConcessionaria1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton4)
                    .addComponent(jRadioButton5))
                .addGap(35, 35, 35)
                .addGroup(dadosNewConcessionaria1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        jPanel_CadastrarCarro.add(dadosNewConcessionaria1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 406, -1));

        dadosNewConcessionaria3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do Carro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        inputNewModeloCarro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNewModeloCarroActionPerformed(evt);
            }
        });

        Modelo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Modelo.setText("Modelo:");

        Ano.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Ano.setText("Ano:");

        jComboBox_anoDoCarro.setModel(model
        );

        checkSeguro.setText("Seguro");

        Placa.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Placa.setText("Placa:");

        Cor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Cor.setText("Cor:");

        inputNewValorHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNewValorHoraActionPerformed(evt);
            }
        });

        ValorPorHora.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ValorPorHora.setText("Valor por hora:");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Marca:");

        try {
            inputNewPlacaCarro.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("???-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout dadosNewConcessionaria3Layout = new javax.swing.GroupLayout(dadosNewConcessionaria3);
        dadosNewConcessionaria3.setLayout(dadosNewConcessionaria3Layout);
        dadosNewConcessionaria3Layout.setHorizontalGroup(
            dadosNewConcessionaria3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dadosNewConcessionaria3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dadosNewConcessionaria3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dadosNewConcessionaria3Layout.createSequentialGroup()
                        .addComponent(Modelo, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(inputNewModeloCarro, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dadosNewConcessionaria3Layout.createSequentialGroup()
                        .addGroup(dadosNewConcessionaria3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Ano, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(dadosNewConcessionaria3Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(Cor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(dadosNewConcessionaria3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dadosNewConcessionaria3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox_anoDoCarro, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(checkSeguro, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(dadosNewConcessionaria3Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(inputNewCorCarro, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addGroup(dadosNewConcessionaria3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Placa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ValorPorHora, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dadosNewConcessionaria3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField_marca)
                    .addComponent(inputNewValorHora)
                    .addComponent(inputNewPlacaCarro, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        dadosNewConcessionaria3Layout.setVerticalGroup(
            dadosNewConcessionaria3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dadosNewConcessionaria3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(dadosNewConcessionaria3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Modelo)
                    .addComponent(inputNewModeloCarro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Placa)
                    .addComponent(inputNewPlacaCarro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(dadosNewConcessionaria3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dadosNewConcessionaria3Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(dadosNewConcessionaria3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField_marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(dadosNewConcessionaria3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(dadosNewConcessionaria3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Ano)
                            .addComponent(jComboBox_anoDoCarro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkSeguro))))
                .addGap(10, 10, 10)
                .addGroup(dadosNewConcessionaria3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ValorPorHora)
                    .addComponent(inputNewValorHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cor)
                    .addComponent(inputNewCorCarro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel_CadastrarCarro.add(dadosNewConcessionaria3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 710, 150));

        jTabbedPane_CrudCarro.addTab("Cadastrar", jPanel_CadastrarCarro);

        jPanel_Manutencao.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Carro:");
        jPanel_Manutencao.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 31, 80, -1));

        inputPlacaCarroManutencao.setEditable(false);
        jPanel_Manutencao.add(inputPlacaCarroManutencao, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 28, 580, -1));

        botaoConfirmarManutencao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Confirmar.png"))); // NOI18N
        botaoConfirmarManutencao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoConfirmarManutencaoActionPerformed(evt);
            }
        });
        jPanel_Manutencao.add(botaoConfirmarManutencao, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 318, 60, 50));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Pagamento"));

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Descrição:");

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Valor: R$");

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Vencimento:");

        jCheckBox1.setText("Pago");

        try {
            jFormattedTextField2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputProblemasCarro, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jCheckBox1)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(inputProblemasCarro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel_Manutencao.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 106, -1, -1));

        jTabbedPane_CrudCarro.addTab("Manutenção", jPanel_Manutencao);

        getContentPane().add(jTabbedPane_CrudCarro, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputNewValorHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNewValorHoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputNewValorHoraActionPerformed

    private void inputNewModeloCarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNewModeloCarroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputNewModeloCarroActionPerformed

    private void inputConsultaCorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputConsultaCorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputConsultaCorActionPerformed

    private void inputConsultaAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputConsultaAnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputConsultaAnoActionPerformed

    private void inputConsultaModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputConsultaModeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputConsultaModeloActionPerformed

    private void botaoConfirmarCadastroCarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConfirmarCadastroCarroActionPerformed
    try {
        //Definição do objeto do tipo Carro
        Carro carro = new Carro();
        carro.setCor(inputNewCorCarro.getText());
        carro.setAno(Integer.parseInt(jComboBox_anoDoCarro.getSelectedItem().toString()));
        carro.setMarca(jTextField_marca.getText());
        carro.setModelo(inputNewModeloCarro.getText());
        carro.setPlaca(Formatacao.textoPlaca(inputNewPlacaCarro.getText()));
        carro.setSeguro(checkSeguro.isSelected());
        carro.setValorHora(Float.parseFloat(inputNewValorHora.getText()));
        carro.setAcessorio(getAcessorio());
        
        //Adicionar no Banco de Dados
        DaoCarro.insert(carro);
        ControleLogin.addCarroCadastrado();
        tbmCarro.atualizar();
        
        JOptionPane.showMessageDialog(this, "Inserido com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    } 
    }//GEN-LAST:event_botaoConfirmarCadastroCarroActionPerformed

    private void botaoConfirmarManutencaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConfirmarManutencaoActionPerformed
        try {
            //Definição do objeto do tipo Despesa
            Despesa despesa = new Despesa();
            despesa.setPago(jCheckBox1.isSelected());
            despesa.setDataPagamento(LocalDate.now());
            despesa.setDescricao(inputProblemasCarro.getText() + " - Carro: " + inputPlacaCarroManutencao.getText());
            despesa.setValor(Float.parseFloat(jTextField1.getText()));
            
            //Definição da data de vencimento
            int dia = Integer.parseInt(jFormattedTextField2.getText().split("/")[0]);
            int mes = Integer.parseInt(jFormattedTextField2.getText().split("/")[1]);
            int ano = Integer.parseInt(jFormattedTextField2.getText().split("/")[2]);
            despesa.setVencimento(LocalDate.of(ano, mes, dia));
            despesa.setDataPagamento(LocalDate.now());
            
            //Adicionar no Banco de Dados
            DaoDespesa.insert(despesa);
            JOptionPane.showMessageDialog(this, "Inserido com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }//GEN-LAST:event_botaoConfirmarManutencaoActionPerformed

    private void jTable_CarroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_CarroMouseClicked
        //Completar textField da Multa
        try {
            String placa = String.valueOf(jTable_Carro.getValueAt(jTable_Carro.getSelectedRow(), 0));
            inputPlacaCarroManutencao.setText(DaoCarro.retrieve(placa).toString());
        } catch (Exception e) {
        }
        
    }//GEN-LAST:event_jTable_CarroMouseClicked

    private void botao_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_voltarActionPerformed
        this.setVisible(false);
        ControleLogin.MENU.setVisible(true);
    }//GEN-LAST:event_botao_voltarActionPerformed

    private String getAcessorio() {
        //Preparação da String que vai para o banco
        String acessorio = "";
        int qtd = 0;
        if (jRadioButton1.isSelected()) {
            acessorio += jRadioButton1.getText();
            qtd++;
        }
        if (jRadioButton2.isSelected()) {
            if (qtd > 0) {
                acessorio += ", ";
            }
            acessorio += jRadioButton2.getText();
            qtd++;
        }
        if (jRadioButton3.isSelected()) {
            if (qtd > 0) {
                acessorio += ", ";
            }
            acessorio += jRadioButton3.getText();
            qtd++;
        }
        if (jRadioButton4.isSelected()) {
            if (qtd > 0) {
                acessorio += ", ";
            }
            acessorio += jRadioButton4.getText();
            qtd++;
        }
        if (jRadioButton5.isSelected()) {
            if (qtd > 0) {
                acessorio += ", ";
            }
            acessorio += jRadioButton5.getText();
            qtd++;
        }
        if (jRadioButton6.isSelected()) {
            if (qtd > 0) {
                acessorio += ", ";
            }
            acessorio += jRadioButton6.getText();
            qtd++;
        }
        if (!jTextField5.getText().equals("")) {
            if (qtd > 0) {
                acessorio += ", ";
            }
            acessorio += jTextField5.getText();
        }
        return acessorio;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Ano;
    private javax.swing.JLabel Cor;
    private javax.swing.JLabel Modelo;
    private javax.swing.JLabel Placa;
    private javax.swing.JLabel PlacadoCarro;
    private javax.swing.JLabel PlacadoCarro1;
    private javax.swing.JLabel PlacadoCarro2;
    private javax.swing.JLabel ValorPorHora;
    private javax.swing.JButton botaoConfirmarCadastroCarro;
    private javax.swing.JButton botaoConfirmarManutencao;
    private javax.swing.JButton botao_voltar;
    private javax.swing.JCheckBox checkSeguro;
    private javax.swing.JPanel dadosNewConcessionaria1;
    private javax.swing.JPanel dadosNewConcessionaria3;
    private javax.swing.JTextField inputConsultaAno;
    private javax.swing.JTextField inputConsultaCor;
    private javax.swing.JTextField inputConsultaModelo;
    private javax.swing.JTextField inputNewCorCarro;
    private javax.swing.JTextField inputNewModeloCarro;
    private javax.swing.JFormattedTextField inputNewPlacaCarro;
    private javax.swing.JTextField inputNewValorHora;
    private javax.swing.JTextField inputPlacaCarroManutencao;
    private javax.swing.JTextField inputProblemasCarro;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jComboBox_anoDoCarro;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel_CadastrarCarro;
    private javax.swing.JPanel jPanel_ConsultarCarro;
    private javax.swing.JPanel jPanel_Manutencao;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane_CrudCarro;
    private javax.swing.JTable jTable_Carro;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField_marca;
    // End of variables declaration//GEN-END:variables
}
