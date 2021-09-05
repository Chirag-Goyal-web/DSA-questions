import java.util.*;
public class distinct_subsequences_leetcode_115{

    //Memoization
    class Solution {
        public int numDistinct(String s, String t) {
            
            int len1=s.length();
            int len2=t.length();
            
            if(len1<len2){
                return 0;
            }
            
            else if(len1==len2 && s.equals(t)){
                return 1;
            }
            
            else{
                int[][] dp=new int[len1][len2];
                for(int i=0;i<len1;i++)
                    Arrays.fill(dp[i],-1);
                return helper(s,t,len1,len2,dp);
            }
        }
        
        public int helper(String s,String t,int len1,int len2,int[][] dp){
            
            if(len2>len1){
                return 0;
            }
            
            else if(len2==0){
                return 1;
            }
            
            else if(dp[len1-1][len2-1]!=-1){
                return dp[len1-1][len2-1];   
            }
            
            else{
                 
                if(s.charAt(len1-1)==t.charAt(len2-1)){
                    int ans=helper(s,t,len1-1,len2,dp)+helper(s,t,len1-1,len2-1,dp);
                    dp[len1-1][len2-1]=ans;
                    return ans;
                }
                
                else{
                    int ans=helper(s,t,len1-1,len2,dp);
                    dp[len1-1][len2-1]=ans;
                    return ans;
                }
    
            }
        }
        
    }

    //Tabulation
    class Solution_ {
    
        public int numDistinct(String s, String t) {
            
            int len1=s.length();
            int len2=t.length();
            
            if(len1<len2){
                return 0;
            }
            
            else if(len1==len2 && s.equals(t)){
                return 1;
            }
            
            else{
                int[][] dp=new int[len1+1][len2+1];
                for(int i=0;i<len1;i++)
                    Arrays.fill(dp[i],-1);
                return helper(s,t,len1,len2,dp);
            }
        }
        
        public int helper(String s,String t,int Len1,int Len2,int[][] dp){
            
            for(int len1=0;len1<=Len1;len1++){
            
                for(int len2=0;len2<=Len2;len2++){
                    
                    if(len2>len1){
                        dp[len1][len2]=0;
                        continue;
                    }
    
                    else if(len2==0){
                        dp[len1][len2]=1;
                        continue;
                    }
    
                    else{
    
                        if(s.charAt(len1-1)==t.charAt(len2-1)){
                            int ans=dp[len1-1][len2]+dp[len1-1][len2-1];
                            dp[len1][len2]=ans;
                        }
    
                        else{
                            int ans=dp[len1-1][len2];
                            dp[len1][len2]=ans;
                        }
    
                    }
                
                }
            }
            
            return dp[Len1][Len2];
        }
        
    }

}