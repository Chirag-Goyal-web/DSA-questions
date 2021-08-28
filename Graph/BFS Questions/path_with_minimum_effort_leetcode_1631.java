import java.util.*;
public class path_with_minimum_effort_leetcode_1631{
    public int minimumEffortPath(int[][] heights) {
        
        int n=heights.length,m=heights[0].length;
        
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            return a[2]-b[2];
        });
        
        pq.add(new int[]{0,0,0});
        
        int[][] dir=new int[][]{{1,0},{-1,0},{0,-1},{0,1}};
        
        boolean[][] visited=new boolean[n][m];
        
        while(pq.size()>0){
            
            int[] temp=pq.remove();
            int row=temp[0],col=temp[1];
            
            if(visited[row][col]==true)
                continue;
            
            visited[row][col]=true;
            
            if(row==n-1 && col==m-1)
                return temp[2];
            
            for(int[] arr:dir){
                int trow=row+arr[0];
                int tcol=col+arr[1];
                
                if(trow>=0 && trow<n && tcol>=0 && tcol<m && visited[trow][tcol]==false){
                    int maxEff=Math.max(temp[2],Math.abs(heights[row][col]-heights[trow][tcol]));
                    pq.add(new int[]{trow,tcol,maxEff});
                }
                
            }
            
        }
        
        return 0;
    }
}