import java.util.*;
public class minimum_score_triangulation_of_polygon_leetcode_1039{

    public int minScoreTriangulation(int[] values) {
        int len=values.length;
        int[][] dp=new int[len][len];
        
        for(int i=0;i<len;i++){
            Arrays.fill(dp[i],-1);
        }

        return helper(0,values.length-1,dp,values);
    }
    
    public int helper(int start,int end,int[][] dp,int[] values){
        
        if(end-start==2){
            return dp[start][end]=values[start]*values[start+1]*values[end];
        }
        
        else if(end-start<2){
            return 0;
        }
        
        else if(dp[start][end]!=-1){
            return dp[start][end];
        }
        
        else{
            
            int ans=(int)1e9;
            
            for(int i=start+1;i<end;i++){
                int val1=helper(start,i,dp,values);
                int val2=helper(i,end,dp,values);
                
                ans=Math.min(ans,val1+val2+values[start]*values[end]*values[i]);
            }
            
            return dp[start][end]=ans;
        }   
    }

}