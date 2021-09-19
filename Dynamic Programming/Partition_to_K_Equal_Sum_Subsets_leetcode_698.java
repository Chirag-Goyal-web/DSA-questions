import java.util.*;
public class Partition_to_K_Equal_Sum_Subsets_leetcode_698{

    public boolean canPartitionKSubsets(int[] nums, int k) {
       
        int n=nums.length;
        boolean[] visited=new boolean[n+1];
        
        int sum=0;
        
        for(int i:nums)
            sum+=i;
        
        if(sum%k!=0){
            return false;
        }
        
        int target=sum/k;
        return helper(nums,0,target,n,visited,k);
    }
    
    public boolean helper(int[] nums,int curSum,int target,int idx,boolean[] visited,int k){
        
        if(k==0){
            return true;
        }
        
        else if(curSum>target){
            return false;
        }
        
        else if(curSum==target){
            //Set curSum=0, idx=length,k=k-1
            return helper(nums,0,target,nums.length,visited,k-1);
        }
        
        else if(idx==0){
            return false;
        }
        
        else{

            if(!visited[idx]){
                visited[idx]=true;
                if(helper(nums,curSum+nums[idx-1],target,idx-1,visited,k))
                    return true;
                visited[idx]=false;
            }
            
            return helper(nums,curSum,target,idx-1,visited,k);
        }
    }

}