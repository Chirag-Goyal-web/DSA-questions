import java.util.*;
public class Remove_Stones_to_Minimize_the_Total_leetcode_1962{
    public int minStoneSum(int[] piles, int k) {
        int sum=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{
            return b-a;
        });
        
        for(int i:piles){
            pq.add(i);
            sum+=i;
        }
        
        while(k>0 && pq.size()>0){
            k--;
            int t=pq.remove();
            sum-=(t/2);
            
            if((t-t/2)>0)
                pq.add(t-t/2);
        }
        
        return sum;
    }
}