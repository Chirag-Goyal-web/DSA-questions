import java.util.*;
public class stock_span_problem{
    public static int[] calculateSpan(int price[], int n){
        
        int[] ans=new int[n];
        Stack<Integer> stk=new Stack<>();
        
        for(int i=0;i<n;i++){
            
            while(stk.size()>0 && price[stk.peek()]<=price[i]){
                stk.pop();
            }
            
            if(stk.size()!=0){
                ans[i]=i-stk.peek();
            }
            else{
                ans[i]=i+1;
            }
            
            stk.add(i);
        }
        
        return ans;
    }
}   