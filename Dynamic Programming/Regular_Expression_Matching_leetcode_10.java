public class Regular_Expression_Matching_leetcode_10{
    
    //Memoization
    class Solution {
        public boolean isMatch(String s, String p) {
            
            int len1=s.length();
            int len2=p.length();
            Boolean[][] dp=new Boolean[len1+1][len2+1];
            
            return helper(s,p,0,0,len1,len2,dp);
        }
        
        public boolean helper(String s,String p,int idx1,int idx2,int len1,int len2,Boolean[][] dp){
            
            if(idx1>=len1 && idx2>=len2){
                dp[idx1][idx2]=true;
                return true;
            }
            
            else if(idx1<len1 && idx2>=len2){
                dp[idx1][idx2]=false;
                return false;
            }
            
            else if(idx1>=len1){
                boolean ans=true;
                
                if((len2-idx2)%2!=0){
                    dp[idx1][idx2]=false;
                    return false;
                }
                
                for(int i=idx2+1;i<len2;i=i+2){
                    if(p.charAt(i)!='*'){
                        ans=false;
                        break;
                    }
                }
                
                dp[idx1][idx2]=ans;
                return ans;
            }
            
            else if(dp[idx1][idx2]!=null){
                return dp[idx1][idx2];
            }
            
            else{
                
                if(idx2<len2-1 && p.charAt(idx2+1)=='*'){
                    
                    boolean ans=helper(s,p,idx1,idx2+2,len1,len2,dp);
    
                    if(s.charAt(idx1)==p.charAt(idx2) || p.charAt(idx2)=='.'){
                        ans=ans||helper(s,p,idx1+1,idx2,len1,len2,dp);
                    }
    
                    dp[idx1][idx2]=ans;
                    return ans;
                }            
                
                else if(p.charAt(idx2)=='.'){
                    boolean ans=helper(s,p,idx1+1,idx2+1,len1,len2,dp);
                    dp[idx1][idx2]=ans;
                    return ans;
                }
                
                else{
                    if(s.charAt(idx1)==p.charAt(idx2)){
                        boolean ans=helper(s,p,idx1+1,idx2+1,len1,len2,dp);
                        dp[idx1][idx2]=ans;
                        return ans;
                    }
                    
                    else{
                        dp[idx1][idx2]=false;
                        return false;
                    }
                }
            }
            
        }
        
    }

    //Tabulation
    class Solution_{
        public boolean isMatch(String s, String p) {
            
            int len1=s.length();
            int len2=p.length();
            Boolean[][] dp=new Boolean[len1+1][len2+1];
            
            return helper(s,p,len1,len2,dp);
        }
        
        public boolean helper(String s,String p,int len1,int len2,Boolean[][] dp){
            
            for(int idx1=len1;idx1>=0;idx1--){
                for(int idx2=len2;idx2>=0;idx2--){
            
                    if(idx1>=len1 && idx2>=len2){
                        dp[idx1][idx2]=true;
                        continue;
                    }
    
                    else if(idx1<len1 && idx2>=len2){
                        dp[idx1][idx2]=false;
                        continue;
                    }
    
                    else if(idx1>=len1){
                        boolean ans=true;
    
                        if((len2-idx2)%2!=0){
                            dp[idx1][idx2]=false;
                            continue;
                        }
    
                        for(int i=idx2+1;i<len2;i=i+2){
                            if(p.charAt(i)!='*'){
                                ans=false;
                                break;
                            }
                        }
    
                        dp[idx1][idx2]=ans;
                        continue;
                    }
    
                    else{
    
                        if(idx2<len2-1 && p.charAt(idx2+1)=='*'){
    
                            boolean ans=dp[idx1][idx2+2];
    
                            if(s.charAt(idx1)==p.charAt(idx2) || p.charAt(idx2)=='.'){
                                ans=ans||dp[idx1+1][idx2];
                            }
    
                            dp[idx1][idx2]=ans;
                        }            
    
                        else if(p.charAt(idx2)=='.'){
                            boolean ans=dp[idx1+1][idx2+1];
                            dp[idx1][idx2]=ans;
                        }
    
                        else{
                            if(s.charAt(idx1)==p.charAt(idx2)){
                                boolean ans=dp[idx1+1][idx2+1];
                                dp[idx1][idx2]=ans;
                            }
    
                            else{
                                dp[idx1][idx2]=false;
                            }
                        }
                    }
                
                }
            }
            
            return dp[0][0];
        }
        
    }

}