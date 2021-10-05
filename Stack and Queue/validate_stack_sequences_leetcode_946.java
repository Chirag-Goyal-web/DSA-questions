import java.util.*;
public class validate_stack_sequences_leetcode_946{
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int ptr=0;
        Stack<Integer> stk=new Stack<>();
        
        for(int i:pushed){
            stk.add(i);
            
            while(stk.size()>0 && stk.peek()==popped[ptr]){
                stk.pop();
                ptr++;
            }
        }
        
        return stk.size()==0;
    }
}