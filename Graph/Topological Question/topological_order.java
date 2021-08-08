import java.util.*;

public class topological_order {
    public static class Edge {
        int v, w;

        Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public static void addEdge(ArrayList<Edge>[] graph, int u, int v, int w) {
        graph[u].add(new Edge(v, w));
    }
    
    public static void display(ArrayList<Edge>[] graph, int V) {
        for (int i = 0; i < V; i++) {
            System.out.print(i + " -> ");
            for (Edge e : graph[i]) {
                System.out.print("(" + e.v + "," + e.w + ") ");
            }
            System.out.println();
        }
    }

    //Using DFS- this can't handle graph with a cycle
    public static void topologicalOrder_1(int n, ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[n];
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                topo_DFS_1(i, graph, vis, ans);
            }
        }

        for (int i = ans.size() - 1; i >= 0; i--) {
            System.out.println(ans.get(i));
        }
    }

    public static void topo_DFS_1(int src, ArrayList<Edge>[] graph, boolean[] vis, ArrayList<Integer> ans) {
        vis[src] = true;
        for (Edge e : graph[src]) {
            if (!vis[e.v]) {
                topo_DFS_1(e.v, graph, vis, ans);
            }
        }
        ans.add(src);
    }

    //DFS which can handle cycle
    public static void topologicalOrder_2(int n, ArrayList<Edge>[] graph) {
        int[] visited=new int[n];
        Arrays.fill(visited,-1);
        ArrayList<Integer> ans=new ArrayList<>();
        
        for(int i=0;i<n;i++){
            if(visited[i]==-1){
                if(topo_DFS_2(graph,visited,i,ans)==false){
                    System.out.println("Cycle detected");
                }   
            }    
        }

    }
    
    public static boolean topo_DFS_2(ArrayList<Edge>[] graph,int[] visited,int src,ArrayList<Integer> ans){
        
        visited[src]=1;
        
        for(Edge i:graph[src]){ 
            if(visited[i.v]==-1){
                boolean temp=topo_DFS_2(graph,visited,i.v,ans);
                if(temp==false){
                    return false;
                }
            }
            
            else{
                if(visited[i.v]==1){
                    return false;
                }
            }
        }
        
        visited[src]=2;
        ans.add(src);
        return true;
    }
    
    //Kahn's Aglorithm- BFS method
    public static ArrayList<Integer> kahnsAlgo(int n, ArrayList<Edge>[] graph) {
        int[] indegree = new int[n];
        for (ArrayList<Edge> edgesList : graph) {
            for (Edge e : edgesList) {
                indegree[e.v]++;
            }
        }

        LinkedList<Integer> que = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++)
            if (indegree[i] == 0)
                que.addLast(i);

        int level = 0;
        while (que.size() != 0) {
            int size = que.size();
            while (size-- > 0) {
                int vtx = que.removeFirst();
                ans.add(vtx);

                for (Edge e : graph[vtx]) {
                    if (--indegree[e.v] == 0)
                        que.addLast(e.v);
                }

            }
            level++;
        }

        if (ans.size() != n) {
            System.out.println("Topological Order is not possible due to Cycle");
            ans.clear();
        }

        return ans;
    }

    public static void constructGraph() {
        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++)
            graph[i] = new ArrayList<>();

        addEdge(graph, 0, 1, 10);
        addEdge(graph, 0, 3, 10);
        addEdge(graph, 1, 2, 10);
        addEdge(graph, 2, 3, 40);

        // addEdge(graph, 2, 7, 2);
        // addEdge(graph, 2, 8, 4);
        // addEdge(graph, 7, 8, 3);

        addEdge(graph, 3, 4, 2);
        addEdge(graph, 4, 5, 2);
        addEdge(graph, 4, 6, 8);
        addEdge(graph, 5, 6, 3);

        addEdge(graph, 0, 6, 3);

        boolean[] vis = new boolean[V];
    }

    public static void main(String[] args) {
        constructGraph();
    }

}