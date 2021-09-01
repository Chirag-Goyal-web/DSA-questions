import java.util.*;
public class Nearest_Exit_from_Entrance_in_Maze_leetcode_1926{
    
    public int nearestExit(char[][] maze, int[] entrance) {
        
        int n=maze.length,m=maze[0].length;
        int[][] dir=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        Queue<Integer> que=new LinkedList<>();

        que.add(entrance[0]*m+entrance[1]);
        maze[entrance[0]][entrance[1]]='+';

        int level=0;
        
        while(que.size()>0){
            level++;
            int size=que.size();
            
            while(size-->0){
                
            int temp=que.remove();
            int row=temp/m;
            int col=temp%m;
            
                for(int[] arr:dir){
                    int tempr=row+arr[0];
                    int tempc=col+arr[1];

                    if(tempr>=0 && tempr<n && tempc>=0 && tempc<m && maze[tempr][tempc]=='.'){
                        que.add(tempr*m+tempc);
                        maze[tempr][tempc]='+';
                        if(tempr==0 || tempr==n-1 || tempc==0|| tempc==m-1){
                            return level;
                        }
                    }
                }
            
            }
        }

        return -1;
    }
} 