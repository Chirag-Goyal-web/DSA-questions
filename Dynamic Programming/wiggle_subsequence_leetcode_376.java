public class wiggle_subsequence_leetcode_376{

    public int wiggleMaxLength(int[] nums) {
        int len=nums.length;
        int[][] dp=new int[2][len];
        int ans=0;
        
        for(int i=0;i<len;i++){
            int pos=0,neg=0;
            
            for(int j=i-1;j>=0;j--){
                if(nums[i]>nums[j]){
                    pos=Math.max(pos,dp[1][j]);
                }
                else if(nums[i]<nums[j]){
                    neg=Math.max(neg,dp[0][j]);
                }
            }
            
            dp[0][i]=pos+1;
            dp[1][i]=neg+1;
            ans=Math.max(ans,Math.max(pos,neg)+1);
        }
        
        return ans;
    }

    //O(n) approach
    public int wiggleMaxLength_(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        int[] up = new int[nums.length];
        int[] down = new int[nums.length];
        up[0] = down[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up[i] = down[i - 1] + 1;
                down[i] = down[i - 1];
            } else if (nums[i] < nums[i - 1]) {
                down[i] = up[i - 1] + 1;
                up[i] = up[i - 1];
            } else {
                down[i] = down[i - 1];
                up[i] = up[i - 1];
            }
        }
        return Math.max(down[nums.length - 1], up[nums.length - 1]);
    }

    //O(n) approach (greedy approach)
    public int wiggleMaxLength__(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        int prevdiff = nums[1] - nums[0];
        int count = prevdiff != 0 ? 2 : 1;
        for (int i = 2; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];
            
            //if the previous diff was -ve and current is positive, then direction is changed, so increment one
            //Otherwise if previous difference was positive and current is -ve, so increment one
            if ((diff > 0 && prevdiff <= 0) || (diff < 0 && prevdiff >= 0)) {
                count++;
                prevdiff = diff;
            }
        }
        return count;
    }

}