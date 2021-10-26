import java.util.*;
public class min_stack_leetcode_155{
    class MinStack {

        Stack<Integer> allData;
        Stack<Integer> minData;
        
        public MinStack() {
            allData=new Stack<>();
            minData=new Stack<>();
        }
        
        public void push(int val) {
            allData.push(val);
            if(minData.size()==0 || val<=minData.peek()){
                minData.push(val);
            }
        }
        
        public void pop() {
            int t1=minData.peek();
            int t2=allData.peek();
            if(t1==t2){
                minData.pop();
                allData.pop();
            }
            else{
                allData.pop();
            }
        }
        
        public int top() {
            return allData.peek();
        }
        
        public int getMin() {
            return minData.peek();
        }
    }

    class MinStack_ {

        Stack<Long> stk;
        long min;
        
        public MinStack() {
            stk=new Stack<>();
            min=Integer.MAX_VALUE;
        }
        
        public void push(int val) {
            long temp=(long)val;
            if(temp<=min){
                stk.push(temp+(temp-min));
                min=temp;
            }
            else{
                stk.push(temp);
            }
        }
        
        public void pop() {
            long temp=stk.pop();
            
            if(temp<=min){
                min=2*min-temp;
            }
        }
        
        public int top() {
            if(stk.peek()<=min){
                return (int)min;
            }
            else{
                long l=stk.peek();
                return (int)l;
            }
        }
        
        public int getMin() {
            return (int)min;
        }
    }

}