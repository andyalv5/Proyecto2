package project2;

import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Clase Users
 * Esta es la clase que crea la lista de usuarios
 * @author Andy,Maria,Jose,Ulises
 * @version 2/7/21
 */
public class Users {
    private NodoUsers first;
    private NodoUsers last;
    private int size;

    /**
     * Constructor de la lista usuarios inicializada como vacia
     */
    
    public Users() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    /**
     * Función que retorna el tamaño de la lista
     * @return size
     */
    public int getSize() {
        return size;
    }

     /**
     * Función que retorna al primer usuario
     * @return first
     */
    public NodoUsers getFirst() {
        return first;
    }

     /**
     * Método que define al primer usuario
     * @param first
     */
    public void setFirst(NodoUsers first) {
        this.first = first;
    }
    /**
     * Función que retorna al último usuario
     * @return last
     */
    public NodoUsers getLast() {
        return last;
    }

    /**
     * Método que define al último usuario
     * @param last
     */
    public void setLast(NodoUsers last) {
        this.last = last;
    }

    /**
     * Función que retorna si la lista está vacia
     * @return devuelve verdadero si está vacia
     */
    public boolean isEmpty(){
        return first == null;
    }
    
    /**
     * Método que añade un usuario al final de la lista 
     * @param node nodo a introducir al final
     */
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
    
    /**
     * Método que añade un usuario al inicio de la lista 
     * @param newNodo nuevo nodo a introducir
     */
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
    
     /**
     * Función que retorna un String con los nombres de usuarios
     * @return el String de usuarios
     */
    public String returnUsers(){
        String usuarios = "";
        NodoUsers temp = this.first;
        while(temp!=null){
            usuarios+= temp.getUser() +",";
            temp = temp.getNext();
        }
        return usuarios;
    }
    
    /**
     * Función que retorna un String de la prioridad de los usuarios
     * @return la prioridad de los usuarios
     */
    public String returnStatus(){
        String usuarios = "";
        NodoUsers temp = this.first;
        while(temp!=null){
            usuarios+= temp.getPriority() +",";
            temp = temp.getNext();
        }
        return usuarios;
    }
    
    /**
     * Método que crea la lista de usuarios y los introduce directamente
     * @param users un String de los usuarios que estan originalmente en el txt
     * @param priority un String de la prioridad de los usuarios que esta originalmente
     * en el txt
     */
    
    public void createList(String users, String priority){
        String[] usuario =users.split(",");
        String[] prioridad =priority.split(",");
        for(int i =0;i<usuario.length;i++){
            NodoUsers nodoTemp = new NodoUsers(usuario[i],prioridad[i]);
            this.addAtEnd(nodoTemp);
        }
    }
    
    /**
     * Función que busca un usuario por el nombre
     * @param searched el nombre del usuario
     * @return el nodo del usuario si existe
     */
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
    
    /**
     * Método que elimina un usuario por el nombre 
     * @param name
     */
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
    
    /**
     * Método que elimina al usuario al final de la lista
     */
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
    
    /**
     * Método que imprime en pantalla los nombres de los usuarios
     */
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
    
    /**
     * Función que prepara el documento para ser enviado a la lista de impresión
     * @param search nombre del documento buscado
     * @param aux lista de usuarios
     * @param node nodo del documento
     * @return la lista de usuarios actualizada
     */
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
 
    /**
     * Función que prepara el documento para enviarse a la cola de impresión
     * @param aux lista de usuarios 
     * @return la lista de los usuarios actualizada
     */
    
    public Users prepareDocument2(Users aux){
        Users doc=new Users();
        NodoUsers elem=aux.getFirst();
        while(elem!=null){
            doc.addAtEnd(elem);
            elem=elem.getNext();
        }
        return doc;
    }
    
    /**
     * Método que imprime los documentos y usuarios que no están en la cola de impresión
     */
    
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
