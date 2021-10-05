import java.util.*;
public class next_greater_element_2_leetcode_503{

    public int[] nextGreaterElements(int[] nums) {
        
        int len=nums.length;
        int[] ans=new int[len];
        int temp=0;
        
        Stack<Integer> stk=new Stack<>();
        for(int i=len-2;i>=0;i--){
            stk.add(nums[i]);
        }
        
        for(int i=len-1;i>=0;i--){
            temp=nums[i];
            
            if(stk.size()>0 && stk.peek()>temp){
                ans[i]=stk.peek();
            }
            else{
                
                while(stk.size()>0 && stk.peek()<=temp){
                    stk.pop();
                }
                
                if(stk.size()==0){
                    ans[i]=-1;
                }
                else{
                    ans[i]=stk.peek();
                }
            }
            
            stk.add(temp);
        }
        
        return ans;
    }

}