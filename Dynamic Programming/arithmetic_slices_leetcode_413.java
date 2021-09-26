public class arithmetic_slices_leetcode_413{
    
    //1st approach
    public int numberOfArithmeticSlices(int[] nums) {
        
        int len=nums.length;
        int[] dp=new int[len];
        int ans=0;
        
        for(int i=2;i<len;i++){
            if(nums[i]-nums[i-1]==nums[i-1]-nums[i-2]){
                dp[i]=dp[i-1]+1;
                ans+=dp[i];
            }
        }
        
        return ans;
    }

    //2nd approach
    public int numberOfArithmeticSlices_(int[] nums) {
        
        int len=nums.length;
        int ans=0;
        int cur=0;
        
        for(int i=2;i<len;i++){
            if(nums[i]-nums[i-1]==nums[i-1]-nums[i-2]){
                cur++;
                ans+=cur;
            }
            else{
                cur=0;    
            }
        }
        
        return ans;
    }

}