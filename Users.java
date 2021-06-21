package proyecto2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mkferrerteran
 */
public class Users {
    private String user;
    private String priority;
    private NodoUsers first;
    private NodoUsers last;
    private int size;

    public Users(NodoUsers first, NodoUsers last, int size) {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public NodoUsers getFirst() {
        return first;
    }

    public void setFirst(NodoUsers first) {
        this.first = first;
    }

    public NodoUsers getLast() {
        return last;
    }

    public void setLast(NodoUsers last) {
        this.last = last;
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
    
    public boolean isEmpty(){
        return first == null;
    }
    
}
