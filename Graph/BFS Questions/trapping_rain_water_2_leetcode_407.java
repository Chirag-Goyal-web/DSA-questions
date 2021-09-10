import java.util.*;
public class trapping_rain_water_2_leetcode_407{

    public int trapRainWater(int[][] mat) {
        
        int n=mat.length,m=mat[0].length;
        int[][] dir=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        boolean[][] visited=new boolean[n][m];
        
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{
            return mat[a/m][a%m]-mat[b/m][b%m];
        });
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || i==n-1 || j==0 || j==m-1){
                    pq.add(i*m+j);
                    visited[i][j]=true;
                }
            }
        }
        
        int ans=0;
        int max=0;
        
        while(pq.size()>0){
            
            int temp=pq.remove();
            int row=temp/m;
            int col=temp%m;
            
            max=Math.max(max,mat[row][col]);
            
            for(int[]arr:dir){
                int tempr=row+arr[0];
                int tempc=col+arr[1];
                
                if(tempr>=0 && tempr<n && tempc>=0 && tempc<m && visited[tempr][tempc]==false){
                    
                    if(mat[tempr][tempc]<max){
                        ans+=max-mat[tempr][tempc];
                    }
                    
                    visited[tempr][tempc]=true;
                    pq.add(tempr*m+tempc);
                }
            }
            
        }
        
        return ans;
    }

}