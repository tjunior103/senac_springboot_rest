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
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Silvio
 */
public class CadastroChamado extends javax.swing.JFrame {
    
    private Session session;
    private Chamado chamado;
    private ChamadoDao chamadoDao;

    /**
     * novo cadastro
     */
    public CadastroChamado() {
        initComponents();
        formatarData(new Date());
        chamadoDao = new ChamadoDaoImpl();
        lbSituacao.setVisible(false);
        tfSituacao.setVisible(false);
    }

    /**
     * edição de cadastro
     */
    public CadastroChamado(Chamado chamado) {
        initComponents();
        this.chamado = chamado;
        chamadoDao = new ChamadoDaoImpl();
        tfEquipamento.setText(chamado.getEquipamento());
        taDescricao.setText(chamado.getDescricao());
        formatarData(chamado.getCadastro());
        btSalvar.setText("Alterar");
        titulo.setText("Alteração de Cadastro");
        
        tfSituacao.setText(chamado.isAtivo() ? "Aberto" : "Encerrado");
    }
    
    private void formatarData(Date data) {
        SimpleDateFormat dataFormatada = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        dataCadastro.setText(dataFormatada.format(data));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painel_principal = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        lb_dataCadastro = new javax.swing.JLabel();
        btSalvar = new javax.swing.JButton();
        dataCadastro = new javax.swing.JLabel();
        equipamento = new javax.swing.JLabel();
        descricao = new javax.swing.JLabel();
        tfEquipamento = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        taDescricao = new javax.swing.JTextArea();
        btLimpar = new javax.swing.JButton();
        lbSituacao = new javax.swing.JLabel();
        tfSituacao = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro Chamado");

        titulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Cadastro de Chamado");
        titulo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        lb_dataCadastro.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_dataCadastro.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_dataCadastro.setText("Data Cadastro:");

        btSalvar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btSalvar.setText("Salvar");
        btSalvar.setPreferredSize(new java.awt.Dimension(90, 25));
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        dataCadastro.setText(" ");

        equipamento.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        equipamento.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        equipamento.setText("Equipamento: *");

        descricao.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        descricao.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        descricao.setText("Descrição: *");

        tfEquipamento.setText(" ");

        taDescricao.setColumns(20);
        taDescricao.setRows(5);
        jScrollPane1.setViewportView(taDescricao);

        btLimpar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btLimpar.setText("Limpar");
        btLimpar.setPreferredSize(new java.awt.Dimension(90, 25));
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });

        lbSituacao.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbSituacao.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbSituacao.setText("Situação:");

        tfSituacao.setText("  ");

        javax.swing.GroupLayout painel_principalLayout = new javax.swing.GroupLayout(painel_principal);
        painel_principal.setLayout(painel_principalLayout);
        painel_principalLayout.setHorizontalGroup(
            painel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_principalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                    .addGroup(painel_principalLayout.createSequentialGroup()
                        .addGroup(painel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painel_principalLayout.createSequentialGroup()
                                .addGroup(painel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(equipamento, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(painel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfEquipamento)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(painel_principalLayout.createSequentialGroup()
                                .addGap(199, 199, 199)
                                .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(painel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painel_principalLayout.createSequentialGroup()
                                    .addComponent(lbSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(tfSituacao))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painel_principalLayout.createSequentialGroup()
                                    .addComponent(lb_dataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(dataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painel_principalLayout.setVerticalGroup(
            painel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_principalLayout.createSequentialGroup()
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(painel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_dataCadastro)
                    .addComponent(dataCadastro))
                .addGap(6, 6, 6)
                .addGroup(painel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSituacao)
                    .addComponent(tfSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(equipamento)
                    .addComponent(tfEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descricao)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
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
            session = HibernateUtil.abrirConexao();
            
            if (chamado == null) {
                chamado = new Chamado(tfEquipamento.getText(), taDescricao.getText());                
            } else {
                chamado.setDescricao(taDescricao.getText());
                chamado.setEquipamento(tfEquipamento.getText());
            }
            
            try {
                chamadoDao.salvarOuAlterar(chamado, session);
                JOptionPane.showMessageDialog(null, "Salvo com sucesso!!");
                limpar();
            } catch (HibernateException e) {
                JOptionPane.showMessageDialog(null, "Erro ao salvar");
            }
            
        }
        //TODO criar validação dos campos
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        limpar();
    }//GEN-LAST:event_btLimparActionPerformed
    
    private boolean validarCampo() {
        String mensagem = "";
        boolean erro = false;
        String equipamentoTela = tfEquipamento.getText().trim();
        if (equipamentoTela.length() <= 1) {
            mensagem += "Valor inválido para o equipamento!\n";
            erro = true;
        }
        
        String observacao = taDescricao.getText().trim();
        if (observacao.length() <= 5) {
            mensagem += "Valor inválido para o descrição!";
            erro = true;
        }
        if (erro) {
            JOptionPane.showMessageDialog(null, mensagem);
        }
        return erro;
    }
    
    private void limpar() {
        tfEquipamento.setText("");
        taDescricao.setText("");
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
            java.util.logging.Logger.getLogger(CadastroChamado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroChamado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroChamado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroChamado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroChamado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btLimpar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JLabel dataCadastro;
    private javax.swing.JLabel descricao;
    private javax.swing.JLabel equipamento;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbSituacao;
    private javax.swing.JLabel lb_dataCadastro;
    private javax.swing.JPanel painel_principal;
    private javax.swing.JTextArea taDescricao;
    private javax.swing.JTextField tfEquipamento;
    private javax.swing.JTextField tfSituacao;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
