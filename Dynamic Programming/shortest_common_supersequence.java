import java.util.*;
public class shortest_common_supersequence{
    
    public static int shortestCommonSupersequence(String X,String Y,int m,int n){
        int[][] dp=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(X,Y,m,n,dp);
    }
    
    public static int helper(String X,String Y,int idx1,int idx2,int[][] dp){
        if(idx1==0||idx2==0){
            return idx1==0?idx2:idx1;
        }
    
        else if(dp[idx1][idx2]!=-1){
            return dp[idx1][idx2];
        }
    
        else{
            if(X.charAt(idx1-1)==Y.charAt(idx2-1)){
                return dp[idx1][idx2]=helper(X,Y,idx1-1,idx2-1,dp)+1; 
            }
            
            else{
                return dp[idx1][idx2]=Math.min(helper(X,Y,idx1-1,idx2,dp),helper(X,Y,idx1,idx2-1,dp))+1;    
            }   
        }
    }

}