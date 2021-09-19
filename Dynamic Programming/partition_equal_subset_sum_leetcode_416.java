public class partition_equal_subset_sum_leetcode_416{
    
    public boolean canPartition(int[] nums) {
        
        int sum=0;
        int n=nums.length;
        
        for(int i:nums){
            sum+=i;
        }
        
        if(sum%2!=0){
            return false;
        }
        
        Boolean[][] dp=new Boolean[sum+1][n+1];
        return helper(dp,n,sum/2,nums);
    }
    
    public Boolean helper(Boolean[][] dp,int N,int Sum,int[]arr){
        
        for(int sum=0;sum<=Sum;sum++){
            for(int n=0;n<=N;n++){
            
                if(sum==0){
                    dp[sum][n]=true;
                }
                
                else if(n==0){
                    dp[sum][n]=false;
                }
                
                else{
                    Boolean ans=false;
                    
                    if(sum-arr[n-1]>=0){
                        ans=dp[sum-arr[n-1]][n-1];
                    }
                    
                    ans=ans||dp[sum][n-1];
                    dp[sum][n]=ans;
                }
            }
        }
        
        return dp[Sum][N];
    }

}