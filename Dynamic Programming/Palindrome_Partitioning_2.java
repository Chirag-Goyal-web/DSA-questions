import java.util.*;
public class Palindrome_Partitioning_2{

    public int minCut(String s) {
        int len=s.length();
        int[][] dp=new int[len][len];
        
        for(int i=0;i<len;i++){
            Arrays.fill(dp[i],-1);
        }
        
        boolean[][] bool=longestPalindrome(s);
        return helper(dp,0,s.length()-1,s,bool);
        
    }
    
    public boolean[][] longestPalindrome(String s){
        
        int len=s.length();
        int start=0,end=0;
        int maxLen=1;
        
        boolean[][] dp=new boolean[len][len];
        
        for(int i=len-1;i>=0;i--){
            for(int j=i;j<len;j++){
                if(i==j){
                    dp[i][j]=true;
                }
                
                else if(s.charAt(i)!=s.charAt(j)){
                    dp[i][j]=false;
                }
                
                else{
                    if(j-i==1){
                        dp[i][j]=true;
                    }
                    else{
                        dp[i][j]=dp[i+1][j-1];
                    }
                    
                    if(dp[i][j]==true && j-i+1>maxLen){
                        maxLen=j-i+1;
                        start=i;
                        end=j;
                    }
                }
            }
        }
        
        return dp;
    }
    
    //No need of 2-d dp, 1 d do will also work
    public int helper(int[][] dp,int start,int end,String s,boolean[][] bool){
        
        if(start==end){
            dp[start][end]=0;
            return 0;
        }
        
        else if(dp[start][end]!=-1){
            return dp[start][end];
        }
        
        else{
            
            boolean flag=false;
            
            for(int i=start,j=end;i<j;i++,j--){
                if(s.charAt(i)!=s.charAt(j)){
                    flag=true;
                    break;
                }
            }
            
            if(flag==false){
                dp[start][end]=0;
                return 0;
            }
            
            else{
                
                int ans=Integer.MAX_VALUE;
                
                for(int cut=start;cut<end;cut++){
                    if(bool[start][cut]==true){
                        int t1=helper(dp,start,cut,s,bool);
                        int t2=helper(dp,cut+1,end,s,bool);
                        ans=Math.min(ans,t1+t2+1);   
                    }
                }
                
                dp[start][end]=ans;
                return ans;
            }
        }
        
    }

}