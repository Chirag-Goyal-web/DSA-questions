public class longest_valid_parentheses_leetcode_32{

    public int longestValidParentheses(String s) {
        Stack<Integer> stk=new Stack<>();
        int len=s.length();
        int max=0;
        stk.add(-1);
        
        for(int i=0;i<len;i++){
            if(s.charAt(i)=='('){
                stk.push(i);       
            }
            
            else{
                if(stk.size()>1){
                    if(s.charAt(stk.peek())=='('){
                        stk.pop();
                        max=Math.max(max,i-stk.peek());
                    }
                    else{
                        stk.push(i);
                    }    
                }
                else{
                    stk.push(i);
                }
            }
            
        }
        
        return max;
    }

}