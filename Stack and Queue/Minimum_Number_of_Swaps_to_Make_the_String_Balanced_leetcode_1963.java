public class Minimum_Number_of_Swaps_to_Make_the_String_Balanced_leetcode_1963.java{
    public int minSwaps(String s) {
        
        Stack<Character> stk=new Stack<>();
        char[] arr=s.toCharArray();
        
        for(char c:arr){
            if(c=='['){
                stk.push(c);
            }
            else{
                if(stk.size()>0 && stk.peek()=='['){
                    stk.pop();
                }   
                else{
                    stk.push(c);
                }
            }
        }
        
        return (int)Math.ceil(((double)stk.size())/(double)4);
    }
}