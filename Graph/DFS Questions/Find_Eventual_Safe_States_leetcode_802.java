import java.util.*;
public class Find_Eventual_Safe_States_leetcode_802{

    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        int[] visited=new int[graph.length];
        
        List<Integer> ans=new ArrayList<>();
        
        for(int i=0;i<graph.length;i++){
            if(visited[i]==0){
                dfs(graph,i,visited);
            }
        }
        
        for(int i=0;i<visited.length;i++){
            if(visited[i]==2)
                ans.add(i);
        }
        
        return ans;
    }
    
    public boolean dfs(int[][] graph,int src,int[] visited){
        
        if(visited[src]==1 || visited[src]==3){
            return false;
        }
        
        else if(visited[src]==2){
            return true;
        }
        
        else{
            
            boolean ans=true;
            
            for(int i:graph[src]){
                if(visited[src]==0){
                    visited[src]=1;
                }
                ans=ans&&dfs(graph,i,visited);
            }
            
            if(ans==true){
                visited[src]=2;
                return true;
            }
            
            else{
                visited[src]=3;
                return false;
            }
            
        }
        
    }

}