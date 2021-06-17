/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SecondProject;

/**
 *
 * @author andynet
 */
public class TreeNode {
    public Object data;
    public TreeNode right;
    public TreeNode left;
    public int id;
    
    
    //constructor de nodo
    public TreeNode(int i,Object data){
        this.data =data;
        this.right =null;
        this.left = null;
        this.id=i;
    }
    
    
}
