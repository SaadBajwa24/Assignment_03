import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

    BSTNode root;

    public BinarySearchTree()
    {
    	root=null;
    }
    public boolean isEmpty() 
    {
        return root == null;
    }
    public void insert(String data) 
    {
		BSTNode tempnode = root;
		BSTNode	prevnode = null;
	    while (tempnode != null) 
	    {
	    	prevnode = tempnode;
	    	if (tempnode.data.compareTo(data) < 0)
			 tempnode = tempnode.right;
	    	else 
			 tempnode = tempnode.left;
        }
		    if (root == null)
		        root = new BSTNode(data);
		    else if (prevnode.data.compareTo(data) < 0)
		        prevnode.right = new BSTNode(data);
		    else 
		    	prevnode.left  = new BSTNode(data);
    }   
    public boolean breadthFirst(String cmp)
    {
        BSTNode tempnode = root;
        Queue<BSTNode> queue = new LinkedList<>();
        if (tempnode != null) 
        {
            queue.add(tempnode);
            while (!queue.isEmpty()) 
            {
            	tempnode = queue.remove();
                if(tempnode.data.equals(cmp))
                	return true ;
                if (tempnode.left != null)
                    queue.add(tempnode.left);
                if (tempnode.right != null)
                    queue.add(tempnode.right);
            }
        }
        return false ;
    }
    // recursively traverse the BST  
    public void inorder_Recursive(BSTNode root) { 
        if (root != null) { 
            inorder_Recursive(root.left); 
            System.out.print(root.data + " "); 
            inorder_Recursive(root.right); 
        } 
    } 
 // method for inorder traversal of BST 
    public void inorder() { 
        inorder_Recursive(root); 
    } 
   
 
    
}
