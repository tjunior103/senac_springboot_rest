/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import dao.HibernateUtil;
import dao.PerfilDao;
import dao.PerfilDaoImpl;
import dao.UsuarioDao;
import dao.UsuarioDaoImpl;
import entidade.Endereco;
import entidade.Perfil;
import entidade.Usuario;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import web_service.EnderecoWebService;

/**
 *
 * @author Silvio
 */
public class CadastroFornecedor extends javax.swing.JFrame {

    private PerfilDao perfilDao;
    private UsuarioDao usuarioDao;
    private Session sessao;
    private List<Perfil> perfis;
    private Usuario usuario;
    private Endereco endereco;

    public CadastroFornecedor() {
        initComponents();
        usuarioDao = new UsuarioDaoImpl();
    }

    public CadastroFornecedor(Usuario usuario) {
        initComponents();
        this.usuario = usuario;
        usuarioDao = new UsuarioDaoImpl();
        carregarParaAlterar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painel_principal = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        lb_nome = new javax.swing.JLabel();
        btSalvar = new javax.swing.JButton();
        lb_login = new javax.swing.JLabel();
        lb_perfil = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        tfLogradouro = new javax.swing.JTextField();
        btLimpar = new javax.swing.JButton();
        lb_nome1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taDescricao = new javax.swing.JTextArea();
        tfBairro = new javax.swing.JTextField();
        lb_perfil1 = new javax.swing.JLabel();
        lb_perfil2 = new javax.swing.JLabel();
        lb_perfil3 = new javax.swing.JLabel();
        lb_login1 = new javax.swing.JLabel();
        tfCep = new javax.swing.JFormattedTextField();
        tfCidade = new javax.swing.JTextField();
        tfEstado = new javax.swing.JTextField();
        tfComplemento = new javax.swing.JTextField();
        btPesquisarCep = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro Usuário");

        titulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Cadastro de Fornecedor");
        titulo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        lb_nome.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_nome.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_nome.setText("Nome:");

        btSalvar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btSalvar.setText("Salvar");
        btSalvar.setPreferredSize(new java.awt.Dimension(90, 25));
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        lb_login.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_login.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_login.setText("Logradouro:");

        lb_perfil.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_perfil.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_perfil.setText("Bairro:");

        tfNome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        tfLogradouro.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btLimpar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btLimpar.setText("Limpar");
        btLimpar.setPreferredSize(new java.awt.Dimension(90, 25));
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });

        lb_nome1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_nome1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_nome1.setText("Descrição:");

        taDescricao.setColumns(20);
        taDescricao.setRows(5);
        jScrollPane1.setViewportView(taDescricao);

        lb_perfil1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_perfil1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_perfil1.setText("Cidade:");

        lb_perfil2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_perfil2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_perfil2.setText("Estado:");

        lb_perfil3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_perfil3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_perfil3.setText("Complemento:");

        lb_login1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_login1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_login1.setText("CEP:");

        try {
            tfCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btPesquisarCep.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btPesquisarCep.setText("Pesquisar");
        btPesquisarCep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarCepActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painel_principalLayout = new javax.swing.GroupLayout(painel_principal);
        painel_principal.setLayout(painel_principalLayout);
        painel_principalLayout.setHorizontalGroup(
            painel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_principalLayout.createSequentialGroup()
                .addGroup(painel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel_principalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(painel_principalLayout.createSequentialGroup()
                        .addGroup(painel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(painel_principalLayout.createSequentialGroup()
                                    .addComponent(lb_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(painel_principalLayout.createSequentialGroup()
                                    .addGap(165, 165, 165)
                                    .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(painel_principalLayout.createSequentialGroup()
                                    .addComponent(lb_nome1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jScrollPane1))
                                .addGroup(painel_principalLayout.createSequentialGroup()
                                    .addComponent(lb_perfil, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(tfBairro)
                                    .addGap(30, 30, 30))
                                .addGroup(painel_principalLayout.createSequentialGroup()
                                    .addComponent(lb_perfil2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(tfEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(painel_principalLayout.createSequentialGroup()
                                    .addGroup(painel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(lb_login1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lb_login, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(painel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tfLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(painel_principalLayout.createSequentialGroup()
                                            .addComponent(tfCep, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(btPesquisarCep, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(painel_principalLayout.createSequentialGroup()
                                    .addComponent(lb_perfil1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(tfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(painel_principalLayout.createSequentialGroup()
                                .addComponent(lb_perfil3, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 105, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painel_principalLayout.setVerticalGroup(
            painel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_principalLayout.createSequentialGroup()
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addGroup(painel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_nome)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_nome1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_login1)
                    .addComponent(tfCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btPesquisarCep))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_login)
                    .addComponent(tfLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_perfil)
                    .addComponent(tfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_perfil1)
                    .addComponent(tfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_perfil2)
                    .addComponent(tfEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_perfil3)
                    .addComponent(tfComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(painel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel_principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel_principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        if (!validarCampo()) {
            carregarUsuario();
            try {
                sessao = HibernateUtil.abrirConexao();
                usuarioDao.salvarOuAlterar(usuario, sessao);
                JOptionPane.showMessageDialog(null, "Usuário salvo com sucesso!");
                limpar();
            } catch (HibernateException e) {
                if (e.getCause().toString().contains("usuario.login_UNIQUE")) {
                    JOptionPane.showMessageDialog(null, "Já existe um usuário com esse e-mail");
                }
                System.out.println("causa " + e.getCause());
            } finally {
                sessao.close();
            }
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        limpar();
    }//GEN-LAST:event_btLimparActionPerformed

    private void btPesquisarCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarCepActionPerformed
        
        EnderecoWebService webService = new EnderecoWebService();
        endereco = webService.pesquisaCep(tfCep.getText().replace("-", ""));
        
        if (endereco != null) {
            tfBairro.setText(endereco.getBairro());
            tfLogradouro.setText(endereco.getLogradouro());
            tfCidade.setText(endereco.getLocalidade());
            tfEstado.setText(endereco.getUf());
        } else {
            JOptionPane.showMessageDialog(null, "Não existe nenhum endereço com esse CEP!");
        }
    }//GEN-LAST:event_btPesquisarCepActionPerformed

    private void limpar() {
        tfLogradouro.setText("");
        tfNome.setText("");
        usuario = null;
    }

    private void carregarParaAlterar() {
        setTitle("Alterar Usuário");
        btSalvar.setText("Alterar");
        titulo.setText("Alteração de Usuário");
        tfNome.setText(usuario.getNome());
        tfLogradouro.setText(usuario.getLogin());
    }

    private void carregarUsuario() {
        if (usuario == null) {
            usuario = new Usuario();
            usuario.setSenha("12345");
            usuario.setAtivo(true);
        }

        usuario.setNome(tfNome.getText().trim());
        usuario.setLogin(tfLogradouro.getText().trim());

    }

    private boolean validarCampo() {
        String mensagem = "";
        boolean erro = false;
        String nome = tfNome.getText().trim();
        if (nome.length() <= 3) {
            mensagem += "Valor inválido para o nome!\n";
            erro = true;
        }
        String login = tfLogradouro.getText().trim();
        if (login.length() <= 5 || !login.contains("@")) {
            mensagem += "Valor inválido para o e-mail!\n";
            erro = true;
        }
        if (erro) {
            JOptionPane.showMessageDialog(null, mensagem);
        }
        return erro;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroFornecedor.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroFornecedor.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroFornecedor.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroFornecedor.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroFornecedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btLimpar;
    private javax.swing.JButton btPesquisarCep;
    private javax.swing.JButton btSalvar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_login;
    private javax.swing.JLabel lb_login1;
    private javax.swing.JLabel lb_nome;
    private javax.swing.JLabel lb_nome1;
    private javax.swing.JLabel lb_perfil;
    private javax.swing.JLabel lb_perfil1;
    private javax.swing.JLabel lb_perfil2;
    private javax.swing.JLabel lb_perfil3;
    private javax.swing.JPanel painel_principal;
    private javax.swing.JTextArea taDescricao;
    private javax.swing.JTextField tfBairro;
    private javax.swing.JFormattedTextField tfCep;
    private javax.swing.JTextField tfCidade;
    private javax.swing.JTextField tfComplemento;
    private javax.swing.JTextField tfEstado;
    private javax.swing.JTextField tfLogradouro;
    private javax.swing.JTextField tfNome;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
