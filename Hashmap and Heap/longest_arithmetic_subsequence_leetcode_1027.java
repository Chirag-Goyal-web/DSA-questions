import java.util.*;
public class longest_arithmetic_subsequence_leetcode_1027{
    public int longestArithSeqLength(int[] nums) {
        int[][] dp=new int[501][1001];
        int ans=2;

        for(int i=0;i<nums.length;i++){
            Arrays.fill(dp[nums[i]],1);
            for(int j=i-1;j>=0;j--){
                int diff=nums[i]-nums[j];
                dp[nums[i]][diff+500]=dp[nums[j]][diff+500]+1;
                ans=Math.max(ans,dp[nums[i]][diff+500]);
            }
        }
        
        return ans;
    }
}