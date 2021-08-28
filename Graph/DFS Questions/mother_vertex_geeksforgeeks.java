import java.util.*;

public class mother_vertex_geeksforgeeks{
    
    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>>adj){
        boolean[] visited=new boolean[V];
        int ans=0;
        
        for(int i=0;i<V;i++){
            if(visited[i]==false){
                dfs(adj,i,visited);
                ans=0;
            }
        }
        
        visited=new boolean[V];
        dfs(adj,ans,visited);
        
        for(int i=0;i<V;i++){
            if(visited[i]==false)
                return -1;
        }
        
        return ans;
    }
    
    public static void dfs(ArrayList<ArrayList<Integer>>adj,int src,boolean[] visited){
        
        visited[src]=true;
        
        for(int i:adj.get(src)){
            if(visited[i]==false){
                dfs(adj,i,visited);
            }
        }  

    } 

}