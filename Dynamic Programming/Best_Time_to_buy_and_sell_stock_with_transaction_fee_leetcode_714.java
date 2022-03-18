public class Best_Time_to_buy_and_sell_stock_with_transaction_fee_leetcode_714{
    public int maxProfit(int[] prices, int fee) {
        int buy=-(int)1e9;
        int sell=0;
        
        for(int i:prices){
            int tempBuy=Math.max(sell-i-fee,buy);
            int tempSell=Math.max(sell,buy+i);
            buy=tempBuy;
            sell=tempSell;
        }
        
        return sell;
    }
}