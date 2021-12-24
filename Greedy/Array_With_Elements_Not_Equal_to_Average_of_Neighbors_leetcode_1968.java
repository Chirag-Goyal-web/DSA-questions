import java.util.*;
public class Array_With_Elements_Not_Equal_to_Average_of_Neighbors_leetcode_1968{
    public int[] rearrangeArray(int[] nums) {
        Arrays.sort(nums);
        
        for(int i=0;i<nums.length-1;i=i+2){
            int temp=nums[i];
            nums[i]=nums[i+1];
            nums[i+1]=temp;
        }
        
        return nums;
    }
}