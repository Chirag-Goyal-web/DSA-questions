import java.util.*;
public class minimum_time_to_collect_all_apples_in_a_tree{

    public int minTime(int n, int[][] edges, ArrayList<Boolean> hasApple) {
        
        ArrayList<Integer>[] graph=new ArrayList[n];
        
        boolean[] vis=new boolean[n];
        
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        
        for(int i=0;i<edges.length;i++){
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }
        
        int ans=dfs(0,graph,hasApple,vis);
        
        return ans==-1?0:ans;
        
    }
    
    public int dfs(int v,ArrayList<Integer>[] graph,ArrayList<Boolean> hasApple,boolean[] vis){
        
        int count=0;
        vis[v]=true;
        
        for(int i=0;i<graph[v].size();i++){
            if(vis[graph[v].get(i)]==false){
                int temp=dfs(graph[v].get(i),graph,hasApple,vis);
                if(temp!=-1){
                    count+=2+temp;
                }    
            }
            
        }
        
        vis[v]=false;
        
        if(count>0){
            return count;
        }
        
        if(hasApple.get(v)==true){
            return 0;
        }
        
        else{
            return -1;
        }
        
    }

    public static void main(String[] args) {
        
    }
}
