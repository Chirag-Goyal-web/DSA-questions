import java.util.*;
public class decode_string_leetcode_394{
    public String decodeString(String s) {
        Stack<Integer> stk=new Stack<>();
        int len=s.length();
        StringBuilder str=new StringBuilder("");

        for(int i=len-1;i>=0;){
            if(s.charAt(i)=='['){
                String temp=str.substring(stk.pop());
                i--;
                
                int t=i;
                while(t>=0){
                    if(s.charAt(t)>='0' && s.charAt(t)<='9'){
                        t--;
                    }   
                    else{
                        break;
                    }
                }
                
                int count=Integer.parseInt(s.substring(t+1,i+1));
                
                i=t;
                for(int k=0;k<count-1;k++){
                    str.append(temp);
                }
            }
            
            else if(s.charAt(i)==']'){
                stk.push(str.length());
                i--;
            }   
            
            else{
                str.append(s.charAt(i)+"");
                i--;
            }
            
        }

        return str.reverse().toString();
    }
}