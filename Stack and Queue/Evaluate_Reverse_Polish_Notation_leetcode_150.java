public class Evaluate_Reverse_Polish_Notation_leetcode_150.java{
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk=new Stack<>();
        
        for(String s:tokens){
            if(s.equals("+")||s.equals("-")||s.equals("/")||s.equals("*")){
                int temp2=stk.pop();
                int temp1=stk.pop();
                
                if(s.equals("+")){
                    stk.push(temp1+temp2);   
                }
                else if(s.equals("-")){
                    stk.push(temp1-temp2);
                }
                else if(s.equals("/")){
                    stk.push(temp1/temp2);
                }
                else{
                    stk.push(temp1*temp2);
                }
            }
            else{
                stk.push(Integer.parseInt(s));
            }
        }
        
        return stk.pop();
    }
}