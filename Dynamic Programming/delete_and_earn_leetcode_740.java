import java.util.*;
public class delete_and_earn_leetcode_740{

    public int deleteAndEarn(int[] nums) {
        
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i:nums){
            hm.put(i,hm.getOrDefault(i,0)+i);
        }
        
        List<Integer> ls=new ArrayList<>();
        for(int i:hm.keySet()){
            ls.add(i);
        }
        
        Collections.sort(ls);
        int inc=hm.get(ls.get(0));
        int exc=0;
        
        for(int i=1;i<ls.size();i++){
            int temp1=0,temp2=0;
            int val=ls.get(i);
            
            if(val-ls.get(i-1)==1){
                temp1=exc+hm.get(val);     
            }
            
            else{
                temp1=Math.max(inc,exc)+hm.get(val);     
            }
            
            temp2=Math.max(inc,exc);
            inc=temp1;
            exc=temp2;
        }
        
        return Math.max(inc,exc);
    }

}