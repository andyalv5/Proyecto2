/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hash_ulises;
import javax.swing.JOptionPane;
import Interfaz_ulises.Principal;
/**
 *
 * @author Ulises
 */
public class Lista_documentos {
    
    private Nodo_documentos primer_documento;
    private Nodo_documentos ultimo_documento;
    private int size;
    
    public Lista_documentos(){
        
        this.primer_documento = null;
        this.ultimo_documento = null;
        this.size = 0;
        
    }

    /**
     * @return the primer_documento
     */
    public Nodo_documentos getPrimer_documento() {
        return primer_documento;
    }

    /**
     * @param primer_documento the primer_documento to set
     */
    public void setPrimer_documento(Nodo_documentos primer_documento) {
        this.primer_documento = primer_documento;
    }

    /**
     * @return the ultimo_documento
     */
    public Nodo_documentos getUltimo_documento() {
        return ultimo_documento;
    }

    /**
     * @param ultimo_documento the ultimo_documento to set
     */
    public void setUltimo_documento(Nodo_documentos ultimo_documento) {
        this.ultimo_documento = ultimo_documento;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }
    
    public boolean EsVacio(){
        
       return primer_documento == null;
        
    }
    
    public void InsertarFinal(String nombre, String tipo, String estado, int size_documento){
        
       Nodo_documentos nuevo = new Nodo_documentos(nombre, tipo, estado, size_documento);
       
       if(EsVacio()){
           primer_documento = nuevo;
           ultimo_documento = nuevo;
       }else{
           this.ultimo_documento.setProximo(nuevo);
           ultimo_documento = nuevo;
       }
       size ++;
       
    }
    
    public String imprimir(Nodo_documentos primero, String linea){
        
        linea = "";
        
        primero = this.getPrimer_documento();
        
        linea += primero.getNombre_documento() + "," + primero.getTipo() + primero.getEstado() + "\n";
        
        primero = primero.getProximo();
        
        imprimir(primero, linea);
        
        return linea;
        
    }
    
    public void Agregar_documento(String nombre_usuario, String nombre_documento, String tipo, int size_documento, Hash_table tabla){
        
        Nodo_hash nodo = tabla.buscar(nombre_usuario);
        
        if(nodo != null){
            
            nodo.getUsuario().getDocumentos().InsertarFinal(nombre_documento, tipo, "afuera", size_documento);
            nodo.getUsuario().getDocumentos().getUltimo_documento().setTiempo(Principal.getTiempo2());
            
        }
        
        else{
            
            JOptionPane.showConfirmDialog(null, "El usuario que ingreso no existe");
            
        }
    }
    
}
