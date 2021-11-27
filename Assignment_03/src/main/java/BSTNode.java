public class BSTNode {

    String data;
    BSTNode left, right;

    public BSTNode() 
    {
        left = null;
        right = null;
        data="";
    }
    public BSTNode(String data)
    {
        this(data,null,null);
    }
    public BSTNode(String data, BSTNode lt, BSTNode rt) 
    {
        this.data = data; 
        left = lt; 
        right = rt;
    }
    
}


