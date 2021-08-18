import java.util.*;
public class time_needed_to_inform_all_employees_leetcode_1376 {
    
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        
        HashMap<Integer,ArrayList<Integer>> hm=new HashMap<>();
        hm.put(headID,new ArrayList<>());
        for(int i=0;i<n;i++){
            if(manager[i]!=-1){
                if(hm.containsKey(manager[i])==false){
                    hm.put(manager[i],new ArrayList<>());
                }
                hm.get(manager[i]).add(i);
            }
        }
        
        return helper(hm,headID,informTime);    
    }
    
    public int helper(HashMap<Integer,ArrayList<Integer>> hm,int src,int[] informTime){
        
        int max=0;
        ArrayList<Integer> ls=hm.get(src);
        
        for(int val:ls){
            if(hm.containsKey(val)){
                int temp=helper(hm,val,informTime);
                max=Math.max(max,temp);    
            }
            
        }
        
        return max+informTime[src];
    }
    
}