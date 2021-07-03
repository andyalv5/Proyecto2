package project2;

/**
 * Clase NodoUsers
 * Esta es la clase que crea el Nodo del usuario
 * @author Andy,Maria,Jose,Ulises
 * @version 2/7/21
 */
public class NodoUsers {
    private String user;
    private String priority;
    private ListaDoc documents;
    private NodoUsers next;
    private NodoUsers previous;

    /**
     * Constructor del NodoUsers inicializando todo a nulo
     */
    
    public NodoUsers(){
    
    }
    
    /**
     * Constructor del NodoUsers
     * @param user nombre del usuario
     * @param priority numero de prioridad
     */
    public NodoUsers(String user, String priority) {
        this.user = user;
        this.priority = priority;
    }

    /**
     * Función que retorna el nombre de usuario
     * @return user
     */
    public String getUser() {
        return user;
    }

    /**
     * Método que define el nombre de usuario
     * @param user
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * Función que retorna la prioridad del usuario
     * @return priority
     */
    public String getPriority() {
        return priority;
    }

    /**
     * Método que define el nivel de prioridad del usuario
     * @param priority prioridad a configurar
     */
    public void setPriority(String priority) {
        this.priority = priority;
    }

    /**
     * Función que retorna el siguiente Nodo Usuario
     * @return next
     */
    public NodoUsers getNext() {
        return next;
    }

    /**
     * Método que establece el siguiente Nodo usuario
     * @param next nodoUsers siguiente
     */
    public void setNext(NodoUsers next) {
        this.next = next;
    }

    /**
     * Función que retorna el Nodo usuario anterior
     * @return previous
     */
    public NodoUsers getPrevious() {
        return previous;
    }

    /**
     * Método que define el Nodo usuario anterior
     * @param previous Nodo usuario anterior
     */
    public void setPrevious(NodoUsers previous) {
        this.previous = previous;
    }

    /**
     * Función que retorna la lista de documentos
     * @return the documents
     */
    public ListaDoc getDocuments() {
        return documents;
    }

    /**
     * Método que define la lista de documentos
     * @param documents the documents to set
     */
    public void setDocuments(ListaDoc documents) {
        this.documents = documents;
    }
    
    /**
     * Función que busca un documento dentro de la lista guardada por el usuario
     * @param searched nombre del documento buscado
     * @return el documento si existe
     */
    
    public NodoDoc BuscarDoc(String searched){
        
        ListaDoc doc=this.getDocuments();
        NodoDoc aux = doc.getpFirst();
        while(aux!=null){
            if(searched.equals(aux.getNombre())){
                return aux;
            }
            aux=aux.getpNext();
        }
        return null;
    }
    
    /**
     * Función que retorna la etiqueta modificada de tiempo
     * @param usuario Nodo usuario del cual se extrae la prioridad para proceder a modificar
     * la etiqueta de tiempo de ser necesario
     * @param timeTag etiqueta de tiempo original antes de ser modificada
     * @return etiqueta de tiempo modificada por prioridad
     */
    public int checkPriority(NodoUsers usuario,int timeTag){
        
        if(usuario.getPriority().equals(" prioridad_baja")){
            timeTag = timeTag *6;
        }
        else if(usuario.getPriority().equals(" prioridad_media")){
            timeTag = timeTag *3;
        }
        return timeTag;
    }
}
