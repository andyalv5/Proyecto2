/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import static Interfaces.VentanaAgregarDocumento.listaDocs;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import project2.NodoDoc;
import project2.Users;


/**
 *
 * @author Jose
 */
public class VentanaPrincipal extends javax.swing.JFrame {
    
    private Timer t;
    private int dias;
    private int horas;
    private int minutos;
    private int segundos;
    private ActionListener action =new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            segundos++;
            if(segundos==60){
                segundos=0;
                minutos++;
            }
            if(minutos==60){
                minutos=0;
                horas++;
            }
            if(horas==24){
                horas=0;
                dias++;
            }
            actualizar();
        }
    };
    /**
     * Creates new form VentanaPrincipal
     */
    public static Users lista;
    
    public static Users enviar(){
        
        return lista;
    };
    
    private void actualizar(){
        String time="Dias: "+dias+" Horas: "+ (horas<=9?"0":"")+horas +" Minutos: "+ (minutos<=9?"0":"")+minutos +" Segundos: "+ (segundos<=9?"0":"")+segundos;
        this.reloj.setText(time);
                
    }
    
    public VentanaPrincipal() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        t=new Timer(1000,action);
        t.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnAggUsuario = new javax.swing.JButton();
        btnAggDocumento = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        btnDelDocumento = new javax.swing.JButton();
        btnDelUsuario = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        reloj = new javax.swing.JLabel();

        jButton1.setText("ELIMINAR USUARIO");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("BIENVENIDO");

        btnAggUsuario.setText("AGREGAR USUARIO");
        btnAggUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAggUsuarioActionPerformed(evt);
            }
        });

        btnAggDocumento.setText("AGREGAR DOCUMENTO");
        btnAggDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAggDocumentoActionPerformed(evt);
            }
        });

        btnImprimir.setText("IMPRIMIR DOCUMENTOS");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        btnDelDocumento.setText("ELIMINAR DOCUMENTO");
        btnDelDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelDocumentoActionPerformed(evt);
            }
        });

        btnDelUsuario.setText("ELIMINAR USUARIO");
        btnDelUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelUsuarioActionPerformed(evt);
            }
        });

        jLabel2.setText("reloj:");

        reloj.setText("00:00:00:00");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(reloj))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnImprimir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAggDocumento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAggUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDelUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDelDocumento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(jLabel1)))
                .addContainerGap(123, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAggUsuario)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelUsuario)
                        .addGap(18, 18, 18)
                        .addComponent(btnAggDocumento)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelDocumento)
                        .addGap(18, 18, 18)
                        .addComponent(btnImprimir))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(reloj))))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAggUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAggUsuarioActionPerformed
        // TODO add your handling code here:
        VentanaAgregarUsuario venaddus = new VentanaAgregarUsuario();
        venaddus.setVisible(true);
    }//GEN-LAST:event_btnAggUsuarioActionPerformed

    private void btnAggDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAggDocumentoActionPerformed
        // TODO add your handling code here:
        
        VentanaAgregarDocumento venadddoc = new VentanaAgregarDocumento();
        venadddoc.setVisible(true);
        
        
        
    
    }//GEN-LAST:event_btnAggDocumentoActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        // TODO add your handling code here:
        VentanaImprimirDocumento venprint = new VentanaImprimirDocumento();
        venprint.setVisible(true);
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void btnDelUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelUsuarioActionPerformed
        // TODO add your handling code here:
        
        listaDocs = VentanaEliminarUsuario.enviar();
        VentanaEliminarUsuario vendelus = new VentanaEliminarUsuario();
        vendelus.setVisible(true);
    
    }//GEN-LAST:event_btnDelUsuarioActionPerformed

    private void btnDelDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelDocumentoActionPerformed
        // TODO add your handling code here:
        VentanaEliminarDocumento vendeldoc = new VentanaEliminarDocumento();
        vendeldoc.setVisible(true);
    }//GEN-LAST:event_btnDelDocumentoActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAggDocumento;
    private javax.swing.JButton btnAggUsuario;
    private javax.swing.JButton btnDelDocumento;
    private javax.swing.JButton btnDelUsuario;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel reloj;
    // End of variables declaration//GEN-END:variables
}
