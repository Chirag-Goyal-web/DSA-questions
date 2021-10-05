import java.util.*;
public class score_of_parentheses_leetcode_856{
    public int scoreOfParentheses(String s) {
        
        Stack<Integer> stk=new Stack<>();
        char[] arr=s.toCharArray();
        
        for(char c:arr){
            if(c=='('){
                stk.add(-1);
            }
            else{
                if(stk.peek()==-1){
                    stk.pop();
                    int temp=1;
                    while(stk.size()!=0 && stk.peek()!=-1){
                        temp+=stk.pop();
                    }
                    stk.push(temp);
                }
                
                else{
                    int val=stk.pop();
                    stk.pop();
                    int temp=val*2;
                    while(stk.size()!=0 && stk.peek()!=-1){
                        temp+=stk.pop();
                    }
                    stk.push(temp);
                }
            }
            
        }
        
        return stk.peek();
    }
}