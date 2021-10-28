import java.util.*;
public class Minimum_Insertions_to_Balance_a_Parentheses_String_leetcode_1541.java{
    public int minInsertions(String s) {
        
        int stack=0;
        int ans=0;
        int len=s.length();
        
        for(int i=0;i<len;i++){
            if(s.charAt(i)=='('){
                stack++;
            }
            
            else{
                if(i+1>=len || s.charAt(i+1)=='('){
                    ans++;
                }
                if(stack==0){
                    ans++;
                }
                else{
                    stack--;
                }
                
                if(i+1<len && s.charAt(i+1)==')'){
                    i++;
                }
            }
        }
        
        return ans+stack*2;
    }
}