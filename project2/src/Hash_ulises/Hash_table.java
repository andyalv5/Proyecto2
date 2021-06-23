/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hash_ulises;

/**
 *
 * @author Ulises
 */
public class Hash_table {
    
    Nodo_hash tabla[];
    int size_tabla;
    
    public Hash_table(int size_tabla){
        
        this.size_tabla = size_tabla;
        this.tabla = new Nodo_hash[size_tabla];
        
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
    
    public void Insertar(Nodo_usuarios usuario){
        
        int posicion = hashing(usuario.getNombre());
        boolean existe = false;
        
        if(this.tabla[posicion] != null){
            
            Nodo_hash temp = this.tabla[posicion];
            if(temp.getUsuario().getNombre().equals(usuario.getNombre())){
                
                existe = true;
                
            }
            
            while(temp.getSiguiente() != null){
                
                temp = temp.getSiguiente();
                if(temp.getUsuario().getNombre().equals(usuario.getNombre())){
                
                existe = true;
                
                }
                
            }
            
            if(!existe){
                
                Nodo_hash aux = new Nodo_hash(usuario);
                temp.setSiguiente(aux);
                
            }
            
        }
        
        else{
            
            Nodo_hash aux = new Nodo_hash(usuario);
            this.tabla[posicion] = aux;
            
        }
        
    }
    
    public Nodo_hash buscar(String nombre){
        
        int posicion = hashing(nombre);
        Nodo_hash temp = this.tabla[posicion];
        boolean existe = false;
        
        if(temp != null){
            
            if(temp.getSiguiente() == null){
                
                existe =  true; 
                
            }
            
            else{
                
                while(temp.getSiguiente() != null){
                    
                    if(temp.getUsuario().getNombre().equals(nombre)){
                        
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
    
    public void imprimir(){
        
        String linea = "";
        
        for (int i = 0; i < size_tabla; i++) {
            
            if(this.tabla[i] != null){
                
                linea += this.tabla[i].getUsuario().getNombre() + "," + this.tabla[i].getUsuario().getPrioridad() + "," + this.tabla[i].getUsuario().getDocumentos().imprimir(this.tabla[i].getUsuario().getDocumentos().getPrimer_documento(), linea) + "\n";
                
                if(this.tabla[i].getSiguiente() != null){
                    
                    Nodo_hash temp = this.tabla[i].getSiguiente();
                    while(temp != null){
                        
                        linea += this.tabla[i].getUsuario().getNombre() + "," + this.tabla[i].getUsuario().getPrioridad() + "," + this.tabla[i].getUsuario().getDocumentos().imprimir(this.tabla[i].getUsuario().getDocumentos().getPrimer_documento(), linea) + "\n";
                        temp = temp.getSiguiente();

                        
                    }
                    
                }
                
            }
            
        }
        
    }
    
    public void Crear_usuario(String nombre, String prioridad){
        
        Nodo_usuarios nuevo = new Nodo_usuarios(nombre, prioridad, null);
        this.Insertar(nuevo);
        
    }
    
}
