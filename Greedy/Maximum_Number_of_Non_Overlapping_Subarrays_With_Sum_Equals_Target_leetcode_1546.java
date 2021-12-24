import java.util.*;
public class Maximum_Number_of_Non_Overlapping_Subarrays_With_Sum_Equals_Target_leetcode_1546{
    public int maxNonOverlapping(int[] nums, int target) {
        Set<Integer> s=new HashSet<>();
        int sum=0;
        int count=0;
        
        for(int i:nums){
            sum+=i;
            
            if(sum==target){
                sum=0;
                count++;
                s.clear();
            }
            else if(s.contains(sum-target)){
                count++;
                sum=0;
                s.clear();
            }
            else{
                s.add(sum);
            }
        }
        
        return count;
    }
}