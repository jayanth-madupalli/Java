import java.util.LinkedList;
import java.util.Queue;

//Binary Tree (Not BST)

class MyBTree{

    class Node{
        int data;
        Node left,right;    
        public Node(int x){
            this.data = x;
            this.left = null;
            this.right = null;
        }
    }

    Node root;

    public MyBTree(){
        this.root = null;
    }

    //Took me sometime to figure this out!
    void insert(int x){
        if(root == null){
            this.root = new Node(x);
            return;
        }
        Queue<Node> lvl = new LinkedList();
        lvl.add(root);
        Node curr = lvl.poll();
        while(curr.left != null && curr.right != null){
            if(curr.left != null)
                lvl.add(curr.left);
            if(curr.right != null)
                lvl.add(curr.right);
            curr = lvl.poll();
        }
        if(curr.left == null)
            curr.left = new Node(x);
        else
            curr.right = new Node(x);
    }

    //find the deepest node and its parent using level order traversal, Ik.. a lot of lvl order traversals.
    void remove(){
        if(root == null)
            return;
        Queue<Node> lvl = new LinkedList();
        lvl.add(root);
        Node toDel = null;
        Node parent = null;
        while(!lvl.isEmpty()){
            toDel = lvl.peek();
            Node curr = lvl.poll();
            if(curr.left != null){
                lvl.add(curr.left);
                parent = curr;
            }
            if(curr.right != null){
                lvl.add(curr.right);
                parent = curr;
            }
        }
        delete(toDel, parent);
    }

    void delete(Node toDel, Node parent){
        if(parent.left == toDel)
            parent.left = null;
        else
            parent.right = null;
    }

    void display(int i){
        switch(i){
            case 0: inorder(root);
                    break;
            case 1: preorder(root);
                    break;
            case 2: postorder(root);
                    break;
            case 3: lvlOrder();
                    break;
        }
        System.out.println();
    }

    void lvlOrder(){
        Queue<Node> lvl = new LinkedList();
        if(this.root == null)
            return;
        lvl.add(root);
        while(!lvl.isEmpty()){
            Node temp = lvl.poll();
            System.out.print("->"+temp.data);
            if(temp.left != null)
                lvl.add(temp.left);
            if(temp.right != null)
                lvl.add(temp.right);
        }
        System.out.println();
    }

    void inorder(Node node){
        if(node == null)
            return;
        inorder(node.left);
        System.out.print("->"+node.data);
        inorder(node.right);
    }

    void preorder(Node node){
        if(node == null)
            return;
        System.out.print("->"+node.data);
        preorder(node.left);
        preorder(node.right);
    }

    void postorder(Node node){
        if(node == null)
            return;
        postorder(node.left);
        postorder(node.right);
        System.out.print("->"+node.data);
    }

}

public class MyBTreeI{
    public static void main(String args[]){
        MyBTree bt = new MyBTree();
        for(int i=1;i<=7;i++)
            bt.insert(i);
        bt.remove();
        bt.remove();
        System.out.print("Inorder: ");
        bt.display(0);
        System.out.print("Preorder: ");
        bt.display(1);
        System.out.print("Postorder: ");
        bt.display(2);
        System.out.print("LevelOrder: ");
        bt.display(3);
    }
}