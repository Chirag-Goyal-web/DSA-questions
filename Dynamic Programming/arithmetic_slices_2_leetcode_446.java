import java.util.*;
public class arithmetic_slices_2_leetcode_446{
    public int numberOfArithmeticSlices(int[] nums) {
        int len=nums.length;
        HashMap<Long,Long>[] hm=new HashMap[len];
        
        for(int i=0;i<len;i++){
            hm[i]=new HashMap<>();
        }
        
        long ans=0;
        for(int i=0;i<len;i++){
            for(int j=i-1;j>=0;j--){
                long diff=(long)nums[i]-(long)nums[j];
                long temp=hm[j].getOrDefault(diff,0L);
                ans+=temp;
                hm[i].put(diff,hm[i].getOrDefault(diff,0L)+temp+1);
            }
        }
        
        return (int)ans;
    }
}