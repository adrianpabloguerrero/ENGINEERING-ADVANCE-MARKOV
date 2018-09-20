
package tpcientificosdedatos;

import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;


public class InterfazGraficaSeleccionArchivos extends javax.swing.JFrame {

    private TPCientificosDeDatos tpCD;
    
    
    
    public InterfazGraficaSeleccionArchivos() {
        initComponents();
       }
    
    public InterfazGraficaSeleccionArchivos(TPCientificosDeDatos var) {
        initComponents();
        this.tpCD = var;
    }
 
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        examinarAlumnosBoton = new javax.swing.JButton();
        alumnosField = new javax.swing.JTextField();
        alumnosLabel = new javax.swing.JLabel();
        finalesLabel = new javax.swing.JLabel();
        examinarFinalesBoton = new javax.swing.JButton();
        finalesField = new javax.swing.JTextField();
        cargarBoton = new javax.swing.JButton();
        cursadasLabel = new javax.swing.JLabel();
        cursadasField = new javax.swing.JTextField();
        examinarCursadasBoton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        examinarAlumnosBoton.setText("Examinar");
        examinarAlumnosBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                examinarAlumnosBotonActionPerformed(evt);
            }
        });

        alumnosField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alumnosFieldActionPerformed(evt);
            }
        });

        alumnosLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        alumnosLabel.setText("Alumnos");

        finalesLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        finalesLabel.setText("Finales");

        examinarFinalesBoton.setText("Examinar");
        examinarFinalesBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                examinarFinalesBotonActionPerformed(evt);
            }
        });

        cargarBoton.setText("Cargar");
        cargarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarBotonActionPerformed(evt);
            }
        });

        cursadasLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cursadasLabel.setText("Cursadas");

        cursadasField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cursadasFieldActionPerformed(evt);
            }
        });

        examinarCursadasBoton.setText("Examinar");
        examinarCursadasBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                examinarCursadasBotonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel1.setText("Seleccion de Archivos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(cursadasField, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(alumnosField, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(alumnosLabel)
                            .addComponent(finalesLabel)
                            .addComponent(finalesField, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cursadasLabel))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(examinarCursadasBoton)
                            .addComponent(examinarAlumnosBoton)
                            .addComponent(examinarFinalesBoton)))
                    .addGroup(javax.swing.GroupLayout.Alignment.CENTER, layout.createSequentialGroup()
                        .addGap(249, 249, 249)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cargarBoton, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.CENTER))))
                .addContainerGap(202, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(46, 46, 46)
                .addComponent(alumnosLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alumnosField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(examinarAlumnosBoton))
                .addGap(49, 49, 49)
                .addComponent(finalesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(examinarFinalesBoton)
                    .addComponent(finalesField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(cursadasLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cursadasField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(examinarCursadasBoton))
                .addGap(48, 48, 48)
                .addComponent(cargarBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void examinarAlumnosBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_examinarAlumnosBotonActionPerformed
 
        this.alumnosField.setText(this.seleccionarArchivo(this.alumnosField).getAbsolutePath());
    }//GEN-LAST:event_examinarAlumnosBotonActionPerformed

    private File seleccionarArchivo(Component parent){
        File fichero = null;
        JFileChooser fc=new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int seleccion=fc.showOpenDialog(parent);
        if(seleccion==JFileChooser.APPROVE_OPTION){
            fichero=fc.getSelectedFile();
        }
        return fichero;
    }
    private void examinarFinalesBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_examinarFinalesBotonActionPerformed
  
        this.finalesField.setText(this.seleccionarArchivo(this.finalesField).getAbsolutePath());
    }//GEN-LAST:event_examinarFinalesBotonActionPerformed

    private void cargarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarBotonActionPerformed
                this.setVisible(false);
                String pathAlumnos = this.alumnosField.getText();
                String pathFinales = this.finalesField.getText();
                String pathCursadas = this.cursadasField.getText();
                
                if(pathAlumnos.equals("")){
                    pathAlumnos = "C:\\Users\\User\\Documents\\alumnos.csv";
                }
                if(pathFinales.equals("")){
                    pathFinales = "C:\\Users\\User\\Documents\\finales.csv";
                }
                if(pathCursadas.equals("")){
                    pathCursadas = "C:\\Users\\User\\Documents\\cursadas.csv";
                }
                
        try {
            this.tpCD.cargarAlumnos(pathAlumnos);
        } catch (IOException ex) {
            Logger.getLogger(InterfazGraficaSeleccionArchivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            this.tpCD.cargarFinales(pathFinales);
        } catch (IOException | ParseException ex) {
            Logger.getLogger(InterfazGraficaSeleccionArchivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            this.tpCD.cargarCursadas(pathCursadas);
        } catch (IOException | ParseException ex) {
            Logger.getLogger(InterfazGraficaSeleccionArchivos.class.getName()).log(Level.SEVERE, null, ex);
        }
                this.tpCD.mostrarInterfazPrincipal();
    }//GEN-LAST:event_cargarBotonActionPerformed

    private void cursadasFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cursadasFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cursadasFieldActionPerformed

    private void examinarCursadasBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_examinarCursadasBotonActionPerformed
      
        this.cursadasField.setText(this.seleccionarArchivo(this.cursadasField).getAbsolutePath());
    }//GEN-LAST:event_examinarCursadasBotonActionPerformed

    private void alumnosFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alumnosFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alumnosFieldActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alumnosField;
    private javax.swing.JLabel alumnosLabel;
    private javax.swing.JButton cargarBoton;
    private javax.swing.JTextField cursadasField;
    private javax.swing.JLabel cursadasLabel;
    private javax.swing.JButton examinarAlumnosBoton;
    private javax.swing.JButton examinarCursadasBoton;
    private javax.swing.JButton examinarFinalesBoton;
    private javax.swing.JTextField finalesField;
    private javax.swing.JLabel finalesLabel;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
