import java.util.*;
public class min_cost_to_connect_all_points_leetcode_1584{
    
    class Solution {
    
        public int findPar(int[] par,int idx){
            if(par[idx]==idx){
                    return idx;
            }
                
            else{
                int temp=findPar(par,par[idx]);
                par[idx]=temp;
                return temp;
            }       
        }
        
        public int minCostConnectPoints(int[][] points) {
            
            if(points.length==1){
                return 0;
            }
            
            else{
                
                int len=points.length;
                int size=((len)*(len-1))/2;
                long[][] graph=new long[size][3];
                int idx=0;
                
                for(int i=0;i<len;i++){
                    for(int j=i+1;j<len;j++){
                        graph[idx][0]=i;
                        graph[idx][1]=j;
                        long temp1=Math.abs(points[i][0]-points[j][0]);
                        long temp2=Math.abs(points[i][1]-points[j][1]);
                        graph[idx][2]=temp1+temp2;
                        idx++;
                    }
                }
    
                Arrays.sort(graph, (a, b) -> {
                    return (int)((a[2]-b[2])%1000000007); 
                });
            
                int[] par=new int[len];
                
                for(int i=0;i<len;i++){
                    par[i]=i;
                }
    
                int sum=0;            
                for(int i=0;i<size;i++){
                    int p1=findPar(par,(int)graph[i][0]);
                    int p2=findPar(par,(int)graph[i][1]);
                    
                    if(p1!=p2){
                        par[p1]=p2;
                        sum+=graph[i][2];
                    }   
                }
                
                return sum;
            }
            
        }
    }

    public static void main(String[] args) {
        
    }
}