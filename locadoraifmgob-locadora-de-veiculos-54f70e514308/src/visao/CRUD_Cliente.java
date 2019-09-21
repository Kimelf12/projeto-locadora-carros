package visao;

import java.time.LocalDate;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import controle.ControleLogin;
import controle.Formatacao;
import dataAcess.DaoCliente;
import dataAcess.DaoEndereco;
import javax.swing.event.DocumentListener;
import modelo.Cliente;
import modelo.Endereco;
import tableModel.TBMCliente;

/**
 * @author Augusto, Erick e Filipe - INFO 2
 */

public class CRUD_Cliente extends javax.swing.JFrame {
    private DefaultComboBoxModel modelAno, modelDia;
    private TBMCliente tbmCliente;
   
    public CRUD_Cliente() {
        //Definição do título do frame
        super("Cliente");
        
        //Definição dos modelos
        atualizarModelAno();
        atualizarModelDia();
        tbmCliente = new TBMCliente ();
        
        //Definição dos componentes e posicionamento
        initComponents();
        this.setLocationRelativeTo(null);
        inputNewAno.setSelectedIndex(inputNewAno.getItemCount() - 1);
        
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
    
    private boolean eBissexto (int ano) {
        return ano % 4 == 0;
    }

    private void atualizarModelAno () {
        //Define a partir de 18 anos atrás
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
            //Mês selecionado pelo usuário
            int mes = Integer.parseInt(inputNewMes.getSelectedItem().toString());
            //Ano selecionado pelo usuário
            int ano = Integer.parseInt(inputNewAno.getSelectedItem().toString());
            
            switch(mes) {
                case 2:
                    //Mês de Fevereiro - Difere em caso de ano bissexto
                    if (eBissexto(ano)) {
                        dias = new String[29];
                    } else {
                        dias = new String[28];
                    }
                    break;
                case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                    //Meses de Janeiro, Março, Maio, Julho, Agosto, Outubro e Dezembro - 31 dias
                    dias = new String[31];
                    break;
                default:
                    //Outros meses - 30 dias
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
    
    private void validarCadastro() throws Exception {
        //Validação de CPF
        if (!controle.Validadores.validarCPF(Formatacao.numerosCPF(inputNewCPF.getText()))) {
            throw new Exception("CPF Inválido");
        }
        //Validação da Data de Nascimento
        LocalDate.of(Integer.parseInt(inputNewAno.getSelectedItem().toString()),
                     Integer.parseInt(inputNewMes.getSelectedItem().toString()),
                     Integer.parseInt(inputNewDia.getSelectedItem().toString()));
        //Validação do número da casa
        Integer.parseInt(inputNewNumero.getText());
    }
    
    private void filtrar () {
        //Filtrar por nome e cpf
        tbmCliente.filtrar(inputPesqNome.getText(), "");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        jTabbedPane_CrudCliente = new javax.swing.JTabbedPane();
        Consulta_Cliente = new javax.swing.JPanel();
        pesquisaNome = new javax.swing.JLabel();
        inputPesqNome = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Cliente = new javax.swing.JTable();
        botaoVoltar = new javax.swing.JButton();
        Cadastrar_Cliente = new javax.swing.JPanel();
        botaoConfirmar = new javax.swing.JButton();
        dadosNewPessoais = new javax.swing.JPanel();
        newNomeCompleto = new javax.swing.JLabel();
        inputNewNome = new javax.swing.JTextField();
        newCPF = new javax.swing.JLabel();
        newRG = new javax.swing.JLabel();
        newNascimento = new javax.swing.JLabel();
        inputNewAno = new javax.swing.JComboBox<>();
        inputNewMes = new javax.swing.JComboBox<>();
        inputNewDia = new javax.swing.JComboBox<>();
        newCNH = new javax.swing.JLabel();
        inputNewCNH = new javax.swing.JTextField();
        inputNewRG = new javax.swing.JFormattedTextField();
        inputNewCPF = new javax.swing.JFormattedTextField();
        dadosNewContato = new javax.swing.JPanel();
        newTelefone = new javax.swing.JLabel();
        newCelular = new javax.swing.JLabel();
        newEmail = new javax.swing.JLabel();
        inputNewEmail = new javax.swing.JTextField();
        inputNewTelefone = new javax.swing.JFormattedTextField();
        inputNewCelular = new javax.swing.JFormattedTextField();
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
        Modificar_Cliente = new javax.swing.JPanel();
        dadosLocalizacao = new javax.swing.JPanel();
        rua = new javax.swing.JLabel();
        inputRua = new javax.swing.JTextField();
        bairro = new javax.swing.JLabel();
        inputBairro = new javax.swing.JTextField();
        cidade = new javax.swing.JLabel();
        inputCidade = new javax.swing.JTextField();
        uf = new javax.swing.JLabel();
        inputUF = new javax.swing.JComboBox<>();
        numero = new javax.swing.JLabel();
        inputNumero = new javax.swing.JTextField();
        referencia = new javax.swing.JLabel();
        inputReferencia = new javax.swing.JTextField();
        complemento = new javax.swing.JLabel();
        inputComplemento = new javax.swing.JTextField();
        dadosContato = new javax.swing.JPanel();
        telefone = new javax.swing.JLabel();
        celular = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        inputEmail = new javax.swing.JTextField();
        inputTelefone = new javax.swing.JFormattedTextField();
        inputCelular = new javax.swing.JFormattedTextField();
        textoCliente = new javax.swing.JLabel();
        inputCliente = new javax.swing.JTextField();
        botaoEditar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cliente");
        setResizable(false);

        pesquisaNome.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        pesquisaNome.setText("Nome:");

        inputPesqNome.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                inputPesqNomeInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        inputPesqNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputPesqNomeActionPerformed(evt);
            }
        });

        jTable_Cliente.setModel(tbmCliente);
        jTable_Cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_ClienteMouseClicked(evt);
            }
        });
        jTable_Cliente.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                jTable_ClienteCaretPositionChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_Cliente);

        botaoVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/VoltarMenor.png"))); // NOI18N
        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Consulta_ClienteLayout = new javax.swing.GroupLayout(Consulta_Cliente);
        Consulta_Cliente.setLayout(Consulta_ClienteLayout);
        Consulta_ClienteLayout.setHorizontalGroup(
            Consulta_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Consulta_ClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE))
            .addGroup(Consulta_ClienteLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(pesquisaNome, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(inputPesqNome, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoVoltar)
                .addGap(45, 45, 45))
        );
        Consulta_ClienteLayout.setVerticalGroup(
            Consulta_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Consulta_ClienteLayout.createSequentialGroup()
                .addGroup(Consulta_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Consulta_ClienteLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(Consulta_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pesquisaNome)
                            .addComponent(inputPesqNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Consulta_ClienteLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(botaoVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jTabbedPane_CrudCliente.addTab("Consultar", Consulta_Cliente);

        Cadastrar_Cliente.setLayout(null);

        botaoConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/AddUser.png"))); // NOI18N
        botaoConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoConfirmarActionPerformed(evt);
            }
        });
        Cadastrar_Cliente.add(botaoConfirmar);
        botaoConfirmar.setBounds(400, 410, 100, 50);

        dadosNewPessoais.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados Pessoais", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        dadosNewPessoais.setLayout(null);

        newNomeCompleto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        newNomeCompleto.setText("Nome completo: ");
        dadosNewPessoais.add(newNomeCompleto);
        newNomeCompleto.setBounds(16, 30, 100, 14);

        inputNewNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNewNomeActionPerformed(evt);
            }
        });
        dadosNewPessoais.add(inputNewNome);
        inputNewNome.setBounds(123, 27, 285, 20);

        newCPF.setText("CPF:");
        dadosNewPessoais.add(newCPF);
        newCPF.setBounds(250, 70, 35, 14);

        newRG.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        newRG.setText("RG:");
        dadosNewPessoais.add(newRG);
        newRG.setBounds(16, 68, 89, 14);

        newNascimento.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        newNascimento.setText("Data de Nascimento:");
        dadosNewPessoais.add(newNascimento);
        newNascimento.setBounds(16, 157, 100, 14);

        inputNewAno.setModel(modelAno);
        inputNewAno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNewAnoActionPerformed(evt);
            }
        });
        dadosNewPessoais.add(inputNewAno);
        inputNewAno.setBounds(284, 154, 85, 20);

        inputNewMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        inputNewMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNewMesActionPerformed(evt);
            }
        });
        dadosNewPessoais.add(inputNewMes);
        inputNewMes.setBounds(216, 154, 50, 20);

        inputNewDia.setModel(modelDia);
        dadosNewPessoais.add(inputNewDia);
        inputNewDia.setBounds(148, 154, 50, 20);

        newCNH.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        newCNH.setText("CNH:");
        dadosNewPessoais.add(newCNH);
        newCNH.setBounds(25, 111, 80, 14);
        dadosNewPessoais.add(inputNewCNH);
        inputNewCNH.setBounds(123, 108, 290, 20);

        try {
            inputNewRG.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        dadosNewPessoais.add(inputNewRG);
        inputNewRG.setBounds(120, 70, 120, 20);

        try {
            inputNewCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        dadosNewPessoais.add(inputNewCPF);
        inputNewCPF.setBounds(290, 70, 120, 20);

        Cadastrar_Cliente.add(dadosNewPessoais);
        dadosNewPessoais.setBounds(20, 20, 430, 200);

        dadosNewContato.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados de Contato", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        newTelefone.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        newTelefone.setText("Telefone:");

        newCelular.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        newCelular.setText("Celular: ");

        newEmail.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        newEmail.setText("E-mail:");

        try {
            inputNewTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            inputNewCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(dadosNewContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(inputNewEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                    .addComponent(inputNewTelefone)
                    .addComponent(inputNewCelular))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        dadosNewContatoLayout.setVerticalGroup(
            dadosNewContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dadosNewContatoLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(dadosNewContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newTelefone)
                    .addComponent(inputNewTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dadosNewContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newCelular)
                    .addComponent(inputNewCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(dadosNewContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newEmail)
                    .addComponent(inputNewEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        Cadastrar_Cliente.add(dadosNewContato);
        dadosNewContato.setBounds(460, 20, 360, 200);

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
                .addContainerGap(122, Short.MAX_VALUE))
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

        Cadastrar_Cliente.add(dadosNewLocalizacao);
        dadosNewLocalizacao.setBounds(20, 240, 800, 167);

        jTabbedPane_CrudCliente.addTab("Cadastrar", Cadastrar_Cliente);

        dadosLocalizacao.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados de Localização", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        rua.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rua.setText("Rua:");

        bairro.setText("Bairro: ");

        cidade.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        cidade.setText("Cidade:");

        uf.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        uf.setText("UF:");

        inputUF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));

        numero.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        numero.setText("Número:");

        referencia.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        referencia.setText("Referência:");

        complemento.setText("Complemento:");

        javax.swing.GroupLayout dadosLocalizacaoLayout = new javax.swing.GroupLayout(dadosLocalizacao);
        dadosLocalizacao.setLayout(dadosLocalizacaoLayout);
        dadosLocalizacaoLayout.setHorizontalGroup(
            dadosLocalizacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dadosLocalizacaoLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(dadosLocalizacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(referencia, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                    .addComponent(rua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(dadosLocalizacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(dadosLocalizacaoLayout.createSequentialGroup()
                        .addGroup(dadosLocalizacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(dadosLocalizacaoLayout.createSequentialGroup()
                                .addComponent(inputCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(uf, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(dadosLocalizacaoLayout.createSequentialGroup()
                                .addComponent(inputRua, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(bairro)))
                        .addGap(18, 18, 18)
                        .addGroup(dadosLocalizacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(inputBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(dadosLocalizacaoLayout.createSequentialGroup()
                                .addComponent(inputUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(numero, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(inputNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(dadosLocalizacaoLayout.createSequentialGroup()
                        .addComponent(inputReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(complemento, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(inputComplemento)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        dadosLocalizacaoLayout.setVerticalGroup(
            dadosLocalizacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dadosLocalizacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dadosLocalizacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rua)
                    .addComponent(inputRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bairro))
                .addGap(18, 18, 18)
                .addGroup(dadosLocalizacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cidade)
                    .addComponent(inputCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uf)
                    .addComponent(inputUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numero)
                    .addComponent(inputNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(dadosLocalizacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(referencia)
                    .addComponent(inputReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(complemento)
                    .addComponent(inputComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 40, Short.MAX_VALUE))
        );

        dadosContato.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados de Contato", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        telefone.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        telefone.setText("Telefone:");

        celular.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        celular.setText("Celular: ");

        email.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        email.setText("E-mail:");

        try {
            inputTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            inputCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout dadosContatoLayout = new javax.swing.GroupLayout(dadosContato);
        dadosContato.setLayout(dadosContatoLayout);
        dadosContatoLayout.setHorizontalGroup(
            dadosContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dadosContatoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dadosContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(telefone)
                    .addComponent(celular, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                    .addComponent(email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addGroup(dadosContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(inputEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                    .addComponent(inputTelefone)
                    .addComponent(inputCelular))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        dadosContatoLayout.setVerticalGroup(
            dadosContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dadosContatoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dadosContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(telefone)
                    .addComponent(inputTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dadosContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(celular)
                    .addComponent(inputCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dadosContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(email))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        textoCliente.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        textoCliente.setText("Cliente a ser alterado:");

        inputCliente.setEditable(false);

        botaoEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Modificar.png"))); // NOI18N
        botaoEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Modificar_ClienteLayout = new javax.swing.GroupLayout(Modificar_Cliente);
        Modificar_Cliente.setLayout(Modificar_ClienteLayout);
        Modificar_ClienteLayout.setHorizontalGroup(
            Modificar_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Modificar_ClienteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(349, 349, 349))
            .addGroup(Modificar_ClienteLayout.createSequentialGroup()
                .addGroup(Modificar_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Modificar_ClienteLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(textoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(inputCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Modificar_ClienteLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(Modificar_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dadosLocalizacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Modificar_ClienteLayout.createSequentialGroup()
                                .addComponent(dadosContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(109, 109, 109)))))
                .addGap(0, 25, Short.MAX_VALUE))
        );
        Modificar_ClienteLayout.setVerticalGroup(
            Modificar_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Modificar_ClienteLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(Modificar_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoCliente)
                    .addComponent(inputCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(dadosLocalizacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(dadosContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(botaoEditar)
                .addContainerGap())
        );

        jTabbedPane_CrudCliente.addTab("Modificar", Modificar_Cliente);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane_CrudCliente, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane_CrudCliente)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditarActionPerformed
        try {
            //Pegar cliente correspondente
            String cpf = tbmCliente.getValueAt(jTable_Cliente.getSelectedRow(), 0).toString();
            Cliente cliente = DaoCliente.retrieve(cpf);
            
            //Atualizar dados
            cliente.getEndereco().setBairro(inputBairro.getText());
            cliente.getEndereco().setCidade(inputCidade.getText());
            cliente.getEndereco().setComplemento(inputComplemento.getText());
            cliente.getEndereco().setNumero(Integer.parseInt(inputNumero.getText()));
            cliente.getEndereco().setReferencia(inputReferencia.getText());
            cliente.getEndereco().setRua(inputRua.getText());
            cliente.getEndereco().setUf(inputUF.getSelectedItem().toString());
            cliente.setTelefoneFixo(Formatacao.numerosTelefone(inputTelefone.getText()));
            cliente.setTelefoneMovel(Formatacao.numerosTelefone(inputCelular.getText()));
            cliente.setEmail(inputEmail.getText());
            
            //Executar alterações no Banco
            DaoCliente.update(cliente);

            JOptionPane.showMessageDialog(this, "Atualizado com Sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botaoEditarActionPerformed

    private void inputNewMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNewMesActionPerformed
        atualizarModelDia();
        inputNewDia.setModel(modelDia);
    }//GEN-LAST:event_inputNewMesActionPerformed

    private void inputNewAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNewAnoActionPerformed
        atualizarModelDia();
        inputNewDia.setModel(modelDia);
    }//GEN-LAST:event_inputNewAnoActionPerformed

    private void inputNewNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNewNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputNewNomeActionPerformed

    private void botaoConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConfirmarActionPerformed
        try {
            //Validação dos dados digitados
            validarCadastro();

            //Definição do Endereço
            Endereco endereco = new Endereco();
            endereco.setBairro     (inputNewBairro.getText());
            endereco.setCidade     (inputNewCidade.getText());
            endereco.setComplemento(inputNewComplemento.getText());
            endereco.setNumero     (Integer.parseInt(inputNewNumero.getText()));
            endereco.setReferencia (inputNewReferencia.getText());
            endereco.setRua        (inputNewRua.getText());
            endereco.setUf         (inputNewUF.getSelectedItem().toString());
            DaoEndereco.insert(endereco);

            //Definição do Cliente
            Cliente cliente = new Cliente();
            cliente.setNome           (inputNewNome.getText());
            cliente.setCpf            (Formatacao.numerosCPF(inputNewCPF.getText()));
            cliente.setCnh            (inputNewCNH.getText());
            cliente.setRg             (Formatacao.formatarRG(inputNewRG.getText()));
            cliente.setData_nascimento(LocalDate.of(Integer.parseInt(inputNewAno.getSelectedItem().toString()),
                                                    Integer.parseInt(inputNewMes.getSelectedItem().toString()),
                                                    Integer.parseInt(inputNewDia.getSelectedItem().toString())));
            cliente.setEmail          (inputNewEmail.getText());
            cliente.setTelefoneFixo   (Formatacao.numerosTelefone(inputNewTelefone.getText()));
            cliente.setTelefoneMovel  (Formatacao.numerosTelefone(inputNewCelular.getText()));
            cliente.setEndereco       (endereco);
            cliente.setAutorizado     (true);
            
            DaoCliente.insert(cliente);
            ControleLogin.addClienteCadastrado();
            tbmCliente.atualizar();
            
            JOptionPane.showMessageDialog(this, "Cadastrado com Sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botaoConfirmarActionPerformed

    private void jTable_ClienteCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTable_ClienteCaretPositionChanged

    }//GEN-LAST:event_jTable_ClienteCaretPositionChanged

    private void jTable_ClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_ClienteMouseClicked
        try {
            //Pegar cliente correspondente
            String cpf = tbmCliente.getValueAt(jTable_Cliente.getSelectedRow(), 0).toString();
            Cliente cliente = DaoCliente.retrieve(cpf);

            //Mostrar os dados do cliente na aba correspondente
            inputCliente.setText(cliente.getNome() + " - CPF:" + cliente.getCpf());
            inputRua.setText(cliente.getEndereco().getRua());
            inputNumero.setText(String.valueOf(cliente.getEndereco().getNumero()));
            inputBairro.setText(cliente.getEndereco().getBairro());
            inputCidade.setText(cliente.getEndereco().getCidade());
            inputComplemento.setText(cliente.getEndereco().getComplemento());
            inputReferencia.setText(cliente.getEndereco().getReferencia());
            inputUF.setSelectedItem(cliente.getEndereco().getUf());
            inputEmail.setText(cliente.getEmail());
            inputTelefone.setText(cliente.getTelefoneFixo());
            inputCelular.setText(cliente.getTelefoneMovel());

        } catch (Exception e) {
            inputCliente.setText("-");
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_jTable_ClienteMouseClicked

    private void inputPesqNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputPesqNomeActionPerformed
        filtrar();
    }//GEN-LAST:event_inputPesqNomeActionPerformed

    private void inputPesqNomeInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_inputPesqNomeInputMethodTextChanged
        filtrar();
    }//GEN-LAST:event_inputPesqNomeInputMethodTextChanged

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarActionPerformed
        this.setVisible(false);
        ControleLogin.MENU.setVisible(true);
    }//GEN-LAST:event_botaoVoltarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Cadastrar_Cliente;
    private javax.swing.JPanel Consulta_Cliente;
    private javax.swing.JPanel Modificar_Cliente;
    private javax.swing.JLabel bairro;
    private javax.swing.JButton botaoConfirmar;
    private javax.swing.JButton botaoEditar;
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JLabel celular;
    private javax.swing.JLabel cidade;
    private javax.swing.JLabel complemento;
    private javax.swing.JPanel dadosContato;
    private javax.swing.JPanel dadosLocalizacao;
    private javax.swing.JPanel dadosNewContato;
    private javax.swing.JPanel dadosNewLocalizacao;
    private javax.swing.JPanel dadosNewPessoais;
    private javax.swing.JLabel email;
    private javax.swing.JTextField inputBairro;
    private javax.swing.JFormattedTextField inputCelular;
    private javax.swing.JTextField inputCidade;
    private javax.swing.JTextField inputCliente;
    private javax.swing.JTextField inputComplemento;
    private javax.swing.JTextField inputEmail;
    private javax.swing.JComboBox<String> inputNewAno;
    private javax.swing.JTextField inputNewBairro;
    private javax.swing.JTextField inputNewCNH;
    private javax.swing.JFormattedTextField inputNewCPF;
    private javax.swing.JFormattedTextField inputNewCelular;
    private javax.swing.JTextField inputNewCidade;
    private javax.swing.JTextField inputNewComplemento;
    private javax.swing.JComboBox<String> inputNewDia;
    private javax.swing.JTextField inputNewEmail;
    private javax.swing.JComboBox<String> inputNewMes;
    private javax.swing.JTextField inputNewNome;
    private javax.swing.JTextField inputNewNumero;
    private javax.swing.JFormattedTextField inputNewRG;
    private javax.swing.JTextField inputNewReferencia;
    private javax.swing.JTextField inputNewRua;
    private javax.swing.JFormattedTextField inputNewTelefone;
    private javax.swing.JComboBox<String> inputNewUF;
    private javax.swing.JTextField inputNumero;
    private javax.swing.JTextField inputPesqNome;
    private javax.swing.JTextField inputReferencia;
    private javax.swing.JTextField inputRua;
    private javax.swing.JFormattedTextField inputTelefone;
    private javax.swing.JComboBox<String> inputUF;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane_CrudCliente;
    private javax.swing.JTable jTable_Cliente;
    private javax.swing.JLabel newBairro;
    private javax.swing.JLabel newCNH;
    private javax.swing.JLabel newCPF;
    private javax.swing.JLabel newCelular;
    private javax.swing.JLabel newCidade;
    private javax.swing.JLabel newComplemento;
    private javax.swing.JLabel newEmail;
    private javax.swing.JLabel newNascimento;
    private javax.swing.JLabel newNomeCompleto;
    private javax.swing.JLabel newNumero;
    private javax.swing.JLabel newRG;
    private javax.swing.JLabel newReferencia;
    private javax.swing.JLabel newRua;
    private javax.swing.JLabel newTelefone;
    private javax.swing.JLabel newUF;
    private javax.swing.JLabel numero;
    private javax.swing.JLabel pesquisaNome;
    private javax.swing.JLabel referencia;
    private javax.swing.JLabel rua;
    private javax.swing.JLabel telefone;
    private javax.swing.JLabel textoCliente;
    private javax.swing.JLabel uf;
    // End of variables declaration//GEN-END:variables
}
