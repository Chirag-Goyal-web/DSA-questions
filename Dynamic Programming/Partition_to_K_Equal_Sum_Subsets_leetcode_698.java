import java.util.*;
public class Partition_to_K_Equal_Sum_Subsets_leetcode_698{
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int total=0;
        
        for(int i:nums)
            total+=i;
        
        if(total%k!=0)
            return false;
        
        int[] sum=new int[k];
        return helper(nums,0,sum,total/k);
    }
    
    public boolean helper(int[] nums,int idx,int[] sum,int expected){
        if(idx==nums.length){
            for(int i=0;i<sum.length-1;i++){
                if(sum[i]!=sum[i+1])
                    return false;
            }
            return true;
        }
        else{
            int cur=nums[idx];
            
            for(int i=0;i<sum.length;i++){
                if(cur+sum[i]<=expected){
                    sum[i]+=cur;
                    if(helper(nums,idx+1,sum,expected)==true)
                        return true;
                    sum[i]-=cur;
                }
                if(sum[i]==0)
                    break;
            }
            
            return false;
        }
    }
}