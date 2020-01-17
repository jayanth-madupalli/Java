import java.util.LinkedList;
public class Graph{
    private final int V; // number of vertices
    private LinkedList<Integer>[] adj; //adjancey list
    private boolean isDigraph = false;
    public Graph(int V){
        // Implementation of Undirected Graph
        this.V = V;
        adj = (LinkedList<Integer>[]) new LinkedList[V];
        for(int v=0; v<V; v++)
            adj[v] = new LinkedList<Integer>();
    }

    public Graph(int V, boolean isDigraph){
        // Implementation of Directed Graph
        this.V = V;
        this.isDigraph = isDigraph;
        adj = (LinkedList<Integer>[]) new LinkedList[V];
        for(int v=0; v<V; v++)
            adj[v] = new LinkedList<Integer>();
    }

    public void addEdge(int v, int w){
        adj[v].add(w);
        if(!this.isDigraph)
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