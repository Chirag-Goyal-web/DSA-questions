import java.util.*;

public class zero_one_knapsack_problem{

    //Memoization
    class Solution{ 

        public static int knapSack(int w, int wt[], int val[], int n) { 
            int[][] dp=new int[w+1][n+1];
            
            for(int i=0;i<=w;i++){
                Arrays.fill(dp[i],-1);
            }
            
            return helper(w,wt,val,n,dp);
        } 
        
        public static int helper(int w,int wt[],int val[],int n,int[][] dp){
            
            if(w==0 || n==0){
                return dp[w][n]=0;
            }
            
            else if(dp[w][n]!=-1){
                return dp[w][n];
            }
            
            else{
                
                int ans=0;
                
                if(w>=wt[n-1]){
                    ans=helper(w-wt[n-1],wt,val,n-1,dp)+val[n-1];
                }
                
                ans=Math.max(ans,helper(w,wt,val,n-1,dp));
                
                dp[w][n]=ans;
                return ans;
            }
        
        }
    }

    //Tabulation
    class Solution_{ 

        static int knapSack(int w, int wt[], int val[], int n) { 
            
            int[][] dp=new int[w+1][n+1];

            return helper(w,wt,val,n,dp);
        } 
        
        static int helper(int W,int wt[],int val[],int N,int[][] dp){
            
            for(int w=0;w<=W;w++){
                for(int n=0;n<=N;n++){
                
                    if(w==0 || n==0){
                        dp[w][n]=0;
                    }
                    
                    else{
                        
                        int ans=0;
                        
                        if(w>=wt[n-1]){
                            ans=dp[w-wt[n-1]][n-1]+val[n-1];
                        }
                        
                        ans=Math.max(ans,dp[w][n-1]);
                        dp[w][n]=ans;
                    }
                }
            }
            
            return dp[W][N];
        }
    }

}