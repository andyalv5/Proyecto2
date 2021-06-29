/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import static Interfaces.VentanaPrincipal.monticuloMin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import project2.Funciones;
import project2.Hash_table;
import project2.ListaDoc;
import project2.MonticuloMin;
import project2.NodoArbol;
import project2.NodoUsers;
import project2.NodoDoc;
import project2.Users;


/**
 *
 * @author Jose
 */
public class VentanaImprimirDocumento extends javax.swing.JFrame {
    
    public Users carpetaDoc;
    public Users DocumList;
    public Timer t;
    public int dias;
    public int horas;
    public int minutos;
    public int segundos;
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

    private VentanaImprimirDocumento() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void actualizar(){
        String time="Dias: "+dias+" Horas: "+ (horas<=9?"0":"")+horas +" Minutos: "+ (minutos<=9?"0":"")+minutos +" Segundos: "+ (segundos<=9?"0":"")+segundos;
        this.reloj.setText(time);
                
    }
    /**
     * Creates new form VentanaImprimirDocumento
     * @param dias
     * @param horas
     * @param minutos
     * @param segundos
     */
    public VentanaImprimirDocumento(int dias,int horas,int minutos,int segundos) {
        
        
        t=new Timer(1000,action);
        t.start();
        this.dias=dias;
        this.horas=horas;
        this.minutos=minutos;
        this.segundos=segundos;
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        Funciones fun =new Funciones();
        File f=new File("test//new.csv");
        Users listaUser=fun.Leer_csv(f);
        String usuarios =listaUser.returnUsers();
        String[] user = usuarios.split(",");
        User.setModel(new javax.swing.DefaultComboBoxModel(user));
        DocumList = VentanaAgregarUsuario.enviar();
        carpetaDoc = VentanaAgregarUsuario.enviar();
        
        documento.setEnabled(true);
        NodoUsers Nodo=this.DocumList.BuscarUser(User.getSelectedItem().toString());
        String selection="";
        if(Nodo.getDocuments()!=null){
            NodoDoc aux=Nodo.getDocuments().getpFirst();
            while(aux!=null){
                selection+= aux.getNombre()+",";
                aux=aux.getpNext();
            }
        }
        String[] toSel =selection.split(",");
        documento.setModel(new javax.swing.DefaultComboBoxModel(toSel));
        
    }

    public void sendUserList(Users usuario){
        
        
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
        jLabel2 = new javax.swing.JLabel();
        reloj = new javax.swing.JLabel();
        User = new javax.swing.JComboBox<>();
        documento = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("reloj:");

        reloj.setText("00:00:00:00");

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

        documento.setEnabled(false);
        documento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                documentoActionPerformed(evt);
            }
        });

        jLabel3.setText("NOMBRE DEL DOCUMENTO:");

        jLabel4.setText("ID USUARIO:");

        jLabel1.setText("ENVIAR A LA COLA DE IMPRESION");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(33, 33, 33))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(reloj))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jLabel1)))
                .addContainerGap(103, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(56, 56, 56)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(19, 19, 19)
                            .addComponent(documento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(User, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(56, 56, 56)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(reloj))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 164, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(42, 42, 42))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(114, 114, 114)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(User, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(documento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(114, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        
        Hash_table hashTab=VentanaPrincipal.enviarHashTable();
        Users lista =VentanaAgregarUsuario.enviar();
        
        String timeTagSt="";
        timeTagSt = ""+ this.dias+this.horas+this.minutos+this.segundos;
        int timeTag = Integer.parseInt(timeTagSt);
        
        
        NodoUsers usuario = lista.BuscarUser(User.getSelectedItem().toString());
        timeTag =usuario.checkPriority(usuario, timeTag);
        NodoDoc document= usuario.BuscarDoc(documento.getSelectedItem().toString());
        hashTab.Insertar(User.getSelectedItem().toString(), timeTag, document);
        NodoArbol nodo=new NodoArbol(document,timeTag);
        ListaDoc listado=usuario.getDocuments();
        listado.delByName(documento.getSelectedItem().toString());
        carpetaDoc.BuscarUser(User.getSelectedItem().toString()).setDocuments(listado);
        
        monticuloMin.insertar(nodo);
        
        String selection="";
        if(usuario.getDocuments()!=null){
            NodoDoc aux=usuario.getDocuments().getpFirst();
            while(aux!=null){
                selection+= aux.getNombre()+",";
                aux=aux.getpNext();
            }
        }
        String[] toSel =selection.split(",");
        documento.setModel(new javax.swing.DefaultComboBoxModel(toSel));
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void UserItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_UserItemStateChanged
        documento.setEnabled(true);
        NodoUsers Nodo=this.DocumList.BuscarUser(User.getSelectedItem().toString());
        String selection="";
        if(Nodo.getDocuments()!=null){
            NodoDoc aux=Nodo.getDocuments().getpFirst();
            while(aux!=null){
                selection+= aux.getNombre()+",";
                aux=aux.getpNext();
            }
        }
        String[] toSel =selection.split(",");
        documento.setModel(new javax.swing.DefaultComboBoxModel(toSel));
    }//GEN-LAST:event_UserItemStateChanged

    private void UserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserActionPerformed

    }//GEN-LAST:event_UserActionPerformed

    private void documentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_documentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_documentoActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaImprimirDocumento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaImprimirDocumento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaImprimirDocumento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaImprimirDocumento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaImprimirDocumento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> User;
    private javax.swing.JComboBox<String> documento;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel reloj;
    // End of variables declaration//GEN-END:variables
}
