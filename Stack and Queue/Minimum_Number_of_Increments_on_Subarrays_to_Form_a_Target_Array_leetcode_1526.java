public class Minimum_Number_of_Increments_on_Subarrays_to_Form_a_Target_Array_leetcode_1526{
    public int minNumberOperations(int[] target) {
        int ans=target[0];
        int len=target.length;
        
        for(int i=1;i<len;i++){
            ans+=Math.max(0,target[i]-target[i-1]);
        }
        
        return ans;
    }
}