import java.util.*;
public class furthest_building_you_can_reach_leetcode_1642{
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int len=heights.length;
        
        for(int i=1;i<len;i++){
            int d=heights[i]-heights[i-1];
            if(d>0){
                pq.add(d);
                
                if(pq.size()>ladders){
                    int temp=pq.remove();
                    
                    if(bricks>=temp){
                        bricks-=temp;
                    }
                    else{
                        return i-1;
                    }
                }
            }
        }
        
        return len-1;
    }
}