import java.util.*;
public class matrix_chain_multiplication{

    //Memoization
    class Solution{
    
        static int matrixMultiplication(int N, int arr[]){
            int[][] dp=new int[N][N];
            for(int i=0;i<N;i++){
                Arrays.fill(dp[i],-1);
            }
            return helper(0,N-1,arr,dp);
        }
        
        static int helper(int start,int end,int[] arr,int[][] dp){
            
            if(Math.abs(start-end)==1){
                return dp[start][end]=0;
            }
            
            else if(dp[start][end]!=-1){
                return dp[start][end];
            }
            
            else{
                
                int ans=Integer.MAX_VALUE;
                
                for(int i=start+1;i<=end-1;i++){
                    int temp1=helper(start,i,arr,dp);
                    int temp2=helper(i,end,arr,dp);
                    ans=Math.min(ans,temp1+temp2+arr[start]*arr[i]*arr[end]);
                }
                
                dp[start][end]=ans;
                return ans;
            }
        }
    }

    //Tabulation
    class Solution_{
    
        static int matrixMultiplication(int N, int arr[]){
            
            int[][] dp=new int[N][N];
            
            for(int i=0;i<N;i++){
                Arrays.fill(dp[i],-1);
            }
            
            return helper(arr,dp,N-1);
        }
        
        static int helper(int[] arr,int[][] dp,int N){
            
            for(int start=N;start>=0;start--){
                for(int end=start;end<=N;end++){
                    
                    if(Math.abs(start-end)==1){
                        dp[start][end]=0;
                    }
    
                    else{
                        
                        int ans=Integer.MAX_VALUE;
                        
                        for(int i=start+1;i<=end-1;i++){
                            int temp1=dp[start][i];
                            int temp2=dp[i][end];
                            ans=Math.min(ans,temp1+temp2+arr[start]*arr[i]*arr[end]);
                        }
                        
                        dp[start][end]=ans;
                    }
                    
                }
            }
            
            return dp[0][N];
        }
    }

}