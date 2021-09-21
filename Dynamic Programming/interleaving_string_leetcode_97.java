public class interleaving_string_leetcode_97{

    public boolean isInterleave(String s1, String s2, String s3) {
        int len1=s1.length();
        int len2=s2.length();
        
        Boolean[][] dp=new Boolean[len1+1][len2+1];
        
        return helper(s3.length(),len1,len2,s1,s2,s3,dp);   
    }
    
    public Boolean helper(int idx,int i1,int i2,String s1,String s2,String s3,Boolean[][] dp){
        
        if(i1==0 && i2==0 && idx==0){
            return dp[i1][i2]=true;
        }
        
        else if(dp[i1][i2]!=null){
            return dp[i1][i2];
        }
        
        else{
            
            boolean ans=false;
            
            if(i1>0 && idx>0 && s1.charAt(i1-1)==s3.charAt(idx-1))
                ans=ans||helper(idx-1,i1-1,i2,s1,s2,s3,dp);
                    
            if(i2>0 && idx>0 && ans==false && s2.charAt(i2-1)==s3.charAt(idx-1))
                ans=ans||helper(idx-1,i1,i2-1,s1,s2,s3,dp);
            
            return dp[i1][i2]=ans;
        }
        
    }

}