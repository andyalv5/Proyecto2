package project2;

import javax.swing.JOptionPane;

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
        
        NodoUsers aux=this.first;
        while(aux!=null){
            if(searched.equals(aux.getUser())){
                return aux;
            }
            aux=aux.getNext();
        }
        return null;
    }
    
    public void delByName(String name){
        if(name.equals(this.first.getUser())){
            this.first = this.first.getNext();
        }
        else if(name.equals(this.last.getUser())){
            this.last=null;
        }
        else{
            int contador =0;
            NodoUsers nodoTmp = this.first;
            while(contador < size-1 && nodoTmp.getNext() !=null){
                if(name.equals(nodoTmp.getNext().getUser())){
                    nodoTmp.setNext(nodoTmp.getNext().getNext());
                }
                nodoTmp = nodoTmp.getNext(); 
            }
        }
        size--;
    }
    
    public void delAtEnd(){
        NodoUsers temp= this.first;
        if(this.first == this.last){
            this.first = this.last = null;
        }
        else{
            while(temp.getNext()!=this.last){
                temp = temp.getNext();
            }
        this.last =temp;
        this.last.setNext(null);
        }
    }
    
    public void pntAllelmnt(){
        NodoUsers nodoTmp = this.first;
        if(this.isEmpty()){
         JOptionPane.showMessageDialog(null,"The list is empty");
        }
        while(nodoTmp != null){
            JOptionPane.showMessageDialog(null,nodoTmp.getUser());
            nodoTmp=nodoTmp.getNext();
        }
        
    }
    
    public Users prepareDocument(String search, Users aux, NodoDoc node){
        ListaDoc doc=new ListaDoc();
        NodoUsers elem=aux.getFirst();
        while(elem!=null){
            if(search.equals(elem.getUser())){
                if(elem.getDocuments()!=null){
                    doc=elem.getDocuments();
                }
                doc.addAtEnd(node);
                elem.setDocuments(doc);
            }
            elem=elem.getNext();
        }
        return aux;
    }
 
    public Users prepareDocument2(Users aux){
        Users doc=new Users();
        NodoUsers elem=aux.getFirst();
        while(elem!=null){
            doc.addAtEnd(elem);
            elem=elem.getNext();
        }
        return doc;
    }
    
    public void imprimirTodo(){
        NodoUsers nodoTmp = this.first;
        String imprimir = "<html><b>Usuarios y Documentos que NO ESTAN en cola de impresion:</b><html>"+"\n";
        
        if(this.isEmpty()){
         JOptionPane.showMessageDialog(null,"The list is empty");
        }
        while(nodoTmp != null){
            imprimir += "Usuario: "+nodoTmp.getUser()+" "+nodoTmp.getPriority()+"\n";
            if(nodoTmp.getDocuments()!=null && nodoTmp.getDocuments().getpFirst()!=null){
                NodoDoc aux =nodoTmp.getDocuments().getpFirst();
                while(aux!=null){
                    imprimir += "       Documento: "+aux.getNombre()+" tipo: " +aux.getTipo()+" size: "+aux.getSize()+"\n";
                    aux=aux.getpNext();
                }
            }
            nodoTmp=nodoTmp.getNext();
        }
        JOptionPane.showMessageDialog(null, imprimir);
    }
    
}
