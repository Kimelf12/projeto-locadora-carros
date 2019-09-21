package visao;

import controle.Formatacao;
import dataAcess.Autenticacao;
import dataAcess.Conexao;
import controle.ControleLogin;
import dataAcess.DaoFuncionario;
import dataAcess.DaoLocadora;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import modelo.Endereco;
import modelo.Funcionario;
import modelo.Locadora;

/**
 * @author Augusto, Erick e Filipe - INFO 2
 */

public final class Login extends javax.swing.JFrame {

    public Login() {
        //Definição do título do Frame
        super("Login");
        
        //Estabelecimento da conexão ao Banco de Dados
        if (!Conexao.conectar()) {
            JOptionPane.showMessageDialog(this, "Impossível se conectar ao Banco de Dados", "Erro", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        
        //Definição da Locadora
        Locadora locadora;
        try {
             locadora = DaoLocadora.getList().get(0);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Bem vindo! A seguir, informe os dados de seu estabelecimento", "Welcome", JOptionPane.INFORMATION_MESSAGE);
            
            locadora = new Locadora();
            locadora.setNomeLocadora(JOptionPane.showInputDialog(this, "Informe o nome"));
            locadora.setCnpj(JOptionPane.showInputDialog(this, "Informe o CNPJ"));
            locadora.setContaBancaria(JOptionPane.showInputDialog(this, "Informe a conta bancária"));
            locadora.setDataFundacao(LocalDate.parse(JOptionPane.showInputDialog(this, "Informe a data de fundação")));
            locadora.setDataFundacao(LocalDate.now());
            
            Endereco endereco = new Endereco();
            endereco.setRua(JOptionPane.showInputDialog(this, "Informe a rua"));
            endereco.setNumero(Integer.parseInt(JOptionPane.showInputDialog(this, "Informe o número")));
            endereco.setBairro(JOptionPane.showInputDialog(this, "Informe o bairro"));
            endereco.setReferencia(JOptionPane.showInputDialog(this, "Informe uma referência"));
            endereco.setCidade(JOptionPane.showInputDialog(this, "Informe a cidade"));
            endereco.setUf(JOptionPane.showInputDialog(this, "Informe o estado"));
            locadora.setEndereco(endereco);
            
            try {
                DaoLocadora.insert(locadora);
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(this, "Ocorreu um erro", "Erro", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
            
        }
        
        //Instanciação e posicionamento dos componentes
        initComponents();
        this.setLocationRelativeTo(null);
        
        iniciarPrograma ();
    }
    
    private void iniciarPrograma () {
        ControleLogin.iniciarPrograma(this);
        jLabel1.setText(ControleLogin.LOCADORA.getNomeLocadora());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        grupoBotaoUsuarioLogin = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        inputNewCPF = new javax.swing.JFormattedTextField();
        inputSenhaLogin = new javax.swing.JPasswordField();
        botaoLogin = new javax.swing.JButton();
        botaoSair = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jLabel5.setText("Desenvolvido pela AEF ");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Nome da Concessionária");

        jLabel2.setFont(new java.awt.Font("Gill Sans MT", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Bem-vindo de volta!");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do Usuário", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        try {
            inputNewCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(inputNewCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 100, -1));
        jPanel1.add(inputSenhaLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 100, -1));

        botaoLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Login.png"))); // NOI18N
        botaoLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLoginActionPerformed(evt);
            }
        });
        jPanel1.add(botaoLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 60, 50));

        botaoSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Sair.png"))); // NOI18N
        botaoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSairActionPerformed(evt);
            }
        });
        jPanel1.add(botaoSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 60, 50));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("CPF:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Senha:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addComponent(jLabel2)
                .addGap(35, 35, 35)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLoginActionPerformed
        try {
            if (Autenticacao.loginValido(Formatacao.numerosCPF(inputNewCPF.getText()), String.valueOf(inputSenhaLogin.getPassword()))) {
                //Usuário autenticado
                JOptionPane.showMessageDialog(this, "Autorizado", "Sim", JOptionPane.INFORMATION_MESSAGE);
                Funcionario funcionario = DaoFuncionario.retrieve(Formatacao.numerosCPF(inputNewCPF.getText()));
                ControleLogin.iniciarSessao(funcionario);
                this.setVisible(false);
                ControleLogin.MENU.setVisible(true);

            } else {
                JOptionPane.showMessageDialog(this, "Usuário ou senha inválidos", "Erro", JOptionPane.ERROR_MESSAGE);
            }
            
            inputNewCPF.setText("");
            inputSenhaLogin.setText("");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage() + "\n" + e.toString());
        }
    }//GEN-LAST:event_botaoLoginActionPerformed

    private void botaoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSairActionPerformed
        sair();
    }//GEN-LAST:event_botaoSairActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        sair();
    }//GEN-LAST:event_formWindowClosing

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        Conexao.desconectar();
    }//GEN-LAST:event_formWindowClosed

    private void sair () {
        if (JOptionPane.showConfirmDialog(this, "Você deseja mesmo sair?") == JOptionPane.YES_OPTION) {
            Conexao.desconectar();
            System.exit(0);
        }
    }
    
    public static void main(String args[]) {
        //Definição do Look And Feel
        try {
            javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
        } catch (Exception ex) {
        }
        
        //Definição do objeto Login
        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoLogin;
    private javax.swing.JButton botaoSair;
    private javax.swing.ButtonGroup grupoBotaoUsuarioLogin;
    private javax.swing.JFormattedTextField inputNewCPF;
    private javax.swing.JPasswordField inputSenhaLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
