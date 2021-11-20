import java.util.*;
public class kth_largest_element_in_a_stream_leetcode_703{

    class KthLargest {
        PriorityQueue<Integer> pq;
        int s;
        
        public KthLargest(int k, int[] nums) {
            pq=new PriorityQueue<>();
            s=k;
            
            for(int i=0;i<nums.length;i++){
                if(pq.size()<k){
                    pq.add(nums[i]);
                }
                else{
                    if(pq.size()>0 && nums[i]>pq.peek()){
                        pq.remove();
                        pq.add(nums[i]);
                    }
                }
            }
            
        }
        
        public int add(int val) {
            if(pq.size()<s){
                pq.add(val);
            }
            
            else if(pq.size()>0 && val>pq.peek()){
                pq.remove();
                pq.add(val);
            }
        
            return pq.peek();    
        }

    }
}