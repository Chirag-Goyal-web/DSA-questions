import java.util.*;
public class rabbits_in_forest_leetcode_781{
    public int numRabbits(int[] answers) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        
        for(int i:answers){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        
        int ans=0;
        for(int i:answers){
            if(hm.containsKey(i)){
                ans+=i+1;
                if(hm.get(i)<=i+1){
                    hm.remove(i);
                }
                else{
                    hm.put(i,hm.get(i)-(i+1));
                }
            }
        }
        
        return ans;
    }
}