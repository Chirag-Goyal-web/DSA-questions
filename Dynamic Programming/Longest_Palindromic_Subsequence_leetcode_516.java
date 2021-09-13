public class Longest_Palindromic_Subsequence_leetcode_516{
    //Memoization
    public int helper(String s,int[][]dp,int start,int end){
        
        if(start>end){
            return 0;
        }
        
        else if(start==end){
            return 1;
        }
        
        else if(dp[start][end]!=-1){
            return dp[start][end];
        }
        
        else{
            
            if(s.charAt(start)==s.charAt(end)){
                int ans=2+helper(s,dp,start+1,end-1);
                dp[start][end]=ans;
                return ans;
            }
            
            else{
                int temp1=helper(s,dp,start+1,end);
                int temp2=helper(s,dp,start,end-1);
                int ans=Math.max(temp1,temp2);
                dp[start][end]=ans;
                return ans;
            }
            
        }
        
    }

    //Tabulation
    public int helper(String s,int[][]dp,int len){
        
        for(int start=len;start>=0;start--){
            for(int end=0;end<=len;end++){

                if(start>end){
                    dp[start][end]=0;
                    continue;
                }
        
                else if(start==end){
                    dp[start][end]=1;
                }

                else{

                    if(s.charAt(start)==s.charAt(end)){
                        int ans=2+dp[start+1][end-1];
                        dp[start][end]=ans;
                    }

                    else{
                        int temp1=dp[start+1][end];
                        int temp2=dp[start][end-1];
                        int ans=Math.max(temp1,temp2);
                        dp[start][end]=ans;
                    }

                }
                
            }
        }
        
        return dp[0][len];
    }

    public static String lpss_backEng(String str, int si, int ei, int[][] dp) {
        if (si >= ei) {
            return si == ei ? str.charAt(si) + "" : "";
        }

        if (str.charAt(si) == str.charAt(ei)) {
            return str.charAt(si) + lpss_backEng(str, si + 1, ei - 1, dp) + str.charAt(ei);
        } 
        
        else if (dp[si + 1][ei] > dp[si][ei - 1]) {
            return lpss_backEng(str, si + 1, ei, dp);
        } 
        
        else {
            return lpss_backEng(str, si, ei - 1, dp);
        }
    }

}