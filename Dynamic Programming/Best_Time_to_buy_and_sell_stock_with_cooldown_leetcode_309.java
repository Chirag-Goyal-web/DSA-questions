public class Best_Time_to_buy_and_sell_stock_with_cooldown_leetcode_309{
    public int maxProfit(int[] prices) {
        int t_0_y=-(int)1e9,t_1_y=0;
        int t_0=-(int)1e9,t_1=0;
        
        for(int j=0;j<prices.length;j++){
            int i=prices[j];
            int temp_0=Math.max(t_0,t_1_y-i);
            int temp_1=Math.max(t_1,t_0+i);
            t_0_y=t_0;
            t_1_y=t_1;
            t_0=temp_0;
            t_1=temp_1;
        }
        
        return t_1;
    }
}