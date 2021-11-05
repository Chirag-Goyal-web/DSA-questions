import java.util.*;
public class valid_parenthesis_string_leetcode_636{

    public boolean checkValidString(String s) {
        Boolean[][] dp=new Boolean[s.length()+1][s.length()+1];
        return helper(s,0,0,dp);
    }
    
    public boolean helper(String s,int idx,int count,Boolean[][] dp){
        
        if(idx==s.length()){
            if(count==0){
                return true;
            }
            else{
                return false;
            }
        }
        
        else if(dp[idx][count]!=null){
            return dp[idx][count];
        }
        
        else{
            if(s.charAt(idx)=='('){
                return dp[idx][count]=helper(s,idx+1,count+1,dp);
            }
            else if(s.charAt(idx)==')'){
                if(count==0){
                    return dp[idx][count]=false;
                }
                else{
                    return dp[idx][count]=helper(s,idx+1,count-1,dp);
                }
            }
            else{
                boolean temp1=false,temp2=false,temp3=false;
                temp1=helper(s,idx+1,count+1,dp);
                
                if(count>0){
                    temp2=helper(s,idx+1,count-1,dp);
                }
                
                temp3=helper(s,idx+1,count,dp);
                return dp[idx][count]=(temp1||temp2||temp3);
            }
        }
        
    }
    

    //2nd approach using stack
    public boolean checkValidString_(String s) {
        Stack<Integer> opening=new Stack<>();
        Stack<Integer> star=new Stack<>();
        int len=s.length();
        
        for(int i=0;i<len;i++){
            if(s.charAt(i)=='('){
                opening.push(i);
            }
            else if(s.charAt(i)=='*'){
                star.push(i);
            }
            else{
                if(opening.size()>0){
                    opening.pop();
                }
                else if(star.size()>0){
                    star.pop();
                }
                else{
                    return false;   
                }
            }
        }
        
        while(opening.size()>0){
            if(star.size()==0){
                return false;
            }
            else if(opening.peek() < star.peek())
            {
                opening.pop();
                star.pop();
            }
            else   
                return false;
        }
        
        return true;
    }
}