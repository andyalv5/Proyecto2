/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

import javax.swing.JOptionPane;

/**
 * Clase ListaDoc
 * Esta es la clase que se utiliza para crear la Lista de los documentos 
 * @author Andy,Maria,Jose,Ulises
 * @version 2/7/21
 */
public class ListaDoc {
    private NodoDoc pFirst;
    private NodoDoc pLast;
    private int size;

    /**
     * Función que retorna el primer NodoDoc de la lista
     * @return the pFirst, el primer NodoDoc
     */
    public NodoDoc getpFirst() {
        return pFirst;
    }

    /**
     * Método que configura el primer NodoDoc de la lista
     * @param pFirst the pFirst to set
     */
    public void setpFirst(NodoDoc pFirst) {
        this.pFirst = pFirst;
    }

    /**
     * Función que retorna el último NodoDoc de la lista
     * @return the pLast
     */
    public NodoDoc getpLast() {
        return pLast;
    }

    /**
     * Método que configura el último NodoDoc de la lista
     * @param pLast the pLast to set
     */
    public void setpLast(NodoDoc pLast) {
        this.pLast = pLast;
    }

    /**
     * Función que retorna el tamaño de la lista
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * Método que establece el tamaño de la lista
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }
    
    /**
     * Función que retorna un valor de verdad dependiendo si la lista está o no vacia
     * @return verdadero si la lista está vacia y falso si no está vacia
     */
    
    public boolean IsEmpty(){
        return getpFirst() == null;
    }
    
    /**
     * Método que inserta el nodo en la última posición
     * @param node NodoDoc que se agrega a la lista
     */
    
    public void addAtEnd(NodoDoc node){
        if(this.IsEmpty()){
            addElementbegin(node);
        }
        else{
            NodoDoc tempo = this.pLast;
            tempo.setpNext(node);
            pLast = node;
        }
        size ++;
    }
    /**
     * Método que inserta el nodo en la primera posición
     * @param newNodo NodoDoc insertado en la primera posición de la lista
     */
            
     public void addElementbegin(NodoDoc newNodo){
        if(this.IsEmpty()){
            pFirst=pLast= newNodo;
            size++;
        }
        else{
            NodoDoc pNew= pFirst; 
            pFirst=newNodo;
            pFirst.setpNext(pNew);
            
            size++;
        }
        
    }   
    
     /**
     * Función que busca el NodoDoc con el nombre del documento
     * @param searched nombre del documento
     * @return el NodoDoc del documento encontrado
     */
     
     public NodoDoc BuscarVertex(String searched){
        
        NodoDoc aux;
        try{
            for(aux=this.pFirst;aux !=null;aux=aux.getpNext()){
                if(searched.equals(aux.getNombre())){
                    return aux;
                } 
            }     
        }
        catch(Exception e){
            return null;
        }
        return null;
    }
     
     /**
     * Método que crea el NodoDoc y lo inserta en la lista
     * @param nombre nombre del documento
     * @param size tamaño del documento
     * @param tipo tipo del documento
     */
     
    public void addDoc(String nombre,int size, String tipo){
        NodoDoc nod =new NodoDoc(nombre,size,tipo);
        this.addAtEnd(nod);
    }
    
    /**
     * Método que imprime los nombres de los documentos
     */
    
    public void pntAllelmnt(){
        String toPrint = "";
        NodoDoc nodoTmp = pFirst;
        if(this.IsEmpty()){
         JOptionPane.showMessageDialog(null,"The list is empty");
        }
        while(nodoTmp != null){
            toPrint += " - "+ nodoTmp.getNombre() +" - " +"  ";
            nodoTmp=nodoTmp.getpNext();
        }
        JOptionPane.showMessageDialog(null,toPrint);
    }
    
    /**
     * Método que elimina el NodoDoc por el nombre del mismo
     * @param name nombre del documento
     */
    
    public void delByName(String name){
        if(name.equals(this.pFirst.getNombre())){
            this.pFirst = this.pFirst.getpNext();
        }
        else if(name.equals(this.pLast.getNombre())){
            this.pLast=null;
        }
        else{
            int contador =0;
            NodoDoc nodoTmp = this.pFirst;
            while(contador < size-1 && nodoTmp.getpNext() !=null){
                if(name.equals(nodoTmp.getpNext().getNombre())){
                    nodoTmp.setpNext(nodoTmp.getpNext().getpNext());
                }
                nodoTmp = nodoTmp.getpNext(); 
            }
        }
        size--;
    }
    
}
