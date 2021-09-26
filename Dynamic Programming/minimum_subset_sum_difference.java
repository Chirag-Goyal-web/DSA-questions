import java.util.*;
public class minimum_subset_sum_difference{

    public int findMin(int[] nums) {
        
        int len=nums.length+1;
        int sum=0;

        for(int i:nums)
            sum+=i;

        int[][] dp=new int[len+1][sum+1];
        for(int i=0;i<=len;i++){
            Arrays.fill(dp[i],-1);
        }

        return helper(nums,nums.length,0,0,dp);
    }

    public static int helper(int[] nums,int idx,int sum1,int sum2,int[][] dp){
        if(idx==0){
            return Math.abs(sum1-sum2);
        }

        else if(dp[idx][Math.abs(sum1-sum2)]!=-1){
            return dp[idx][Math.abs(sum1-sum2)];
        }

        else{
            int temp1=helper(nums,idx-1,sum1+nums[idx-1],sum2,dp);
            int temp2=helper(nums,idx-1,sum1,sum2+nums[idx-1],dp);

            return dp[idx][Math.abs(sum1-sum2)]=Math.min(temp1,temp2);
        }
    }

}