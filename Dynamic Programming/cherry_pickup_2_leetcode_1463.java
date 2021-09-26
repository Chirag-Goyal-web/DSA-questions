public class cherry_pickup_2_leetcode_1463{

    public int cherryPickup(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Integer[][][] dp=new Integer[m][n][n];
        int[] dir=new int[]{1,0,-1};
        return helper(0,0,n-1,grid,dir,m,n,dp);
    }
    
    public int helper(int row,int col1,int col2,int[][] grid,int[] dir,int m,int n,Integer[][][] dp){
        if(col1<0||col2<0||col1>=n||col2>=n){
            return -(int)1e9;
        }
        
        else if(row==m){
            return 0;
        }
        
        else if(dp[row][col1][col2]!=null){
            return dp[row][col1][col2];
        }
        
        else{
            
            int cherry=0;
            if(col1==col2){
                cherry+=grid[row][col1];
            }
            else{
                cherry+=grid[row][col1];
                cherry+=grid[row][col2];
            }       
                
            int ans=-(int)1e9;

            for(int temp1:dir){
                int colO=col1+temp1;
                for(int temp2:dir){
                    int colI=col2+temp2;
                    int tempAns=helper(row+1,colO,colI,grid,dir,m,n,dp);
                    ans=Math.max(ans,tempAns);
                }
            }

            if(ans==-(int)1e9){
                return dp[row][col1][col2]=ans;
            }

            else{
                return dp[row][col1][col2]=ans+cherry;
            }
            
        }
    }

}