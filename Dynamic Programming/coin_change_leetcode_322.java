import java.util.*;
public class coin_change_leetcode_322{

    //Memoization
    class Solution {
    
        public int coinChange(int[] coins, int amount) {
            
            int[] dp=new int[amount+1];
            Arrays.fill(dp,Integer.MAX_VALUE);
            int ans=helper(coins,amount,dp);
            
            return ans==(int)1e9?-1:ans;
        }
        
        public int helper(int[] coins,int amount,int[] dp){
            
            if(amount==0){
                return dp[amount]=0;
            }
            
            else if(dp[amount]!=Integer.MAX_VALUE){
                return dp[amount];
            }
            
            else{
                int ans=(int)1e9;
                
                for(int i=0;i<coins.length;i++){
                    if(amount>=coins[i]){
                        int temp=helper(coins,amount-coins[i],dp);
                        ans=Math.min(ans,temp+1);
                    }
                }
                
                dp[amount]=ans;
                return ans;
            }
        }
        
    }

    //Tabulation
    class Solution_{
    
        public int coinChange(int[] coins, int amount) {
            
            int len=coins.length;
            int[] dp=new int[amount+1];
            Arrays.fill(dp,(int)1e9);
            
            dp[0]=0;
            
            for(int i=1;i<=amount;i++){
                for(int j=0;j<len;j++){
                    if(i>=coins[j]){
                        dp[i]=Math.min(dp[i-coins[j]]+1,dp[i]);
                    }
                }
            }
               
            return dp[amount]==(int)1e9?-1:dp[amount];
        }
        
    }

}