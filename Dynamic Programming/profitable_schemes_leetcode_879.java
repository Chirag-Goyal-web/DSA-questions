public class profitable_schemes_leetcode_879{
    
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int len=group.length;
        Integer[][][] dp=new Integer[len+1][minProfit+1][n+1];
        return helper(group,profit,len,minProfit,0,n,dp);
    }
    
    public int helper(int[] group,int[] profit,int idx,int minProfit,int curProfit,int n,Integer[][][] dp){
        
        if(idx==0){
            if(curProfit>=minProfit){
                return 1;
            }
            else{
                return 0;
            }
        }
        
        else if(dp[idx][curProfit][n]!=null){
            return dp[idx][curProfit][n];
        }
        
        else{
            
            long temp1=helper(group,profit,idx-1,minProfit,curProfit,n,dp);
            long temp2=0;
            
            if(n-group[idx-1]>=0){
                if(curProfit+profit[idx-1]>=minProfit){
                    temp2=helper(group,profit,idx-1,minProfit,minProfit,n-group[idx-1],dp);
                }
                else{
                    temp2=helper(group,profit,idx-1,minProfit,curProfit+profit[idx-1],n-group[idx-1],dp);
                }
            }
            
            return dp[idx][curProfit][n]=(int)((temp1+temp2)%1000000007);
        }
        
    }
    
}