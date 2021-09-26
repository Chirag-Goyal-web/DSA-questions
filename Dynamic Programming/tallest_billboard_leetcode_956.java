import java.util.*;
public class tallest_billboard_leetcode_956{

    public int tallestBillboard(int[] rods) {
        
        int sum=0;
        for(int i:rods){
            sum+=i;
        }
        
        int[][] dp=new int[2*sum+1][rods.length+1];
        
        for(int i=0;i<=2*sum;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(rods,rods.length,0,sum,dp);
    }
    
    public int helper(int[] rods,int idx,int sum,int totalSum,int[][] dp){
        
        if(idx==0){
            if(sum==0){
                return 0;
            }
            else{
                return -(int)1e9;
            }
        }
        
        else if(dp[sum+totalSum][idx]!=-1){
            return dp[sum+totalSum][idx];
        }
        
        else{
            
            int ans1=helper(rods,idx-1,sum+rods[idx-1],totalSum,dp)+rods[idx-1];
            int ans2=helper(rods,idx-1,sum,totalSum,dp);
            int ans3=helper(rods,idx-1,sum-rods[idx-1],totalSum,dp);
            
            int ans=Math.max(ans1,Math.max(ans2,ans3));
            return dp[sum+totalSum][idx]=ans;
        }
        
    }

}