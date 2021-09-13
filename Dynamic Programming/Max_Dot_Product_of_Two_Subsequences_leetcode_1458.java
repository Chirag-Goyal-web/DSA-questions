import java.util.*;
public class Max_Dot_Product_of_Two_Subsequences_leetcode_1458{

    public int maxDotProduct(int[] nums1, int[] nums2) {
        
        int[][] dp=new int[nums1.length+1][nums2.length+1];
        
        for(int i=0;i<=nums1.length;i++){
            Arrays.fill(dp[i],-(int)1e9);
        }
        
        return helper(nums1,nums2,nums1.length,nums2.length,dp);
    }
    
    public int helper(int[] nums1,int[] nums2,int len1,int len2,int[][] dp){
        
         if(len1==0 || len2==0){
            return dp[len1][len2]=-(int)1e8;
        }
        
        else if(dp[len1][len2]!=-(int)1e9){
            return dp[len1][len2];
        }
        
        else{
            int val=nums1[len1-1]*nums2[len2-1];
            
            int temp1=helper(nums1,nums2,len1-1,len2,dp);
            int temp2=helper(nums1,nums2,len1,len2-1,dp);
            int temp3=val+helper(nums1,nums2,len1-1,len2-1,dp);
            
            return dp[len1][len2]=getMax(val,temp1,temp2,temp3);
        }
    }
    
    public int getMax(int... arr){
        
        int maxVal=arr[0];
        
        for(int i:arr){
            maxVal=Math.max(maxVal,i);
        }
        
        return maxVal;
    }
    

}