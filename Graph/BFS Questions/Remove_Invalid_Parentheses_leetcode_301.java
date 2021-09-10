import java.util.*;

public class Remove_Invalid_Parentheses_leetcode_301{
    
    public List<String> removeInvalidParentheses(String s) {
        
        List<String> ans=new ArrayList<>();
        
        Set<String> visited=new HashSet<>();
        Queue<String> que=new LinkedList<>();
        
        que.add(s);
        visited.add(s);
        
        boolean found=false;
        
        while(que.size()>0){
            int size=que.size();
            
            while(size-->0){
                String temp=que.remove();
                
                if(isValid(temp)){
                    ans.add(temp);
                    found=true;
                }
                
                if(found==false){
                    int len=temp.length();
                    
                    for(int i=0;i<len;i++){
                        if(temp.charAt(i)=='(' || temp.charAt(i)==')'){
                            String ele=temp.substring(0,i)+temp.substring(i+1);
                            
                            if(!visited.contains(ele)){
                                que.add(ele);
                                visited.add(ele);
                            }
                        }
                    }
                    
                }
                
            }
            
            if(found){
                break;
            }
        }
        
        if(ans.size()==0){
            ans.add("");
            return ans;
        }
        
        return ans;
    }
    
    public boolean isValid(String str){
        int len=str.length();
        int balance=0;
        
        for(int i=0;i<len;i++){
            if(str.charAt(i)=='('){
                balance++;    
            }
            
            else if(str.charAt(i)==')'){
                balance--;
            }
            
            if(balance<0){
                return false;
            }
        }
        
        return balance==0;
    }
    

}