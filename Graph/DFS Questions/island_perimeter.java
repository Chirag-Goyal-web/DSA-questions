public class island_perimeter{
    
    class Solution_1{
        public int islandPerimeter(int[][] grid) {
            
            int m=grid.length;
            int n=grid[0].length;
            int[][] dir=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
            int ones=0;
            int nbr=0;
            
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    
                    if(grid[i][j]==1){
                        ones++;
                        nbr+=countNbr(grid,i,j,m,n,dir);
                    }
                    
                }
            }
            
            return ones*4-nbr;
    
        }
        
        public int countNbr(int[][] grid,int r,int c,int m,int n,int[][] dir){
            
            int count=0;
            
            for(int i=0;i<dir.length;i++){
    
                   int tempr=r+dir[i][0];
                   int tempc=c+dir[i][1];
    
                   if(tempr>=0 && tempc>=0 && tempr<m && tempc<n && grid[tempr][tempc]==1){
                count++;         
                   }
    
              }    
            return count;
            
        }
        
    }

    //DfS solution
    class Solution_2{
    
        public int islandPerimeter(int[][] grid) {
            
            int m=grid.length;
            int n=grid[0].length;
            boolean[][] vis=new boolean[m][n];
            int[] ans=new int[2];
            
            int[][] dir=new int[][]{{0,-1},{0,1},{1,0},{-1,0}};
            
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(grid[i][j]==1){
                        ans=dfs(grid,vis,dir,i,j,m,n);
                       return ans[0]*4-ans[1];
                    }
                }
            }
            
            return 0;
        }
        
        public int[] dfs(int[][] grid,boolean[][] vis,int[][] dir,int r,int c,int m,int n){
            
            vis[r][c]=true;
            
            int []ans=new int[2];
            
            for(int i=0;i<dir.length;i++){
                
                int tempr=r+dir[i][0];
                int tempc=c+dir[i][1];
                
                if(tempr>=0 && tempr<m && tempc>=0 && tempc<n && grid[tempr][tempc]==1 && vis[tempr][tempc]==false){
                    int[] temp=dfs(grid,vis,dir,tempr,tempc,m,n);
                    ans[0]+=temp[0];
                    ans[1]+=temp[1];
                }
                
            }
            
            ans[0]++;
            
            //Check neighbour  
            for(int i=0;i<dir.length;i++){
                
                int tempr=r+dir[i][0];
                int tempc=c+dir[i][1];
                
                if(tempr>=0 && tempr<m && tempc>=0 && tempc<n && grid[tempr][tempc]==1){
                    ans[1]++;
                }
                
            }
           
            return ans;
        }
        
    }

}