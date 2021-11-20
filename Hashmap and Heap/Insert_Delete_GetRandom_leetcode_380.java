import java.util.*;
public class Insert_Delete_GetRandom_leetcode_380{
    class RandomizedSet {
        HashMap<Integer,Integer> hm;
        ArrayList<Integer> arr;
        
        public RandomizedSet() {
            arr=new ArrayList<>();
            hm=new HashMap<>();
        }
        
        public boolean insert(int val) {
            if(!hm.containsKey(val)){
                arr.add(val);
                hm.put(val,arr.size()-1);
                return true;
            }
            return false;
        }
        
        public boolean remove(int val) {
            if(hm.containsKey(val)){
                int idx=hm.get(val);
                arr.set(idx,arr.get(arr.size()-1));
                arr.remove(arr.size()-1);
                hm.remove(val);
                if(arr.size()>idx)
                    hm.put(arr.get(idx),idx);
                return true;
            }
            return false;
        }
        
        public int getRandom() {
            int size=arr.size();
            int idx=(int)((double)size*Math.random());
            
            return arr.get(idx);
        }
    }
}