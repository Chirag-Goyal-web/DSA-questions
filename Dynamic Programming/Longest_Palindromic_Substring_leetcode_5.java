public class Longest_Palindromic_Substring_leetcode_5{

    public String longestPalindrome(String s) {
        
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
        
        return s.substring(start,end+1);
    }

}