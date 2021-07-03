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
 * Clase MonticuloMin
 * Esta es la clase que crea el montículo con un Array y otro con apuntadores
 * @author Andy,Maria,Jose,Ulises
 * @version 2/7/21
 */
public class MonticuloMin {
    private NodoArbol pRoot;
    private NodoArbol[] heap;
    private int size;
    private int newMax;
    private Graph monticuloGraph;
    
    /**
     * Constructor con un maximo determinado por nostoros
     * @param max el máximo de NodoArbol que admite la lista
     */
    public MonticuloMin(int max){
        this.size=0;
        this.newMax=max;
        heap =new NodoArbol[max];
    }
    
    /**
     * Constructor con un máximo de 20 NodoArbol
     */
    public MonticuloMin(){
        this.size=0;
        this.newMax=20;
        heap =new NodoArbol[20];
    }
    /**
     * Función que retorna la posición del padre
     * @param i es la posición del hijo
     * @return posición del padre
     */
    
    public int padre(int i){
        return(i-1)/2;
    }
    
    /**
     * Función que retorna la posición del hijo izquierdo
     * @param i es la posición del padre
     * @return posición del hijo izquierdo
     */
    
    public int leftChild(int i){
        return ((2*i)+1);
    }
    
    /**
     * Función que retorna la posición del hijo derecho
     * @param i es la posición del padre
     * @return posición del hijo derecho
     */
    
    public int rightChild(int i){
        return ((2*i)+2);
    }
    
    /**
     * Método que intercambia la posición del padre con el hijo para cumplir con el MinHeap del montículo
     * @param i es la posición a evaluar para establecer al padre o al hijo en función
     * de su nivel de prioridad
     */
    
    public void intercambiar(int i){
        NodoArbol nuevoNodo= heap[i];
        while((i>0)&&(heap[padre(i)].getPriority()>nuevoNodo.getPriority())){
            heap[i]=heap[padre(i)];
            i=padre(i);
        }
        heap[i]=nuevoNodo;
    }
    
    /**
     * Función que retorna si el monticulo está lleno
     * @return verdadero si se alcanzó el total admitido de NodoArbol en el montículo
     * determinado por size
     */
    
    public boolean monticuloLleno(){
        return this.size==heap.length;
    }
    
    /**
     * Método que amplia el tamaño del heap durante tiempo de ejecución
     */
    public void ampliar(){
        NodoArbol[] toCompare = heap;
        heap = new NodoArbol[this.size+this.newMax];
        for(int i =0;i<size;i++){
            heap[i]=toCompare[i];
        }
    }
    
    /**
     * Función que retorna la raíz del arbol
     * @return la raíz
     */
    
    public NodoArbol returnRoot(){
        return this.heap[0];
    }
    
    /**
     * Método que inserta el NodoArbol en el montículo
     * @param data NodoArbol a introducir en el montículo
     */
    
    public void insertar(NodoArbol data){
        if(this.monticuloLleno()){
            ampliar();
        }
        this.heap[size]=data;
        if(size!=1){
            this.intercambiar(size);
        }
        else if(size==0){
            this.heap[0]=data;
            this.setpRoot(data);
        }
        this.size=size+1;
        
    }
    
    /**
     * Método que crea desde el montículo por arrays otro montículo funcional con listas de apuntadores
     */
    
    public void makeAFamily(){
        this.pRoot=this.heap[0];
        NodoArbol aux;
        
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
     * Función que retorna la raíz del montículo de apuntadores
     * @return the pRoot
     */
    public NodoArbol getpRoot() {
        return pRoot;
    }

    /**
     * Método que define la raíz del montículo de apuntadores
     * @param pRoot the pRoot to set
     */
    public void setpRoot(NodoArbol pRoot) {
        this.pRoot = pRoot;
    }
    
    /**
     * Método que crea el arco entre los nodos del padre y el hijo
     * @param graph el grafo donde se dibuja el montículo
     * @param padre el nodo padre
     * @param hijo el nodo hijo
     */
    
    public void IndividualEdge(Graph graph, String padre,String hijo){
        graph.addEdge(padre+"-->"+hijo, padre, hijo,true);
        this.monticuloGraph=graph;
    }

    /**
     * Función que retorna si el monticulo está lleno
     * @param graph el grafo donde se dibuja el montículo
     * @param cualquiera el NodoArbol donde se extrae la prioridad para crear el nodo del grafo dibujado
     * @return un node de la librería grafo necesario para construir el montículo
     */
    
    public Node IndividualNode(Graph graph, NodoArbol cualquiera){
       Node aux = graph.addNode(""+cualquiera.getPriority());
       aux.setAttribute("ui.label", cualquiera.getPriority());
       aux.setAttribute("ui.color", cualquiera.getPriority());
       
       return aux;
    }
    
    /**
     * Función que define las características que tendrá el grafo al ser dibujado
     * @return el grafo a dibujar
     */
    
    public Graph controladorHeap()
    {
        System.setProperty("org.graphstream.ui", "swing");
        
        Graph graph = new SingleGraph("GRAFO");
        Viewer viewer = graph.display(false);
        viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.HIDE_ONLY);
        viewer.disableAutoLayout();
        graph.setAttribute("ui.stylesheet", "graph { padding: 40px; } edge { arrow-shape: arrow; arrow-size: 5px, 5px; } node { size: 50px; fill-color: white, Magenta; fill-mode: gradient-diagonal2; text-alignment: at-right; text-padding: 10px, 15px; text-background-mode: rounded-box; text-background-color: #EB2; text-color: #222; shadow-mode: plain; shadow-width: 0px; shadow-color: #999; shadow-offset: 3px, -3px;  }");    
        
        return graph;
    }

