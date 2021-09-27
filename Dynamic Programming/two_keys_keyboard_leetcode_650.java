import java.util.*;
public class two_keys_keyboard_leetcode_650{

    //Memoization
    class Solution_{
    
        public int minSteps(int n) {
            int[][] dp=new int[n+1][n+1];
            
            for(int i=0;i<dp.length;i++){
                Arrays.fill(dp[i],-1);
            }
            
            return helper(1,n,0,dp);
        }
        
        public int helper(int cur,int n,int clip,int[][] dp){
            
            if(cur==n){
                return 0;
            }
            
            else if(cur>n){
                return (int)1e9;
            }
            
            else if(dp[cur][clip]!=-1){
                return dp[cur][clip];
            }
            
            else{
                int ans=(int)1e9;
                
                if(cur>clip){
                    int copy=helper(cur,n,cur,dp)+1;
                    ans=Math.min(ans,copy);   
                }
                
                if(clip>0){
                    int paste=helper(cur+clip,n,clip,dp)+1;
                    ans=Math.min(paste,ans);
                }
                
                return dp[cur][clip]=ans;
            }   
        }
    
    }

    //Optimization
    class Solution {
        public int minSteps(int n) {
            int ans = 0, d = 2;
            while (n > 1) {
                while (n % d == 0) {
                    ans += d;
                    n /= d;
                }
                d++;
            }
            return ans;
        }
    }

}