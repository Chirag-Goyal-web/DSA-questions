public class Minimum_ASCII_Delete_Sum_for_Two_Strings_leetcode_712{

    public int minimumDeleteSum(String s1, String s2) {
        int len1=s1.length();
        int len2=s2.length();
        Integer[][] dp=new Integer[len1+1][len2+1];
        
        return helper(s1,s2,len1,len2,dp);
    }
    
    public int helper(String s1,String s2,int idx1,int idx2,Integer[][] dp){
        
        if(dp[idx1][idx2]!=null){
            return dp[idx1][idx2];
        }
        
        else if(idx1==0||idx2==0){
            int ans=0;
            
            for(int i=idx1;i>0;i--){
                ans+=(int)s1.charAt(i-1);
            }
            
            for(int i=idx2;i>0;i--){
                ans+=(int)s2.charAt(i-1);
            }
            
            return dp[idx1][idx2]=ans;
        }
        
        else{
            
            if(s1.charAt(idx1-1)==s2.charAt(idx2-1)){
                return dp[idx1][idx2]=helper(s1,s2,idx1-1,idx2-1,dp);
            }
            
            else{
                int temp1=(int)(s1.charAt(idx1-1))+helper(s1,s2,idx1-1,idx2,dp);   
                int temp2=(int)(s2.charAt(idx2-1))+helper(s1,s2,idx1,idx2-1,dp);
                
                return dp[idx1][idx2]=Math.min(temp1,temp2);
            }
            
        }
        
    }

}