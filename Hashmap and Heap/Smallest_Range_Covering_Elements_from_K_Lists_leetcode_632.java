import java.util.*;
public class Smallest_Range_Covering_Elements_from_K_Lists_leetcode_632{
    public int[] smallestRange(List<List<Integer>> nums) {
        
        int len=nums.size();
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            return nums.get(a[0]).get(a[1])-nums.get(b[0]).get(b[1]);    
        });
        
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        
        for(int i=0;i<len;i++){
            if(nums.get(i).get(0)<min){
                min=nums.get(i).get(0);
            }
            if(nums.get(i).get(0)>max){
                max=nums.get(i).get(0);
            }
            
            pq.add(new int[]{i,0});
        }
        
        int range=max-min;
        int[] ans=new int[]{min,max};
        
        while(pq.size()==len){
            int[] arr=pq.remove();
            min=nums.get(arr[0]).get(arr[1]);
            
            if(max-min<range){
                range=max-min;
                ans[0]=min;
                ans[1]=max;
            }
            
            if(arr[1]+1<nums.get(arr[0]).size()){
                pq.add(new int[]{arr[0],arr[1]+1});
                max=Math.max(max,nums.get(arr[0]).get(arr[1]+1));
            }
            
        }
        
        return ans;
    }
}