import java.util.*;
public class delete_operation_for_two_strings_leetcode_583{

    public int minDistance(String word1, String word2) {
        int[][] dp=new int[word1.length()+1][word2.length()+1];
        
        for(int i=0;i<=word1.length();i++){
            Arrays.fill(dp[i],-1);
        }
        
        return helper(word1,word2,word1.length(),word2.length(),dp);
    }
    
    public int helper(String word1,String word2,int len1,int len2,int[][] dp){
        
        if(len1==0 || len2==0){
            return len1==0?len2:len1;
        }
        
        else if(dp[len1][len2]!=-1){
            return dp[len1][len2];
        }
        
        else{
            
            if(word1.charAt(len1-1)==word2.charAt(len2-1)){
                int ans=helper(word1,word2,len1-1,len2-1,dp);
                dp[len1][len2]=ans;
                return ans;
            }
            
            else{
                int t1=helper(word1,word2,len1-1,len2,dp);
                int t2=helper(word1,word2,len1,len2-1,dp);
                int ans= Math.min(t1,t2)+1;
                
                dp[len1][len2]=ans;
                return ans;
            }
            
        }
        
    }

}