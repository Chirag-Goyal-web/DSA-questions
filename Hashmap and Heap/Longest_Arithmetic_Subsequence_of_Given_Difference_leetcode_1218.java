import java.util.*;
public class Longest_Arithmetic_Subsequence_of_Given_Difference_leetcode_1218{
    public int longestSubsequence(int[] arr, int difference) {
        int ans=0;
        HashMap<Integer,Integer> hm=new HashMap<>();
        
        for(int i:arr){
            hm.put(i,hm.getOrDefault(i-difference,0)+1);
            ans=Math.max(ans,hm.get(i));
        }
        
        return ans;
    }
}