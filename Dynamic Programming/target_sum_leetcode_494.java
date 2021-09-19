import java.util.*;
public class target_sum_leetcode_494{

    public int findTargetSumWays(int[] nums, int target) {
        
        int sum=0;
        int n=nums.length;
        
        for(int i:nums){
            sum+=i;
        }
        
        if(target>sum||target<-sum){
            return 0;
        }
        
        int[][] dp=new int[2*sum+1][n+1];
        
        for(int i=0;i<=2*sum;i++){
            Arrays.fill(dp[i],-1);
        }
        
        return helper(nums,n,0,target,sum,dp);
    }
    
    public int helper(int[] nums,int idx,int curSum,int target,int total,int[][] dp){
        
        if(idx==0){
            if(curSum==target){
                return dp[curSum+total][0]=1;
            }
            
            else{
                return dp[curSum+total][0]=0;
            }
        }
        
        else if(dp[curSum+total][idx]!=-1){
            return dp[curSum+total][idx];
        }
        
        else{
            
            int temp=0;
            temp+=helper(nums,idx-1,curSum+nums[idx-1],target,total,dp);
            temp+=helper(nums,idx-1,curSum-nums[idx-1],target,total,dp);
            return dp[curSum+total][idx]=temp;
        
        }
    }

}