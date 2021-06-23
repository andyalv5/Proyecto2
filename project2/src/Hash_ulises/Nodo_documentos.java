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
public class Nodo_documentos {
    
    private String nombre_documento;
    private int size_documento;
    private String tipo;
    private String estado;
    private Nodo_documentos proximo;
    private String tiempo;

    public Nodo_documentos(String nombre_documento, String tipo, String estado, int size_documento){
        
        this.nombre_documento = nombre_documento;
        this.size_documento = size_documento;
        this.tipo = tipo;
        this.estado = estado;
        this.proximo = null;
        this.tiempo = null;
        
    }
    
    /**
     * @return the nombre_documento
     */
    public String getNombre_documento() {
        return nombre_documento;
    }

    /**
     * @param nombre_documento the nombre_documento to set
     */
    public void setNombre_documento(String nombre_documento) {
        this.nombre_documento = nombre_documento;
    }

    /**
     * @return the size_documento
     */
    public int getSize_documento() {
        return size_documento;
    }

    /**
     * @param size_documento the size_documento to set
     */
    public void setSize_documento(int size_documento) {
        this.size_documento = size_documento;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the proximo
     */
    public Nodo_documentos getProximo() {
        return proximo;
    }

    /**
     * @param proximo the proximo to set
     */
    public void setProximo(Nodo_documentos proximo) {
        this.proximo = proximo;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the tiempo
     */
    public String getTiempo() {
        return tiempo;
    }

    /**
     * @param tiempo the tiempo to set
     */
    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }
    
}
