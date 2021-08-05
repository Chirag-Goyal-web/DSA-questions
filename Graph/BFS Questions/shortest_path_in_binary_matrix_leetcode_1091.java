import java.util.*;
public class shortest_path_in_binary_matrix_leetcode_1091{
    
    class Solution {
        public int shortestPathBinaryMatrix(int[][] grid) {
            
            int m=grid.length,n=grid[0].length;
            
            //If we can't start or reach at end, return -1
            if(grid[0][0]!=0 || grid[m-1][n-1]!=0){
                return -1;
            }
            
            int[][] dir=new int[][]{{1,0},{-1,0},{0,1},{0,-1},{-1,-1},{-1,1},{1,-1},{1,1}};
            
            LinkedList<Integer> que=new LinkedList<>();
            que.add(0);
            
            int dis=1;
            
            while(que.size()>0){
                
                int size=que.size();
                while(size-->0){
                    
                    int temp=que.remove(0);
                    int row=temp/n;
                    int col=temp%n;
                    
                    //Check if we have reached destination
                    if(row==m-1 && col==n-1){
                        return dis;
                    }
                    
                    for(int i=0;i<dir.length;i++){
                        int trow=row+dir[i][0];
                        int tcol=col+dir[i][1];
                        
                        if(trow>=0 && trow<m && tcol>=0 && tcol<n && grid[trow][tcol]==0){
                            grid[trow][tcol]=1;
                            que.add(trow*n+tcol);
                        }
                        
                    }
                    
                }
                dis++;
            }
            
            return -1;
            
        }
    }

}