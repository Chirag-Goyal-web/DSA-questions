public class minimum_cost_for_tickets_leetcode_983{

    public int mincostTickets(int[] days, int[] costs) {
        int len=days.length;
        Integer[] dp=new Integer[len];
        return helper(days,costs,dp,0);
    }
    
    public int helper(int[] days,int[] costs,Integer[] dp,int idx){
        
        if(idx>=days.length){
            return 0;
        }
        
        else if(dp[idx]!=null){
            return dp[idx];
        }
        
        else{    
            int ans=(int)1e9;
            
            int temp1=helper(days,costs,dp,idx+1);
            ans=Math.min(ans,temp1+costs[0]);
            
            int temp2=costs[1];
            
            for(int i=idx+1;i<days.length;i++){
                if(days[i]>=days[idx]+7){
                    temp2+=helper(days,costs,dp,i);
                    break;
                }
            }
            
            ans=Math.min(ans,temp2);
            
            int temp3=costs[2];
            for(int i=idx+1;i<days.length;i++){
                if(days[i]>=days[idx]+30){
                    temp3+=helper(days,costs,dp,i);
                    break;
                }
            }
            
            ans=Math.min(ans,temp3);
            return dp[idx]=ans;
        }
        
    }

}