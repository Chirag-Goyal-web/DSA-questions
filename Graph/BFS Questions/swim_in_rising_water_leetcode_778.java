import java.util.*;
public class swim_in_rising_water_leetcode_778{

    public int swimInWater(int[][] grid) {
        
        int n=grid.length;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            return a[1]-b[1];
        });
        
        pq.add(new int[]{0,grid[0][0]});
        
        int[][] distance=new int[n][n];
        int[][] dir=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        
        for(int i=0;i<n;i++){
            Arrays.fill(distance[i],(int)1e9);
        }
        
        while(pq.size()>0){
            
            int[] temp=pq.remove();
            int row=temp[0]/n;
            int col=temp[0]%n;
            
            if(row==n-1 && col==n-1){
                return temp[1];
            }
            
            for(int[] arr:dir){
                int tempr=row+arr[0];
                int tempc=col+arr[1];
                
                if(tempr>=0 && tempr<n && tempc>=0 && tempc<n ){
                    int cost=Math.max(temp[1],grid[tempr][tempc]);
                    
                    if(cost<distance[tempr][tempc]){
                        distance[tempr][tempc]=cost;
                        pq.add(new int[]{tempr*n+tempc,cost});   
                    }
                }
            }
            
        }
        
        return -1;
    }

}