/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

/**
 *
 * @author andy
 */
public class MonticuloBinario {
    private Nodo[] arrayArbol;
    private int max;
    private int talla;
    
    //constructor
    public MonticuloBinario(int max){
        this.max=max;
        this.arrayArbol=new Nodo[max];
        this.talla=0;
    }
    
    //metodo vacio
    public boolean isEmpty(){
        return this.talla==0;
    }
    
    //metodo insertar
    public void insertar(Object data,int priority){
        Nodo newNod=new Nodo(data,priority);
        int hueco = talla++;
        if(!isEmpty()){
            
            
        }
    }
    
}
