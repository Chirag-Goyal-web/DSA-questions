public class strange_printer_leetcode_664{

    public int strangePrinter(String s) {

        StringBuilder str=new StringBuilder("");
        
        char prev='$';
        for(char c:s.toCharArray()){
            if(c!=prev){
                str.append(c);
                prev=c;
            }
        }
        
        int len=str.length();
        Integer[][] dp=new Integer[len][len];
        return helper(0,len-1,str.toString(),dp);
    }
    
    public int helper(int start,int end,String str,Integer[][] dp){
        
        if(start>end){
            return 0;
        }
        
        else if(dp[start][end]!=null){
            return dp[start][end];
        }
        
        else{
            int i;
            
            for(i=start;i<end;i++){
                if(str.charAt(i)!=str.charAt(i+1)){
                    break;
                }
            }
            
            int ans=helper(i+1,end,str,dp)+1;
            
            for(int m=i+1;m<=end;m++){
                if(str.charAt(m)==str.charAt(i)){
                    ans=Math.min(ans,helper(m,end,str,dp)+helper(i+1,m-1,str,dp));
                }
            }
            
            return dp[start][end]=ans;
        }
        
    }
}