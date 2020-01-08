import java.util.LinkedList;
public class Graph{
    // Implementation of Undirected Graph
    private final int V; // number of vertices
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

    public int getV(){
        return this.V;
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }
    public static void main(String args[]){
        Graph g = new Graph(5);
        g.addEdge(1,2);
        g.addEdge(2,3);
        g.addEdge(3,4);
        g.addEdge(4,1);
        new GraphProcessing(g, 1).bfs();
    }
}