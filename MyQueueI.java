class MyQueue{
    private int front = 0;
    private int rear = -1;
    private int cap = 5;
    private int[] store;
    
    public MyQueue() {
        store = new int[cap];
    }
    
    void add(int x){
        if(rear == -1 || (rear+1 < cap && front <= rear))
            store[++rear] = x;
        else{
            expandStore();
            store[++rear] = x;
        }
    }
    
    int remove() throws Exception {
        if(rear == -1 || front > rear)
            throw new Exception("Queue empty");
        return store[front++];
        
    }
    
    int size(){
        return rear-front+1;
    }
    
    void expandStore(){
        int size = rear - front+1;
        int[] a;
        int j=0;
        if(size < cap){
            a = new int[cap];
            for(int i=front;i<=rear;i++)
                a[j++] = store[i];
        }else{
            a = new int[cap *= 2];
            for(int i=front;i<=rear;i++)
                a[j++] = store[i];
        }
        rear = j-1;
        front = 0;
        this.store = a;
            
    }
}


public class MyQueueI {
    public static void main(String args[]) throws Exception {
        MyQueue q = new MyQueue();
        for(int i=1;i<=50;i++)
            q.add(i);
        while(q.size() != 20)
            System.out.print(q.remove() + " ");
        System.out.println();
        for(int i=51;i<=75;i++)
            q.add(i);
        while(q.size() != 0)
            System.out.print(q.remove() + " ");
        System.out.println();
    }
}
