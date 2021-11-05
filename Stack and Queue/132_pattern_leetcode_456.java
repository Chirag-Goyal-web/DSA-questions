import java.util.*;
public class 132_pattern_leetcode_456{
    public boolean find132pattern(int[] nums) {
        Stack<Integer> stk=new Stack<>();
        int len=nums.length;
        int[] min=new int[len];
        
        int m=Integer.MAX_VALUE;
        for(int i=0;i<len;i++){
            m=Math.min(m,nums[i]);
            min[i]=m;
        }
        
        for(int i=len-1;i>=0;i--){
            while(stk.size()>0 && min[i]>=stk.peek()){
                stk.pop();
            }
            if(stk.size()>0){
                if(min[i]<stk.peek() && stk.peek()<nums[i]){
                    return true;
                }    
            }
            
            stk.push(nums[i]);
        }
        
        return false;
    }
}