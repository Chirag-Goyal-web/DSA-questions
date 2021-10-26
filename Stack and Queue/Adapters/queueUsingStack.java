import java.util.*;
public class queueUsingStack{

    Stack<Integer> stk1=new Stack<>();
    Stack<Integer> stk2=new Stack<>();

    public void push(int x) {
        stk1.push(x);
    }
    
    public int pop() {
        if(stk2.size()==0){
            swap(stk1,stk2);
        }

        return stk2.pop();
    }
    
    public int peek() {
        if(stk2.size()==0){
            swap(stk1,stk2);
        }

        return stk2.peek();
    }
    
    public void swap(Stack<Integer> s1,Stack<Integer> s2){
        while(s1.size()>0){
            s2.push(s1.pop());
        }
    }

    public boolean empty() {
        return stk1.size()==0 && stk2.size()==0;
    }

    public static void main(String[] args) {
        
       
    }
}