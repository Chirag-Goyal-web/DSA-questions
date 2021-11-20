import java.util.*;
public class Top_K_Frequent_Elements_leetcode_347{
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans=new int[k];
        HashMap<Integer,Integer> hm=new HashMap<>();
        
        for(int i:nums){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{
            return hm.get(a)-hm.get(b);
        });
        
        for(int i:hm.keySet()){
            pq.add(i);
            if(pq.size()>k){
                pq.remove();
            }
        }
        
        int idx=0;
        while(pq.size()>0){
            ans[idx++]=pq.remove();
        }
        
        return ans;
    }
}