import java.util.*;
public class scramble_string_leetcode_87{
        
    public boolean isScramble(String s1, String s2) {
        if(s1.equals(s2)){
            return  true;
        }
        
        int len=s1.length();
        Boolean[][][] dp=new Boolean[len][len][len];
        return helper(0,len-1,0,s1,s2,dp);
    }
    
    public boolean helper(int start,int end,int idx,String s1,String s2,Boolean[][][] dp){

        if(start==end){
            if(s1.charAt(start)==s2.charAt(idx)){
                return true;
            }
            else{
                return false;
            }
        }
        
        else if(dp[start][end][idx]!=null){
            return dp[start][end][idx];
        }

        else{
            boolean ans=false;
            int len=(end-start+1);
            for(int cut=start;cut<end;cut++){
                ans=ans||(helper(start,cut,idx,s1,s2,dp) && helper(cut+1,end,idx+(cut-start)+1,s1,s2,dp));
                ans=ans||(helper(start,cut,(idx+len)-(cut-start+1),s1,s2,dp) && helper(cut+1,end,idx,s1,s2,dp));

                if(ans==true){
                    break;
                }
            }

            return dp[start][end][idx]=ans;
        }
        
    }
    

}