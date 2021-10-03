import java.util.*;

public class unbounded_knapsack_problem{

    //Tabulation
    class Solution{
    
        static int knapSack(int N, int W, int val[], int wt[]){
            int[] dp=new int[W+1];
            return helper(W,val,wt,dp);
        }
        
        static int helper(int WT,int val[],int[] w,int[] dp){
            
            for(int wt=0;wt<=WT;wt++){
                int ans=0;
                
                for(int i=0;i<w.length;i++){
                    if(wt>=w[i]){
                        ans=Math.max(ans,dp[wt-w[i]]+val[i]);
                    }
                }
                
                dp[wt]=ans;
            }
            
            return dp[WT];
        }
        
    }

    //Memoization
    class Solution_{
    
        static int knapSack(int N, int W, int val[], int wt[])
        {
            int[] dp=new int[W+1];
            Arrays.fill(dp,-1);
            return helper(W,val,wt,dp);
        }
        
        static int helper(int wt,int val[],int[] w,int[] dp){
            
            if(dp[wt]!=-1){
                return dp[wt];
            }
            
            else{
                
                int ans=0;
                
                for(int i=0;i<w.length;i++){
                    if(w[i]<=wt){
                        ans=Math.max(ans,helper(wt-w[i],val,w,dp)+val[i]);
                    }
                }
                
                return dp[wt]=ans;
            }
            
        }
        
    }

}