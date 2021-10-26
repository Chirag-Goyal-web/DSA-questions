public class design_a_stack_with_increment_operation_leetcode_1381{
    int mSize=0;
    int[] inc;
    Stack<Integer> stk;
    
    public CustomStack(int maxSize) {
        mSize=maxSize;
        stk=new Stack<>();
        inc=new int[mSize];
    }
    
    public void push(int x) {
        if(stk.size()<mSize){
            stk.push(x);
        }
    }
    
    public int pop() {
        if(stk.size()>0){
            int val=stk.peek();
            val+=inc[stk.size()-1];
            if(stk.size()>1){
                inc[stk.size()-2]+=inc[stk.size()-1];
            }
            inc[stk.size()-1]=0;
            stk.pop();
            return val;
        }
        else{
            return -1;
        }
    }
    
    public void increment(int k, int val) {
        if(k>=stk.size()){
            if(stk.size()>0)
                inc[stk.size()-1]+=val;
        }
        else{
            inc[k-1]+=val;
        }
    }
}