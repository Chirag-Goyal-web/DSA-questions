import java.util.*;
public class Critical_Connections_in_a_Network_leetcode_1192{

    class Solution {
    
        private static int[] low, disc, AP;
        private static int time = 0, rootCalls;
        private static boolean[] vis, APoints;
    
        public  class Edge {
            int v, w;
    
            Edge(int v, int w) {
                this.v = v;
                this.w = w;
            }
        }
        
        public List<List<Integer>> criticalConnections(int N, List<List<Integer>> connections) {
            
            ArrayList<Edge>[] graph=new ArrayList[N];
            
            for(int i=0;i<N;i++){
                graph[i]=new ArrayList<>();
            }
            
            for(List<Integer> l:connections){
                int u=l.get(0);
                int v=l.get(1);
                graph[u].add(new Edge(v, 0));
                graph[v].add(new Edge(u, 0));     
            }
           
            
            low = new int[N];
            disc = new int[N];
            AP = new int[N];
            vis = new boolean[N];
            APoints = new boolean[N];
            rootCalls=0;
            
            List<List<Integer>> ans=new ArrayList<>();
    
            dfs(0,-1,graph,ans);
            
            for(int i:AP){
                System.out.print(i+" ");
            }
            
            return ans;
        }
        
         public static void dfs(int src, int par, ArrayList<Edge>[] graph,List<List<Integer>> ans) {
            
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
                    dfs(e.v,src,graph,ans);
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
                    
                    if(low[e.v]>disc[src]){
                        AP[src]++;
                        List<Integer> ls=new ArrayList<>();
                        ls.add(src);
                        ls.add(e.v);
                        ans.add(ls);
                    }
                    
                }
            }
    
        }
    
        
    }

}