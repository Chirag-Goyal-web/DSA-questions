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

}