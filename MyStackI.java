class MyStack{
    
    private int cap = 5;
    private int size = -1;
    private int[] store;
    
    public MyStack(){
        store = new int[cap];
    }
    
    void push(int x){
        if(size < cap)
            expandStore();
        store[++size] = x;
    }
    
    int pop() throws Exception {
        if(size == -1)
            throw new Exception("Stack Underflow");
        return store[size--];
    }
    
    void peek() throws Exception {
        if(size == -1)
            throw new Exception("Stack Underflow");
        System.out.println(store[size]);
    }
    
    int getSize(){
        return this.size+1;
    }
    
    
    void expandStore(){
        int arr[] = new int[cap *= 2];
        for(int i=0;i<store.length;i++)
            arr[i] = store[i];
        this.store = arr;
    }
    
    
    
}

public class MyStackI {
    public static void main(String args[]) throws Exception {
        MyStack st = new MyStack();  
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        st.push(6);
        st.push(7);
        st.push(8);
        st.push(9);
        st.pop();
        System.out.println(st.getSize());
        st.peek();
    }
}
