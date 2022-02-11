/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import dao.HibernateUtil;
import dao.UsuarioDao;
import dao.UsuarioDaoImpl;
import entidade.Usuario;
import java.awt.HeadlessException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class PesquisaUsuario extends javax.swing.JFrame {

    private Session sessao;
    private DefaultTableModel tabelaModelo;
    private Usuario usuario;
    private UsuarioDao usuarioDao;
    private List<Usuario> usuarios;

    public PesquisaUsuario() {
        initComponents();
        usuarioDao = new UsuarioDaoImpl();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painel_principal = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        lb_nome = new javax.swing.JLabel();
        btPesquisar = new javax.swing.JButton();
        tfNome = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaUsuarios = new javax.swing.JTable();
        btAlterar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        titulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Pesquisa de Usuário");
        titulo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        lb_nome.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_nome.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_nome.setText("Nome:");

        btPesquisar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btPesquisar.setText("Pesquisar");
        btPesquisar.setPreferredSize(new java.awt.Dimension(90, 25));
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });

        tabelaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Login", "Situação", "Perfil", "Ultimo Acesso"
            }
        ));
        jScrollPane1.setViewportView(tabelaUsuarios);
        if (tabelaUsuarios.getColumnModel().getColumnCount() > 0) {
            tabelaUsuarios.getColumnModel().getColumn(0).setMinWidth(170);
            tabelaUsuarios.getColumnModel().getColumn(0).setMaxWidth(200);
            tabelaUsuarios.getColumnModel().getColumn(1).setMinWidth(170);
            tabelaUsuarios.getColumnModel().getColumn(1).setMaxWidth(200);
        }

        btAlterar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btAlterar.setText("Alterar");
        btAlterar.setPreferredSize(new java.awt.Dimension(90, 25));
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        btExcluir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btExcluir.setText("Excluir");
        btExcluir.setPreferredSize(new java.awt.Dimension(90, 25));
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painel_principalLayout = new javax.swing.GroupLayout(painel_principal);
        painel_principal.setLayout(painel_principalLayout);
        painel_principalLayout.setHorizontalGroup(
            painel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_principalLayout.createSequentialGroup()
                .addComponent(lb_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(painel_principalLayout.createSequentialGroup()
                .addGroup(painel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel_principalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE))
                    .addGroup(painel_principalLayout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(btPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(painel_principalLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painel_principalLayout.setVerticalGroup(
            painel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_principalLayout.createSequentialGroup()
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addGroup(painel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_nome)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(painel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
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

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        if (!validarCampo()) {
            sessao = HibernateUtil.abrirConexao();
            try {
                usuarios = usuarioDao.pesquisarPorNome(tfNome.getText().trim(), sessao);
                if (usuarios.isEmpty()) {
                    if (tabelaModelo != null) {
                        tabelaModelo.setNumRows(0);
                    }
                    JOptionPane.showMessageDialog(null, "Não foi encontrado nenhum valor!");
                } else {
                    popularTabela();
                }
            } catch (HibernateException e) {
                System.out.println("Erro ao pesquisar " + e.getMessage());
            } finally {
                sessao.close();
            }
        }
    }//GEN-LAST:event_btPesquisarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        int linhaSelecionada = tabelaUsuarios.getSelectedRow();
        
        if (linhaSelecionada >= 0) {
            int opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir");
            if (opcao == 0) {
                try {
                    sessao = HibernateUtil.abrirConexao();
                    Usuario usuarioSelecionado = usuarios.get(linhaSelecionada);
                    usuarioDao.excluir(usuarioSelecionado, sessao);
                    JOptionPane.showMessageDialog(null, "Usuário excluído com sucesso!");
                    tabelaModelo.setNumRows(0);
                    tfNome.setText("");
                } catch (HeadlessException | HibernateException e) {
                    System.out.println("Erro ao excluir " + e.getMessage());
                } finally {
                    sessao.close();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Não foi selecionada nenhuma linha!");
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        int linhaSelecionada = tabelaUsuarios.getSelectedRow();

        if (linhaSelecionada >= 0) {
            Usuario usuarioSelecionado = usuarios.get(linhaSelecionada);
            new CadastroUsuario(usuarioSelecionado).setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Não foi selecionada nenhuma linha!");
        }
    }//GEN-LAST:event_btAlterarActionPerformed

    private void popularTabela() {
        tabelaModelo = (DefaultTableModel) tabelaUsuarios.getModel();
        tabelaModelo.setNumRows(0);
        String ativo;
        String dataFormatada;
        SimpleDateFormat formatado = new SimpleDateFormat("dd-MM-YYYY");
        for (Usuario usuario : usuarios) {
            ativo = usuario.isAtivo() ? "Ativo" : "Inativo";
            dataFormatada = "-";
            if (usuario.getUltimo_acesso() != null) {
                dataFormatada = formatado.format(usuario.getUltimo_acesso());
            }
            tabelaModelo.addRow(new Object[]{usuario.getNome(), usuario.getLogin(), ativo,
                usuario.getPerfil().getNome(), dataFormatada});
        }
    }

    private boolean validarCampo() {
        boolean erro = false;
        String nome = tfNome.getText().trim();
        if (nome.length() <= 3) {
            JOptionPane.showMessageDialog(null, "Informe um nome válido!");
            erro = true;
        }
        return erro;
    }

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
            java.util.logging.Logger.getLogger(PesquisaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PesquisaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PesquisaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PesquisaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PesquisaUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_nome;
    private javax.swing.JPanel painel_principal;
    private javax.swing.JTable tabelaUsuarios;
    private javax.swing.JTextField tfNome;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
