/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.DAO.ProjetosDAO;
import model.bean.Projetos;

/**
 *
 * @author Yuri
 */
public class ViewProjetosSupervisor extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public ViewProjetosSupervisor() {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) jTprojetos.getModel();
        jTprojetos.setRowSorter(new TableRowSorter(modelo));
        
        readJTable();
    }
    
    
    public void readJTable(){
        DefaultTableModel modelo = (DefaultTableModel) jTprojetos.getModel();
        modelo.setNumRows(0);
        ProjetosDAO pdao = new ProjetosDAO();
        
        for (Projetos p: pdao.read()) {
            modelo.addRow(new Object[]{
               p.getId(),
               p.getNome_projeto(),
               p.getCliente(),
               p.getValor_contrato(),
               p.getStatus_projeto(),
               p.getStatus_pagamento(),
               p.getGasto_materiais()
            });
        }
        
    
    }
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtNome_projeto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtValor_contrato = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCliente_projeto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        Voltar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtGasto_materiais = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTprojetos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNome_projeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNome_projetoActionPerformed(evt);
            }
        });
        jPanel1.add(txtNome_projeto, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 179, 25));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("CLIENTE :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 50, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("VALOR DO CONTRATO :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 130, 20));
        jPanel1.add(txtValor_contrato, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 180, 25));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Olá supervisor(a)! Veja abaixo nossos projetos!");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, -1, -1));

        txtCliente_projeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCliente_projetoActionPerformed(evt);
            }
        });
        jPanel1.add(txtCliente_projeto, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 178, 25));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("NOME DO PROJETO :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, 20));

        Voltar.setText("↩");
        Voltar.setToolTipText("");
        Voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoltarActionPerformed(evt);
            }
        });
        jPanel1.add(Voltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("GASTO DE MATERIAIS :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, -1, 20));

        txtGasto_materiais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGasto_materiaisActionPerformed(evt);
            }
        });
        jPanel1.add(txtGasto_materiais, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 90, 100, 25));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/saiba-diferenciar-projeto-projeto-basico-e-projeto-executivo.jpg"))); // NOI18N
        jLabel7.setText("   ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 240));

        jTprojetos.setForeground(new java.awt.Color(0, 51, 153));
        jTprojetos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome do PRJ", "Cliente", "Valor Contrato", "Status PRJ", "Status Pagamento", "Gasto Materiais"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTprojetos.setGridColor(new java.awt.Color(255, 102, 102));
        jTprojetos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTprojetosMouseClicked(evt);
            }
        });
        jTprojetos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTprojetosKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTprojetos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 774, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 785, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCliente_projetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCliente_projetoActionPerformed
       
    }//GEN-LAST:event_txtCliente_projetoActionPerformed
 
    
    private void txtNome_projetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNome_projetoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNome_projetoActionPerformed

    private void jTprojetosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTprojetosKeyReleased
        // TODO add your handling code here:
        if (jTprojetos.getSelectedRow()!= -1 )  {
            txtNome_projeto.setText(jTprojetos.getValueAt(jTprojetos.getSelectedRow(), 1).toString());
            txtValor_contrato.setText(jTprojetos.getValueAt(jTprojetos.getSelectedRow(), 3).toString());
            txtCliente_projeto.setText(jTprojetos.getValueAt(jTprojetos.getSelectedRow(), 2).toString());
            txtGasto_materiais.setText(jTprojetos.getValueAt(jTprojetos.getSelectedRow(), 6).toString());
        }
        
        
        
    }//GEN-LAST:event_jTprojetosKeyReleased

    private void jTprojetosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTprojetosMouseClicked
        // TODO add your handling code here:
        
        if (jTprojetos.getSelectedRow()!= -1 )  {
            txtNome_projeto.setText(jTprojetos.getValueAt(jTprojetos.getSelectedRow(), 1).toString());
            txtValor_contrato.setText(jTprojetos.getValueAt(jTprojetos.getSelectedRow(), 3).toString());
            txtCliente_projeto.setText(jTprojetos.getValueAt(jTprojetos.getSelectedRow(), 2).toString());
            txtGasto_materiais.setText(jTprojetos.getValueAt(jTprojetos.getSelectedRow(), 6).toString());
        }
    }//GEN-LAST:event_jTprojetosMouseClicked

    private void VoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoltarActionPerformed
        new ViewMenuSupervisor().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_VoltarActionPerformed

    private void txtGasto_materiaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGasto_materiaisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGasto_materiaisActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plap.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewProjetosSupervisor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewProjetosSupervisor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewProjetosSupervisor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewProjetosSupervisor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewProjetosSupervisor().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Voltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTprojetos;
    private javax.swing.JTextField txtCliente_projeto;
    private javax.swing.JTextField txtGasto_materiais;
    private javax.swing.JTextField txtNome_projeto;
    private javax.swing.JTextField txtValor_contrato;
    // End of variables declaration//GEN-END:variables
}
