public class Integer_break_leetcode_343{
    
    public int integerBreak(int n) {
        if(n==2){
		    return 1;
		}
        else if(n==3){
            return 2;
        }
		else{
		    int[] dp=new int[n+1];
		    return helper(n,dp);
		}
    }
    
    public int helper(int n,int[] dp){
	    
	    if(dp[n]!=0){
	        return dp[n];
	    }
	    
	    else{
	        int ans=1;
	        
	        for(int i=1;i<=n;i++){
	            ans=Math.max(ans,i*helper(n-i,dp));
	        }
	        
	        return dp[n]=ans;
	    }

	}   
}