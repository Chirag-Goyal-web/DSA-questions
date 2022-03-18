public class Best_Time_to_buy_and_sell_stock_leetcode_121{

    //One generic method
    public int maxProfit(int[] prices) {
        int buy=-(int)1e9;
        int sell=0;
        
        for(int i:prices){
            int tempBuy=Math.max(buy,-i);
            int tempSell=Math.max(sell,buy+i);
            buy=tempBuy;
            sell=tempSell;
        }
        
        return sell;
    }

    //Another simple method
    public int maxProfit_(int[] prices) {
        int buy=(int)1e9;
        int ans=0;
        
        for(int i:prices){
            ans=Math.max(ans,i-buy);
            if(i<buy)
                buy=i;
        }
        
        return ans;
    }

}   