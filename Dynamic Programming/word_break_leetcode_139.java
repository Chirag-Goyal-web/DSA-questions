import java.util.*;
public class word_break_leetcode_139{

    //Memoization
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            
            Set<String> hm=new HashSet<>();
            int maxLen=0;
            
            for(String str:wordDict){
                maxLen=Math.max(maxLen,str.length());
                hm.add(str);
            }
            
            Boolean[] dp=new Boolean[s.length()+1];
            dp[s.length()]=true;
            
            return helper(s,dp,hm,maxLen);
        }
        
        public boolean helper(String s,Boolean[] dp,Set<String> hm,int maxLen){
            
            for(int idx=s.length();idx>=0;idx--){
            
                if(idx>=s.length()){
                    dp[idx]=true;
                    continue;
                }
    
                else{
    
                    Boolean ans=false;
    
                    for(int i=idx+1;i<=s.length() && (idx-i)<=maxLen;i++){
                        if(hm.contains(s.substring(idx,i))){
                            ans=ans||dp[i];
    
                            if(ans){
                                break;
                            }
                        }
                    }
    
                    dp[idx]=ans;
                }
            }
            
            return dp[0];
        }
    }

    //Tabulation
    class Solution_{
        public boolean wordBreak(String s, List<String> wordDict) {
            
            Set<String> hm=new HashSet<>();
            int maxLen=0;
            
            for(String str:wordDict){
                maxLen=Math.max(maxLen,str.length());
                hm.add(str);
            }
            
            Boolean[] arr=new Boolean[s.length()+1];
            arr[s.length()]=true;
            
            return helper(s,arr,hm,maxLen);
        }
        
        public boolean helper(String s,Boolean[] dp,Set<String> hm,int maxLen){
            
            for(int idx=s.length();idx>=0;idx--){
            
                if(idx>=s.length()){
                    dp[idx]=true;
                    continue;
                }
    
                else{
    
                    Boolean ans=false;
    
                    for(int i=idx+1;i<=s.length() && (idx-i)<=maxLen;i++){
                        if(hm.contains(s.substring(idx,i))){
                            ans=ans||dp[i];
    
                            if(ans){
                                break;
                            }
                        }
                    }
    
                    dp[idx]=ans;
                }
            }
            
            return dp[0];
        }
    }

}