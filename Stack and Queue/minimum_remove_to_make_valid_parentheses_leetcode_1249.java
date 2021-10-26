import java.util.*;
public class minimum_remove_to_make_valid_parentheses_leetcode_1249{
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stk=new Stack<>();
        StringBuilder str=new StringBuilder(s);
        
        for(int i=0;i<s.length();i++){
            
            if(s.charAt(i)=='('){
                stk.push(i);
            }
            else if(s.charAt(i)==')'){
                if(stk.size()>0){
                    stk.pop();
                }
                else{
                    str.setCharAt(i,'#');
                }
            }
            
        }
        
        while(stk.size()>0){
            str.setCharAt(stk.pop(),'#');
        }
        
        StringBuilder ans=new StringBuilder("");
        
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)!='#'){
                ans.append(str.charAt(i));
            }
        }
        
        return ans.toString();
    }
}