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
public class Hash_table {
    NodoHash tabla[];
    int size_tabla;
    
    public Hash_table(int size_tabla){
        
        this.size_tabla = size_tabla;
        this.tabla = new NodoHash[size_tabla];
        
        for (int i = 0; i < size_tabla; i++) {
            
            this.tabla[i] = null;
            
        }
        
    }
    
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
    
    public void Insertar(String usuario,int timeTag, NodoDoc doc){
        
        int posicion = hashing(usuario);
        boolean existe = false;
        
        if(this.tabla[posicion] != null){
            
            NodoHash temp = this.tabla[posicion];
            if(temp.getUsuario().equals(usuario)){
                
                existe = true;
                
            }
            
            while(temp.getSiguiente() != null){
                
                temp = temp.getSiguiente();
                if(temp.getUsuario().equals(usuario)){
                
                existe = true;
                
                }
                
            }
            
            if(!existe){
                
                NodoHash aux = new NodoHash(usuario,timeTag,doc);
                temp.setSiguiente(aux);
                
            }
            
        }
        
        else{
            
            NodoHash aux = new NodoHash(usuario,timeTag,doc);
            this.tabla[posicion] = aux;
            
        }
        
    }
    
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
    
//    public void imprimir(){
//        
//        String linea = "";
//        
//        for (int i = 0; i < size_tabla; i++) {
//            
//            if(this.tabla[i] != null){
//                
//                linea += this.tabla[i].getUsuario().getUser() + "," + this.tabla[i].getUsuario().getPriority() + "," + this.tabla[i].getUsuario().getDocuments().imprimir(this.tabla[i].getUsuario().getDocuments().getpFirst(), linea) + "\n";
//                
//                if(this.tabla[i].getSiguiente() != null){
//                    
//                    NodoHash temp = this.tabla[i].getSiguiente();
//                    while(temp != null){
//                        
//                        linea += this.tabla[i].getUsuario().getUser() + "," + this.tabla[i].getUsuario().getPriority() + "," + this.tabla[i].getUsuario().getDocuments().imprimir(this.tabla[i].getUsuario().getDocuments().getpFirst(), linea) + "\n";
//                        temp = temp.getSiguiente();
//
//                        
//                    }
//                    
//                }
//                
//            }
//            
//        }
//        
//    }
//    
    public void Crear_usuario(String nombre, String prioridad,int timeTag, NodoDoc doc){
        
        NodoUsers nuevo = new NodoUsers(nombre, prioridad);
        this.Insertar(nuevo.getUser(),timeTag,doc);
        
    }
}
