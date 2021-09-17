public class subset_sum_problem{

    //Memoization
    class Solution{

        public static Boolean isSubsetSum(int N, int arr[], int sum){
            Boolean[][] dp=new Boolean[sum+1][N+1];
            return helper(dp,N,sum,arr);
        }
        
        public static Boolean helper(Boolean[][] dp,int n,int sum,int[]arr){
            
            if(sum==0){
                return dp[sum][n]=true;
            }
            
            else if(sum<0){
                return false;
            }
            
            else if(n==0){
                return dp[sum][n]=false;
            }
            
            else if(dp[sum][n]!=null){
                return dp[sum][n];
            }
            
            else{
                Boolean ans=helper(dp,n-1,sum-arr[n-1],arr)||helper(dp,n-1,sum,arr);
                dp[sum][n]=ans;
                return ans;
            }
            
        }
        
    }

    //Tabulation
    class Solution_{

        static Boolean isSubsetSum(int N, int arr[], int sum){
            Boolean[][] dp=new Boolean[sum+1][N+1];
            return helper(dp,N,sum,arr);
        }
        
        static Boolean helper(Boolean[][] dp,int N,int Sum,int[]arr){
            
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

    //Backengineer, obtain dp array from tabulation to explore all paths
    public static int backengi_path(int[] arr, int N, boolean[][] dp, int tar, String psf) {
        if (N == 0 || tar == 0) {
            if (tar == 0) {
                System.out.println(psf);
                return 1;
            }
            return 0;
        }

        int count = 0;
        if (tar - arr[N - 1] >= 0 && dp[N - 1][tar - arr[N - 1]])
            count += backengi_path(arr, N - 1, dp, tar - arr[N - 1], psf + arr[N - 1] + " ");
        if (dp[N - 1][tar])
            count += backengi_path(arr, N - 1, dp, tar, psf);

        return count;
    }

}