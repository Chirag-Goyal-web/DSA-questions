public class Best_Time_to_buy_and_sell_stock_3_leetcode_123{
    public int maxProfit(int[] prices) {
        int buyOneTrans=-(int)1e9;
        int buyTwoTrans=-(int)1e9;
        int sellOneTrans=0;
        int sellTwoTrans=0;
        
        for(int i:prices){
            int tempBuyOneTrans=Math.max(buyOneTrans,-i);
            int tempBuyTwoTrans=Math.max(buyTwoTrans,sellOneTrans-i);
            int tempSellOneTrans=Math.max(sellOneTrans,buyOneTrans+i);
            int tempSellTwoTrans=Math.max(sellTwoTrans,buyTwoTrans+i);
            buyOneTrans=tempBuyOneTrans;
            buyTwoTrans=tempBuyTwoTrans;
            sellOneTrans=tempSellOneTrans;
            sellTwoTrans=tempSellTwoTrans;
        }
        
        return sellTwoTrans;
    }
}