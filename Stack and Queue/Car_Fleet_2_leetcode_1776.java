import java.util.*;
public class Car_Fleet_2_leetcode_1776{
    public double[] getCollisionTimes(int[][] cars) {
        Stack<Integer> stk=new Stack<>();
        int len=cars.length;
        double[] ans=new double[len];
        ans[len-1]=-1;
        Arrays.fill(ans,-1);
        
        for(int i=len-1;i>=0;i--){
            while(stk.size()>0 && cars[stk.peek()][1]>=cars[i][1]){
                stk.pop();
            }
            
            while(stk.size()>0){
                if(((double)(cars[stk.peek()][0]-cars[i][0]))/((double)(cars[i][1]-cars[stk.peek()][1]))<=ans[stk.peek()] || ans[stk.peek()]==-1){
                    ans[i]=((double)(cars[stk.peek()][0]-cars[i][0]))/((double)(cars[i][1]-cars[stk.peek()][1]));
                    break;
                }
                else{
                    stk.pop();
                }
            }
            
            stk.push(i);
        }
        
        return ans;
    }
}