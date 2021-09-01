public class Detect_Cycles_in_2D_Grid_leetcode_1559{

    public boolean containsCycle(char[][] grid) {
        int n=grid.length,m=grid[0].length;
        int[][] dir=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]!='V'){
                    if(dfs(i*m+j,-1,grid,dir,n,m)){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean dfs(int src,int par,char[][] grid,int[][] dir,int n,int m){

        int row=src/m;
        int col=src%m;
        int prow=par/m;
        int pcol=par%m;
        char v=grid[row][col];
        grid[row][col]='P';

        for(int[] temp:dir){
            int tempr=row+temp[0];
            int tempc=col+temp[1];

            if(tempr>=0 && tempr<n && tempc>=0 && tempc<m && !(tempr==prow && tempc==pcol)){
                if(grid[tempr][tempc]=='P'){
                    return true;
                }
                else if(grid[tempr][tempc]==v && dfs(tempr*m+tempc,src,grid,dir,n,m)){
                    return true;
                }
            }
        }

        grid[row][col]='V';
        return false;
    }

}