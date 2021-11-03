import java.util.*;
public class maximum_width_ramp_leetcode_962{
    public int maxWidthRamp(int[] nums) {
        Stack<Integer> stk=new Stack<>();
        int len=nums.length;
        
        for(int i=0;i<len;i++){
            if(stk.size()==0 || nums[stk.peek()]>nums[i]){
                stk.push(i);
            }    
        }
        
        int ans=0;
        
        for(int i=len-1;i>=0;i--){
            while(stk.size()>0 && stk.peek()>=i){
                stk.pop();
            }
            while(stk.size()>0 && nums[stk.peek()]<=nums[i]){
                ans=Math.max(ans,i-stk.pop());
            }
        }
        
        return ans;
    }
}