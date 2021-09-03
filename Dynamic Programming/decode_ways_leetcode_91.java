import java.util.Arrays;
public class decode_ways_leetcode_91{

    //Memoization
    class Solution {
        public int numDecodings(String s) {
            int[] dp=new int[s.length()+1];
            Arrays.fill(dp,-1);
            return helper(s,0,dp,s.length());
        }
        
        public int helper(String s,int idx,int[] dp,int len){
            
            if(idx==len)
                return 1;
            
            else if(dp[idx]!=-1){
                return dp[idx];
            }
            
            else if(s.charAt(idx)=='0'){
                dp[idx]=0;
                return 0;
            }
            
            else{
                
                int sum=0;
                sum+=helper(s,idx+1,dp,len);
                
                if(idx+1<len){
                    int temp=(s.charAt(idx)-'0')*10+(s.charAt(idx+1)-'0');
                    if(temp<=26){
                        sum+=helper(s,idx+2,dp,len);
                    }
                }
                
                dp[idx]=sum;
                return sum;
            }
            
        }
    }

    //Tabulation
    class Solution_{
        public int numDecodings(String s) {
            int[] dp=new int[s.length()+1];
            Arrays.fill(dp,-1);
            return helper(s,0,dp,s.length());
        }
        
        public int helper(String s,int i,int[] dp,int len){
            
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
                    int sum=0;
                    sum+=dp[idx+1];
    
                    if(idx+1<len){
                        int temp=(s.charAt(idx)-'0')*10+(s.charAt(idx+1)-'0');
                        if(temp<=26){
                            sum+=dp[idx+2];
                        }
                    }
    
                    dp[idx]=sum;
                }
            }
            return dp[0];
        }
    }

    //Dp-Optimized
    class Solution__{
        public int numDecodings(String s) {
            return helper(s,0,s.length());
        }
        
        public int helper(String s,int i,int len){
            
            int a=1,b=0;
            
            for(int idx=len-1;idx>=0;idx--){
            
                if(s.charAt(idx)=='0'){
                    b=a;
                    a=0;
                }
    
                else{
                    int sum=0;
                    sum+=a;
    
                    if(idx+1<len){
                        int temp=(s.charAt(idx)-'0')*10+(s.charAt(idx+1)-'0');
                        if(temp<=26){
                            sum+=b;
                        }
                    }
    
                    b=a;
                    a=sum;
                }
            }
            
            return a;
        }
    }

}