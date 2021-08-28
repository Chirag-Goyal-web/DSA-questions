import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;
public class articulation_point{


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

    private static int[] low, disc, AP;
    private static int time = 0, rootCalls;
    private static boolean[] vis, APoints;

    public static void dfs(int src, int par, ArrayList<Edge>[] graph) {
        
        vis[src]=true;
        low[src]=disc[src]=time;
        time++;

        for(Edge e:graph[src]){
            
            if(e.v==par){
                continue;
            }
            
            else if(vis[e.v]==true){
                low[src]=Math.min(low[src],disc[e.v]);
            }

            else{
                dfs(e.v,src,graph);
                
                if(par==-1){
                    rootCalls++;
                }

                if(low[e.v]>=disc[src]){
                    AP[src]++;
                    APoints[src]=true;
                }

                else{
                    low[src]=Math.min(low[e.v],low[src]);
                }
            }
        }

    }

    public static void APB(int N, ArrayList<Edge>[] graph) {
        
        low = new int[N];
        disc = new int[N];
        AP = new int[N];
        vis = new boolean[N];
        APoints = new boolean[N];

        for (int i = 0; i < N; i++) {
            if (!vis[i]) {
                AP[i] = -1;//For root
                dfs(i, -1, graph);
                if (rootCalls == 1)
                    APoints[i] = false;
            }
        }

    }

}