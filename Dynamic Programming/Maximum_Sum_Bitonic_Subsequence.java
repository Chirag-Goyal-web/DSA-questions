public class Maximum_Sum_Bitonic_Subsequence{

    public static int maxSumBS(int arr[], int n){
        
        int[] dp1=new int[n];
        int[] dp2=new int[n];
        
        int ans=0;
        
        LIS_LR(arr,dp1);
        LIS_RL(arr,dp2);
        
        for(int i=0;i<n;i++){
            ans=Math.max(ans,dp1[i]+dp2[i]-arr[i]);
        }
        
        return ans;
    }
    
    public static int[] LIS_LR(int[] arr, int[] dp) {
        
        int n = arr.length;
        
        for (int i = 0; i < n; i++) {
            dp[i] = arr[i];
            int temp=0;
            
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j]) {
                    temp=Math.max(temp,dp[j]);
                }
            }
            
            dp[i]+=temp;
        }

        return dp;
    }
    
    public static int[] LIS_RL(int[] arr, int[] dp) {
        int n = arr.length;
        
        for (int i = n - 1; i >= 0; i--) {
            
            dp[i] = arr[i];
            int temp=0;
            
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    temp=Math.max(temp,dp[j]);
                }
            }
            
            dp[i]+=temp;
        }

        return dp;
    }
    

}