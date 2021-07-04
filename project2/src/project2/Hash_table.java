/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

import javax.swing.JOptionPane;

/**
 * Clase Hash_table
 * Esta es la clase que se utiliza para crear la Hash table 
 * @author Andy,Maria,Jose,Ulises
 * @version 2/7/21
 */
public class Hash_table {
    NodoHash tabla[];
    int size_tabla;
    
     /**
     * Constructor para la Hash table
     * @param size_tabla es el tamaño que tendrá la hash table debe contener 
     * un número grande para que el programa utilice memoria en pro de aumentar
     * la velocidad del programa
     */
    
    public Hash_table(int size_tabla){
        
        this.size_tabla = size_tabla;
        this.tabla = new NodoHash[size_tabla];
        
        for (int i = 0; i < size_tabla; i++) {
            
            this.tabla[i] = null;
            
        }
        
    }
    
     /**
     * Función que retorna un valor de verdad dependiendo si la hash table está o no vacia
     * @return verdadero cuando la hash table está vacia, devuelve falso
     * cuando hay al menos un NodoHash dentro de la hash table
     */
    
    
    public boolean isEmpty(){
        for(int i=0;i<size_tabla;i++){
            if(tabla[i]!=null){
                return false;
            }
        }
        return true;
    }
    
      /**
     * Función que asigna la posición donde se almacena al usuario en el sistema
     * @param nombre el nombre al que se procede hacer hashing
     * @return un entero, del residuo que aparece luego de operar el valor ASCII de las letras del nombre
     * con la multiplicación de la posición, el valor de las letras se le resta
     * el valor 
     */
    
    
    public int hashing(String nombre){
        
        int valor = 0;
        int posicion = 1;
        
        for (int i = 0; i < nombre.length(); i++) {
            
            if(nombre.codePointAt(i) == 32){
                
                valor += 0;
                
            }
            
            else if(nombre.codePointAt(i) >= 48 && nombre.codePointAt(i) <= 57){
                
                valor += ((nombre.codePointAt(i) - 47) * posicion);
                
            }
            
            else if(nombre.codePointAt(i) >= 65 && nombre.codePointAt(i) <= 90){
                
                valor += ((nombre.codePointAt(i) - 54) * posicion);
                
            }
            
            else if(nombre.codePointAt(i) >= 97 && nombre.codePointAt(i) <= 122){
                
                valor += ((nombre.codePointAt(i) - 60) * posicion);
                
            }
            
            posicion ++;
            
        }
        
        return (valor % posicion);
        
    }
    
    /**
     * Método que inserta en la posición correspondiente al NodoHash que se crea dentro del método
     * @param usuario nombre del usuario al que se hace hashing
     * @param timeTag etiqueta de tiempo almacenada dentro de la posición
     * correspondiente al usuario dentro de la hash table
     * @param doc NodoDoc que se almacena dentro de la posición
     * correspondiente al usuario dentro de la hash table, es el documento enviado
     * a la cola de impresión
     */
    
    public void Insertar(String usuario,int timeTag, NodoDoc doc){
        
        
        int posicion = hashing(usuario);
        NodoHash temp = this.tabla[posicion];
        if(temp != null){
            
            if(temp.getUsuario().equals(usuario)){
                NodoHash aux = new NodoHash(usuario,timeTag,doc);
                while(temp.getSiguiente()!=null){
                    temp = temp.getSiguiente();
                }
                temp.setSiguiente(aux);
            } 
        }
        else{

            NodoHash aux = new NodoHash(usuario,timeTag,doc);
            this.tabla[posicion] = aux;

        }
            
    }
    
    /**
     * Función que busca por nombre de usuario el documento guardado dentro de la hash table
     * @param nombre el nombre del usuario al que se procede a hacer hashing
     * para encontrar su posición en la hash table
     * @return NodoHash que contiene la etiqueta de tiempo, el nombre de usuario y
     * el documento que se envió a la cola de impresión
     */
    
    public NodoHash buscar(String nombre){
        
        int posicion = hashing(nombre);
        NodoHash temp = this.tabla[posicion];
        boolean existe = false;
        
        if(temp != null){
            
            if(temp.getSiguiente() == null){
                
                existe =  true; 
                
            }
            
            else{
                
                while(temp.getSiguiente() != null){
                    
                    if(temp.getUsuario().equals(nombre)){
                        existe = true;
                        NodoHash aux =temp;
                        return aux;
                        
                        
                    }
                    
                    else{
                        
                        temp = temp.getSiguiente();
                        
                    }
                    
                }
                
            }
            
        }
        
        if(existe){
            return temp;
            
        }
        
        else{
            
            return null;
            
        }
 
    }
    
    /**
     * Método que imprime los documentos que están en la cola de impresión
     * @param usuarios lista de usuarios en el sistema operativo para buscar dentro
     * de la hash table
     */
    
    public void imprimir(Users usuarios){
        String linea = "<html><b>Documentos que ESTAN en cola de impresion:</b><html>"+"\n";
        NodoUsers usuario = usuarios.getFirst();
        while(usuario!=null){
            int posicion =hashing(usuario.getUser());
            NodoHash temp = this.tabla[posicion];
            while(temp!=null){

                linea+="Documento: "+temp.getDocument().getNombre()+" tipo: "+temp.getDocument().getTipo()+" size: "+temp.getDocument().getSize()+"\n";

                temp=temp.getSiguiente();
            }
            usuario=usuario.getNext();
        }
        JOptionPane.showMessageDialog(null, linea);
    }
    
    /**
     * Método que crea un NodoUsers y lo inserta en la hash Table 
     * @param nombre del usuario
     * @param prioridad nivel de prioridad
     * @param timeTag etiqueta de tiempo
     * @param doc NodoDoc del documento enviado a la cola de impresión
     */
    public void Crear_usuario(String nombre, String prioridad,int timeTag, NodoDoc doc){
        
        NodoUsers nuevo = new NodoUsers(nombre, prioridad);
        this.Insertar(nuevo.getUser(),timeTag,doc);
        
    }
}
