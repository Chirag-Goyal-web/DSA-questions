import java.util.*;
public class Reorder_Routes_to_Make_All_Paths_Lead_to_the_City_Zero_leetcode_1466{

    public int minReorder(int n, int[][] connections) {
        
        ArrayList<Integer>[] graph=new ArrayList[n];
        ArrayList<Integer>[] arr=new ArrayList[n];
        
        for(int i=0;i<n;i++){
            arr[i]=new ArrayList<>();
            graph[i]=new ArrayList<>();
        }
        
        for(int[] temp:connections){
            graph[temp[0]].add(temp[1]);
            arr[temp[0]].add(temp[1]);
            arr[temp[1]].add(temp[0]);
        }
        
        int ans=0;
        boolean[] visited=new boolean[n];
        visited[0]=true;
        
        Queue<Integer> que=new LinkedList<>();
        que.add(0);
        
        while(que.size()>0){
            int v=que.remove();
            
            for(int i:graph[v]){
                if(visited[i]==false){
                    ans++;
                }
            }
            
            for(int i:arr[v]){
                if(visited[i]==false){
                    visited[i]=true;
                    que.add(i);
                }
            }
            
        }
        
        return ans;
    }

}