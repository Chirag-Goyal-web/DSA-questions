import java.util.*;
public class Parsing_A_Boolean_Expression_leetcode_1106{
    public boolean parseBoolExpr(String str) {
        
        Stack<Character> stk=new Stack<>();
        int len=str.length();
        
        for(int i=len-1;i>=0;i--){
            if(str.charAt(i)!=',' && str.charAt(i)!='('){
                if(str.charAt(i)=='!'){
                    char temp=stk.pop();
                    stk.pop();
                    temp=temp=='t'?'f':'t';
                    stk.push(temp);
                }
                
                else if(str.charAt(i)=='&'){
                    boolean flag=false;
                    while(stk.size()>0 && stk.peek()!=')'){
                        if(stk.peek()=='f'){
                            flag=true;
                        }
                        stk.pop();
                    }
                    stk.pop();
                    if(flag==true){
                        stk.push('f');
                    }
                    else{
                        stk.push('t');
                    }
                }
                
                else if(str.charAt(i)=='|'){
                    boolean flag=false;
                    while(stk.size()>0 && stk.peek()!=')'){
                        if(stk.peek()=='t'){
                            flag=true;
                        }
                        stk.pop();
                    }
                    stk.pop();
                    if(flag==true){
                        stk.push('t');
                    }
                    else{
                        stk.push('f');
                    }
                }
                
                else{
                    stk.push(str.charAt(i));
                }
            }
        }
        
        return stk.peek()=='t'?true:false;
    }
}