import java.util.*;
public class Kosaraju_algorithm{

    public static class Edge{
        int v=0;
        int w=0;

        Edge(int v,int w){
            this.v=v;
            this.w=w;
        }
    }

    public static void dfs_1(ArrayList<Edge>[] graph,int src,boolean[] visited,ArrayList<Integer> topological){
        
        visited[src]=true;
        
        for(Edge temp:graph[src]){
            if(!visited[temp.v]){
                dfs_1(graph, temp.v, visited,topological);
            }
        }

        topological.add(src);
    }

    public static void dfs_2(ArrayList<Edge>[] graph,int src,boolean[] visited){
        
        visited[src]=true;
        
        for(Edge e:graph[src]){
            if(!visited[e.v]){
                dfs_2(graph,e.v,visited);
            }
        }
    }
    
    public static int kosaRaju(ArrayList<Edge>[] graph,int n){
        boolean[] visited=new boolean[n];
        ArrayList<Integer> topological=new ArrayList<>();

        for(int i=0;i<n;i++){
            if(visited[i]==false){
                dfs_1(graph, i, visited, topological);
            }
        }
        
        visited=new boolean[n];
        ArrayList<Edge>[] rgraph=new ArrayList[n];

        for(int i=0;i<n;i++)    
            rgraph[i]=new ArrayList<>();

        for(int i=0;i<n;i++){
            for(Edge e:graph[i]){
                Edge nw=new Edge(i,e.w);
                graph[e.v].add(nw);
            }
        }

        int count=0;

        for(int i=topological.size();i>=0;i--){
            if(visited[topological.get(i)]==false){
                count++;
                dfs_2(rgraph, topological.get(i), visited);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        


    }

}