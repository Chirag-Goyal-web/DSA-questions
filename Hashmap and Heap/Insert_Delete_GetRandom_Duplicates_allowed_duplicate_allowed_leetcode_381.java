import java.util.*;
public class Insert_Delete_GetRandom_Duplicates_allowed_duplicate_allowed_leetcode_381{
    class RandomizedCollection {
    
        HashMap<Integer,HashSet<Integer>> hm;
        ArrayList<Integer> arr;
        
        public RandomizedCollection() {
            hm=new HashMap<>();
            arr=new ArrayList<>();
        }
        
        public boolean insert(int val) {
            boolean flag=hm.containsKey(val)==true?false:true;
            arr.add(val);        
            hm.putIfAbsent(val,new HashSet<>());
            hm.get(val).add(arr.size()-1);    
            return flag;
        }
        
        public boolean remove(int val) {
            if(hm.containsKey(val)){
                int idx=hm.get(val).iterator().next();

                if(hm.get(val).size()==1){
                    hm.remove(val);
                }
                else{
                    hm.get(val).remove(idx);
                }
                
                int temp=arr.get(arr.size()-1);
                arr.set(idx,temp);
                arr.remove(arr.size()-1);
                
                if(hm.containsKey(temp)){
                    hm.get(temp).remove(arr.size());
                    hm.get(temp).add(idx);
                }
                
                return true;
            }
            else{
                return false;
            }
        }
        
        public int getRandom() {
            int size=arr.size();
            return arr.get((int)((double)size*Math.random()));
        }
    }
}