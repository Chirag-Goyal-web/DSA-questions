public class house_robber_2_leetcode_213{
    
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        else{
            return Math.max(helper(nums,0,nums.length-1),helper(nums,1,nums.length));   
        }
    }
    
    public int helper(int[] nums,int start,int end) {
        int inc=nums[start];
        int exc=0;

        int tempi;
        int tempx;
        
        for(int i=start+1;i<end;i++){
            tempi=inc;
            tempx=exc;
            
            inc=nums[i]+exc;
            exc=Math.max(tempi,tempx);
        }
        
        return Math.max(inc,exc);
    }
    
}