public class get_the_maximum_score_leetcode_1537{
    public int maxSum(int[] nums1, int[] nums2) {
        int idx1=nums1.length-1;
        int idx2=nums2.length-1;
        
        long sum=0;
        long temp1=0,temp2=0;
       
        while(idx1>=0 && idx2>=0){
            if(nums1[idx1]==nums2[idx2]){
                sum+=(Math.max(temp1,temp2)+nums1[idx1]);
                temp1=0;
                temp2=0;
                idx1--;
                idx2--;
            }
            else if(nums1[idx1]>nums2[idx2]){
                temp1+=nums1[idx1];
                idx1--;
            }
            else{
                temp2+=nums2[idx2];
                idx2--;
            }
        }
               
        while(idx1>=0){
            temp1+=nums1[idx1--];
        }
        while(idx2>=0){
            temp2+=nums2[idx2--];
        }
        
        sum+=Math.max(temp1,temp2);
        return (int)(sum%(1000000007));
    }
}