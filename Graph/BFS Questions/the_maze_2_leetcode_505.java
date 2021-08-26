import java.util.*;

public class the_maze_2_leetcode_505{

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        
        int n=maze.length;
        int m=maze[0].length;

        //{source,destination,weight}
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            return a[2]-b[2];
        });
        
        int[][] dir=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        
        int[][] distance=new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                distance[i][j]=(int)1e9;
            }
        }

        pq.add(new int[]{start[0],start[1],0});
        distance[start[0]][start[1]]=0;

        while(pq.size()>0){
            
            int[] temp=pq.remove(); 
            
            if(temp[0]==destination[0] && temp[1]==destination[1]){
                return temp[2];
            }

            else{

                for(int i=0;i<4;i++){
                    int row=temp[0],col=temp[1];
                    int cost=0;
                    
                    while(row>=0 && row<n && col>=0 && col<m && maze[row][col]==0){
                        row+=dir[i][0];
                        col+=dir[i][1];
                        cost++;
                    }
                    
                    cost--;
                    row-=dir[i][0];
                    col-=dir[i][1];

                    if(distance[row][col]>cost+temp[2]){
                        distance[row][col]=cost+temp[2];
                        pq.add(new int[]{row,col,cost+temp[2]});
                    }
                        

                }
            }

        }
        
        return -1;

    }

}