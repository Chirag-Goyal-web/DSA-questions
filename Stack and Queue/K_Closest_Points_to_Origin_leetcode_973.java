import java.util.*;
public class K_Closest_Points_to_Origin_leetcode_973{
    public int[][] kClosest(int[][] arr, int k) {
        
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{
            int t1=arr[a][0]*arr[a][0]+arr[a][1]*arr[a][1];
            int t2=arr[b][0]*arr[b][0]+arr[b][1]*arr[b][1];
            return t2-t1;
        });
        
        
        for(int i=0;i<arr.length;i++){
            pq.add(i);
            if(pq.size()>k){
                pq.remove();
            }
        }
        
        int[][] ans=new int[k][2];
        int idx=0;
        
        while(pq.size()>0){
            ans[idx][0]=arr[pq.peek()][0];
            ans[idx][1]=arr[pq.peek()][1];
            pq.remove();
            idx++;
        }
        
        return ans;
    }
}