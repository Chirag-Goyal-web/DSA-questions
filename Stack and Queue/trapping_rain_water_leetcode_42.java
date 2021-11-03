import java.util.*;
public class trapping_rain_water_leetcode_42{
    public int trap(int[] height) {
        int len=height.length;
        int[] left=new int[len];
        int[] right=new int[len];
        int ans=0;
        int max=0;
        
        for(int i=0;i<len;i++){
            max=Math.max(max,height[i]);
            left[i]=max;
        }
        
        max=0;
        for(int i=len-1;i>=0;i--){
            max=Math.max(max,height[i]);
            right[i]=max;
        }
        
        for(int i=0;i<len;i++){
            ans+=Math.min(left[i],right[i])-height[i];
        }
        
        return ans;
    }
}