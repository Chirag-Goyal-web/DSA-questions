import java.util.*;
public class Network_Delay_Time_leetcode_743{

    class Solution {
    
        public int dijkstra(ArrayList<int[]>[] graph,int src,int n){
            
            int[] dis=new int[n];
            Arrays.fill(dis,(int)1e9);
            boolean[] visited=new boolean[n];
            
            PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
                return a[1]-b[1];
            });
            
            dis[src]=0;
            
            pq.add(new int[]{src,0});
            
            while(pq.size()>0){
                int[] temp=pq.remove();
                
                if(visited[temp[0]]==true){
                    continue;
                }
                
                else{
                    
                    int s=temp[0],wsf=temp[1];
                    visited[s]=true;
                    
                    for(int[] arr:graph[s]){
                        if(!visited[arr[0]]){
                            
                            if(wsf+arr[1]<dis[arr[0]]){
                                dis[arr[0]]=wsf+arr[1];
                                pq.add(new int[]{arr[0],wsf+arr[1]});    
                            }
                        
                        }
                    }
                    
                }
                
            }
            
            int ans=Integer.MIN_VALUE;
    
            for(int i=1;i<n;i++){
                if(dis[i]==((int)1e9)){
                    return -1;
                }
                else if(dis[i]>ans){
                    ans=dis[i];
                }
            }
            
            return ans;
        }
        
        public int networkDelayTime(int[][] times, int n, int k) {
            
            ArrayList<int[]>[] graph=new ArrayList[n+1];
            
            for(int i=0;i<=n;i++){
                graph[i]=new ArrayList<>();
            }
            
            for(int i=0;i<times.length;i++){
                graph[times[i][0]].add(new int[]{times[i][1],times[i][2]});
            }
            
            return dijkstra(graph,k,n+1);
        }
        
    }

}