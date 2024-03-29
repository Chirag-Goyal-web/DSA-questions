import java.util.ArrayList;

public class union_find {
    public static class Edge {
        int v, w;

        Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }


    public static void addEdge(ArrayList<Edge>[] graph, int u, int v, int w) {
        graph[u].add(new Edge(v, w));
        graph[v].add(new Edge(u, w));
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

    static int[] par, size;

    //Find parent along with the path compression. It will keep the time complexity < O(4), 
    //if we don't do path compression, time complexity= O(log n)
    public static int findPar(int u) {
        if(par[u]==u){
            return u;
        }
        else{
            int t=findPar(par[u]);
            par[u]=t;
            return t;
        }
    }

    //Merge the smaller part into bigger part. Even if we merge without comparing size, 
    //it will not affect much bcoz of the path compression
    public static void merge(int p1, int p2) {
        if(size[p1]>size[p2]){
            size[p1]+=size[p2];
            par[p2]=p1;
        }
        else{
            size[p2]+=size[p1];
            par[p1]=p2;
        }
    }

    // {{u,v,w}}
    public static void unionFind(int[][] Edges, int N) {
        ArrayList<Edge>[] graph = new ArrayList[N];
        for (int i = 0; i < N; i++)
            graph[i] = new ArrayList<>();

        par = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++) {
            par[i] = i;
            size[i] = 1;
        }

        for (int[] e : Edges) {
            int u = e[0], v = e[1], w = e[2];
            int p1 = findPar(u);
            int p2 = findPar(v);
            if (p1 != p2) {
                merge(p1, p2);
                addEdge(graph, u, v, w);
            }
        }
    }

}