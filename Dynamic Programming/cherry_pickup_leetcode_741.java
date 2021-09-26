import java.util.*;
public class cherry_pickup_leetcode_741{
    public int cherryPickup(int[][] grid) {
        
        int len=grid.length;
        int[][] dp=new int[len*len][len*len];
        
        for(int i=0;i<len*len;i++){
            Arrays.fill(dp[i],-1);
        }
        
        int ans= helper(0,0,0,0,dp,len,grid);
        
        if(ans==-(int)1e9){
            return 0;
        }
        else{
            return ans;
        }
    }
    
    public int helper(int r1,int c1,int r2,int c2,int[][] dp,int len,int[][] grid){
        
        if(r1>=len||r2>=len||c1>=len||c2>=len||grid[r1][c1]==-1||grid[r2][c2]==-1){
            return -(int)1e9;
        }
        
        else if(r1==len-1 && c1==len-1){
            return grid[r1][c1];
        }
        
        else if(dp[r1*len+c1][r2*len+c2]!=-1){
            return dp[r1*len+c1][r2*len+c2];
        }
        
        else if(dp[r2*len+c2][r1*len+c1]!=-1){
            return dp[r2*len+c2][r1*len+c1];
        }
        
        else{
            
            int cherry=0;
            if(r1==r2 && c1==c2){
                cherry+=grid[r1][c1];
            }
            
            else{
                cherry+=grid[r1][c1];
                cherry+=grid[r2][c2];
            }
            
            int ans=-(int)1e9;
            
            int temp1=helper(r1+1,c1,r2+1,c2,dp,len,grid);
            int temp2=helper(r1+1,c1,r2,c2+1,dp,len,grid);
            int temp3=helper(r1,c1+1,r2+1,c2,dp,len,grid);
            int temp4=helper(r1,c1+1,r2,c2+1,dp,len,grid);
            
            ans=Math.max(Math.max(temp1,temp2),Math.max(temp3,temp4));
            
            if(ans==-(int)1e9){
                dp[r2*len+c2][r1*len+c1]=ans;
                return dp[r1*len+c1][r2*len+c2]=ans;
            }
            else{
                dp[r2*len+c2][r1*len+c1]=ans+cherry;
                return dp[r1*len+c1][r2*len+c2]=ans+cherry;
            }
            
        }  
            
    }
}