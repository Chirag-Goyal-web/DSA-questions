import java.util.*;
public class asteroid_collision_leetcode_735{
    public int[] asteroidCollision(int[] arr) {
    
        Stack<Integer> stk=new Stack<>();
        
        for(int i:arr){
            if(i>0){
                stk.add(i);
            }
            
            else{
                while(stk.size()>0 && stk.peek()>0 && stk.peek()<Math.abs(i)){
                    stk.pop();
                }
                
                if(stk.size()>0 && stk.peek()==Math.abs(i)){
                    stk.pop();
                }
                else if(stk.size()==0 || stk.peek()<0){
                    stk.add(i);
                }
            }
        }
        
        int[] ans=new int[stk.size()];
        for(int i=ans.length-1;i>=0;i--){
            ans[i]=stk.pop();
        }
        
        return ans;
    }
}