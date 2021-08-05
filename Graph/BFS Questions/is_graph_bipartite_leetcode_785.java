import java.util.*;
public class is_graph_bipartite_leetcode_785{

    class Solution {
        public boolean isBipartite(int[][] graph) {
            
            int n=graph.length;
            int[] visited=new int[n];
            Arrays.fill(visited,-1);
            
            for(int i=0;i<n;i++){
                if(visited[i]==-1){
                    if(bfs(graph,i,visited)==false){
                        return false;
                    }
                }    
            }
            
            return true;
        }
        
        public boolean bfs(int[][] graph,int src,int[] visited){
            
            LinkedList<Integer> ls=new LinkedList<>();
            ls.add(src);
            int color=0;
            
            while(ls.size()>0){
                int size=ls.size();
                
                while(size-->0){
                    int temp=ls.remove(0);
                    
                    if(visited[temp]==-1){
                        for(int j=0;j<graph[temp].length;j++){
                            if(visited[graph[temp][j]]==-1){
                                ls.add(graph[temp][j]);
                            }
                        }
                    }
                    
                    else if(visited[temp]!=color){
                        return false;
                    }
                    
                    
                    visited[temp]=color;
                }
                
                color=(color+1)%2;
            }
            
            return true;
        }
        
    }

    public static void main(String[] args) {
        
    }
}