import java.util.*;
public class split_array_largest_sum_leetcode_410{

    //Dp solution
    class Solution {
    
        public int splitArray(int[] nums, int m) {
            int len=nums.length;
            int[] prefix=new int[len];
            prefix[0]=nums[0];
            
            for(int i=1;i<len;i++){
                prefix[i]=prefix[i-1]+nums[i];
            }
            
            int[][] dp=new int[len+1][m+1];
            for(int i=0;i<=len;i++){
                Arrays.fill(dp[i],-1);
            }
            
            return helper(prefix,nums,0,m,dp);
        }
        
        public int helper(int[] prefix,int[] nums,int idx,int m,int[][] dp){
    
            if(dp[idx][m]!=-1){
                return dp[idx][m];
            }
    
            else if(m==1){
                if(idx==0){
                    return dp[idx][m]=prefix[nums.length-1];
                }
                else{
                    return dp[idx][m]=prefix[nums.length-1]-prefix[idx-1];
                }
            }
    
            else{
    
                int ans=(int)1e9;
    
                for(int i=0;i<=nums.length-idx-m;i++){
                    int temp;
                    
                    if(idx>0){
                        temp=prefix[idx+i]-prefix[idx-1];
                    }
    
                    else{
                        temp=prefix[idx+i];
                    }
    
                    ans=Math.min(ans,Math.max(temp,helper(prefix,nums,idx+i+1,m-1,dp)));
                }
    
                return dp[idx][m]=ans;
            }
        }
        
        
    }

    

}