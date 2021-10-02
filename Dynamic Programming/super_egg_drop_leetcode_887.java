import java.util.*;
public class super_egg_drop_leetcode_887{

    class Solution {
        public int superEggDrop(int k, int n){
            
            int[][] dp=new int[n+1][k+1];
            
            for(int i=0;i<=n;i++){
                Arrays.fill(dp[i],-1);
            }
            
            return helper(n,k,dp);
        }
        
        public int helper(int n,int k,int[][] dp){
            
            if(n==0){
                return 0;
            }
            
            else if(k==0){
                return (int)1e9;
            }
            
            else if(n==1){
                return 1;
            }
            
            else if(k==1){
                return n;
            }
            
            else if(dp[n][k]!=-1){
                return dp[n][k];
            }
            
            else{
                int ans=(int)1e9;
                for(int i=1;i<=n;i++){
                    ans=Math.min(ans,Math.max(helper(i-1,k-1,dp),helper(n-i,k,dp)));
                }
                
                return dp[n][k]=(ans+1);
            }   
        }   
    }

    class Solution_ {
    
        public int superEggDrop(int k, int n){
            
            int[][] dp=new int[n+1][k+1];
            
            for(int i=0;i<=n;i++){
                Arrays.fill(dp[i],-1);
            }
            
            return helper(n,k,dp);
        }
        
        public int helper(int n,int k,int[][] dp){
            
            if(n==0)
                return 0;
            
            else if(k==0)
                return (int)1e9;
            
            else if(n==1)
                return 1;
            
            else if(k==1)
                return n;
            
            else if(dp[n][k]!=-1)
                return dp[n][k];
            
            else{
                
                int ans=(int)1e9;
                int low=1,high=n;
                
                while(low+1<high){
                    int mid=(low+high)/2;
                    int eggBreak=helper(mid-1,k-1,dp);
                    int notEggBreak=helper(n-mid,k,dp);
                    
                    if(eggBreak>notEggBreak){
                        high=mid;
                    }
                    else if(eggBreak<notEggBreak){
                        low=mid;
                    }
                    else{
                        high=mid;
                        low=mid;
                    }
                }
                
                return dp[n][k]=Math.min(Math.max(helper(low-1,k-1,dp),helper(n-low,k,dp)),Math.max(helper(high-1,k-1,dp),helper(n-high,k,dp)))+1;
            }
            
        }
        
    }

}