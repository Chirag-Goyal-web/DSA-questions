public class edit_distance_leetcode_72{

    //Memoization
    public int helper(String word1,String word2,int len1,int len2,int[][] dp){
        
        if(len1==0 || len2==0){
            return len1==0?len2:len1;
        }
        
        else if(dp[len1][len2]!=-1){
            return dp[len1][len2];
        }
        
        else{
            
            int insert=helper(word1,word2,len1,len2-1,dp);
            int replace=helper(word1,word2,len1-1,len2-1,dp);
            int delete=helper(word1,word2,len1-1,len2,dp);
            
            if(word1.charAt(len1-1)!=word2.charAt(len2-1)){
                int temp=Math.min(insert,Math.min(replace,delete))+1;
                dp[len1][len2]=temp;
                return temp;
            }
            
            else{
                //Because replace is same call
                dp[len1][len2]=replace;
                return replace;
            }
            
        }
        
    }

    //Tabulation
    public int helper_(String word1,String word2,int Len1,int Len2,int[][] dp){
        
        for(int len1=0;len1<=Len1;len1++){
        
            for(int len2=0;len2<=Len2;len2++){
            
                if(len1==0 || len2==0){
                    int temp= len1==0?len2:len1;
                    dp[len1][len2]=temp;
                }

                else{

                    int insert=dp[len1][len2-1];
                    int replace=dp[len1-1][len2-1];
                    int delete=dp[len1-1][len2];

                    if(word1.charAt(len1-1)!=word2.charAt(len2-1)){
                        int temp=Math.min(insert,Math.min(replace,delete))+1;
                        dp[len1][len2]=temp;
                    }

                    else{
                        //Replcae is same call
                        dp[len1][len2]=replace;
                    }
                }
            }   
        }
        
        return dp[Len1][Len2];
    }

}