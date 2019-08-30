class MyMaxHeap{
    private int[] store;
    private int cap = 5;
    private int size = 1;
    public MyMaxHeap(){
        this.store = new int[cap];
    }
    void insert(int x){
        if(size >= store.length-1)
            expandStore();
        this.store[size++] = x;
    }
    void expandStore(){
        int a[] = new int[cap *= 2];
        for(int i=1;i<size;i++)
            a[i] = store[i];
        this.store = a;
    }
    int getSize(){
        return this.size-1;
    }
    void max_heapify(int i){
        int left = 2*i;
        int right = 2*i+1;

        int largest = i;
        if(left < size && store[i] < store[left])
            largest = left;
        if(right < size && store[largest] < store[right])
            largest = right;
        if(largest != i){
            swap(i,largest);
            max_heapify(largest);
        }
    }
    void heapify(){
        for(int i=(size-1)/2;i>=1;i--)
            max_heapify(i);
    }
    int returnMax(){
        return this.store[1];
    }
    void display(){
        for(int i=1;i<size;i++)
            System.out.print(this.store[i]+" ");
        System.out.println();
    }
    void swap(int a, int b){
        int temp = store[a];
        store[a] = store[b];
        store[b] = temp; 
    }
}
public class MyMaxHeapI{
    public static void main(String args[]){
        MyMaxHeap mmh = new MyMaxHeap();
        for(int i=1;i<=5;i++)
            mmh.insert(i);
        mmh.display();
        mmh.heapify();
        System.out.println("Root element: "+mmh.returnMax());
        mmh.display();
    }
}