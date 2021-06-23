/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hash_ulises;

/**
 *
 * @author Ulises
 */
public class Nodo_usuarios {
    
    private String nombre;
    private String prioridad;
    private Nodo_usuarios siguiente;
    private Lista_documentos documentos;

    public Nodo_usuarios(String nombre, String prioridad, Lista_documentos documentos){
        
        this.nombre = nombre;
        this.prioridad = prioridad;
        this.documentos = documentos;
        this.siguiente = null;
        
    }
    
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the prioridad
     */
    public String getPrioridad() {
        return prioridad;
    }

    /**
     * @param prioridad the prioridad to set
     */
    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    /**
     * @return the documentos
     */
    public Lista_documentos getDocumentos() {
        return documentos;
    }

    /**
     * @param documentos the documentos to set
     */
    public void setDocumentos(Lista_documentos documentos) {
        this.documentos = documentos;
    }

    /**
     * @return the siguiente
     */
    public Nodo_usuarios getSiguiente() {
        return siguiente;
    }

    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(Nodo_usuarios siguiente) {
        this.siguiente = siguiente;
    }
    
}
