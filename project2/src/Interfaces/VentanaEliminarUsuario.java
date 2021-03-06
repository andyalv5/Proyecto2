/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import static Interfaces.VentanaAgregarDocumento.listaDocs;
import static Interfaces.VentanaAgregarUsuario.usuario;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import project2.Funciones;
import project2.Users;

/**
 * Clase VentanaEliminarUsuario
 * Esta es la clase que crea la interfaz que elimina al usuario
 * @author Andy,Maria,Jose,Ulises
 * @version 2/7/21
 */
public class VentanaEliminarUsuario extends javax.swing.JFrame {
    private String usuarios;
    public static Users listaDrop;
    
    public static Users enviar(){
        listaDrop = VentanaAgregarUsuario.enviar();
        return listaDrop;
    };
    /**
     * Constructor de VentanaEliminarUsuario
     * Creates new form VentanaEliminarUsuario
     */
    public VentanaEliminarUsuario() {
        this.setLocationRelativeTo(null);
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Funciones fun =new Funciones();
        File f=new File("test//new.csv");
        Users listaUser=fun.Leer_csv(f);
        usuarios =listaUser.returnUsers();
        String[] user = usuarios.split(",");
        Selector.setModel(new javax.swing.DefaultComboBoxModel(user));
        listaDrop =VentanaAgregarDocumento.enviar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        Selector = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPane3 = new javax.swing.JTextPane();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(376, 200));
        setMinimumSize(new java.awt.Dimension(376, 200));
        setPreferredSize(new java.awt.Dimension(376, 200));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("ELIMINAR USUARIO");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, -1));

        jLabel2.setText("ID USUARIO:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 76, 90, 20));

        jButton1.setText("Eliminar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, -10, 530, 70));

        Selector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Selector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectorActionPerformed(evt);
            }
        });
        getContentPane().add(Selector, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 140, 40));

        jTextPane3.setEditable(false);
        jTextPane3.setDragEnabled(false);
        jTextPane3.setEnabled(false);
        jTextPane3.setFocusCycleRoot(false);
        jTextPane3.setFocusTraversalKeysEnabled(false);
        jTextPane3.setRequestFocusEnabled(false);
        jTextPane3.setVerifyInputWhenFocusTarget(false);
        jScrollPane3.setViewportView(jTextPane3);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 120, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/Bosque,_monta??as,_nieve,_lago,_2020,_paisaje_de_la_naturaleza,_fotoPapel pintado_1024x768[10wallpaper.com].jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * M??todo bot??n que elimina al usuario
    */
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    try{
        Funciones fun=new Funciones();
        String toDel = Selector.getSelectedItem().toString();
        String user =fun.writeTxt(toDel);
        String[] users = user.split(",");
        Selector.setModel(new javax.swing.DefaultComboBoxModel(users));
        
        File newfile= new File("test//new.csv");
        fun.Leer_csv(newfile);
        listaDrop.delByName(toDel);
    }
    catch(Exception e){
        JOptionPane.showMessageDialog(null, "Algo ha salido mal, por favor intentelo de nuevo","Error",JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
    * M??todo que contiene el JComboBox Selector 
    */
    
    private void SelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SelectorActionPerformed

    /**
     * M??todo est??tico main de este jFrame
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
            java.util.logging.Logger.getLogger(VentanaEliminarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaEliminarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaEliminarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaEliminarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaEliminarUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Selector;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextPane jTextPane3;
    // End of variables declaration//GEN-END:variables
}
