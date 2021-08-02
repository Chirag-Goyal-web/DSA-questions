public class leetCode_695_Max_area_of_Island{
    public int maxAreaOfIsland(int[][] grid) {
        
        int m=grid.length;
        int n=grid[0].length;
        int[][] dir=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        int ans=0;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    int temp=dfs(grid,i,j,m,n,dir);
                    ans=Math.max(ans,temp);
                }
            }
        }
        
        return ans;
        
    }
    
    
    public int dfs(int[][] grid,int row,int col,int m,int n,int[][]dir){
            
          int ans=0;  
          grid[row][col]=0;

          for(int i=0;i<dir.length;i++){

               int tempr=row+dir[i][0];
               int tempc=col+dir[i][1];

               if(tempr>=0 && tempc>=0 && tempr<m && tempc<n && grid[tempr][tempc]==1){
                   ans+=dfs(grid,tempr,tempc,m,n,dir);
               }

          }   
          
        return ans+1;
    }
}
