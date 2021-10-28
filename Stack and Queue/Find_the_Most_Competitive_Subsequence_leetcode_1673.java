public class Find_the_Most_Competitive_Subsequence_leetcode_1673.java{
    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> stk=new Stack<>();
        int len=nums.length;
        
        for(int i=0;i<len;i++){
            int temp=k-(len-i)<0?0:k-(len-i);
            
            while(stk.size()>temp && stk.peek()>nums[i]){
                stk.pop();
            }
            stk.push(nums[i]);
        }
        
        int[] ans=new int[k];
        while(stk.size()>k){
            stk.pop();
        }
        
        while(stk.size()>0){
            ans[--k]=stk.pop();
        }
        
        return ans;
    }
}