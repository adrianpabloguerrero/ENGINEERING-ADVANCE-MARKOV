
package tpcientificosdedatos;

import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InterfazGraficaPrincipal extends javax.swing.JFrame {

    private TPCientificosDeDatos tpCD;
    
    
    public InterfazGraficaPrincipal() {
        initComponents();
    }

    public InterfazGraficaPrincipal(TPCientificosDeDatos var) {
        initComponents();
        this.tpCD = var;
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        anioLabel = new javax.swing.JLabel();
        abandonoLabel = new javax.swing.JLabel();
        anioField = new javax.swing.JTextField();
        abandonoField = new javax.swing.JTextField();
        obtenerMatrizMarkovBoton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        anioLabel.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        anioLabel.setText("Año");

        abandonoLabel.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        abandonoLabel.setText("Abandono");

        anioField.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        anioField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        anioField.setText("2005");
        anioField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anioFieldActionPerformed(evt);
            }
        });

        abandonoField.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        abandonoField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        abandonoField.setText("2");
        abandonoField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abandonoFieldActionPerformed(evt);
            }
        });

        obtenerMatrizMarkovBoton.setText("Obtener Matriz Markov");
        obtenerMatrizMarkovBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                obtenerMatrizMarkovBotonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        jLabel1.setText("Seleccion de Parametros");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(274, 274, 274)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(anioLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(anioField, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(abandonoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(abandonoField, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(obtenerMatrizMarkovBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(244, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(anioLabel)
                    .addComponent(anioField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(96, 96, 96)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(abandonoLabel)
                    .addComponent(abandonoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(91, 91, 91)
                .addComponent(obtenerMatrizMarkovBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(153, 153, 153))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void abandonoFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abandonoFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_abandonoFieldActionPerformed

    private void anioFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anioFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_anioFieldActionPerformed

    private void obtenerMatrizMarkovBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_obtenerMatrizMarkovBotonActionPerformed
        this.setVisible(false);
        this.tpCD.setParametroAnio(parseInt(this.anioField.getText()));
        this.tpCD.setParametroAbandono(parseInt(this.abandonoField.getText()));
        try {
            this.tpCD.calcularMatrizMarkov();
        } catch (ParseException ex) {
            Logger.getLogger(InterfazGraficaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            this.tpCD.mostrarInterfazMatrizMarkov();
        } catch (IOException ex) {
            Logger.getLogger(InterfazGraficaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_obtenerMatrizMarkovBotonActionPerformed

    
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
            java.util.logging.Logger.getLogger(InterfazGraficaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazGraficaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazGraficaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazGraficaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazGraficaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField abandonoField;
    private javax.swing.JLabel abandonoLabel;
    private javax.swing.JTextField anioField;
    private javax.swing.JLabel anioLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton obtenerMatrizMarkovBoton;
    // End of variables declaration//GEN-END:variables
}
