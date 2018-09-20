/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpcientificosdedatos;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class InterfazGraficaMatrizMarkov extends javax.swing.JFrame {

    private TPCientificosDeDatos tpCD;
    
    
    public InterfazGraficaMatrizMarkov() {
        initComponents();
    }

    public void mostrate() throws IOException{
        this.setVisible(true);
        this.setTextArea(this.tpCD.getMatrizMarkov().getMatrizMostrar());

    }
    public void setTextArea(String matriz){
        this.textArea1.setText(matriz);
    }
    public InterfazGraficaMatrizMarkov(TPCientificosDeDatos var) {
        initComponents();
        this.tpCD = var;
        //this.textArea1.setVisible(false);
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textArea1 = new java.awt.TextArea();
        MatrizCohortesBoton = new javax.swing.JButton();
        exportarBoton1 = new javax.swing.JButton();
        MatrizMarkovBoton = new javax.swing.JButton();
        analisisMarkovBoton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1007, 659));

        textArea1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        MatrizCohortesBoton.setText("Matriz cohortes");

        exportarBoton1.setText("Exportar");
        exportarBoton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportarBoton1ActionPerformed(evt);
            }
        });

        MatrizMarkovBoton.setText("Matriz Markov");

        analisisMarkovBoton1.setText("Analisis");
        analisisMarkovBoton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                analisisMarkovBoton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textArea1, javax.swing.GroupLayout.DEFAULT_SIZE, 987, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(MatrizMarkovBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(analisisMarkovBoton1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exportarBoton1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MatrizCohortesBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textArea1, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exportarBoton1)
                    .addComponent(analisisMarkovBoton1)
                    .addComponent(MatrizMarkovBoton)
                    .addComponent(MatrizCohortesBoton))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exportarBoton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportarBoton1ActionPerformed
        try {
            this.tpCD.getMatrizMarkov().GuardarArchivo();
        } catch (IOException ex) {
            Logger.getLogger(InterfazGraficaMatrizMarkov.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_exportarBoton1ActionPerformed

    private void analisisMarkovBoton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_analisisMarkovBoton1ActionPerformed
        this.setVisible(false);
        try {
            this.tpCD.mostrarInterfazAnalisis();// TODO add your handling code here:
        } catch (IOException ex) {
            Logger.getLogger(InterfazGraficaMatrizMarkov.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_analisisMarkovBoton1ActionPerformed

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
            java.util.logging.Logger.getLogger(InterfazGraficaMatrizMarkov.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazGraficaMatrizMarkov.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazGraficaMatrizMarkov.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazGraficaMatrizMarkov.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazGraficaMatrizMarkov().setVisible(true);
            }
            
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton MatrizCohortesBoton;
    private javax.swing.JButton MatrizMarkovBoton;
    private javax.swing.JButton analisisMarkovBoton1;
    private javax.swing.JButton exportarBoton1;
    private java.awt.TextArea textArea1;
    // End of variables declaration//GEN-END:variables
}
