import java.util.*;

public class exclusive_time_of_functions_leetcode_636{
    //This approach is based on the fact that no. of start is same as no. of end 
    class Solution {
        public int[] exclusiveTime(int n, List<String> logs) {
            int len=logs.size();
            int[] ans=new int[n];
            Stack<Pair> stk=new Stack<>();
            
            for(int i=0;i<len;i++){
                String[] temp=logs.get(i).split(":");
                
                if(temp[1].equals("start")){
                    stk.push(new Pair(Integer.parseInt(temp[0]),Integer.parseInt(temp[2]),0));
                }
                else{
                    Pair p=stk.pop();
                    ans[p.id]+=Integer.parseInt(temp[2])-p.time+1-p.sleepTime;
                    
                    if(stk.size()>0){
                        stk.peek().sleepTime+=Integer.parseInt(temp[2])-p.time+1;
                    }
                }
            }
            
            return ans;
        }
        
        public class Pair{
            int id;
            int time;
            int sleepTime;
            
            Pair(int id,int time,int sleepTime){
                this.id=id;
                this.time=time;
                this.sleepTime=sleepTime;
            }
        }
        
    }

    //Not necessary no. of start==no. of end
    class Solution_ {
        public int[] exclusiveTime(int n, List<String> logs) {
            int[] res = new int[n];
            Stack<Integer> stack = new Stack<>();
            int prevTime = 0;
            
            for (String log : logs) {
                String[] parts = log.split(":");
                
                if (!stack.isEmpty()) res[stack.peek()] +=  Integer.parseInt(parts[2]) - prevTime; 
                prevTime = Integer.parseInt(parts[2]);
                
                if (parts[1].equals("start")) stack.push(Integer.parseInt(parts[0]));
                else {
                    res[stack.pop()]++;
                    prevTime++;
                }
            }
            
            return res;
        }
    }
}

