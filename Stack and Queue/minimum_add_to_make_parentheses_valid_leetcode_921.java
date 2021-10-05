import java.util.*;
public class minimum_add_to_make_parentheses_valid_leetcode_921{
    
    public int minAddToMakeValid(String s) {  
        char[] arr=s.toCharArray();
        Stack<Character> stk=new Stack<>();
        int moves=0;
        
        for(char c:arr){
            if(c=='('){
                stk.add(c);
            }
            else{
                if(stk.size()==0){
                    moves++;
                }
                else{
                    stk.pop();
                }
            }
        }
        
        return moves+stk.size();
    }
}