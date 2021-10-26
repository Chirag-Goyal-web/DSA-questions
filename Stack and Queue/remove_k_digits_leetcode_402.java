import java.util.*;
public class remove_k_digits_leetcode_402{
    public String removeKdigits(String num, int k) {
        Stack<Character> stk=new Stack<>();
        int len=num.length();
        
        for(int i=0;i<len;i++){
            char temp=num.charAt(i);
            
            while(stk.size()>0 && k>0){
                if(stk.peek()-'0'>temp-'0'){
                    stk.pop();
                    k--;
                }
                else{
                    break;
                }
            }
        
            stk.push(temp);         
        }
        
        while(k>0 && stk.size()>0){
            stk.pop();
            k--;
        }
        
        StringBuilder ans=new StringBuilder("");
        
        while(stk.size()>0){
            ans.append(stk.pop());
        }
        
        ans.reverse();
        
        int ptr=0;
        
        for(ptr=0;ptr<ans.length();ptr++){
            if(ans.charAt(ptr)!='0'){
                break;
            }
        }
        
        return ans.substring(ptr).equals("")?"0":ans.substring(ptr);
    }
}