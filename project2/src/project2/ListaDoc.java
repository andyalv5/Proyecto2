/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

import javax.swing.JOptionPane;

/**
 *
 * @author andy
 */
public class ListaDoc {
    private NodoDoc pFirst;
    private NodoDoc pLast;
    private int size;

    /**
     * @return the pFirst
     */
    public NodoDoc getpFirst() {
        return pFirst;
    }

    /**
     * @param pFirst the pFirst to set
     */
    public void setpFirst(NodoDoc pFirst) {
        this.pFirst = pFirst;
    }

    /**
     * @return the pLast
     */
    public NodoDoc getpLast() {
        return pLast;
    }

    /**
     * @param pLast the pLast to set
     */
    public void setpLast(NodoDoc pLast) {
        this.pLast = pLast;
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
    
    
    public boolean IsEmpty(){
        return getpFirst() == null;
    }
    
    
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
     
    
    public void addDoc(String nombre,int size, String tipo){
        NodoDoc nod =new NodoDoc(nombre,size,tipo);
        this.addAtEnd(nod);
    }
    
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
}
