/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

import javax.swing.JOptionPane;

/**
 *
 * @author andynet
 */

//arbol avl
public class ArbolBinario {
    private NodoArbol pRoot;
   
   
    public ArbolBinario(){
    }
    
    public ArbolBinario(Object tInfo,int clave){
        NodoArbol s= new NodoArbol(tInfo,clave);
        this.setpRoot(s);
    }
    public boolean isEmpty(){
        return this.getpRoot()==null;
    }
    
    public void insertar(Object tInfo,int clave){
        NodoArbol newNode=new NodoArbol(tInfo,clave);
        insertar(this.pRoot,newNode);
    }
    
    public void insertar2(Object tInfo,int clave){
        NodoArbol newNode=new NodoArbol(tInfo,clave);
        insertar2(this.pRoot,newNode);
    }
    
    public void insertar(NodoArbol padre,NodoArbol newNode){
        if(!this.isEmpty()){
            if(newNode.getClave() < padre.getClave()){
                if(padre.getNodIzquierdo()==null){
                    padre.setNodIzquierdo(newNode);
                }
                else{
                    insertar(padre.getNodIzquierdo(),newNode);
                }
            }
            else if (newNode.getClave() > padre.getClave()){
                if(padre.getNodDerecho()==null){
                    padre.setNodDerecho(newNode);
                }
                else{
                    insertar(padre.getNodDerecho(),newNode);
                }
            }
            else{
            }
        }
        else{
            this.pRoot=newNode;
        }
    }

    public void insertar2(NodoArbol padre,NodoArbol newNode){
        if(!this.isEmpty()){
            if(newNode.getClave() > padre.getClave()){
                if(padre.getNodIzquierdo()==null){
                    padre.setNodIzquierdo(newNode);
                }
                else{
                    insertar(padre.getNodIzquierdo(),newNode);
                }
            }
            else if (newNode.getClave() < padre.getClave()){
                if(padre.getNodDerecho()==null){
                    padre.setNodDerecho(newNode);
                }
                else{
                    insertar(padre.getNodDerecho(),newNode);
                }
            }
            else{
            }
        }
        else{
            this.pRoot=newNode;
        }
    }
    
    /**
     * @return the pRoot
     */
    public NodoArbol getpRoot() {
        return pRoot;
    }

    /**
     * @param pRoot the pRoot to set
     */
    public void setpRoot(NodoArbol pRoot) {
        this.pRoot = pRoot;
    }
    
    public NodoArbol buscar (NodoArbol nodo, int clave){
        NodoArbol buscado= null; 
        if(nodo == null){
            JOptionPane.showMessageDialog(null, "El arbol esta vacio");
            return null;
        }
        else if(nodo.getClave()==clave){
            buscado = nodo;
        }
        else if(nodo.getNodDerecho() != null && nodo.getClave() < clave){
            if (clave == nodo.getNodDerecho().getClave()){
                buscado = nodo.getNodDerecho();
            }
            else if(clave != nodo.getNodDerecho().getClave()){
                buscado = buscar(nodo.getNodDerecho(),clave);
            }
        }
        else if(nodo.getNodIzquierdo() != null && nodo.getClave() > clave){
            if (clave == nodo.getNodIzquierdo().getClave()){
                buscado=nodo.getNodIzquierdo();
                
            }
            else if(clave != nodo.getNodIzquierdo().getClave()){
                buscado = buscar(nodo.getNodIzquierdo(),clave);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "no existe el nodo");
            return null;
        }
        return buscado;
    }
    
    public String preorden(NodoArbol nodo){
        String toPrint= ""+nodo.getClave()+", ";
        if(nodo.getNodIzquierdo()!= null){
            toPrint += preorden(nodo.getNodIzquierdo());
        }
        if(nodo.getNodDerecho()!=null){
            toPrint += preorden(nodo.getNodDerecho());
        }
        return toPrint;
    }
    
    public String inorden(NodoArbol nodo,String cadena){
        
        if(nodo!= null){
            cadena=inorden(nodo.getNodIzquierdo(),cadena);
            cadena=cadena+nodo.getClave()+", ";
            cadena=inorden(nodo.getNodDerecho(),cadena);
        }
        return cadena;
    }
    
    public String postorden(NodoArbol nodo){
        String toPrint= "";
        if(nodo.getNodIzquierdo()!= null){
            toPrint += postorden(nodo.getNodIzquierdo());
        }
        if(nodo.getNodDerecho()!=null){
            toPrint += postorden(nodo.getNodDerecho());
        }
        toPrint+= nodo.getClave()+", ";
        return toPrint;
    }
    
    public Boolean sameStructure(NodoArbol fRoot,NodoArbol sRoot){
        boolean same = true;
        if(fRoot==null || sRoot==null){
            return false;
        }
        if((fRoot.getNodIzquierdo()!=null || sRoot.getNodIzquierdo()!=null) && same){
            same=sameStructure(fRoot.getNodIzquierdo(),sRoot.getNodIzquierdo());
        }
        if((fRoot.getNodDerecho()!=null || sRoot.getNodDerecho()!=null) && same){
            same=sameStructure(fRoot.getNodDerecho(),sRoot.getNodDerecho());
        }
        return same;
    }
    
