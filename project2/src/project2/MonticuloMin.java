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
public class MonticuloMin {
    private NodoArbol[] heap;
    private int size;
    private int newMax;
    
    //constructor con un maximo determinado por nostoros
    public MonticuloMin(int max){
        this.size=0;
        this.newMax=max;
        heap =new NodoArbol[max];
    }
    //constructor por defecto con un maximo de 20 elementos
    public MonticuloMin(){
        this.size=0;
        this.newMax=20;
        heap =new NodoArbol[20];
    }
    
    public int padre(int i){
        return(i-1)/2;
    }
    
    public int leftChild(int i){
        return (2*(i+1));
    }
    
    public int rightChild(int i){
        return (2*(i+1))+1;
    }
    
    public void intercambiar(int i){
        NodoArbol nuevoNodo= heap[i];
        while((i>0)&&(heap[padre(i)].getPriority()>nuevoNodo.getPriority())){
            heap[i]=heap[padre(i)];
            i=padre(i);
        }
        heap[i]=nuevoNodo;
    }
    
    public boolean monticuloLleno(){
        return this.size==heap.length;
    }
    
    public void ampliar(){
        NodoArbol[] toCompare = heap;
        heap = new NodoArbol[this.size+this.newMax];
        for(int i =0;i<size;i++){
            heap[i]=toCompare[i];
        }
    }
    
    public NodoArbol returnRoot(){
        return this.heap[0];
    }
    
    public void insertar(NodoArbol data){
        if(this.monticuloLleno()){
            ampliar();
        }
        this.heap[size]=data;
        
        this.intercambiar(size);
        this.size=size+1;
    }
    
    public void seleccion(int raiz){
        boolean finalizar=false;
        int hijo;
        while((raiz<this.size/2)&&!finalizar){
            if(this.leftChild(raiz)==(this.size-1)){
                hijo = leftChild(raiz);
            }
            else{
                if(this.heap[leftChild(raiz)].getPriority()<this.heap[rightChild(raiz)].getPriority()){
                    hijo=this.leftChild(raiz);
                }
                else{
                    hijo=this.rightChild(raiz);
                }
            }
            if(this.heap[hijo].getPriority()<this.heap[raiz].getPriority()){
                NodoArbol nodonew = this.heap[raiz];
                this.heap[raiz]=this.heap[hijo];
                this.heap[hijo]= nodonew;
                raiz=hijo;
            }
            else{
                finalizar= true;
            }
        }
        
    }
}
