import java.util.*;
public class GraphProcessing{

    private boolean[] visited;
    private int edgeTo[], s;
    private Graph G;

    public GraphProcessing(Graph G, int s){
        this.G = G;
        this.s = s;
        this.visited = new boolean[G.getV()];
        this.edgeTo = new int[G.getV()];
    }

    public boolean hasPath(int v){
        return visited[v];
    }

    public void dfs_iterative(){
        Stack<Integer> st = new Stack<Integer>();
        st.push(s);
        while(!st.isEmpty()){
            int v = st.pop();
            if(!this.visited[v]){
                System.out.print(v+" -> ");
                this.visited[v] = true;
            }
            for(int w : G.adj(v))
                if(!this.visited[w]){
                    st.push(w);
                    this.edgeTo[w] = v;
                }
        }
        System.out.println();
    }

    public void dfs_rec(){
        dfs_recursive(this.s);
    }

    public void dfs_recursive(int v){
        if(!this.visited[v]){
            System.out.print(v+" -> ");
            this.visited[v] = true;
            for(int w : G.adj(v))
                if(!this.visited[w]){
                    this.edgeTo[w] = v;
                    dfs_recursive(w);
                }
        }
    }

    public void bfs(){
        Queue<Integer> qu = new LinkedList<Integer>();
        qu.add(this.s);
        this.visited[s] = true;

        while(!qu.isEmpty()){
            int v = qu.poll();
            System.out.print(v + " -> ");
            for(int w : this.G.adj(v))
                if(!this.visited[w]){
                    this.edgeTo[w] = v;
                    this.visited[w] = true;
                    qu.add(w);
                }
        }
    }

}