public class max_area_of_a_island_leetcode_695{

    class Solution {
    
        public int maxAreaOfIsland(int[][] grid) {
            
            int m=grid.length;
            int n=grid[0].length;
            int[] par=new int[m*n];
            int len=m*n;
            int max=0;
            
            for(int i=0;i<len;i++)
                par[i]=i;
            
            int[][] dir=new int[][]{{1,0},{0,1}};
            
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    
                    if(grid[i][j]>0){
                    
                    int p1=findPar(par,i*n+j);
                    for(int k=0;k<2;k++){
    
                       int tempr=i+dir[k][0];
                       int tempc=j+dir[k][1];
    
                       if(tempr>=0 && tempc>=0 && tempr<m && tempc<n && grid[tempr][tempc]>0){
                        int p2=findPar(par,tempr*n+tempc);
                        
                        if(p1!=p2){
                            par[p2]=p1; //We can't merge p1 in p2, bcoz then we need to calculate p1 again in direction loop                        
                            grid[p1/n][p1%n]+=grid[p2/n][p2%n];
                        }
                           
                       }
    
              } 
                    max=Math.max(max,grid[p1/n][p1%n]);
                    }
                }
            }
            
            return max;
            
        }
        
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
        
    }

    public static void main(String[] args) {
        
    }
}

