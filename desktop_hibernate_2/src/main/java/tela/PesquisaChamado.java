/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import dao.ChamadoDao;
import dao.ChamadoDaoImpl;
import dao.HibernateUtil;
import entidade.Chamado;
import java.awt.HeadlessException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Silvio
 */
public class PesquisaChamado extends javax.swing.JFrame {

    private Session session;
    private Chamado chamado;
    private ChamadoDao chamadoDao;
    private List<Chamado> chamados;
    private DefaultTableModel tabelaModelo;

    public PesquisaChamado() {
        initComponents();
        chamadoDao = new ChamadoDaoImpl();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painel_principal = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        lb_nome = new javax.swing.JLabel();
        btPesquisar = new javax.swing.JButton();
        tfEquipamento = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaChamados = new javax.swing.JTable();
        btAlterar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pesquisar Chamado");

        titulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Pesquisa de Chamado");
        titulo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        lb_nome.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_nome.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_nome.setText("Equipamento:");

        btPesquisar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btPesquisar.setText("Pesquisar");
        btPesquisar.setPreferredSize(new java.awt.Dimension(90, 25));
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });

        tfEquipamento.setText(" ");

        tabelaChamados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Equipamento", "Situa????o", "Abertura", "Descri????o"
            }
        ));
        jScrollPane1.setViewportView(tabelaChamados);

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
                .addGroup(painel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel_principalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(painel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(painel_principalLayout.createSequentialGroup()
                                .addComponent(lb_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(painel_principalLayout.createSequentialGroup()
                        .addGroup(painel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painel_principalLayout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(painel_principalLayout.createSequentialGroup()
                                .addGap(96, 96, 96)
                                .addComponent(btPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(btAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 81, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painel_principalLayout.setVerticalGroup(
            painel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_principalLayout.createSequentialGroup()
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(painel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_nome)
                    .addComponent(tfEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(painel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(77, Short.MAX_VALUE))
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
        if (validarCampo()) {
            try {
                session = HibernateUtil.abrirConexao();
                chamados = chamadoDao.
                        pesquisarPorEquipamento(tfEquipamento.getText().trim(), session);
//                chamados = chamadoDao.pesquisarChamadoAberto(session);
                if (chamados.isEmpty()) {
                    if (tabelaModelo != null) {
                        tabelaModelo.setNumRows(0);
                    }
                    JOptionPane.showMessageDialog(null, "N??o foi encontrado nenhum valor!");
                } else {
                    popularTabela();
                }

            } catch (HibernateException e) {
                System.out.println("Erro ao pesquisar " + e.getMessage());
            } finally {
                session.close();
            }

        }
    }//GEN-LAST:event_btPesquisarActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        int linhaSelecionada = tabelaChamados.getSelectedRow();

        if (linhaSelecionada >= 0) {
            Chamado chamadoSelecionado = chamados.get(linhaSelecionada);
            new CadastroChamado(chamadoSelecionado).setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "N??o foi selecionada nenhuma linha!");
        }
    }//GEN-LAST:event_btAlterarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed

        int linhaSelecionada = tabelaChamados.getSelectedRow();

        if (linhaSelecionada >= 0) {
            int opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir");
            if (opcao == 0) {

                try {
                    session = HibernateUtil.abrirConexao();
                    Chamado chamadoSelecionado = chamados.get(linhaSelecionada);
                    chamadoDao.excluir(chamadoSelecionado, session);
                    JOptionPane.showMessageDialog(null, "Chamado exclu??do com sucesso!");
//                    chamados.remove(linhaSelecionada);
//                    popularTabela();
                    tabelaModelo.setNumRows(0);
                    tfEquipamento.setText("");
                } catch (HeadlessException | HibernateException e) {
                    System.out.println("Erro ao excluir " + e.getMessage());
                } finally {
                    session.close();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "N??o foi selecionada nenhuma linha!");
        }


    }//GEN-LAST:event_btExcluirActionPerformed

    private boolean validarCampo() {
        boolean erro = true;
        String equipamento = tfEquipamento.getText().trim();
        if (equipamento.length() <= 1) {
            JOptionPane.showMessageDialog(null, "Valor equipamente inv??lido!");
            erro = false;
        }
        return erro;
    }

    private void popularTabela() {
        tabelaModelo = (DefaultTableModel) tabelaChamados.getModel();
        tabelaModelo.setNumRows(0);
        String ativo;
        SimpleDateFormat formatado = new SimpleDateFormat("dd-MM-YYYY HH:mm");
        for (Chamado chamadoFor : chamados) {
            ativo = chamadoFor.isAtivo() ? "Aberto" : "Encerrado";
            tabelaModelo.addRow(new Object[]{chamadoFor.getEquipamento(), ativo,
                formatado.format(chamadoFor.getCadastro()), chamadoFor.getDescricao()});
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
            java.util.logging.Logger.getLogger(PesquisaChamado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PesquisaChamado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PesquisaChamado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PesquisaChamado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PesquisaChamado().setVisible(true);
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
    private javax.swing.JTable tabelaChamados;
    private javax.swing.JTextField tfEquipamento;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables

}
