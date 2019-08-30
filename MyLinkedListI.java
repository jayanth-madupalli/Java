class MyLinkedList {
    
    class Node{
        int val;
        Node next=null;
        public Node(int val){
            this.val = val;
        }
    }
    
    Node head;
    public MyLinkedList(){
        this.head = null;
    }
    
    void add(int x){
        if(head == null)
            this.head = new Node(x);
        else{
            Node temp = head;
            while(temp.next != null)
                temp = temp.next;
            temp.next = new Node(x);
        }
    }
    
    void addFirst(int x){
        if(head == null)
            this.add(x);
        else{
            Node temp = new Node(x);
            temp.next = head;
            head = temp;
        }
    }
    
    void addAfter(int x, int y){
        if(head == null)
            this.add(x);
        else{
            Node temp = head;
            while(temp.val != y && temp.next != null)
                temp = temp.next;
            temp.next = new Node(x);
        }
    }
    
    
    void remove(int x){
        Node temp = head;
        while(temp.next.val != x && temp != null)
            temp = temp.next;
        temp.next = temp.next.next;
    }
    
    void removeFirst(){
        Node temp = head;
        head = head.next;
        temp = null;
    }
    
    void removeLast(){
        Node temp = head;
        while(temp.next.next != null)
            temp = temp.next;
        temp.next = null;
    }
    
    void reverse(){
        Node current = head;
        Node prev = null, next = null;
        
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        this.head = prev;
        
    }
    
    void display(){
        Node temp = head;
        while(temp != null){
            System.out.print("->" + temp.val);
            temp = temp.next;
        }
        System.out.println();
    }
    
    
}

public class MyLinkedListI {
    public static void main(String args[]) {
      MyLinkedList ll = new MyLinkedList();
      ll.add(2);
      ll.add(1);
      ll.addFirst(3);
      ll.addFirst(4);
      ll.add(0);
      ll.addAfter(-1,0);
      ll.display();
      ll.removeLast();
      ll.removeFirst();
      ll.remove(2);
      ll.reverse();
      ll.display();
    }
}
