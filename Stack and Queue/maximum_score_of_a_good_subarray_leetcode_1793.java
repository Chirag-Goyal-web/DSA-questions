import java.util.*;
public class maximum_score_of_a_good_subarray_leetcode_1793{

    //Approach-1
    class Solution {
        public int maximumScore(int[] heights, int k) {
            int[] ans1=seol(heights);
            int[] ans2=seor(heights);
            int max=0;
      
            for(int i=0;i<heights.length;i++){
                if(k<=(ans2[i]-1) && (ans1[i]+1)<=k){
                    max=Math.max(max,heights[i]*(ans2[i]-ans1[i]-1));   
                }
            }
            
            return max;
        }
        
        public int[] seol(int[] arr){
            Stack<Integer> stk=new Stack<>();
            int[] ans=new int[arr.length];
            
            for(int i=0;i<arr.length;i++){
                while(stk.size()>0 && arr[stk.peek()]>=arr[i]){
                    stk.pop();
                }
                
                if(stk.size()==0){
                    ans[i]=-1;
                }
                else{
                    ans[i]=stk.peek();
                }
                stk.add(i);
            }
            
            return ans;
        }
        
        public int[] seor(int[] arr){
            Stack<Integer> stk=new Stack<>();
            int[] ans=new int[arr.length];
            
            for(int i=arr.length-1;i>=0;i--){
                while(stk.size()>0 && arr[stk.peek()]>=arr[i]){
                    stk.pop();
                }
                
                if(stk.size()==0){
                    ans[i]=arr.length;
                }
                else{
                    ans[i]=stk.peek();
                }
                
                stk.add(i);
            }
            
            return ans;
        }
        
    }

    //Approach-2
    class Solution_ {
        public int maximumScore(int[] nums, int k) {
            int i=k;
            int j=k;
            int len=nums.length;
            int ans=nums[k];
            int min=nums[k];
            
            while(i>0 || j<len-1){
                
                if(i==0){
                    j++;
                }
                else if(j==len-1){
                    i--;
                }
                else if(nums[i-1]<nums[j+1]){
                    j++;
                }
                else{
                    i--;
                }
                
                min=Math.min(min,Math.min(nums[i],nums[j]));
                ans=Math.max(ans,(j-i+1)*min);
            }
            
            return ans;
        }
    }

}