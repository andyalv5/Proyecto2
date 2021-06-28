/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2;

/**
 *
 * @author mkferrerteran
 */
public class hashtable {
    private NodoH tabla[];
    private int size;

    public hashtable(int size) {
        this.tabla = new NodoH[size];
        this.size = size;
        
        for (int i = 0; i < size; i++) {
            this.tabla[i] = null;
        }     
    }

    public NodoH[] getTabla() {
        return tabla;
    }

    public void setTabla(NodoH[] tabla) {
        this.tabla = tabla;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public void insertar(NodoH nodo, int posicion){
        this.tabla[posicion] = nodo;
    }
    
    public int exploracionLineal(int posicion){
        int indice = posicion;
        while(this.tabla[indice] != null){
            indice ++;
            if (indice >= this.getSize()){
                indice = indice%this.getSize();
            }   
        }
        return indice;
        
    }
}

