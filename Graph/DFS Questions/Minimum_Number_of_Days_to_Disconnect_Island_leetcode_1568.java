public class Minimum_Number_of_Days_to_Disconnect_Island_leetcode_1568{

    int[][] dir=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    int[][] disc;
    int[][] low;
    boolean[][] visited;
    int time=0;
    int[][] arti;
    
    public int minDays(int[][] grid) {
        
        int n=grid.length,m=grid[0].length;
        disc=new int[n][m];
        low=new int[n][m];
        visited=new boolean[n][m];
        boolean flag=false;
        time=0;
        arti=new int[n][m];
        int count=0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                
                if(grid[i][j]==1 && visited[i][j]==false){
                    //If we are again calling, it means graph is already disconnected
                    if(flag==true){
                        return 0;
                    }
                    
                    else{
                        //To handle root case
                        arti[i][j]=-1;
                        int temp=i*m+j;
                        articulation(grid,temp,-1,n,m);
                        flag=true;
                    }
                }
                //Count number of ones for later use
                if(grid[i][j]==1){
                    count++;
                }  
            }
        }
        
        if(count<=2)
            return count;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arti[i][j]>0)
                    return 1;
            }
        }
        
        return 2;
    }
    
    public void articulation(int[][] grid,int src,int parent,int n,int m){
        time++;
        int row=src/m;
        int col=src%m;
        int prow=parent/m;
        int pcol=parent%m;
        disc[row][col]=time;
        low[row][col]=time;
        visited[row][col]=true;
        
        for(int[] temp:dir){
            int tempr=row+temp[0];
            int tempc=col+temp[1];
            
            if(tempr<0 || tempr>=n || tempc<0 || tempc>=m || (tempr==prow && tempc==pcol) || grid[tempr][tempc]==0){
                continue;
            }
            
            else if(visited[tempr][tempc]==true){
                low[row][col]=Math.min(low[row][col],disc[tempr][tempc]);
            }
            
            else{
                articulation(grid,tempr*m+tempc,src,n,m);
                low[row][col]=Math.min(low[row][col],low[tempr][tempc]);
                
                if(low[tempr][tempc]>=disc[row][col]){
                    arti[row][col]++;
                }
                
            }
            
        }
        
    }


}