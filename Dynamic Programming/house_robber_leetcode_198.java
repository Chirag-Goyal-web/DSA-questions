import java.util.*;
public class house_robber_leetcode_198{
    
    //Memoization
    class Solution {
    
        public int rob(int[] nums) {
            int n=nums.length;
            int[] dp=new int[n+1];
            Arrays.fill(dp,-1);
            return helper(nums,n,dp);
        }
        
        public int helper(int[] nums,int n,int[] dp){
            if(n<=0){
                return 0;
            }

            else if(dp[n]!=-1){
                return dp[n];
            }

            else{
                int temp1=helper(nums,n-2,dp)+nums[n-1];
                int temp2=helper(nums,n-1,dp);
                return dp[n]=Math.max(temp1,temp2);
            }
        }
    }

    //Tabulation
    class Solution_ {
        public int rob(int[] nums) {
            int inc=0;
            int exc=0;
            
            for(int i:nums){
                int temp1=exc+i;
                int temp2=Math.max(inc,exc);
                inc=temp1;
                exc=temp2;
            }
            
            return Math.max(inc,exc);
        }
    }

}