import java.util.*;
public class possible_bipartition_leetcode_886{

    public boolean possibleBipartition(int n, int[][] dislikes) {
        
        ArrayList<Integer>[] graph=new ArrayList[n+1];
        
        for(int i=0;i<=n;i++)
            graph[i]=new ArrayList<>();
        
        for(int[] arr:dislikes){
            graph[arr[0]].add(arr[1]); 
            graph[arr[1]].add(arr[0]); 
        }
               
        boolean[] visited=new boolean[n+1];
        int[] color=new int[n+1];
        Arrays.fill(color,-1);
    
        for(int i=1;i<=n;i++){
            if(visited[i]==false && graph[i].size()>0){
                
                Queue<Integer> que=new LinkedList<>();
                que.add(i);
                visited[i]=true;
                color[i]=0;
                
                while(que.size()>0){
                    int temp=que.remove();
                    
                    for(int v:graph[temp]){
                        
                        if(color[v]==-1){
                            color[v]=(color[temp]+1)%2;
                        }
                        else{
                            if(color[v]!=(color[temp]+1)%2){
                                return false;
                            }
                        }
                        
                        if(visited[v]==false){
                            que.add(v);
                            visited[v]=true;
                        }   
                    }
                    
                }
                
            }
        }
        
        return true;
    }

}