import java.util.*;
public class Number_of_Visible_People_in_a_Queue_leetcode_1944{
    public int[] canSeePersonsCount(int[] arr) {
        int len=arr.length;
        int[] ans=new int[len];
        Stack<Integer> stk=new Stack<>();
        
        for(int i=len-1;i>=0;i--){
            int count=0;
            while(stk.size()>0 && stk.peek()<arr[i]){
                count++;
                stk.pop();
            }
            
            if(stk.size()>0){
                count++;
            }
            
            ans[i]=count;
            stk.push(arr[i]);
        }
        
        return ans;
    }
}