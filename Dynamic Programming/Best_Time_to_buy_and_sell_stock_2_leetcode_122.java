public class Best_Time_to_buy_and_sell_stock_2_leetcode_122{
    //Generic method
    public int maxProfit(int[] prices) {
        int buy=-(int)1e9;
        int sell=0;
        
        for(int i:prices){
            int tempBuy=Math.max(buy,sell-i);
            int tempSell=Math.max(sell,buy+i);
            buy=tempBuy;
            sell=tempSell;
        }
        
        return sell;
    }

    //Another simple method
    public int maxProfit_(int[] prices) {
        int prev=(int)1e9;
        int ans=0;
        
        for(int i:prices){
            if(i>prev){
                ans+=i-prev;
            }
            prev=i;
        }
        
        return ans;
    }
}