import java.util.Queue;
import java.util.LinkedList;

class MyBST{

    Node root = null;

    class Node{
        int data;
        Node left,right;
        
        public Node(int x){
            this.data = x;
            left = right = null;
        }
    }

    void insert(int x){
        this.root = insert(x, this.root);
    }
    
    Node insert(int x, Node node){
        if(node == null)
            return new Node(x);
        if(x < node.data)
            node.left = insert(x, node.left);
        else if(x > node.data)
            node.right = insert(x, node.right);
        else
            System.out.println("Element already present in BST.");
        return node;
    }

    void lvlOrder(){
        if(root == null) return;
        
        Queue<Node> lvl = new LinkedList();
        lvl.add(root);
        while(!lvl.isEmpty()){
            Node curr = lvl.poll();

            System.out.print("->"+curr.data);
            if(curr.left != null)
                lvl.add(curr.left);
            if(curr.right != null)
                lvl.add(curr.right);
        }

    }
}
public class MyBSTI{
    public static void main(String args[]){
        MyBST bst = new MyBST();
        bst.insert(6);
        bst.insert(5);
        bst.insert(7);
        bst.insert(8);
        bst.insert(9);
        bst.insert(10);
        bst.insert(3);
        bst.insert(4);
        bst.lvlOrder();
    }
}