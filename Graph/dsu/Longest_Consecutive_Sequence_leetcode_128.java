import java.util.*;
public class Longest_Consecutive_Sequence_leetcode_128{

    class Solution {
        public int longestConsecutive(int[] nums) {
            
            if(nums.length==0)
                return 0;
                        //{par,size}
            HashMap<Integer,int[]> hm=new HashMap<>();
            int ans=1;
            
            for(int i:nums){
                if(!hm.containsKey(i)){
                    int []arr=new int[]{i,1};
                    hm.put(i,arr);
                    
                    if(hm.containsKey(i-1)){
                        int p1=findPar(hm,i);
                        int p2=findPar(hm,i-1);
                        
                        int[] arr1=hm.get(p1);
                        int[] arr2=hm.get(p2);
                        
                        arr1[0]=p2;
                        arr2[1]+=arr1[1];
                        
                        ans=Math.max(ans,arr2[1]);
                    }
                    
                    if(hm.containsKey(i+1)){
                        int p1=findPar(hm,i);
                        int p2=findPar(hm,i+1);
                        
                        int[] arr1=hm.get(p1);
                        int[] arr2=hm.get(p2);
                        
                        arr1[0]=p2;
                        arr2[1]+=arr1[1];
                        
                        ans=Math.max(ans,arr2[1]);
                    }
                }  
            }
            
            return ans; 
        }
        
        public int findPar(HashMap<Integer,int[]> graph,int u){
            if(graph.get(u)[0]==u){
                return u;
            }
            
            else{
                int temp=findPar(graph,graph.get(u)[0]);
                graph.get(u)[0]=temp;
                return temp;
            }
        }
    }

    //Alternative approach
    class Solution_ {
        public int longestConsecutive(int[] nums) {
            Set<Integer> num_set = new HashSet<Integer>();
            for (int num : nums) {
                num_set.add(num);
            }
    
            int longestStreak = 0;
    
            for (int num : num_set) {
                if (!num_set.contains(num-1)) {
                    int currentNum = num;
                    int currentStreak = 1;
    
                    while (num_set.contains(currentNum+1)) {
                        currentNum += 1;
                        currentStreak += 1;
                    }
    
                    longestStreak = Math.max(longestStreak, currentStreak);
                }
            }
    
            return longestStreak;
        }
    }

}