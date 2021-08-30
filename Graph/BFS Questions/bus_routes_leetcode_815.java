import java.util.*;
public class bus_routes_leetcode_815{

    class Solution {
        public int numBusesToDestination(int[][] routes, int source, int target) {
            
            int stop=0;
            HashMap<Integer,ArrayList<Integer>> hm=new HashMap<>();
            
            for(int i=0;i<routes.length;i++){
                for(int j=0;j<routes[i].length;j++){
                    
                    if(!hm.containsKey(routes[i][j])){
                        hm.put(routes[i][j],new ArrayList<>());
                    }
                    
                    hm.get(routes[i][j]).add(i);
                }
            }
            
            Queue<Integer> que=new LinkedList<>();
            que.add(source);
            
            Set<Integer> busNo=new HashSet<>();
            Set<Integer> busStop=new HashSet<>();
            busStop.add(source);
            
            while(que.size()>0){
                int size=que.size();
                
                while(size-->0){
                    int temp=que.remove();            
                    
                    if(temp==target){
                        return stop;
                    }
                    
                    else{
                        for(int i:hm.get(temp)){
                            if(!busNo.contains(i)){
                                
                                for(int j:routes[i]){
                                    if(!busStop.contains(j)){
                                        que.add(j);
                                        busStop.add(j);
                                    }
                                }    
                                busNo.add(i);
                            }                    
                        }
                    }
                    
                }
                stop++;
            }
         
            return -1;
        }
    }

}