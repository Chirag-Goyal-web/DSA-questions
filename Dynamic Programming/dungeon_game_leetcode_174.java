public class dungeon_game_leetcode_174{
    
    public int calculateMinimumHP(int[][] arr) {
        return Math.abs(helper(arr,0,0,arr.length,arr[0].length,new Integer[arr.length+1][arr[0].length+1]))+1;
    }
    
    public int helper(int[][] arr,int row,int col,int m,int n,Integer[][] dp){
        
        if(row==m-1 && col==n-1){
            return arr[row][col]<0?arr[row][col]:0;
        }
        
        else if(dp[row][col]!=null){
            return dp[row][col];
        }
        
        else{
            int ans=-(int)1e9;
            
            if(row+1<m){
                int temp=helper(arr,row+1,col,m,n,dp);
                if(temp+arr[row][col]>ans){
                    ans=temp+arr[row][col];
                }
            }
            
            if(col+1<n){
                int temp=helper(arr,row,col+1,m,n,dp);
                if(temp+arr[row][col]>ans){
                    ans=temp+arr[row][col];
                }
            }
            
            return dp[row][col]=(ans<0?ans:0);
        }
        
    }

}