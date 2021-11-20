public class maximum_sum_circular_subarray_leetcode_918{
    
    public int maxSubarraySumCircular(int[] nums) {    
        int len=nums.length;
        int ans1=maxSubArray(nums);
        int[] left=new int[len];
        int[] right=new int[len];
        
        int temp1=0;
        int max1=nums[0];
        
        for(int i=0;i<len;i++){
            temp1+=nums[i];
            max1=Math.max(max1,temp1);
            left[i]=max1;
        }
        
        int temp2=0;
        int max2=nums[len-1];
        
        for(int i=len-1;i>=0;i--){
            temp2+=nums[i];
            max2=Math.max(max2,temp2);
            right[i]=max2;
        }
        
        int ans2=-(int)1e9;
        
        for(int i=0;i<len-1;i++){
            ans2=Math.max(left[i]+right[i+1],ans2);
        }
        
        return Math.max(ans1,ans2);
    }
    
    public int maxSubArray(int[] nums) {
        int max=nums[0];
        int temp=0;
        
        for(int i:nums){
            temp+=i;
            max=Math.max(max,temp);
            temp=temp<0?0:temp;
        }
        
        return max;
    }
}