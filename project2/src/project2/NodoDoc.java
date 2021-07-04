/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

/**
 * Clase NodoDoc
 * Esta es la clase que crea el Nodo del documento
 * @author Andy,Maria,Jose,Ulises
 * @version 2/7/21
 */
public class NodoDoc {
    private String nombre;
    private int size;
    private String tipo;
    private NodoDoc pNext;

    
    /**
     * Constructor del NodoDoc
     * @param nombre nombre del documento
     * @param size tamaño del documento
     * @param tipo tipo del documento
     */
    public NodoDoc(String nombre,int size, String tipo){
        this.nombre=nombre;
        this.size=size;
        this.tipo=tipo;
    }
    /**
     * Función que retorna el nombre del documento
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método que define el nombre del documento
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *Función que retorna el tamaño del documento
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * Método que define el tamaño del documento
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Función que retorna el tipo del documento
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Método que define el tipo del documento
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Función que retorna el siguiente Nodo de documento
     * @return the pNext
     */
    public NodoDoc getpNext() {
        return pNext;
    }

    /**
     * Método que define el próximo Nodo Documento
     * @param pNext the pNext to set
     */
    public void setpNext(NodoDoc pNext) {
        this.pNext = pNext;
    }
}
