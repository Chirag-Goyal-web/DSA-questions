import java.util.*;
public class race_car_leetcode_818{

    public int racecar(int target) {
        
        LinkedList<int[]> que=new LinkedList<>();
        que.add(new int[]{0,1});
        Set<String> visited=new HashSet<>();
        int level=0;
        
        while(que.size()>0){
            int size=que.size();
            
            while(size-->0){
                
                int[] temp=que.removeFirst();
                int pos=temp[0];
                int speed=temp[1];
                
                if(pos==target){
                    return level;
                }
                
                int nextPos=pos+speed;
                int nextSpeed=speed*2;
                
                if(0<=nextPos && nextPos<=target*2){
                    if(!visited.contains(nextPos+" "+nextSpeed)){
                        visited.add(nextPos+" "+nextSpeed);
                        que.add(new int[]{nextPos,nextSpeed});
                    }                    
                }
                
                nextSpeed=speed>0?-1:1;
                
                if(!visited.contains(pos+" "+nextSpeed)){
                    visited.add(pos+" "+nextSpeed);
                    que.add(new int[]{pos,nextSpeed});
                }                    
            
            }
            
            level++;
        }
        
        return -1;
    }

}