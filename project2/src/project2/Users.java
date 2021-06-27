package project2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mkferrerteran
 */
public class Users {
    private NodoUsers first;
    private NodoUsers last;
    private int size;

    
    public Users() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public NodoUsers getFirst() {
        return first;
    }

    public void setFirst(NodoUsers first) {
        this.first = first;
    }

    public NodoUsers getLast() {
        return last;
    }

    public void setLast(NodoUsers last) {
        this.last = last;
    }

    
    public boolean isEmpty(){
        return first == null;
    }
    
    public void addAtEnd(NodoUsers node){
        if(this.isEmpty()){
            addElementbegin(node);
        }
        else{
            NodoUsers tempo = this.last;
            tempo.setNext(node);
            this.last = node;
        }
        size ++;
    }
    
     public void addElementbegin(NodoUsers newNodo){
        if(this.isEmpty()){
            this.first=this.last= newNodo;
        }
        else{
            NodoUsers pNew= this.first; 
            this.first=newNodo;
            this.first.setNext(pNew);
            
            size++;
        }
        
    }   
    
    public String returnUsers(){
        String almacenes = "";
        NodoUsers temp = this.first;
        while(temp!=null){
            almacenes+= temp.getUser() +",";
            temp = temp.getNext();
        }
        return almacenes;
    }
    
    public String returnStatus(){
        String almacenes = "";
        NodoUsers temp = this.first;
        while(temp!=null){
            almacenes+= temp.getPriority() +",";
            temp = temp.getNext();
        }
        return almacenes;
    }
    
    public void createList(String users, String priority){
        String[] usuario =users.split(",");
        String[] prioridad =priority.split(",");
        for(int i =0;i<usuario.length;i++){
            NodoUsers nodoTemp = new NodoUsers(usuario[i],prioridad[i]);
            this.addAtEnd(nodoTemp);
        }
    }
    
    public NodoUsers BuscarUser(String searched){
        
        NodoUsers aux;
        try{
            for(aux=this.first;aux !=null;aux=aux.getNext()){
                if(searched.equals(aux.getUser())){
                    return aux;
                } 
            }     
        }
        catch(Exception e){
            return null;
        }
        return null;
    }
}
