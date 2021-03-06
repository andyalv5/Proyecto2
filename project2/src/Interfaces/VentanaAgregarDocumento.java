/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.io.File;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import project2.Funciones;
import project2.Users;
import project2.NodoDoc;

/**
 * Clase VentanaAgregarDocumento
 * Esta es la clase que crea la interfaz que agrega el documento
 * @author Andy,Maria,Jose,Ulises
 * @version 2/7/21
 */
public class VentanaAgregarDocumento extends javax.swing.JFrame {
    public static Users listaDocs;
    public static NodoDoc node;
    public static String search;
    
    /**
    * Método estático que envía una lista usuario que es estática
    * @return la lista estática del usuario
    */
    public static Users enviar(){
        Users lista= VentanaAgregarUsuario.enviar();
        if(search!=null && node!=null){
            listaDocs= lista.prepareDocument(search, lista, node);
        }
        Users esto = listaDocs;
        return esto;
    };
    
    /**
     * Constructor de la clase VentanaAgregarDocumento
     * Creates new form VentanaAgregarDocumento
     */
    public VentanaAgregarDocumento() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        Funciones fun =new Funciones();
        File f=new File("test//new.csv");
        Users listaUser=fun.Leer_csv(f);
        String usuarios =listaUser.returnUsers();
        String[] user = usuarios.split(",");
        this.Chooser.setModel(new javax.swing.DefaultComboBoxModel(user));
        
        
        
    }

    /**
     * Constructor de la clase VentanaAgregarDocumento que recibe la lista de usuarios
     * Creates new form VentanaAgregarDocumento
     */
    
    VentanaAgregarDocumento(Users lista) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPane3 = new javax.swing.JTextPane();
        nomDoc = new javax.swing.JTextField();
        sizeDoc = new javax.swing.JTextField();
        DocTy = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        Chooser = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextPane4 = new javax.swing.JTextPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(473, 370));
        setMinimumSize(new java.awt.Dimension(473, 370));
        setPreferredSize(new java.awt.Dimension(473, 370));
        setResizable(false);
        setSize(new java.awt.Dimension(473, 370));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("ID USUARIO:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 116, -1, 20));

        jLabel3.setText("NOMBRE DEL DOCUMENTO:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 156, -1, 20));

        jLabel4.setText("TAMAÑO DEL DOCUMENTO:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, 30));

        jLabel5.setText("TIPO DE DOCUMENTO:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, -1, 30));

        jTextPane3.setEditable(false);
        jTextPane3.setEnabled(false);
        jScrollPane3.setViewportView(jTextPane3);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 190, 30));

        nomDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomDocActionPerformed(evt);
            }
        });
        getContentPane().add(nomDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, 170, -1));

        sizeDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sizeDocActionPerformed(evt);
            }
        });
        getContentPane().add(sizeDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 170, -1));

        DocTy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DocTyActionPerformed(evt);
            }
        });
        getContentPane().add(DocTy, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, 170, -1));

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 290, -1, -1));

        Chooser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Chooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChooserActionPerformed(evt);
            }
        });
        getContentPane().add(Chooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, 170, -1));

        jTextPane1.setEditable(false);
        jTextPane1.setEnabled(false);
        jScrollPane1.setViewportView(jTextPane1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 190, 30));

        jTextPane2.setEditable(false);
        jTextPane2.setDragEnabled(false);
        jTextPane2.setEnabled(false);
        jTextPane2.setFocusCycleRoot(false);
        jTextPane2.setFocusTraversalKeysEnabled(false);
        jTextPane2.setRequestFocusEnabled(false);
        jTextPane2.setVerifyInputWhenFocusTarget(false);
        jScrollPane2.setViewportView(jTextPane2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 190, 30));

        jScrollPane4.setEnabled(false);
        jScrollPane4.setFocusable(false);

        jTextPane4.setEditable(false);
        jScrollPane4.setViewportView(jTextPane4);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 190, 30));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));

        jLabel1.setText("AGREGAR DOCUMENTO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(jLabel1)
                .addContainerGap(188, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, -10, 530, 70));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/Isla_de_Zakynthos,_Grecia,_2021,_Naturaleza,_Paisajes,_5K,_FotoPapel pintado_1024x768[10wallpaper.com].jpg"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 570, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
    * Método que contiene la información en el campo de texto nomDoc
    */
    
    private void nomDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomDocActionPerformed
        
    }//GEN-LAST:event_nomDocActionPerformed

    /**
    * Método que contiene el botón que agrega el documento al sistema operativo
    */
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        try{
            Users lista= VentanaAgregarUsuario.enviar();
            search=Chooser.getSelectedItem().toString();
            node= new NodoDoc(nomDoc.getText(),Integer.parseInt(sizeDoc.getText()),DocTy.getText());
            listaDocs= lista.prepareDocument(search, lista, node);
            
            JOptionPane.showMessageDialog(null, "se ha agregado con exito el documento al sistema, esperando a enviar el documento a la cola de impresion");
        
        }
        catch(Exception e){
            
            JOptionPane.showMessageDialog(null, "Ha introducido un tipo de dato invalido","Error",JOptionPane.ERROR_MESSAGE);
        
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    /**
    * Método que contiene el JComboBox chooser
    */
    
    private void ChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChooserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ChooserActionPerformed

    private void sizeDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sizeDocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sizeDocActionPerformed

    private void DocTyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DocTyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DocTyActionPerformed

    /**
     * método main de este JFrame
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
            java.util.logging.Logger.getLogger(VentanaAgregarDocumento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaAgregarDocumento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaAgregarDocumento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaAgregarDocumento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaAgregarDocumento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Chooser;
    private javax.swing.JTextField DocTy;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JTextPane jTextPane3;
    private javax.swing.JTextPane jTextPane4;
    private javax.swing.JTextField nomDoc;
    private javax.swing.JTextField sizeDoc;
    // End of variables declaration//GEN-END:variables
}