    public Boolean sameStructureEspejo(NodoArbol fRoot,NodoArbol sRoot){
        boolean same = true;
        if(fRoot==null || sRoot==null){
            return false;
        }
        if((fRoot.getNodIzquierdo()!=null || sRoot.getNodDerecho()!=null) && same){
            same=sameStructureEspejo(fRoot.getNodIzquierdo(),sRoot.getNodDerecho());
        }
        if((fRoot.getNodDerecho()!=null || sRoot.getNodIzquierdo()!=null) && same){
            same=sameStructureEspejo(fRoot.getNodDerecho(),sRoot.getNodIzquierdo());
        }
        return same;
    }
    
    public Boolean isIdentical(NodoArbol fRoot,NodoArbol sRoot){
        boolean same = true;
        if(fRoot==null || sRoot==null || fRoot.getClave()!=sRoot.getClave()){
            return false;
        }
        if((fRoot.getNodIzquierdo()!=null || sRoot.getNodIzquierdo()!=null) && same){
            same=isIdentical(fRoot.getNodIzquierdo(),sRoot.getNodIzquierdo());
        }
        if((fRoot.getNodDerecho()!=null || sRoot.getNodDerecho()!=null) && same){
            same=isIdentical(fRoot.getNodDerecho(),sRoot.getNodDerecho());
        }
        return same;
    }
    
    public Boolean isIdenticalEspejo(NodoArbol fRoot,NodoArbol sRoot){
        boolean same = true;
        if(fRoot==null || sRoot==null || fRoot.getClave()!=sRoot.getClave()){
            return false;
        }
        if((fRoot.getNodIzquierdo()!=null || sRoot.getNodDerecho()!=null) && same){
            same=isIdenticalEspejo(fRoot.getNodIzquierdo(),sRoot.getNodDerecho());
        }
        if((fRoot.getNodDerecho()!=null || sRoot.getNodIzquierdo()!=null) && same){
            same=isIdenticalEspejo(fRoot.getNodDerecho(),sRoot.getNodIzquierdo());
        }
        return same;
    }
    
    public NodoArbol ancestroComun(String a,int val,String b, int val2){
        NodoArbol primero = new NodoArbol(a,val);
        NodoArbol segundo = new NodoArbol(b,val2);
        
        if(this.pRoot.getClave()==val || this.pRoot.getClave()==val2){
            return pRoot;
        }
        NodoArbol ancestro = ancestro(this.pRoot,primero,segundo);
        return ancestro;
    }
    
    public NodoArbol ancestro(NodoArbol pRoots, NodoArbol primero, NodoArbol segundo){
        NodoArbol aux = pRoots;
        while(aux !=null){
            if(aux.getClave()==primero.getClave() || aux.getClave()==segundo.getClave()){
                return padre(aux,pRoots);
            }
            if((primero.getClave()> aux.getClave() )&& (segundo.getClave()> aux.getClave())){
                aux = aux.getNodDerecho();
            }
            if((primero.getClave()< aux.getClave()) && (segundo.getClave()< aux.getClave())){
                aux = aux.getNodIzquierdo();
            }
            else{
                return aux;
            }
        }
        return null;
    }
    
    public NodoArbol padre(NodoArbol raiz,NodoArbol nodo){
        if(raiz==null || nodo==null){
            return null;
        }
        else if(raiz.getNodIzquierdo() !=null){
            if (raiz.getNodIzquierdo()== nodo || raiz.getNodDerecho()==nodo){
                return raiz;
            }
            return raiz;
        }
        else{
            NodoArbol encontrado =padre(nodo,raiz.getNodIzquierdo());
            if(encontrado ==null){
                encontrado =padre(nodo,raiz.getNodDerecho());
            }
            return encontrado;
        }
    }
    
    public NodoArbol eliminar(NodoArbol nodo,int clave){
        if(nodo == null){
            return nodo;
        } 
        if(clave < nodo.getClave()){
            nodo.setNodIzquierdo(eliminar(nodo.getNodIzquierdo(), clave));
        }
        else if(clave > nodo.getClave()){
            nodo.setNodDerecho(eliminar(nodo.getNodDerecho(), clave));
        }
        else{
            if((nodo.getNodIzquierdo() == null)||(nodo.getNodDerecho() == null)){
                NodoArbol aux = null;
                if(nodo.getNodIzquierdo() == null){
                    aux = nodo.getNodDerecho();
                }
                else{
                    aux = nodo.getNodIzquierdo();
                }
                if(aux!=null){
                    nodo=aux;
                }
                else{
                    nodo=null;
                }
            }
            else{
                NodoArbol aux = nodo;
                while(aux.getNodDerecho()!=null){
                    aux = aux.getNodDerecho();
                }
                nodo.setClave(aux.getClave());
                nodo.settInfo(aux.gettInfo());
                nodo.setNodIzquierdo(eliminar(nodo.getNodIzquierdo(), aux.getClave()));
            }
        }
        return nodo;
    }
    
}
