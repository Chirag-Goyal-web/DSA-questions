public class out_of_boundary_paths_leetcode_576{

    int mod=1000000007;
    
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        
        Long[][][] dp=new Long[m+1][n+1][maxMove+1];
        int[][] dir=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        
        return (int)helper(startRow,startColumn,m,n,dp,dir,maxMove);
    }
    
    public long helper(int row,int col,int m,int n,Long[][][] dp,int[][] dir,int maxMove){
        
        if(row<0 || row>=m || col<0 || col>=n){
            return 1;
        }
        
        else if(maxMove==0){
            return dp[row][col][maxMove]=(long)0;
        }
        
        else if(dp[row][col][maxMove]!=null){
            return dp[row][col][maxMove];
        }
        
        else{
            
            long ans=0;
            
            for(int[] temp:dir){
                int tempr=row+temp[0];
                int tempc=col+temp[1];
                ans=(ans+helper(tempr,tempc,m,n,dp,dir,maxMove-1))%mod;
            }
            
            return dp[row][col][maxMove]=ans;
        }
        
    } 

}