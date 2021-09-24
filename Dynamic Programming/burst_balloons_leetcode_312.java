import java.util.*;
public class burst_balloons_leetcode_312{

    public int maxCoins(int[] nums) {
        int len=nums.length;
        int[][] dp=new int[len][len];
        
        for(int i=0;i<len;i++){
            Arrays.fill(dp[i],-1);
        }
        
        return helper(0,nums.length-1,nums,dp);
    }
    
    public int helper(int start,int end,int[] nums,int[][] dp){
        
        if(start>end){
            return 0;
        }
        
        else if(dp[start][end]!=-1){
            return dp[start][end];
        }
        
        else{
            
            int ans=0;
            int temp1=start-1>=0?nums[start-1]:1;
            int temp2=end+1<nums.length?nums[end+1]:1;
            
            for(int i=start;i<=end;i++){
                int left=helper(start,i-1,nums,dp);
                int right=helper(i+1,end,nums,dp);
                                
                ans=Math.max(ans,left+right+(temp1*temp2*nums[i]));    
            }

            return dp[start][end]=ans;
        }
        
    }

}