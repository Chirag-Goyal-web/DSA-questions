import java.util.*;
public class simplify_path_leetcode_71{
    public String simplifyPath(String path) {
        StringBuilder str=new StringBuilder("");
        
        for(char c:path.toCharArray()){
            if(c=='/'){
                if(str.length()==0 || str.charAt(str.length()-1)!='/'){
                    str.append(c);
                }
            }
            else {
                str.append(c);
            }
        }
        
        str=new StringBuilder(str.substring(1));
        String[] arr=str.toString().split("/");
        Stack<String> stk=new Stack<>();
        
        for(String s:arr){
            if(s.equals("..")){
                if(stk.size()>0){
                    stk.pop();
                }
            }    
            else if(!s.equals(".")){
                stk.push(s);
            }
        }
        
        StringBuilder ans=new StringBuilder();
        Stack<String> temp=new Stack<>();
        
        while(stk.size()>0){
            temp.push(stk.pop());
        }
        
        while(temp.size()>0){
            ans.append("/"+temp.pop());
        }
        
        return ans.toString().equals("")?"/":ans.toString();
    }
}