import java.util.*;
public class the_maze_leetcode_490{
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        
        int n=maze.length;
        int m=maze[0].length;

        Queue<int[]> pq=new LinkedList<>();
        pq.add(new int[]{start[0],start[1]});
       
        int[][] dir=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        boolean[][] visited=new boolean[n][m];
       
        visited[start[0]][start[1]]=true;

        while(pq.size()>0){
            
            int[] temp=pq.remove();

            if(temp[0]==destination[0] && temp[1]==destination[1]){
                return true;
            }

            else{

                for(int i=0;i<4;i++){
                    
                    int row=temp[0],col=temp[1];
                    
                    //Keep moving while wall is reached
                    while(row>=0 && row<n && col>=0 && col<m && maze[row][col]==0){
                        row+=dir[i][0];
                        col+=dir[i][1];
                    }
                    
                    //Go one step back
                    row-=dir[i][0];
                    col-=dir[i][1];

                    if(visited[row][col]==true)
                        continue;

                    else{
                        visited[row][col]=true;
                        pq.add(new int[]{row,col});
                    }

                }
            }

        }
        
        return false;
    }
}