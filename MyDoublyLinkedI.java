import java.util.*;
class MyDoubleLinked{
    private Node head;
    
    class Node{
        int data;
        Node next;
        Node prev;
        public Node(int x){
            this.data = x;
            this.next = null;
            this.prev = null;
        }
    }

    void insert(int x){
        if(head == null){
            head = new Node(x);
            return;
        }
        Node temp = this.head;
        while(temp.next != null)
            temp = temp.next;
        Node temp2 = new Node(x);
        temp.next = temp2;
        temp2.prev = temp;
        return;        
    }
    void insertAtBegin(int x){
        if(head == null){
            head = new Node(x);
            return;
        }
        Node temp = new Node(x);
        temp.next = head;
        head.prev = temp;
        this.head = temp;
    }
    int removeFirst(){
        if(head == null)
            return -1;
        Node temp = head;
        head = head.next;
        head.prev = null;
        return temp.data;
    }
    int removeLast(){
        if(head == null)
            return -1;
        Node temp = head;
        while(temp.next.next != null)
            temp = temp.next;
        Node toDel = temp.next;
        temp.next = null;
        return toDel.data;
    }
    void display(int f){
        Node temp = head;
        if(temp == null)
            return;
        if(f==0)
            while(temp != null){
                System.out.print(temp.data+" ");
                temp = temp.next;
            }
        if(f==1){
            while(temp.next != null)
                temp = temp.next;
            while(temp != null){
                System.out.print(temp.data+" ");
                temp = temp.prev;
            }
        }

    }

}

public class MyDoublyLinkedI{
    public static void main(String args[]){
        MyDoubleLinked dl = new MyDoubleLinked();
        for(int i=1;i<=10;i++)
            dl.insert(i);
        dl.insertAtBegin(0);
        dl.display(0);
        dl.removeLast();
        dl.removeFirst();
        System.out.println();
        dl.display(1);
    }
}