    /**
     * Método que define la posición de los nodos para ser dibujados en el grafo 
     * @param toStart el NodoArbol que aporta información sobre los hijos izquierdo y derecho
     * @param dad el nodo a dibujar 
     * @param posx la posición en el eje de las x del nodo dibujado en el grafo 
     * @param posy la posición en el eje de las y del nodo dibujado en el grafo 
     */
    
    public void paintHeap(NodoArbol toStart, Node dad,int posx,int posy){
        
        NodoArbol aux = toStart;
        if(aux!=null){
            Node father =dad;
            father.setAttribute("x", posx);
            father.setAttribute("y", posy);
            if(aux.getNodoIzq()!=null){
                Node son = this.IndividualNode(monticuloGraph,aux.getNodoIzq());
                son.setAttribute("x", posx-100);
                son.setAttribute("y", posy-100);
                this.IndividualEdge(monticuloGraph, father.getId(),son.getId());
                if(aux.getNodoIzq().getNodoIzq()!=null){
                    paintHeap(aux.getNodoIzq(),son,posx-200,posy-200);
                }
            }
            if(aux.getNodoDer()!=null){
                Node daughter = this.IndividualNode(monticuloGraph,aux.getNodoDer());
                daughter.setAttribute("x", posx+100);
                daughter.setAttribute("y", posy-100);
                this.IndividualEdge(monticuloGraph, father.getId(),daughter.getId());
                if(aux.getNodoDer().getNodoIzq()!=null){
                    paintHeap(aux.getNodoDer(),daughter,posx+200,posy-200);
                }
            }
        }
    }
    
    /**
     * Función que prepara y realiza el dibujo del montículo
     * @return el grafo del montículo;
     */
    
    public Graph ShowHeap(){
        this.monticuloGraph =this.controladorHeap();
        int posx =0;
        int posy=0;
        Node father = this.IndividualNode(monticuloGraph,this.pRoot);
        paintHeap(this.pRoot,father,posx,posy);
        return monticuloGraph;
    }
    
    /**
     * Método que imprime todos los elementos del arbol del montículo con array
     */
    
    public void pntAllelmnt(){
        String toPrint ="";
        if(this.size==0){
         JOptionPane.showMessageDialog(null,"The list is empty");
        }
        else{
            for(int i=0;i<size;i++){
                toPrint+= "Nombre: ["+this.heap[i].getData().getNombre()+"] Tipo:"+this.heap[i].getData().getTipo()+ " size:" +this.heap[i].getData().getSize()+" \n";
            }
            JOptionPane.showMessageDialog(null,toPrint);
        }
        
    }
    
    /**
     * Método que hunde un nodo hasta que este sea mayor a sus hijos
     * @param raiz 
     */
    
    public void hundir(int raiz){
        boolean terminar=false;
        int hijo;
        while(raiz<(this.size/2)&&!terminar){
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
                NodoArbol nod = this.heap[raiz];
                this.heap[raiz]=this.heap[hijo];
                this.heap[hijo]=nod;
                raiz++;
            } 
            else{
                terminar=true;
            }
        }
    }
    
    /**
     * Función que elimina el primer elemento del montículo
     * @return el NodoArbol eliminado para ser impreso o no dependiendo el caso
     */
    
    public NodoArbol eliminarMinimo(){
        NodoArbol rama;
        if(this.size==0){
            rama=this.heap[0];
            this.size=0;
        }
        else{
            rama = this.heap[0];
            heap[0]=heap[this.size-1];
            heap[this.size-1]=null;
            this.size--;
            hundir(0);
        }
        return rama;
        
    }
    
    
    public void imprimir(){
        while(this.pRoot!=null){
            NodoArbol nodo= eliminarMinimo();
            
        }
    }
}
