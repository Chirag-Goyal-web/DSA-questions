import java.util.*;
public class combination_sum_4_leetcode_377{
    
    //Memoization
    class Solution {
    
        public int combinationSum4(int[] nums, int target) {
            int[] dp=new int[target+1];
            Arrays.fill(dp,-1);
            return helper(nums,target,dp);
        }
        
        public int helper(int[] nums,int target,int[] dp){
            
            if(target==0){
                return dp[target]=1;
            }
            
            else if(dp[target]!=-1){
                return dp[target];
            }
            
            else{
                int count=0;
                
                for(int i=0;i<nums.length;i++){
                    if(target>=nums[i]){
                        count+=helper(nums,target-nums[i],dp);        
                    }
                }
                
                return dp[target]=count;
            }
            
        }
        
    }

    //Tabulation
    class Solution_{
        public int combinationSum4(int[] nums, int target) {
            
            int[] dp=new int[target+1];
            dp[0]=1;
            int len=nums.length;
            
            for(int i=1;i<=target;i++){
                for(int j=0;j<len;j++){
                    if(i>=nums[j]){
                        dp[i]+=dp[i-nums[j]];
                    }
                }        
            }
            
            return dp[target];
        }
    }

}