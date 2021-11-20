import java.util.*;
public class Longest_Consecutive_Sequence_leetcode_128{
    public int longestConsecutive(int[] nums) {   
        if(nums.length==0)
            return 0;
        
        HashSet<Integer> hm=new HashSet<>();
        for(int i:nums){
            hm.add(i);
        }
        
        int ans=1;
        
        for(int i:nums){
            if(hm.contains(i)){
                int prev=i-1,next=i+1;
                
                hm.remove(i);
                
                while(hm.contains(prev))
                    hm.remove(prev--);
                
                while(hm.contains(next))
                    hm.remove(next++);
                
                ans=Math.max(ans,next-prev-1);
            }
        }
        
        return ans;
    }
}