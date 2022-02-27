import java.util.*;
public class Minimum_Cost_to_Hire_K_Workers_leetcode_857{
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int len=quality.length;
        double[][] arr=new double[len][3];
        
        for(int i=0;i<arr.length;i++){
            arr[i][0]=quality[i];
            arr[i][1]=wage[i];
            arr[i][2]=(arr[i][1]/arr[i][0]);
        }
        
        Arrays.sort(arr,(a,b)->{
            if(a[2]<b[2]){
                return -1;
            }
            else{
                return 1;
            }
        });
        
        PriorityQueue<double[]> pq=new PriorityQueue<>((a,b)->{
            if(a[0]<b[0]){
                return 1;
            }
            else{
                return -1;
            }
        });
        
        double sum=0;
        double maxRatio=0;
        double ans=Integer.MAX_VALUE;
        
        for(int i=0;i<len;i++){
            if(pq.size()<k){
                pq.add(arr[i]);
                sum+=arr[i][0];
                maxRatio=arr[i][2];
                if(pq.size()==k){
                    ans=Math.min(ans,maxRatio*sum);
                }
            }    
            else{
                double[] temp=pq.remove();
                sum-=temp[0];
                sum+=arr[i][0];
                pq.add(arr[i]);
                maxRatio=arr[i][2];
                ans=Math.min(ans,maxRatio*sum);
            }
        }
        
        return ans;
    }
}