import java.util.*;
public class rotten_orange_leetcode_994{

    class Solution {
        public int orangesRotting(int[][] grid) {
            
            int freshOrange=0;
            int m=grid.length;
            int n=grid[0].length;
            int[][] dir=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
            
            LinkedList<Integer> que=new LinkedList<>();
            
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(grid[i][j]==2){
                        int idx=i*n+j;
                        que.add(idx);
                    }
                    
                    else if(grid[i][j]==1){
                        freshOrange++;
                    }
                }
            }
            
            if(freshOrange==0){
                return 0;
            }
            
            int time=0;
            
            while(que.size()>0){
                
                int size=que.size();
                while(size-->0){
                    
                    int temp=que.remove(0);
                    int row=temp/n;
                    int col=temp%n;
                    
                    for(int i=0;i<dir.length;i++){
                        int trow=row+dir[i][0];
                        int tcol=col+dir[i][1];
                        
                        if(trow>=0 && trow<m && tcol>=0 && tcol<n && grid[trow][tcol]==1){
                            grid[trow][tcol]=2;
                            que.add(trow*n+tcol);
                            freshOrange--;
                            if(freshOrange==0){
                                return time+1;
                            }
                        }
                        
                    }
                    
                }
                time++;
            }
            
            return -1;
        }
    }

    public static void main(String[] args) {
        
    }
}