import java.util.*;
public class longest_increasing_subsequence_leetcode_300{

    //Memoization
    class Solution {
        public int lengthOfLIS(int[] nums) {
            
            int len=nums.length;
            int[] dp=new int[len];
            Arrays.fill(dp,-1);
            int ans=0;
            
            for(int i=len-1;i>=0;i--){
                if(dp[i]==-1){
                    int temp=helper(i,dp,nums);
                    ans=Math.max(ans,temp);
                }
            }
            
            return ans;
        }
        
        public int helper(int idx,int[] dp,int[] nums){
            
            if(idx==0){
                return dp[idx]=1;
            }
            
            else if(dp[idx]!=-1){
                return dp[idx];
            }
            
            else{
                int ans=0;
                int val=nums[idx];
                
                for(int i=idx-1;i>=0;i--){
                    
                    if(val>nums[i]){    
                        int temp=helper(i,dp,nums);
                        ans=Math.max(ans,temp);
                    }
                }
                
                return dp[idx]=ans+1;
            }
        }
        
    }

    //Tabulation
    class Solution_{
        
        public int lengthOfLIS(int[] nums) {
            return LIS_LR(nums,new int[nums.length]);
        }

        public int LIS_LR(int[] arr, int[] dp) {
            int n = arr.length, maxLen = 0;
            for (int i = 0; i < n; i++) {
                dp[i] = 1;
                for (int j = i - 1; j >= 0; j--) {
                    if (arr[i] > arr[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
    
                maxLen = Math.max(dp[i], maxLen);
            }
    
            return maxLen;
        }

    }

}