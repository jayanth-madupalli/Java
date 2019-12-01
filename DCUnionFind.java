import java.util.*;
class OUnionFind{

    int n,id[],sz[];

    public OUnionFind(int n){
        this.n = n;
        id = new int[n*n + 2];
        sz = new int[n*n + 2];
        for(int i=0;i<(n*n)+2;i++){
            id[i] = i;
            sz[i] = 1;
        }
    }

    private int root(int i){
        while(i != id[i]){
            id[i] = id[id[i]];
            i = id[i];
        }   
        return i;
    }

    public boolean find(int p, int q){
        return root(p) == root(q);
    }

    public void union(int p, int q){
        int i = root(p);
        int j = root(q);
        if(sz[i] < sz[j]){
            id[i] = j;
            sz[j] += sz[i];
        }else{
            id[j] = i;
            sz[i] += sz[j];
        }
    }

    public void display(){
        for(int i=0;i<(n*n)+2;i++)
            System.out.print(id[i]+" ");
        System.out.println();
    }



}

public class DCUnionFind{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter N: ");
        int n = sc.nextInt();
        
        OUnionFind UF = new OUnionFind(n);

        while(true){
            System.out.print("\n1. Find\n2. Union\n3. Display\nEnter your choice: ");
            int c = sc.nextInt();
            int p,q;
            switch(c){
                case 1: System.out.println("Enter p & q: ");
                        p = sc.nextInt();
                        q = sc.nextInt();
                        System.out.println(UF.find(p, q));
                        break;
                case 2: 
                        System.out.println("Enter p & q: ");
                        p = sc.nextInt();
                        q = sc.nextInt();
                        UF.union(p, q);
                        System.out.println("Connected.");
                        break;
                case 3: UF.display();
                        break;
                default: System.exit(0);
            }
        }

    }

}