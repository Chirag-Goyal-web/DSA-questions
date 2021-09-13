public class maximum_sum_increasing_subsequence{

    public int maxSumIS(int arr[], int n)  {  
	    int[] dp=new int[n];
	    return LIS_LR(arr,dp);
	}
	
	public static int LIS_LR(int[] arr, int[] dp) {
        
        int n = arr.length;
        int ans=0;
        
        for (int i = 0; i < n; i++) {
            dp[i] = arr[i];
            int temp=0;
            
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j]) {
                    temp=Math.max(temp,dp[j]);
                }
            }
            dp[i]+=temp;
            ans=Math.max(ans,dp[i]);
        }

        return ans;
    }

}