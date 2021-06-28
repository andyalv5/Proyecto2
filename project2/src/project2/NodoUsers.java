package project2;

public class NodoUsers {
    private String user;
    private String priority;
    private ListaDoc documents;
    private NodoUsers next;
    private NodoUsers previous;

    public NodoUsers(){
    
    }
    public NodoUsers(String user, String priority) {
        this.user = user;
        this.priority = priority;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public NodoUsers getNext() {
        return next;
    }

    public void setNext(NodoUsers next) {
        this.next = next;
    }

    public NodoUsers getPrevious() {
        return previous;
    }

    public void setPrevious(NodoUsers previous) {
        this.previous = previous;
    }

    /**
     * @return the documents
     */
    public ListaDoc getDocuments() {
        return documents;
    }

    /**
     * @param documents the documents to set
     */
    public void setDocuments(ListaDoc documents) {
        this.documents = documents;
    }
    
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
}
