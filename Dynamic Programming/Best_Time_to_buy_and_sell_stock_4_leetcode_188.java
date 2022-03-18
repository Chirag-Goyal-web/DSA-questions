public class Best_Time_to_buy_and_sell_stock_4_leetcode_188{
    public int maxProfit(int k, int[] prices) {
        Integer[][][] dp=new Integer[prices.length][k][2];
        int ans=helper(prices,prices.length-1,k-1,1,dp);
        return ans;
    }
    
    public int helper(int[] prices,int i,int k,int flag,Integer[][][] dp){
        if(i<0 || k<0){
            if(flag==0)
                return -(int)1e9;
            else
                return 0;
        }

        else if(dp[i][k][flag]!=null)
            return dp[i][k][flag];
        
        else{
            int ans=0;
            
            if(flag==0)
                ans=Math.max(helper(prices,i-1,k,flag,dp),helper(prices,i-1,k-1,1,dp)-prices[i]);
            else
                ans=Math.max(helper(prices,i-1,k,flag,dp),helper(prices,i-1,k,0,dp)+prices[i]);
            
            return dp[i][k][flag]=ans;
        }
    }
}