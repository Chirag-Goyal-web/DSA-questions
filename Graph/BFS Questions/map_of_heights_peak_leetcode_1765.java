import java.util.*;
public class map_of_heights_peak_leetcode_1765{

    public int[][] highestPeak(int[][] isWater) {
        
        int n=isWater.length,m=isWater[0].length;
        boolean[][] visited=new boolean[n][m];
        int[][] dir=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        
        //{index,val}
        Queue<int[]> que=new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(isWater[i][j]==1){
                    visited[i][j]=true;
                    que.add(new int[]{i*m+j,0});
                }
            }
        }

        while(que.size()>0){
            int[] temp=que.remove();
            int row=temp[0]/m;
            int col=temp[0]%m;
            isWater[row][col]=temp[1];
            
            for(int[] arr:dir){
                int tempr=row+arr[0];
                int tempc=col+arr[1];

                if(tempr>=0 && tempr<n && tempc>=0 && tempc<m && visited[tempr][tempc]==false){
                    que.add(new int[]{tempr*m+tempc,temp[1]+1});
                    visited[tempr][tempc]=true;
                }

            }

        }

        return isWater;
    }

}