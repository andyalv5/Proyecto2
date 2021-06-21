package proyecto2;

public class NodoUsers {
    private String user;
    private String priority;
    private NodoUsers next;
    private NodoUsers previous;

    public NodoUsers(String user, String priority, NodoUsers next, NodoUsers previous) {
        this.user = user;
        this.priority = priority;
        this.next = next;
        this.previous = previous;
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

    public void setPrevious(NodoUsers last) {
        this.previous = previous;
    }
    
}
