public class count_sub_islands_leetcode_1905{

    class Solution {
    
        public int countSubIslands(int[][] grid1, int[][] grid2) {
            
            int count=0;
            int m=grid1.length;
            int n=grid1[0].length;
            int[][] dir=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
            
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    
                    if(grid2[i][j]==1){
                        if(dfs(grid1,grid2,i,j,dir)==true){
                            count++;                
                        }
                    } 
                }
            }
            
            return count;
        }
        
        public boolean dfs(int[][] grid1,int [][] grid2,int row,int col,int[][] dir){
            
            boolean ans=true;
            grid2[row][col]=0;
            
            for(int i=0;i<4;i++){
                int tempr=row+dir[i][0];
                int tempc=col+dir[i][1];
                
                if(tempr>=0 && tempr<grid1.length && tempc>=0 && tempc<grid1[0].length && grid2[tempr][tempc]==1){
                    
                    boolean temp=dfs(grid1,grid2,tempr,tempc,dir);
                    ans=ans&&temp;    
                }
            }
            
            if(grid1[row][col]==0)
                return false;
            
            else
                return ans;
            
        }
        
    }

}