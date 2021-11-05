import java.util.*;
public class car_fleet_leetcode_853{
    public int carFleet(int target, int[] position, int[] speed) {        
        int len=position.length;
        double[][] arr=new double[len][2];
        
        for(int i=0;i<len;i++){
            arr[i][0]=position[i];
            arr[i][1]=((double)(target-position[i])/(double)speed[i]);             
        }
        
        Arrays.sort(arr,(a,b)->{
            return (int)(a[0]-b[0]);
        });
        
        int ans=0;
        for(int i=len-1;i>=0;){
            ans++;
            double time=arr[i][1];
            while(i>=0 && arr[i][1]<=time){
                i--;
            }  
        }
        
        return ans;
    }
}