import java.util.*;
public class minimum_cost_tree_from_leaf_values_leetcode_130{
    public int mctFromLeafValues(int[] arr) {
        int len=arr.length;
        Integer[][] dp=new Integer[len][len];
        
        int[][] maxArr=helper(arr);
        
        func(0,len-1,arr,maxArr,dp);
        return dp[0][len-1];
    }

    public int func(int l,int r,int[] arr,int[][] ans,Integer[][] dp){
        
        if(l>=r){
            return 0;
        }
        
        else if(dp[l][r]!=null){
            return dp[l][r];
        }
        
        else{
            int min=Integer.MAX_VALUE;
            
            for(int i=l;i<r;i++){
                min=Math.min(ans[l][i]*ans[i+1][r]+func(l,i,arr,ans,dp)+func(i+1,r,arr,ans,dp),min);
            }
            
            return dp[l][r]=min;
        }
        
    }
    
    public int[][] helper(int[] arr){
        int len=arr.length;
        int[][] ans=new int[len][len];
        
        for(int i=len-1;i>=0;i--){
            for(int j=i;j<len;j++){
                if(i==j){
                    ans[i][j]=arr[i];
                }
                else{
                    int temp1=ans[i+1][j];
                    int temp2=ans[i][j-1];
                    ans[i][j]=Math.max(temp1,temp2);   
                }
            }
        }
        
        return ans;
    }
}