import java.util.*;
public class Palindrome_Partitioning_3{

    public int palindromePartition(String s, int k) {  
        int[][] charChange=minChange(s);
        int[][] dp=new int[s.length()+1][k+1];
        
        for(int i=0;i<=s.length();i++){
            Arrays.fill(dp[i],-1);
        }
        
        return helper(s,0,s.length(),k,charChange,dp); 
    }
    
    public int helper(String s,int idx,int len,int k,int[][] charChange,int[][] dp){
        
        if((len-idx)<k){
            return dp[idx][k]=(int)1e9;
        }
        
        else if((len-idx)==k){
            return dp[idx][k]=0;
        }
        
        else if(dp[idx][k]!=-1){
            return dp[idx][k];
        }
        
        else if(k==1){
            return dp[idx][k]=charChange[idx][len-1];
        }
        
        else if(k==0){
            return dp[idx][k]=(int)1e9;
        }
        
        else{
            
            int ans=Integer.MAX_VALUE;
            
            for(int i=idx;i<len;i++){
                ans=Math.min(ans,charChange[idx][i]+helper(s,i+1,len,k-1,charChange,dp));
            }
            
            dp[idx][k]=ans;
            return ans;
        }
    }
    
    public int[][] minChange(String s){
        
        int len=s.length();
        
        int[][] dp=new int[len][len];
        
        for(int i=len-1;i>=0;i--){
            for(int j=i;j<len;j++){
                if(i==j){
                    dp[i][j]=0;
                }
                
                else if(s.charAt(i)!=s.charAt(j)){
                    dp[i][j]=dp[i+1][j-1]+1;
                }
                
                else{
                    dp[i][j]=dp[i+1][j-1];
                }
            }
        }
        
        return dp;
    }

}