import java.util.*;
public class the_maze_3_leetcode_499{

    public class Pair{
        int row;
        int col;
        int cost;
        String psf="";
        
        Pair(int row,int col,int cost,String psf){
            this.row=row;
            this.col=col;
            this.cost=cost;
            this.psf=psf;
        }
    }
    
    public String findShortestWay(int[][] maze, int[] start, int[] destination) {
        
        int n=maze.length;
        int m=maze[0].length;

        //{source,destination,weight}
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->{
            if(a.cost!=b.cost){
                return a.cost-b.cost;
            }
            else{
                return a.psf.compareTo(b.psf);
            }
        });
        
        int[][] dir=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        String[] name=new String[]{"d","u","r","l"};
        int[][] distance=new int[n][m];
        String[][] str=new String[n][m];
    
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                distance[i][j]=(int)1e9;
                str[i][j]="";
            }
        }  

        pq.add(new Pair(start[0],start[1],0,""));
        distance[start[0]][start[1]]=0;

        while(pq.size()>0){
            
            Pair temp=pq.remove(); 

            if(temp.row==destination[0] && temp.col==destination[1]){
                return temp.psf;
            }
        
            else{

                for(int i=0;i<4;i++){
                    int row=temp.row,col=temp.col;
                    int cost=0;
                    
                    while(row>=0 && row<n && col>=0 && col<m && maze[row][col]==0 && !(row==destination[0] && col==destination[1])){
                        row+=dir[i][0];
                        col+=dir[i][1];
                        cost++;
                    }

                    //If we have reached destination, i.e. hole no need to go one step back                    
                    if(!(row==destination[0] && col==destination[1])){
                        cost--;
                        row-=dir[i][0];
                        col-=dir[i][1];
                    }

                    if(distance[row][col]>cost+temp.cost){
                        distance[row][col]=cost+temp.cost;
                        str[row][col]=temp.psf+name[i];
                        pq.add(new Pair(row,col,cost+temp.cost,temp.psf+name[i]));
                    }
                    
                    else if((distance[row][col]==cost+temp.cost) && (str[row][col].compareTo(temp.psf+name[i]))>0){
                        str[row][col]=temp.psf+name[i];
                        pq.add(new Pair(row,col,cost+temp.cost,temp.psf+name[i]));
                    }

                }
            }

        }
        
        return "impossible";

    }

}