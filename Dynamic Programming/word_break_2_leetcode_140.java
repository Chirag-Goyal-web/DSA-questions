import java.util.*;
public class word_break_2_leetcode_140{

    public List<String> wordBreak(String s, List<String> wordDict) {
        
        Set<String> hm=new HashSet<>();
        int maxLen=0;
        
        for(String str:wordDict){
            maxLen=Math.max(maxLen,str.length());
            hm.add(str);
        }
        
        Boolean[] dp=new Boolean[s.length()+1];
        dp[s.length()]=true;
        
        helper(s,dp,hm,maxLen);
        
        if(dp[0]==false){
            return new ArrayList<>();
        }
        
        return backEngg(s,0,dp,hm,maxLen);
    }
    
    public List<String> backEngg(String s,int idx,Boolean[] dp,Set<String> hm,int maxLen){
        
        if(idx==s.length()){
            List<String> ans=new ArrayList<>();
            ans.add("");
            return ans;
        }
        
        else{
            
            List<String> ans=new ArrayList<>();
            
            for(int i=idx+1;i<=s.length() && (i-idx)<=maxLen;i++){
                String subStr=s.substring(idx,i);
                
                if(dp[i]!=null && dp[i]==true && hm.contains(subStr)){
                    List<String> temp=backEngg(s,i,dp,hm,maxLen);
                    
                    for(String str:temp){
                        if(str.equals("")){
                            ans.add(subStr);
                        }
                        
                        else{
                            String ss=subStr+" "+str;
                            ans.add(ss);
                        }
                    }
                }
            }
            
            return ans;
        }
        
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