import java.util.*;
public class chocolate_journey_hackerrank{

    public static void helper(ArrayList<int[]>[] graph,int frnd1,int[] distance1){
        
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            return a[1]-b[1];
        });

        pq.add(new int[]{frnd1,0});

        while(pq.size()>0){
            
            int[] temp=pq.remove();

            for(int[] arr:graph[temp[0]]){
                
                if(temp[1]+arr[1]<distance1[arr[0]]){
                    distance1[arr[0]]=temp[1]+arr[1];
                    pq.add(new int[]{arr[0],temp[1]+arr[1]});
                }

            }

        }


    }

    public static void function(ArrayList<int[]>[] graph,int n,boolean[] chocolate,int frnd1,int frnd2,int x){
        
        int[] distance1=new int[n+1];
        Arrays.fill(distance1,(int)1e9);

        int[] distance2=new int[n+1];
        Arrays.fill(distance2,(int)1e9);


        distance1[frnd1]=0;
        distance2[frnd2]=0;

        helper(graph,frnd1,distance1);
        helper(graph,frnd2,distance2);

        int ans=(int)1e9;
        for(int i=1;i<=n;i++){
            if(chocolate[i]==true && distance1[i]<=x){
                ans=Math.min(ans,distance1[i]+distance2[i]);
            }
        }

        if(ans!=(int)1e9){
            System.out.println(ans);
        }
        else{
            System.out.println(-1);
        }
    }

}