import java.util.*;
public class online{

    static int count=-1;
    Stack<int[]> stk;
    
    public StockSpanner() {
        stk=new Stack<>();
        count=-1;
    }
    
    public int next(int price) {
        count++;
        int ans;
        while(stk.size()>0 && stk.peek()[1]<=price){
            stk.pop();
        }
            
        if(stk.size()>0){
            ans= count-stk.peek()[0];
        }
        else{
            ans=count+1;
        }
        
        stk.add(new int[]{count,price});
        return ans;
    }

}