import java.util.*;
public class array_of_doubled_pairs_leetcode_954{   

    public boolean canReorderDoubled(int[] Arr) {
        Integer[] arr=new Integer[Arr.length];
        int idx=0;
        HashMap<Integer,Integer> hm=new HashMap<>();
        
        for(int i:Arr){
            arr[idx++]=i;
        }
        
        Arrays.sort(arr,(a,b)->{
            return Math.abs(a)-Math.abs(b);
        });
        
        for(int i:arr){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        
        for(int i:arr){
            if(hm.containsKey(i)){

                if(hm.get(i)==1)
                    hm.remove(i);
                else
                    hm.put(i,hm.get(i)-1);
                
                if(hm.containsKey(i*2)){
                    if(hm.get(i*2)==1)
                        hm.remove(i*2);
                    else
                        hm.put(i*2,hm.get(i*2)-1);
                }
                else{
                    return false;
                }
            }
        }
        
        return true;
    }

}