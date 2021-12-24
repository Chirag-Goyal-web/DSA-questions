import java.util.PriorityQueue;
public class Equal_Sum_Arrays_With_Minimum_Number_of_Operations_leetcode_1775{
    public int minOperations(int[] nums1, int[] nums2) {
        int size1=nums1.length;
        int size2=nums2.length;
        
        int min1=size1;
        int min2=size2;
        int max1=size1*6;
        int max2=size2*6;
        
        if(max1<min2 || max2<min1){
            return -1;
        }
        else{
            int sum1=0;
            int sum2=0;
            
            for(int i:nums1){
                sum1+=i;
            }
            for(int i:nums2){
                sum2+=i;
            }
            
            int diff=Math.abs(sum1-sum2);
            PriorityQueue<Integer> minHeap=new PriorityQueue<>((a,b)->{
                return a-b;
            });
            PriorityQueue<Integer> maxHeap=new PriorityQueue<>((a,b)->{
                return b-a;
            });
            
            if(sum1>sum2){
                maxHeap(nums1,maxHeap);        
                minHeap(nums2,minHeap);
            }
            else{
                maxHeap(nums2,maxHeap);        
                minHeap(nums1,minHeap);
            }
            
            int ans=0;
            while(diff>0){
                ans++;
                int s1=maxHeap.size();
                int s2=minHeap.size();
                int temp1=0,temp2=0;
                
                if(s1>0)
                     temp1=maxHeap.remove()-1;
    
                if(s2>0)
                     temp2=6-minHeap.remove();
                
                int max=Math.max(temp1,temp2);
                if(max>diff){
                    break;
                }
                else{
                    diff-=max;
                    
                    if(temp1==max){
                        if(s2>0)
                            minHeap.add(6-temp2);
                    }
                    else{
                        if(s1>0) 
                            maxHeap.add(temp1+1);
                    }
                }
                
            }
            
            return ans;
        }
        
    }
    
    public void maxHeap(int[] arr,PriorityQueue<Integer> maxHeap){
        for(int i:arr){
            maxHeap.add(i);
        }
    }
    
    public void minHeap(int[] arr,PriorityQueue<Integer> minHeap){
        for(int i:arr){
            minHeap.add(i);
        }
    }
}