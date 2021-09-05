public class wildcard_matching_leetcode_44{
    
    //Memoization
    class Solution {
        public boolean isMatch(String s, String p) {
            
            int len1=s.length();
            int len2=p.length();
            
            Boolean[][] dp=new Boolean[len1+1][len2+1];
    
            return helper(s,p,len1,len2,dp);
        }
        
        public boolean helper(String s,String p,int len1,int len2,Boolean[][] dp){
            
            if(len1==0 && len2==0){
                return true;
            }
            
            else if(len1!=0 && len2==0){
                return false;
            }
            
            else if(len1==0 && p.charAt(len2-1)!='*'){
                return false;
            }
            
            else if(dp[len1][len2]!=null){
                return dp[len1][len2];
            }
            
            else{
                
                if(p.charAt(len2-1)=='*'){
                    Boolean b;
                    
                    if(len1==0){
                         b=helper(s,p,len1,len2-1,dp);
                    }
                    else{
                         b=helper(s,p,len1,len2-1,dp)||helper(s,p,len1-1,len2,dp);    
                    }
                    
                    dp[len1][len2]=b;
                    return b;
                }
                
                else if(p.charAt(len2-1)=='?'){
                    Boolean b=helper(s,p,len1-1,len2-1,dp);
                    dp[len1][len2]=b;
                    return b;
                }
                
                else{
                    
                    if(p.charAt(len2-1)!=s.charAt(len1-1)){
                        dp[len1][len2]=false;
                        return false;
                    }
                    
                    else{
                        Boolean b=helper(s,p,len1-1,len2-1,dp);
                        dp[len1][len2]=b;
                        return b;
                    }
                }
            }
            
        }
        
    }

    //Tabulation
    class Solution_ {
        public boolean isMatch(String s, String p) {
            
            int len1=s.length();
            int len2=p.length();
            
            Boolean[][] dp=new Boolean[len1+1][len2+1];
    
            return helper(s,p,len1,len2,dp);
        }
        
        public boolean helper(String s,String p,int Len1,int Len2,Boolean[][] dp){
            
            for(int len1=0;len1<=Len1;len1++){
                for(int len2=0;len2<=Len2;len2++){
            
                    if(len1==0 && len2==0){
                        dp[len1][len2]=true;
                        continue;
                    }
    
                    else if(len1!=0 && len2==0){
                        dp[len1][len2]=false;
                        continue;
                    }
    
                    else if(len1==0 && p.charAt(len2-1)!='*'){
                        dp[len1][len2]=false;
                        continue;
                    }
    
                    else{
                        if(p.charAt(len2-1)=='*'){
                            Boolean b;
    
                            if(len1==0){
                                 b=dp[len1][len2-1];
                            }
                            
                            else{
                                 b=dp[len1][len2-1]||dp[len1-1][len2];;    
                            }
    
                            dp[len1][len2]=b;
                        }
    
                        else if(p.charAt(len2-1)=='?'){
                            Boolean b=dp[len1-1][len2-1];
                            dp[len1][len2]=b;
                        }
    
                        else{
    
                            if(p.charAt(len2-1)!=s.charAt(len1-1)){
                                dp[len1][len2]=false;
                            }
    
                            else{
                                Boolean b=dp[len1-1][len2-1];
                                dp[len1][len2]=b;
                            }
                        }
                    }
                }        
            }
            
            return dp[Len1][Len2];
        }
        
    }

}