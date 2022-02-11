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
import entidade.Perfil;
import entidade.Usuario;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Silvio
 */
public class CadastroUsuario extends javax.swing.JFrame {

    private PerfilDao perfilDao;
    private UsuarioDao usuarioDao;
    private Session sessao;
    private List<Perfil> perfis;
    private Usuario usuario;

    public CadastroUsuario() {
        initComponents();
        carregarComboPerfil();
        usuarioDao = new UsuarioDaoImpl();
    }

    public CadastroUsuario(Usuario usuario) {
        initComponents();
        carregarComboPerfil();
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
        tfLogin = new javax.swing.JTextField();
        comboPerfil = new javax.swing.JComboBox<>();
        btLimpar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro Usuário");

        titulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Cadastro de Usuário");
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
        lb_login.setText("Login:");

        lb_perfil.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_perfil.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_perfil.setText("Perfil:");

        tfNome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        tfLogin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btLimpar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btLimpar.setText("Limpar");
        btLimpar.setPreferredSize(new java.awt.Dimension(90, 25));
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
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
                        .addGroup(painel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(painel_principalLayout.createSequentialGroup()
                                .addComponent(lb_login, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfLogin))
                            .addGroup(painel_principalLayout.createSequentialGroup()
                                .addComponent(lb_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(painel_principalLayout.createSequentialGroup()
                                .addComponent(lb_perfil, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(painel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(painel_principalLayout.createSequentialGroup()
                                        .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 125, Short.MAX_VALUE)))
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
                .addGroup(painel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_login)
                    .addComponent(tfLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_perfil)
                    .addComponent(comboPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(painel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(128, Short.MAX_VALUE))
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
               if(e.getCause().toString().contains("usuario.login_UNIQUE")){
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

    private void limpar() {
        tfLogin.setText("");
        tfNome.setText("");
        comboPerfil.setSelectedIndex(0);
        usuario = null;
    }

    private void carregarParaAlterar() {
        setTitle("Alterar Usuário");
        btSalvar.setText("Alterar");
        titulo.setText("Alteração de Usuário");
        tfNome.setText(usuario.getNome());
        tfLogin.setText(usuario.getLogin());
        comboPerfil.setSelectedItem(usuario.getPerfil().getNome());
    }

    private void carregarUsuario() {
        if (usuario == null) {
            usuario = new Usuario();
            usuario.setSenha("12345");
            usuario.setAtivo(true);
        }

        usuario.setNome(tfNome.getText().trim());
        usuario.setLogin(tfLogin.getText().trim());

        int indice = comboPerfil.getSelectedIndex() - 1;
        Perfil perfil = perfis.get(indice);
        usuario.setPerfil(perfil);
    }

    private boolean validarCampo() {
        String mensagem = "";
        boolean erro = false;
        String nome = tfNome.getText().trim();
        if (nome.length() <= 3) {
            mensagem += "Valor inválido para o nome!\n";
            erro = true;
        }
        String login = tfLogin.getText().trim();
        if (login.length() <= 5 || !login.contains("@")) {
            mensagem += "Valor inválido para o e-mail!\n";
            erro = true;
        }
        int indice = comboPerfil.getSelectedIndex();
        if (indice <= 0) {
            mensagem += "Valor inválido para o perfil\n";
            erro = true;
        }
        if (erro) {
            JOptionPane.showMessageDialog(null, mensagem);
        }
        return erro;
    }

    private void carregarComboPerfil() {
        perfilDao = new PerfilDaoImpl();
        try {
            sessao = HibernateUtil.abrirConexao();
            perfis = perfilDao.pesquisarTodo(sessao);
        } catch (HibernateException he) {
            System.out.println("Erro ao carregar combobox perfil " + he.getMessage());
        } finally {
            sessao.close();
        }
        comboPerfil.addItem("Selecione uma opção");

        for (Perfil perfil : perfis) {
            comboPerfil.addItem(perfil.getNome());
        }
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
            java.util.logging.Logger.getLogger(CadastroUsuario.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroUsuario.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroUsuario.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroUsuario.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btLimpar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox<String> comboPerfil;
    private javax.swing.JLabel lb_login;
    private javax.swing.JLabel lb_nome;
    private javax.swing.JLabel lb_perfil;
    private javax.swing.JPanel painel_principal;
    private javax.swing.JTextField tfLogin;
    private javax.swing.JTextField tfNome;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
