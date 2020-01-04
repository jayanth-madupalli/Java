import java.util.LinkedList;
public class Graph{

    private final int V;
    private LinkedList<Integer>[] adj; //adjancey list

    public Graph(int V){
        this.V = V;
        adj = (LinkedList<Integer>[]) new LinkedList[V];
        for(int v=0; v<V; v++)
            adj[v] = new LinkedList<Integer>();
    }

    public void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }
    public static void main(String args[]){

    }
}