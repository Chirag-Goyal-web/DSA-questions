import java.util.*;

public class daily_temperatures_leetcode_739{

    public int[] dailyTemperatures(int[] arr) {
        Stack<Integer> stk=new Stack<>();
        int[] ans=new int[arr.length];
        int idx=arr.length-1;
        
        for(int i=arr.length-1;i>=0;i--){
            while(stk.size()>0 && arr[stk.peek()]<=arr[i]){
                stk.pop();
            }
            
            if(stk.size()!=0){
                ans[idx]=stk.peek()-i;
            }
            
            idx--;
            stk.add(i);
        }
        
        return ans;
    }
}