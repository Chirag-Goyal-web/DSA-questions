import java.util.*;
public class decode_ways_leetcode_639{
    
    //Memoization
    class Solution{
    
        int mod=1000000007;
        
        public int numDecodings(String s) {
            long[] dp=new long[s.length()+1];
            Arrays.fill(dp,-1);
            return (int)helper(s,0,dp,s.length());
        }
        
        public long helper(String s,int idx,long[] dp,int len){
            
            if(idx==len)
                return 1;
            
            else if(dp[idx]!=-1)
                return dp[idx];
            
            else if(s.charAt(idx)=='0'){
                dp[idx]=0;
                return 0;
            }
            
            else{
                
                long sum=0;
                
                if(s.charAt(idx)=='*'){
                    sum+=9*helper(s,idx+1,dp,len);
                }
                else{
                    sum+=helper(s,idx+1,dp,len);
                }
                
                sum=sum%mod;
                
                if(idx+1<len){
                    
                    if(s.charAt(idx)=='*' && s.charAt(idx+1)=='*'){
                        sum+=15*helper(s,idx+2,dp,len);
                    }
                    
                    else if(s.charAt(idx)=='*' && s.charAt(idx+1)!='*'){
                        sum+=helper(s,idx+2,dp,len);
                        if((s.charAt(idx+1)-'0')<=6){
                           sum+=helper(s,idx+2,dp,len); 
                        }
                    }
                    
                    else if(s.charAt(idx)!='*' && s.charAt(idx+1)!='*'){
                        int temp=((s.charAt(idx)-'0')*10+s.charAt(idx+1)-'0');
                        if(temp<=26){
                            sum+=helper(s,idx+2,dp,len); 
                        }
                    }
                    
                    else{
                        if(s.charAt(idx)=='1'){
                            sum+=9*helper(s,idx+2,dp,len); 
                        }
                        else if(s.charAt(idx)=='2'){
                            sum+=6*helper(s,idx+2,dp,len); 
                        }
                    }
                    
                    sum=sum%mod;
                }
                
                dp[idx]=sum;
                return sum;
            }
        }
    }

    //Tabulation
    class Solution_{
    
        int mod=1000000007;
        
        public int numDecodings(String s) {
            long[] dp=new long[s.length()+1];
            Arrays.fill(dp,-1);
            return (int)helper(s,0,dp,s.length());
        }
        
        public long helper(String s,int i,long[] dp,int len){
            
            for(int idx=len;idx>=0;idx--){
            
                if(idx==len){
                    dp[idx]=1;
                    continue;
                }
    
                else if(s.charAt(idx)=='0'){
                    dp[idx]=0;
                    continue;
                }
            
                else{
    
                    long sum=0;
    
                    if(s.charAt(idx)=='*'){
                        sum+=9*dp[idx+1];
                    }
                    else{
                        sum+=dp[idx+1];
                    }
    
                    sum=sum%mod;
    
                    if(idx+1<len){
    
                        if(s.charAt(idx)=='*' && s.charAt(idx+1)=='*'){
                            sum+=15*dp[idx+2];
                        }
    
                        else if(s.charAt(idx)=='*' && s.charAt(idx+1)!='*'){
                            sum+=dp[idx+2];
                            if((s.charAt(idx+1)-'0')<=6){
                               sum+=dp[idx+2];
                            }
                        }
    
                        else if(s.charAt(idx)!='*' && s.charAt(idx+1)!='*'){
                            int temp=((s.charAt(idx)-'0')*10+s.charAt(idx+1)-'0');
                            if(temp<=26){
                                sum+=dp[idx+2];
                            }
                        }
    
                        else{
                            if(s.charAt(idx)=='1'){
                                sum+=9*dp[idx+2];
                            }
                            else if(s.charAt(idx)=='2'){
                                sum+=6*dp[idx+2];
                            }
                        }
    
                        sum=sum%mod;
                    }
    
                    dp[idx]=sum;
                   
                }
    
            }
            return dp[0];
        }
    }

    //Dp-optimized
    class Solution__ {
    
        int mod=1000000007;
        
        public int numDecodings(String s) {
            return (int)helper(s,0,s.length());
        }
        
        public long helper(String s,int i,int len){
            
            long a=1,b=0;
            
            for(int idx=len-1;idx>=0;idx--){
            
                if(s.charAt(idx)=='0'){
                    b=a;
                    a=0;
                    continue;
                }
            
                else{
    
                    long sum=0;
    
                    if(s.charAt(idx)=='*'){
                        sum+=9*a;
                    }
                    else{
                        sum+=a;
                    }
    
                    sum=sum%mod;
    
                    if(idx+1<len){
    
                        if(s.charAt(idx)=='*' && s.charAt(idx+1)=='*'){
                            sum+=15*b;
                        }
    
                        else if(s.charAt(idx)=='*' && s.charAt(idx+1)!='*'){
                            sum+=b;
                            if((s.charAt(idx+1)-'0')<=6){
                               sum+=b;
                            }
                        }
    
                        else if(s.charAt(idx)!='*' && s.charAt(idx+1)!='*'){
                            int temp=((s.charAt(idx)-'0')*10+s.charAt(idx+1)-'0');
                            if(temp<=26){
                                sum+=b;
                            }
                        }
    
                        else{
                            if(s.charAt(idx)=='1'){
                                sum+=9*b;
                            }
                            else if(s.charAt(idx)=='2'){
                                sum+=6*b;
                            }
                        }
    
                        sum=sum%mod;
                    }
    
                    b=a;
                    a=sum;
                }
    
            }
            return a;
        }
    }

}