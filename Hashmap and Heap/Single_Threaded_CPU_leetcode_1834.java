import java.util.*;
public class Single_Threaded_CPU_leetcode_1834{
    public int[] getOrder(int[][] tasks) {
        int len=tasks.length;
        int[][] arr=new int[len][3];
        
        for(int i=0;i<len;i++){
            arr[i][0]=i;
            arr[i][1]=tasks[i][0];
            arr[i][2]=tasks[i][1];
        }
        
        Arrays.sort(arr,(a,b)->{
            if(a[1]==b[1]){
                return a[2]-b[2];
            }
            else{
                return a[1]-b[1];
            }
        });

        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{
            if(arr[a][2]!=arr[b][2])
                return arr[a][2]-arr[b][2];
            else
                return arr[a][0]-arr[b][0];
        });
        
        int idx=1;
        int[] ans=new int[len];
        int cur=0;
        int time=arr[0][1];
        int remainTask=len;
        pq.add(0);
        
        while(remainTask-->0){
            int temp=pq.remove();
            ans[cur++]=arr[temp][0];
            time+=arr[temp][2];
            
            if(pq.size()==0 && idx<len && arr[idx][1]>time){
                time=arr[idx][1];
            }
            
            while(idx<len && time>=arr[idx][1]){
                pq.add(idx);
                idx++;
            }
        }
        
        return ans;
    }
}