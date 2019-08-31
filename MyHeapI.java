class MyHeap{
    private int[] store;
    private int cap = 5;
    private int size = 1;
    private int type;

    //0 = minheap, 1 = maxheap

    public MyHeap(int flag){
        this.store = new int[cap];
        this.type = flag;
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
    void min_heapify(int i){
        int left = 2*i;
        int right = 2*i+1;

        int smallest = i;
        if(left < size && store[i] > store[left])
            smallest = left;
        if(right < size && store[smallest] > store[right])
            smallest = right;
        if(smallest != i){
            swap(smallest, i);
            min_heapify(smallest);
        }
    }
    void heapify(){
        for(int i=(size-1)/2;i>=1;i--)
            if(type == 0)
                min_heapify(i);
            else
                max_heapify(i);
    }
    int getRoot(){
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
public class MyHeapI{
    public static void main(String args[]){
        MyHeap mh = new MyHeap(0);
        for(int i=5;i>=1;i--)
            mh.insert(i);
        mh.display();
        mh.heapify();
        System.out.println("Root element: "+mh.getRoot());
        mh.display();
    }
}