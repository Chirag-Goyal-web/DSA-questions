import java.util.*;
public class longest_well_performing_interval_leetcode_1124{
    public int longestWPI(int[] hours) {
        int len=hours.length;
        HashMap<Integer,Integer> hm=new HashMap<>();
        int score=0;
        int ans=0;
        
        for(int i=0;i<len;i++){
            if(hours[i]>8){
                score++;
            }
            else{
                score--;
            }
            
            if(score>0){
                ans=Math.max(ans,i+1);
            }
            else if(hm.containsKey(score-1)){
                ans=Math.max(ans,i-hm.get(score-1));
            }
            
            hm.putIfAbsent(score,i);
        }
        
        return ans;
    }
}