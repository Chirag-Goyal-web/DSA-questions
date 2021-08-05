import java.util.*;
public class number_of_enclaves_leetcode_1020{
    
    //BFS approach
    class Solution {
        public int numEnclaves(int[][] grid) {
            
            int m=grid.length,n=grid[0].length;
            LinkedList<Integer> que=new LinkedList<>();
            int[][] dir=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
            
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(i==0 || i==m-1 || j==0 || j==n-1){
                        if(grid[i][j]==1){
                            que.add(i*n+j);
                            grid[i][j]=0;
                        }
                    }
                }
            }
            
            while(que.size()>0){
                
                int size=que.size();
                
                while(size-->0){
                    int temp=que.remove(0);
                    int row=temp/n;
                    int col=temp%n;
                    
                    for(int i=0;i<dir.length;i++){
                        int tempr=row+dir[i][0];
                        int tempc=col+dir[i][1];
                        
                        if(tempr>=0 && tempr<m && tempc>=0 && tempc<n && grid[tempr][tempc]==1){
                            grid[tempr][tempc]=0;
                            que.add(tempr*n+tempc);
                        }
                        
                    }
                    
                }
            }
            
            int count=0;
            
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(grid[i][j]==1){
                        count++;
                    }
                }
            }
            
            return count;
        }
    }


    //DFS approach
    class Solution_2{
        public int numEnclaves(int[][] grid) {
            
            int m=grid.length,n=grid[0].length;
            int[][] dir=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
            
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(i==0 || i==m-1 || j==0 || j==n-1){
                        if(grid[i][j]==1){
                            dfs(grid,i,j,dir);
                        }
                    }
                }
            }
            
            int count=0;
            
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(grid[i][j]==1){
                        count++;
                    }
                }
            }
            
            return count;
        }
        
        public void dfs(int[][] grid,int row,int col,int[][] dir){
            
            grid[row][col]=0;
            
            for(int i=0;i<dir.length;i++){
    
                int trow=row+dir[i][0];
                int tcol=col+dir[i][1];
                
                if(trow>=0 && trow<grid.length && tcol>=0 && tcol<grid[0].length && grid[trow][tcol]==1){
                    dfs(grid,trow,tcol,dir);
                }
            }
            
        }
        
    }

    public static void main(String[] args) {
        
    }
}