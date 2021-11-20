public class maximum_subarray_leetcode_53{
    
    //Divide and conquer
    class Solution {
        public int maxSubArray(int[] nums) {
            return helper(nums,0,nums.length-1);
        }
        
        public int helper(int[] nums,int l,int h){
            
            if(l>h){
                return -(int)1e9;
            }
            else{
                int mid=(l+h)/2;
                int left=helper(nums,l,mid-1);
                int right=helper(nums,mid+1,h);
                
                int temp1=0;
                int max1=0;
                for(int i=mid-1;i>=l;i--){
                    temp1+=nums[i];
                    max1=Math.max(max1,temp1);
                }
                
                int temp2=0;
                int max2=0;
                for(int i=mid+1;i<=h;i++){
                    temp2+=nums[i];
                    max2=Math.max(max2,temp2);
                }
                
                return Math.max(left,Math.max(right,max1+max2+nums[mid]));
            }
        
        }
        
    }

    //Kadane
    class Solution_ {
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

}