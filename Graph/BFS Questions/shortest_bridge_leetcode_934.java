import java.util.*;

public class shortest_bridge_leetcode_934{

    public int shortestBridge(int[][] grid) {
        
        int n=grid.length,m=grid[0].length;
        int[][] dir=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int[]> que=new LinkedList<>();
        
        boolean b=false;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    dfs(grid,i,j,dir,que);
                    b=true;
                    break;
                }
            }
            
            if(b==true)
                break;
        }
        
        int time=0;
        
        while(que.size()>0){
            
            int size=que.size();
            
            while(size-->0){
                int[] temp=que.remove();
                int row=temp[0];
                int col=temp[1];
                
                for(int[] arr:dir){
                    int tempr=row+arr[0];
                    int tempc=col+arr[1];
                    
                    if(tempr>=0 && tempr<grid.length && tempc>=0 && tempc<grid[0].length && grid[tempr][tempc]!=-1){
                        if(grid[tempr][tempc]==1){
                            return time;
                        }   
                        else{
                            grid[tempr][tempc]=-1;
                            que.add(new int[]{tempr,tempc});
                        }
                    }
                }
            
            }
            time++;
        }
        
        return 0;
    }

    public void dfs(int[][] grid,int row,int col,int[][] dir,Queue<int[]> que){
        
        grid[row][col]=-1;
        
        boolean flag=false;
        
        for(int[] temp:dir){
            int tempr=row+temp[0];
            int tempc=col+temp[1];
            
            if(tempr>=0 && tempr<grid.length && tempc>=0 && tempc<grid[0].length){
                if(grid[tempr][tempc]==1){
                    dfs(grid,tempr,tempc,dir,que);    
                }
                else if(grid[tempr][tempc]==0){
                    flag=true;
                }
            }
                
        }
        
        if(flag==true)
            que.add(new int[]{row,col});
        
    }

}