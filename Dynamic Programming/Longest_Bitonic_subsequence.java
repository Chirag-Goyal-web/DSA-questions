public class Longest_Bitonic_subsequence{

    public int LongestBitonicSequence(int[] nums)
    {
        int len=nums.length;
        int[] dp1=new int[len];
        int[] dp2=new int[len];
        
        int ans=0;
        
        LIS_LR(nums,dp1);
        LIS_RL(nums,dp2);
        
        for(int i=0;i<len;i++){
            ans=Math.max(ans,dp1[i]+dp2[i]-1);
        }
        
        return ans;
    }
    
    public static int[] LIS_LR(int[] arr, int[] dp) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        return dp;
    }
    
    public static int[] LIS_RL(int[] arr, int[] dp) {
        int n = arr.length;
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        return dp;
    }

}