package visao;

import controle.ControleLogin;
import controle.Formatacao;
import dataAcess.DaoFuncionario;
import java.time.LocalDate;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentListener;
import modelo.Endereco;
import modelo.Funcionario;
import tableModel.TBMFuncionario;

/**
 * @author Augusto e Filipe, only that!!!
 */

public class CRUD_Funcionario extends javax.swing.JFrame {
    private DefaultComboBoxModel modelAno;
    private DefaultComboBoxModel modelMes;
    private DefaultComboBoxModel modelDia;
    private final TBMFuncionario tableFuncionario;
    
    public CRUD_Funcionario() {
        //Definição do título do Frame
        super("Funcionário");
        
        //Definição dos Models
        tableFuncionario = new TBMFuncionario();
        atualizarModelAno();
        atualizarModelDia();
        
        //Instanciação e posicionamento dos componentes
        initComponents();
        this.setLocationRelativeTo(null);
        
        //Eventos de texto mudado
        inputPesqNome.getDocument().addDocumentListener(new DocumentListener() {
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
        tableFuncionario.filtrar(inputPesqNome.getText(), "");
    }

    private boolean eBissexto (int ano) {
        return ano % 4 == 0;
    }

    private void atualizarModelAno () {
        int anoAtual = LocalDate.now().getYear();
        String[] anos = new String[98];
        int index = 0;
        for (int i = anoAtual - 115; i <= anoAtual - 18; i++) {
            anos[index] = String.valueOf(i);
            index++;
        }
        modelAno = new DefaultComboBoxModel(anos);
    }
    
    private void atualizarModelDia () {
        String[] dias;
        try {
            int mes = Integer.parseInt(inputNewMes.getSelectedItem().toString());
            int ano = Integer.parseInt(inputNewAno.getSelectedItem().toString());
            switch(mes) {
                case 2:
                    if (eBissexto(ano)) {
                        dias = new String[29];
                    } else {
                        dias = new String[28];
                    }
                    break;
                case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                    dias = new String[31];
                    break;
                default:
                    dias = new String[30];
            }
        } catch (Exception e) {
            dias = new String[30];
        }
        for (int i = 0; i < dias.length; i++) {
            dias[i] = String.valueOf(i + 1);
        }
        modelDia = new DefaultComboBoxModel(dias);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        inputCnsulSalFuncionario = new javax.swing.JTextField();
        inputCnsulComisFuncionario = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        inputPesqNome = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        dadosNewContato = new javax.swing.JPanel();
        newTelefone = new javax.swing.JLabel();
        newCelular = new javax.swing.JLabel();
        newEmail = new javax.swing.JLabel();
        inputNewEmail = new javax.swing.JTextField();
        jFormattedTextField3 = new javax.swing.JFormattedTextField();
        jFormattedTextField4 = new javax.swing.JFormattedTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        inputSalario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        inputComissao = new javax.swing.JTextField();
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
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        checkBoxAutorizado = new javax.swing.JCheckBox();
        inputSenhaFuncionario = new javax.swing.JPasswordField();
        botaoCadastrarFuncionario = new javax.swing.JButton();
        dadosNewPessoais3 = new javax.swing.JPanel();
        newNomeCompleto3 = new javax.swing.JLabel();
        inputNewNome3 = new javax.swing.JTextField();
        newCPF = new javax.swing.JLabel();
        newRG = new javax.swing.JLabel();
        newNascimento = new javax.swing.JLabel();
        inputNewAno = new javax.swing.JComboBox<>();
        inputNewMes = new javax.swing.JComboBox<>();
        inputNewDia = new javax.swing.JComboBox<>();
        newCNH = new javax.swing.JLabel();
        inputNewCNH = new javax.swing.JTextField();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jPanel3 = new javax.swing.JPanel();
        dadosNewContato1 = new javax.swing.JPanel();
        newTelefone1 = new javax.swing.JLabel();
        newCelular1 = new javax.swing.JLabel();
        newEmail1 = new javax.swing.JLabel();
        inputNewEmail1 = new javax.swing.JTextField();
        jFormattedTextField5 = new javax.swing.JFormattedTextField();
        jFormattedTextField6 = new javax.swing.JFormattedTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        checkBoxAutorizado1 = new javax.swing.JCheckBox();
        inputSenhaFuncionario1 = new javax.swing.JPasswordField();
        dadosNewLocalizacao1 = new javax.swing.JPanel();
        newRua1 = new javax.swing.JLabel();
        inputNewRua1 = new javax.swing.JTextField();
        newBairro1 = new javax.swing.JLabel();
        inputNewBairro1 = new javax.swing.JTextField();
        newCidade1 = new javax.swing.JLabel();
        inputNewCidade1 = new javax.swing.JTextField();
        newNumero1 = new javax.swing.JLabel();
        inputNewNumero1 = new javax.swing.JTextField();
        newReferencia1 = new javax.swing.JLabel();
        inputNewReferencia1 = new javax.swing.JTextField();
        newComplemento1 = new javax.swing.JLabel();
        inputNewComplemento1 = new javax.swing.JTextField();
        newUF1 = new javax.swing.JLabel();
        inputNewUF1 = new javax.swing.JComboBox<>();
        jPanel8 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        inputSalario1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        inputComissao1 = new javax.swing.JTextField();
        botaoModificar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Funcionário");

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Informações Complementares"));

        jLabel17.setText("Salário:");

        jLabel18.setText("Comissão: ");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(8, 8, 8)))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputCnsulComisFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                    .addComponent(inputCnsulSalFuncionario))
                .addGap(52, 52, 52))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(inputCnsulSalFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(inputCnsulComisFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jTable2.setModel(tableFuncionario);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Voltar.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setText("Nome:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(46, 46, 46))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 806, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(inputPesqNome)))
                .addGap(24, 24, 24))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(inputPesqNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jButton1)))
                .addGap(0, 0, 0))
        );

        jTabbedPane1.addTab("Consultar", jPanel2);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dadosNewContato.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados de Contato", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        newTelefone.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        newTelefone.setText("Telefone:");

        newCelular.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        newCelular.setText("Celular: ");

        newEmail.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        newEmail.setText("E-mail:");

        try {
            jFormattedTextField3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jFormattedTextField4.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout dadosNewContatoLayout = new javax.swing.GroupLayout(dadosNewContato);
        dadosNewContato.setLayout(dadosNewContatoLayout);
        dadosNewContatoLayout.setHorizontalGroup(
            dadosNewContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dadosNewContatoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dadosNewContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(newCelular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(newEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(newTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(dadosNewContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jFormattedTextField3)
                    .addComponent(inputNewEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                    .addComponent(jFormattedTextField4))
                .addGap(23, 23, 23))
        );
        dadosNewContatoLayout.setVerticalGroup(
            dadosNewContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dadosNewContatoLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(dadosNewContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newTelefone)
                    .addComponent(jFormattedTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dadosNewContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newCelular)
                    .addComponent(jFormattedTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(dadosNewContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newEmail)
                    .addComponent(inputNewEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jPanel1.add(dadosNewContato, new org.netbeans.lib.awtextra.AbsoluteConstraints(453, 26, -1, 200));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados de Pagamento"));

        jLabel1.setText("Salário: ");

        jLabel2.setText("Comissão:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputComissao, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(inputSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(inputComissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 392, 360, 80));

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel1.add(dadosNewLocalizacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 232, 785, -1));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Empresariais "));

        jLabel3.setText("Senha:");

        checkBoxAutorizado.setText("Autorizado");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputSenhaFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkBoxAutorizado)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(inputSenhaFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBoxAutorizado))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 390, 294, 90));

        botaoCadastrarFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/AddUser.png"))); // NOI18N
        botaoCadastrarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastrarFuncionarioActionPerformed(evt);
            }
        });
        jPanel1.add(botaoCadastrarFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 410, -1, -1));

        dadosNewPessoais3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados Pessoais", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        newNomeCompleto3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        newNomeCompleto3.setText("Nome completo: ");

        inputNewNome3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNewNome3ActionPerformed(evt);
            }
        });

        newCPF.setText("CPF:");

        newRG.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        newRG.setText("RG:");

        newNascimento.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        newNascimento.setText("Data de Nascimento:");

        inputNewAno.setModel(modelAno);
        inputNewAno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNewAnoActionPerformed(evt);
            }
        });

        inputNewMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        inputNewMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNewMesActionPerformed(evt);
            }
        });

        inputNewDia.setModel(modelDia);

        newCNH.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        newCNH.setText("CTPS:");

        try {
            jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jFormattedTextField2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout dadosNewPessoais3Layout = new javax.swing.GroupLayout(dadosNewPessoais3);
        dadosNewPessoais3.setLayout(dadosNewPessoais3Layout);
        dadosNewPessoais3Layout.setHorizontalGroup(
            dadosNewPessoais3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dadosNewPessoais3Layout.createSequentialGroup()
                .addGroup(dadosNewPessoais3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dadosNewPessoais3Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(newCNH, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(inputNewCNH, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dadosNewPessoais3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(newNascimento)
                        .addGap(32, 32, 32)
                        .addComponent(inputNewDia, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(inputNewMes, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(inputNewAno, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dadosNewPessoais3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(dadosNewPessoais3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(dadosNewPessoais3Layout.createSequentialGroup()
                                .addComponent(newRG, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jFormattedTextField1)
                                .addGap(18, 18, 18)
                                .addComponent(newCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(dadosNewPessoais3Layout.createSequentialGroup()
                                .addComponent(newNomeCompleto3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(inputNewNome3, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(11, 11, 11))
        );
        dadosNewPessoais3Layout.setVerticalGroup(
            dadosNewPessoais3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dadosNewPessoais3Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(dadosNewPessoais3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dadosNewPessoais3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(newNomeCompleto3))
                    .addComponent(inputNewNome3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dadosNewPessoais3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dadosNewPessoais3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(newRG)
                        .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dadosNewPessoais3Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(dadosNewPessoais3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(newCPF))))
                .addGap(18, 18, 18)
                .addGroup(dadosNewPessoais3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dadosNewPessoais3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(newCNH))
                    .addComponent(inputNewCNH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(dadosNewPessoais3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dadosNewPessoais3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(newNascimento))
                    .addComponent(inputNewDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputNewMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputNewAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel1.add(dadosNewPessoais3, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 26, 430, 200));

        jTabbedPane1.addTab("Cadastrar", jPanel1);

        dadosNewContato1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados de Contato", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        newTelefone1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        newTelefone1.setText("Telefone:");

        newCelular1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        newCelular1.setText("Celular: ");

        newEmail1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        newEmail1.setText("E-mail:");

        try {
            jFormattedTextField5.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jFormattedTextField6.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout dadosNewContato1Layout = new javax.swing.GroupLayout(dadosNewContato1);
        dadosNewContato1.setLayout(dadosNewContato1Layout);
        dadosNewContato1Layout.setHorizontalGroup(
            dadosNewContato1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dadosNewContato1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dadosNewContato1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(newCelular1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(newEmail1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(newTelefone1, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dadosNewContato1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(inputNewEmail1, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                    .addComponent(jFormattedTextField5)
                    .addComponent(jFormattedTextField6))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        dadosNewContato1Layout.setVerticalGroup(
            dadosNewContato1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dadosNewContato1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(dadosNewContato1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newTelefone1)
                    .addComponent(jFormattedTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dadosNewContato1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newCelular1)
                    .addComponent(jFormattedTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(dadosNewContato1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newEmail1)
                    .addComponent(inputNewEmail1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Empresariais "));

        jLabel4.setText("Senha:");

        checkBoxAutorizado1.setText("Autorizado");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputSenhaFuncionario1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkBoxAutorizado1)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(inputSenhaFuncionario1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBoxAutorizado1))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        dadosNewLocalizacao1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados de Localização", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        newRua1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        newRua1.setText("Rua:");

        newBairro1.setText("Bairro: ");

        newCidade1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        newCidade1.setText("Cidade:");

        newNumero1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        newNumero1.setText("Número:");

        newReferencia1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        newReferencia1.setText("Referência:");

        newComplemento1.setText("Complemento:");

        newUF1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        newUF1.setText("UF:");

        inputNewUF1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));

        javax.swing.GroupLayout dadosNewLocalizacao1Layout = new javax.swing.GroupLayout(dadosNewLocalizacao1);
        dadosNewLocalizacao1.setLayout(dadosNewLocalizacao1Layout);
        dadosNewLocalizacao1Layout.setHorizontalGroup(
            dadosNewLocalizacao1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dadosNewLocalizacao1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(dadosNewLocalizacao1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(newCidade1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(newReferencia1, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                    .addComponent(newRua1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(dadosNewLocalizacao1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(dadosNewLocalizacao1Layout.createSequentialGroup()
                        .addGroup(dadosNewLocalizacao1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(dadosNewLocalizacao1Layout.createSequentialGroup()
                                .addComponent(inputNewCidade1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(newUF1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(dadosNewLocalizacao1Layout.createSequentialGroup()
                                .addComponent(inputNewRua1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(newBairro1)))
                        .addGap(18, 18, 18)
                        .addGroup(dadosNewLocalizacao1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(inputNewBairro1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(dadosNewLocalizacao1Layout.createSequentialGroup()
                                .addComponent(inputNewUF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(newNumero1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(inputNewNumero1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(dadosNewLocalizacao1Layout.createSequentialGroup()
                        .addComponent(inputNewReferencia1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(newComplemento1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(inputNewComplemento1)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        dadosNewLocalizacao1Layout.setVerticalGroup(
            dadosNewLocalizacao1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dadosNewLocalizacao1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dadosNewLocalizacao1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newRua1)
                    .addComponent(inputNewRua1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputNewBairro1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newBairro1))
                .addGap(18, 18, 18)
                .addGroup(dadosNewLocalizacao1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dadosNewLocalizacao1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(newNumero1)
                        .addComponent(inputNewNumero1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dadosNewLocalizacao1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(newCidade1)
                        .addComponent(inputNewCidade1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(newUF1)
                        .addComponent(inputNewUF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addGroup(dadosNewLocalizacao1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newReferencia1)
                    .addComponent(inputNewReferencia1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newComplemento1)
                    .addComponent(inputNewComplemento1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 40, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados de Pagamento"));

        jLabel5.setText("Salário: ");

        jLabel6.setText("Comissão:");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputSalario1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputComissao1)
                .addGap(27, 27, 27))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(inputSalario1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(inputComissao1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        botaoModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Confirmar.png"))); // NOI18N
        botaoModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(dadosNewLocalizacao1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botaoModificar)
                        .addGap(0, 21, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(dadosNewContato1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(dadosNewContato1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(dadosNewLocalizacao1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(botaoModificar)))
                .addGap(0, 0, 0))
        );

        jTabbedPane1.addTab("Modificar", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoCadastrarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCadastrarFuncionarioActionPerformed
        try {
            //Definição do Endereço
            Endereco endereco = new Endereco();
            endereco.setBairro(inputNewBairro.getText());
            endereco.setCidade(inputNewCidade.getText());
            endereco.setComplemento(inputNewComplemento.getText());
            endereco.setNumero(Integer.parseInt(inputNewNumero.getText()));
            endereco.setReferencia(inputNewReferencia.getText());
            endereco.setRua(inputNewRua.getText());
            endereco.setUf(inputNewUF.getSelectedItem().toString());
            
            //Definição do Funcionario
            Funcionario funcionario = new Funcionario();
            funcionario.setSalario(Float.parseFloat(inputComissao.getText()));
            funcionario.setComissao(Float.parseFloat(inputComissao.getText()));
            funcionario.setCpf(Formatacao.numerosCPF(jFormattedTextField2.getText()));
            funcionario.setCtps(inputNewCNH.getText());
            funcionario.setData_nascimento(LocalDate.of(Integer.parseInt(inputNewAno.getSelectedItem().toString()), 
                                                        Integer.parseInt(inputNewMes.getSelectedItem().toString()), 
                                                        Integer.parseInt(inputNewDia.getSelectedItem().toString())));
            funcionario.setEmail(inputNewEmail.getText());
            funcionario.setEndereco(endereco);
            funcionario.setGerente(checkBoxAutorizado.isSelected());
            funcionario.setNome(inputNewNome3.getText());
            funcionario.setRg(Formatacao.formatarRG(jFormattedTextField1.getText()));
            funcionario.setTelefoneFixo(Formatacao.numerosTelefone(jFormattedTextField3.getText()));
            funcionario.setTelefoneMovel(Formatacao.numerosTelefone(jFormattedTextField4.getText()));
            
            //Armazenar no Banco de Dados
            DaoFuncionario.insert(funcionario, String.valueOf(inputSenhaFuncionario.getPassword()));
            tableFuncionario.atualizar();
            ControleLogin.addFuncionarioCadastrado();
            
            JOptionPane.showMessageDialog(this, "Cadastrado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botaoCadastrarFuncionarioActionPerformed

    private void inputNewNome3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNewNome3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputNewNome3ActionPerformed

    private void inputNewAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNewAnoActionPerformed
        atualizarModelDia();
        inputNewDia.setModel(modelDia);
    }//GEN-LAST:event_inputNewAnoActionPerformed

    private void inputNewMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNewMesActionPerformed
        atualizarModelDia();
        inputNewDia.setModel(modelDia);
    }//GEN-LAST:event_inputNewMesActionPerformed

    private void botaoModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoModificarActionPerformed
        try {
            Funcionario funcionario = DaoFuncionario.retrieve(String.valueOf(tableFuncionario.getValueAt(jTable2.getSelectedRow(), 0)));
            //Atualização do Funcionário
            funcionario.setTelefoneFixo(Formatacao.numerosTelefone(jFormattedTextField6.getText()));
            funcionario.setTelefoneMovel(Formatacao.numerosTelefone(jFormattedTextField5.getText()));
            funcionario.setEmail(inputNewEmail1.getText());
            funcionario.setSalario(Float.parseFloat(inputSalario1.getText()));
            funcionario.setComissao(Float.parseFloat(inputComissao1.getText()));
            funcionario.setGerente(checkBoxAutorizado1.isSelected());
            //Atualização do Endereço do Funcionário
            funcionario.getEndereco().setBairro(inputNewBairro1.getText());
            funcionario.getEndereco().setCidade(inputNewCidade1.getText());
            funcionario.getEndereco().setComplemento(inputNewComplemento1.getText());
            funcionario.getEndereco().setNumero(Integer.parseInt(inputNewNumero1.getText()));
            funcionario.getEndereco().setReferencia(inputNewReferencia1.getText());
            funcionario.getEndereco().setRua(inputNewRua1.getText());
            funcionario.getEndereco().setUf(inputNewUF1.getSelectedItem().toString().toUpperCase());
            //Atualizando no Banco e mostrando se deu certo
            DaoFuncionario.update(funcionario, String.valueOf(inputSenhaFuncionario1.getPassword()));
            JOptionPane.showMessageDialog(this, "Alterado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao atualizar o funcionário", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botaoModificarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        ControleLogin.MENU.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        try {
            Funcionario funcionario = DaoFuncionario.retrieve(String.valueOf(tableFuncionario.getValueAt(jTable2.getSelectedRow(), 0)));
            inputCnsulSalFuncionario.setText("R$" + funcionario.getSalario());
            inputCnsulComisFuncionario.setText(funcionario.getComissao() + "%");
            jFormattedTextField6.setText(funcionario.getTelefoneFixo());
            jFormattedTextField5.setText(funcionario.getTelefoneMovel());
            inputNewEmail1.setText(funcionario.getEmail());
            inputNewRua1.setText(funcionario.getEndereco().getRua());
            inputNewBairro1.setText(funcionario.getEndereco().getBairro());
            inputNewCidade1.setText(funcionario.getEndereco().getCidade());
            inputNewComplemento1.setText(funcionario.getEndereco().getComplemento());
            inputNewReferencia1.setText(funcionario.getEndereco().getReferencia());
            inputNewUF1.setSelectedItem(funcionario.getEndereco().getUf());
            inputNewNumero1.setText(String.valueOf(funcionario.getEndereco().getNumero()));
            inputSalario1.setText(String.valueOf(funcionario.getSalario()));
            inputComissao1.setText(String.valueOf(funcionario.getComissao()));
            checkBoxAutorizado1.setSelected(funcionario.isGerente());
        } catch (Exception e) {

        }
    }//GEN-LAST:event_jTable2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCadastrarFuncionario;
    private javax.swing.JButton botaoModificar;
    private javax.swing.JCheckBox checkBoxAutorizado;
    private javax.swing.JCheckBox checkBoxAutorizado1;
    private javax.swing.JPanel dadosNewContato;
    private javax.swing.JPanel dadosNewContato1;
    private javax.swing.JPanel dadosNewLocalizacao;
    private javax.swing.JPanel dadosNewLocalizacao1;
    private javax.swing.JPanel dadosNewPessoais3;
    private javax.swing.JTextField inputCnsulComisFuncionario;
    private javax.swing.JTextField inputCnsulSalFuncionario;
    private javax.swing.JTextField inputComissao;
    private javax.swing.JTextField inputComissao1;
    private javax.swing.JComboBox<String> inputNewAno;
    private javax.swing.JTextField inputNewBairro;
    private javax.swing.JTextField inputNewBairro1;
    private javax.swing.JTextField inputNewCNH;
    private javax.swing.JTextField inputNewCidade;
    private javax.swing.JTextField inputNewCidade1;
    private javax.swing.JTextField inputNewComplemento;
    private javax.swing.JTextField inputNewComplemento1;
    private javax.swing.JComboBox<String> inputNewDia;
    private javax.swing.JTextField inputNewEmail;
    private javax.swing.JTextField inputNewEmail1;
    private javax.swing.JComboBox<String> inputNewMes;
    private javax.swing.JTextField inputNewNome3;
    private javax.swing.JTextField inputNewNumero;
    private javax.swing.JTextField inputNewNumero1;
    private javax.swing.JTextField inputNewReferencia;
    private javax.swing.JTextField inputNewReferencia1;
    private javax.swing.JTextField inputNewRua;
    private javax.swing.JTextField inputNewRua1;
    private javax.swing.JComboBox<String> inputNewUF;
    private javax.swing.JComboBox<String> inputNewUF1;
    private javax.swing.JTextField inputPesqNome;
    private javax.swing.JTextField inputSalario;
    private javax.swing.JTextField inputSalario1;
    private javax.swing.JPasswordField inputSenhaFuncionario;
    private javax.swing.JPasswordField inputSenhaFuncionario1;
    private javax.swing.JButton jButton1;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JFormattedTextField jFormattedTextField3;
    private javax.swing.JFormattedTextField jFormattedTextField4;
    private javax.swing.JFormattedTextField jFormattedTextField5;
    private javax.swing.JFormattedTextField jFormattedTextField6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel newBairro;
    private javax.swing.JLabel newBairro1;
    private javax.swing.JLabel newCNH;
    private javax.swing.JLabel newCPF;
    private javax.swing.JLabel newCelular;
    private javax.swing.JLabel newCelular1;
    private javax.swing.JLabel newCidade;
    private javax.swing.JLabel newCidade1;
    private javax.swing.JLabel newComplemento;
    private javax.swing.JLabel newComplemento1;
    private javax.swing.JLabel newEmail;
    private javax.swing.JLabel newEmail1;
    private javax.swing.JLabel newNascimento;
    private javax.swing.JLabel newNomeCompleto3;
    private javax.swing.JLabel newNumero;
    private javax.swing.JLabel newNumero1;
    private javax.swing.JLabel newRG;
    private javax.swing.JLabel newReferencia;
    private javax.swing.JLabel newReferencia1;
    private javax.swing.JLabel newRua;
    private javax.swing.JLabel newRua1;
    private javax.swing.JLabel newTelefone;
    private javax.swing.JLabel newTelefone1;
    private javax.swing.JLabel newUF;
    private javax.swing.JLabel newUF1;
    // End of variables declaration//GEN-END:variables
}
