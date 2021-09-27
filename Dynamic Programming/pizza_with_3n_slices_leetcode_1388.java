import java.util.*;
public class pizza_with_3n_slices_leetcode_1388{

    public int maxSizeSlices(int[] slices) {
        
        int len=slices.length;
        int[][] dp1=new int[len][len/3+1];
        int[][] dp2=new int[len][len/3+1];
        
        for(int i=0;i<len;i++){
            Arrays.fill(dp1[i],-1);
            Arrays.fill(dp2[i],-1);
        }
        
        return Math.max(helper(0,len-2,slices,len/3,dp1),helper(1,len-1,slices,len/3,dp2));
    }
    
    public int helper(int start,int end,int[] slices,int count,int[][] dp){
        
        if(start>end||count==0){
            return 0;
        }
        
        else if(dp[start][count]!=-1){
            return dp[start][count];
        }
        
        else{
            int temp1=helper(start+2,end,slices,count-1,dp)+slices[start];
            int temp2=helper(start+1,end,slices,count,dp);
            
            return dp[start][count]=Math.max(temp1,temp2);
        }
        
    }
    

}