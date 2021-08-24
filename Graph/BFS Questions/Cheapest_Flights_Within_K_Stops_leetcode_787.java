import java.util.*;

public class Cheapest_Flights_Within_K_Stops_leetcode_787{
    
    //Approach-1 Dijkstra algo (TLE)
    class Solution {
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            
            ArrayList<int[]>[] graph=new ArrayList[n];
            
            for(int i=0;i<n;i++){
                graph[i]=new ArrayList<>();
            }
            
            //{dest,cost}
            for(int[] temp:flights){
                graph[temp[0]].add(new int[]{temp[1],temp[2]});
            }
            
            return helper(graph,src,dst,k);
        }
        
        public int helper(ArrayList<int[]>[] graph,int src,int dest,int k){
            
            //{src,wsf,number of stops}
            PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
                return a[1]-b[1];
            });
            
            pq.add(new int[]{src,0,0});
            
            while(pq.size()>0){
                
                int[] temp=pq.remove();
                
                if(temp[2]-1>k){
                    continue;
                }
                if(temp[0]==dest){
                    return temp[1];
                }
                
                for(int i=0;i<graph[temp[0]].size();i++){
                    pq.add(new int[]{graph[temp[0]].get(i)[0],graph[temp[0]].get(i)[1]+temp[1],temp[2]+1});
                }
            }
            
            return -1;
        }
        
    }

    //Bellman ford algorithm
    class Solution_{
    
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            
            int[] prev=new int[n];
            int[] cur=new int[n];
            
            Arrays.fill(prev,(int)1e5);
            prev[src]=0;
                
            for(int i=0;i<=k;i++){
                
                for(int j=0;j<n;j++){
                    cur[j]=prev[j];
                }
                
                for(int[] temp:flights){
                    
                    int source=temp[0];
                    int dest=temp[1];
                    int cost=temp[2];
                    
                    //Check if it is possible to reach source
                    if(prev[source]!=(int)1e5){
                        if(prev[source]+cost<cur[dest]){
                            cur[dest]=prev[source]+cost;                        
                        }  
                    }
                }
                
                for(int j=0;j<n;j++){
                    prev[j]=cur[j];    
                }
              
            }
            
            return prev[dst]==(int)1e5?-1:prev[dst];
        }
    }

}