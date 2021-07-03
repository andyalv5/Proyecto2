/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import static Interfaces.VentanaPrincipal.hashTable;
import static Interfaces.VentanaPrincipal.monticuloMin;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import project2.Funciones;
import project2.MonticuloMin;
import project2.NodoArbol;
import project2.NodoHash;
import project2.Users;

/**
 * Clase EliminarDocCola
 * Esta es la clase que crea la interfaz para eliminar documento de la cola
 * @author Andy,Maria,Jose,Ulises
 * @version 2/7/21
 */
public class EliminarDocCola extends javax.swing.JFrame {
    
    /**
     * Creates new form EliminarDocCola
     */
    
    /**
     * Constructor para ElminarDocCola
     */
    public EliminarDocCola() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        Funciones fun =new Funciones();
        File f=new File("test//new.csv");
        Users listaUser=fun.Leer_csv(f);
        String usuarios =listaUser.returnUsers();
        String[] user = usuarios.split(",");
        User.setModel(new javax.swing.DefaultComboBoxModel(user));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        User = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(478, 257));
        setMinimumSize(new java.awt.Dimension(478, 257));
        setPreferredSize(new java.awt.Dimension(477, 257));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        User.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        User.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                UserItemStateChanged(evt);
            }
        });
        User.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserActionPerformed(evt);
            }
        });
        getContentPane().add(User, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, -1, 40));

        jLabel2.setText("ID USUARIO:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 80, 20));

        jButton1.setText("click");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 160, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        jLabel1.setText("ELIMINAR DOCUMENTO DE COLA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(jLabel1)
                .addContainerGap(160, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(20, 20, 20))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 510, 70));

        jTextPane1.setEditable(false);
        jScrollPane1.setViewportView(jTextPane1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 100, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/wallpapertip_daily-wallpaper_895636.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -40, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método que detecta un cambio de selección en el JComboBox User
     */
    private void UserItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_UserItemStateChanged
        
    }//GEN-LAST:event_UserItemStateChanged

    /**
     * Método que tiene el JComboBox User
     */
    
    private void UserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserActionPerformed

    }//GEN-LAST:event_UserActionPerformed

    /**
     * Método de bóton que elimina el documento
     */
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
            NodoHash nodo=hashTable.buscar(User.getSelectedItem().toString());
            MonticuloMin newMont= new MonticuloMin();
            NodoArbol nodoAr=monticuloMin.eliminarMinimo();
            while(nodoAr!=null){
                if(nodoAr.getData().getNombre().equals(nodo.getDocument().getNombre())){
                    nodoAr.setPriority(1);
                    newMont.insertar(nodoAr);
                }
                else{
                    newMont.insertar(nodoAr);
                }
                nodoAr = monticuloMin.eliminarMinimo();
            }
            newMont.eliminarMinimo();
            monticuloMin = newMont;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Algo ha salido mal, por favor intentelo de nuevo","Error",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * es el método main de la Interfaz
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
            java.util.logging.Logger.getLogger(EliminarDocCola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EliminarDocCola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EliminarDocCola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EliminarDocCola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EliminarDocCola().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> User;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
