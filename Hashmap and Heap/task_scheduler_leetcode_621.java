import java.util.*;
public class task_scheduler_leetcode_621{
    public int leastInterval(char[] tasks, int n) {
        int total=tasks.length;
        int[] freq=new int[26];
        
        for(char c:tasks){
            freq[c-'A']++;
        }
        
        PriorityQueue<Integer> available=new PriorityQueue<>((a,b)->{
            return freq[b]-freq[a];
        });
        PriorityQueue<int[]> coolDown=new PriorityQueue<>((a,b)->{
            return a[1]-b[1];
        });
        
        for(int i=0;i<26;i++){
            if(freq[i]>0){
                available.add(i);
            }
        }
        
        int time=0;
        while(total>0){
            time++;
            
            if(coolDown.size()>0 && time-coolDown.peek()[1]>n){
                available.add(coolDown.remove()[0]);
            }
            
            if(available.size()>0){
                total--;
                int temp=available.remove();
                freq[temp]--;
                if(freq[temp]>0){
                    coolDown.add(new int[]{temp,time});     
                }
            }
        }
        
        return time;
    }
}