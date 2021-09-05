public class Longest_Common_Subsequence_leetcode_1143{
    
    //Memoization
    public int helper(String text1,String text2,int len1,int len2,int[][] dp){
        
        if(len1==0 || len2==0){
            return 0;
        }
        
        else if(dp[len1][len2]!=-1){
            return dp[len1][len2];
        }
        
        else{
            
            if(text1.charAt(len1-1)==text2.charAt(len2-1)){
                int ans=1+helper(text1,text2,len1-1,len2-1,dp);
                dp[len1][len2]=ans;
                return ans;
            }
            
            else{
                int temp1=helper(text1,text2,len1-1,len2,dp);
                int temp2=helper(text1,text2,len1,len2-1,dp);
                
                int ans=Math.max(temp1,temp2);
                dp[len1][len2]=ans;
                return ans;
            }       
        }   
    }

    //Tabulation
    public int helper_(String text1,String text2,int Len1,int Len2,int[][] dp){
        
        for(int len1=0;len1<=Len1;len1++){
            for(int len2=0;len2<=Len2;len2++){
        
                if(len1==0 || len2==0){
                    dp[len1][len2]=0;
                    continue;
                }

                else{

                    if(text1.charAt(len1-1)==text2.charAt(len2-1)){
                        int ans=1+dp[len1-1][len2-1];
                        dp[len1][len2]=ans;
                    }

                    else{
                        int temp1=dp[len1-1][len2];
                        int temp2=dp[len1][len2-1];
                        
                        int ans=Math.max(temp1,temp2);
                        
                        dp[len1][len2]=ans;
                    }       
                }  
            
            }
        }
        
        return dp[Len1][Len2];
    }

}