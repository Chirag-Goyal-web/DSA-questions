import java.util.*;
public class As_Far_from_Land_as_Possible_leetcode_1162{

    public int maxDistance(int[][] grid) {
        
        int n=grid.length;
        int[][] dir=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        Queue<Integer> que=new LinkedList<>();
        int ans=-1;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    que.add(i*n+j);
                }
            }
        }
        
        int level=1;
        while(que.size()>0){
            int size=que.size();
            
            while(size-->0){
                int temp=que.remove();
                int row=temp/n;
                int col=temp%n;

                for(int[] arr:dir){
                    int tempr=row+arr[0];
                    int tempc=col+arr[1];

                    if(tempr>=0 && tempr<n && tempc>=0 && tempc<n && grid[tempr][tempc]==0){
                        grid[tempr][tempc]=level;
                        ans=Math.max(ans,level);
                        que.add(tempr*n+tempc);
                    }
                }
            }
            
            level++;
        }
        
        return ans;
    }

}