import java.util.*;
public class sum_of_distances_in_tree_leetcode_834{

    int[] count,answer;
    int N;
    
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        
        count=new int[n];
        answer=new int[n];
        Arrays.fill(count,1);
        N=n;
        
        ArrayList<Integer>[] graph=new ArrayList[n];
        
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();    
        }
        
        for(int i=0;i<n-1;i++){
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }
        
        dfs1(0,-1,graph);        
        dfs2(0,-1,graph);
        return answer;
    }
    
    public void dfs1(int cur,int parent,ArrayList<Integer>[] graph){
        
        for(int child:graph[cur]){
            if(child!=parent){
                dfs1(child,cur,graph);
                count[cur]+=count[child];
                answer[cur]+=count[child]+answer[child];
            }
        }
        
    }
    
    public void dfs2(int cur,int parent,ArrayList<Integer>[] graph){
        
        for(int child:graph[cur]){
            if(child!=parent){
                answer[child]=answer[cur]-count[child]+N-count[child];
                dfs2(child,cur,graph);
            }
        }
        
    }

}