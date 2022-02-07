import java.util.*;
public class Most_Beautiful_Item_for_Each_Query_leetcode_2070{
    public int[] maximumBeauty(int[][] items, int[] query) {
        int len=query.length;
        int[] ans=new int[len];
        
        int[][] queries=new int[len][2];
        
        for(int i=0;i<len;i++){
            queries[i][0]=query[i];
            queries[i][1]=i;
        }
        
        Arrays.sort(items,(a,b)->{
            return a[0]-b[0];
        });
        
        Arrays.sort(queries,(a,b)->{
            return a[0]-b[0];
        });
        
        int max=0;
        int itr=0;
        
        for(int i=0;i<len;i++){
            int temp=queries[i][0];
            
            while(itr<items.length && items[itr][0]<=temp){
                max=Math.max(max,items[itr][1]);
                itr++;
            }
            
            ans[queries[i][1]]=max;
        }
        
        return ans;
    }
}