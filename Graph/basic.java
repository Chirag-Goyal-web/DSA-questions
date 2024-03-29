import java.util.*;

public class basic{

    public static class Edge{
        int v;
        int w;

        Edge(int v,int w){
            this.v=v;
            this.w=w;
        }
    }

    public static void addEdge(ArrayList<Edge>[] graph,int u,int v,int w){
        graph[u].add(new Edge(v,w));
        graph[v].add(new Edge(v,w));
    }

    public static void display(ArrayList<Edge>[] graph, int V) {
        for(int i=0;i<V;i++){
            System.out.print(i+" -> ");

            for(Edge e:graph[i]){
                System.out.print("("+e.v+","+e.w+") ");
            }

            System.out.println();
        }
    }

    public static void constructGraph() {
        int V = 9;
        ArrayList<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++)
            graph[i] = new ArrayList<>();

        addEdge(graph, 0, 1, 10);
        addEdge(graph, 0, 3, 10);
        addEdge(graph, 1, 2, 10);
        addEdge(graph, 2, 3, 40);

        addEdge(graph, 2, 7, 2);
        addEdge(graph, 2, 8, 4);
        addEdge(graph, 7, 8, 3);

        addEdge(graph, 3, 4, 2);
        addEdge(graph, 4, 5, 2);
        addEdge(graph, 4, 6, 8);
        addEdge(graph, 5, 6, 3);

        //display(graph, V);
    }

    public static int findEdge(ArrayList<Edge>[] graph, int u, int v) {
        
        for(int i=0;i<graph[u].size();i++){
            Edge temp=graph[u].get(i);
            
            if(temp.v==v){
                return i;
            }
        }

        return -1;
    }

    public static void removeEdge(ArrayList<Edge>[] graph, int u, int v){

        int idx1=findEdge(graph,u,v);
        graph[u].remove(idx1);

        int idx2=findEdge(graph,v,u);
        graph[v].remove(idx2);

    }

    public static void removeVtx(ArrayList<Edge>[] graph, int u) {
        
        for(int i=graph[u].size()-1;i>=0;i--){
            Edge e = graph[u].get(i);
            removeEdge(graph, u, e.v);
        }

    }

    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis) {

        if(src==dest){
            return true;
        }

        else{
            
            vis[src]=true; //We dont't need to mark false at end bcoz, we are just finding. So no need to backtrack
            
            for(Edge e:graph[src]){
                if(vis[e.v]==false){
                    if(hasPath(graph, e.v, dest, vis)==true){
                        return true;
                    }
                }
            }

            return false;
        }

    }

    public static int allPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis, String psf) {

        if(src==dest){
            psf+=dest;
            System.out.println(psf);
            return 1;
        }
        
        else{

            int count=0;
            vis[src]=true;

            for(Edge e:graph[src]){
                if(vis[e.v]==false){
                    count+=allPath(graph, e.v, dest, vis, psf+src);
                }
            }

            vis[src]=false;
            return count;
        }

    }
    
    public static void preOrder(ArrayList<Edge>[] graph, int src, boolean[] vis, int wsf, String psf) {
        System.out.println(src + " -> " + (psf + src) + "@" + wsf);
        vis[src] = true;
        for (Edge e : graph[src]) {
            if (!vis[e.v])
                preOrder(graph, e.v, vis, wsf + e.w, psf + src);
        }

        vis[src] = false;
    }

    public static void postOrder(ArrayList<Edge>[] graph, int src, boolean[] vis, int wsf, String psf) {
        vis[src] = true;
        for (Edge e : graph[src]) {
            if (!vis[e.v])
                postOrder(graph, e.v, vis, wsf + e.w, psf + src);
        }

        System.out.println(src + " -> " + (psf + src) + "@" + wsf);
        vis[src] = false;
    }

    public static class pair {
        int heavyPath = 0;
        String psf = "";

        pair() {

        }

        pair(int heavyPath, String psf) {
            this.heavyPath = heavyPath;
            this.psf = psf;
        }
    }

    public static pair heavyPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis) {
        if (src == dest) {
            return new pair(0, src + "");
        }

        vis[src] = true;
        pair myAns = new pair(-1, "");
        for (Edge e : graph[src]) {
            if (!vis[e.v]) {
                pair recAns = heavyPath(graph, e.v, dest, vis);
                if (recAns.heavyPath != -1 && recAns.heavyPath + e.w > myAns.heavyPath) {
                    myAns.heavyPath = recAns.heavyPath + e.w;
                    myAns.psf = src + recAns.psf;
                }
            }
        }

        vis[src] = false;
        return myAns;
    }

    public static void hamintonainPathAndCycle(ArrayList<Edge>[] graph, int src, ArrayList<String> ans) {
        
    }

    public static void main(String[] args) {
        constructGraph();
    }
}