/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

import javax.swing.JOptionPane;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.view.Viewer;

/**
 *
 * @author andy
 */
public class MonticuloMin {
    private NodoArbol pRoot;
    private NodoArbol[] heap;
    private int size;
    private int newMax;
    private Graph monticuloGraph;
    
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
    public void makeAFamily(){
        this.pRoot=this.heap[0];
        NodoArbol aux = this.pRoot;
        
        for(int n=0;n<this.size;n++){
            aux=this.heap[n];
            if(this.heap[(n*2)+1]!=null){
                aux.setNodoIzq(this.heap[(n*2)+1]);
            }
            if(this.heap[(n*2)+2]!=null){
                aux.setNodoDer(this.heap[(n*2)+2]);
            }
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
    
    public Graph IndividualEdge(Graph graph, String padre,String hijo){
        graph.addEdge("relacion", padre, hijo,true);
        return graph;   
    }

    public void IndividualNode(Graph graph, NodoArbol cualquiera){
       Node aux = graph.addNode(""+Integer.toString(cualquiera.getPriority()));
       aux.setAttribute("ui.label", Integer.toString(cualquiera.getPriority()));
       aux.setAttribute("ui.color", Integer.toString(cualquiera.getPriority()));
    }
    
    public Graph controladorHeap()
    {
        System.setProperty("org.graphstream.ui", "swing");
        
        Graph graph = new SingleGraph("GRAFO");
        graph.setAttribute("ui.stylesheet", "graph { padding: 40px; } edge { arrow-shape: arrow; arrow-size: 3px, 3px; } node { size: 40px; fill-color: Orange, black; fill-mode: gradient-horizontal; text-alignment: at-right; text-padding: 10px, 15px; text-background-mode: rounded-box; text-background-color: #EB2; text-color: #222; } ");    
        
        
        return graph;
    }

    public void paintHeap(NodoArbol arbol){
        this.monticuloGraph =this.controladorHeap();
        NodoArbol aux = arbol;
        if(aux!=null){
            this.IndividualNode(monticuloGraph,aux);
        }
        if(this.pRoot.getNodoIzq()!=null){
            this.IndividualNode(monticuloGraph,aux.getNodoIzq());
            this.IndividualEdge(monticuloGraph, Integer.toString(aux.getPriority()),Integer.toString(aux.getNodoIzq().getPriority()));
            if(aux.getNodoIzq()!=null){
                paintHeap(aux.getNodoIzq());
            }
        }
        if(this.pRoot.getNodoDer()!=null){
            this.IndividualNode(monticuloGraph,aux.getNodoDer());
            this.IndividualEdge(monticuloGraph, Integer.toString(aux.getPriority()),Integer.toString(aux.getNodoDer().getPriority()));
            if(aux.getNodoDer()!=null){
                paintHeap(aux.getNodoDer());
            }
        }
    }
    
    public Graph ShowHeap(){
        paintHeap(this.pRoot);
        Viewer viewer = this.monticuloGraph.display();
        viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.HIDE_ONLY);
        return monticuloGraph;
    }
}
