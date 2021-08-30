import java.util.*;
public class Making_A_Large_Island_leetcode_827{

    public int largestIsland(int[][] grid) {
        
        int n=grid.length,m=grid[0].length;
        
        int[] par=new int[n*m];
        int[] size=new int[n*m];
        
        int[][]dir=new int[][]{{1,0},{0,1}};
        int ans=1;
    
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    size[i*m+j]=1;
                }
                par[i*m+j]=i*m+j;
            }
        }
        
        //Union find on the iven grid
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
    
                    for(int[] arr:dir){
                        int tempr=i+arr[0];
                        int tempc=j+arr[1];
                        
                        if(tempr>=0 && tempr<n && tempc>=0 && tempc<m && grid[tempr][tempc]==1){
                            
                            int p1=findPar(tempr*m+tempc,par);
                            int p2=findPar(i*m+j,par);
                            
                            if(p1!=p2){
                                par[p1]=p2;
                                size[p2]+=size[p1];
                                ans=Math.max(ans,size[p2]);
                            }
                            
                        }
                    }
                    
                }
            }
        }
        
        int[][] direc=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        
        //Try to change 0 into 1 and merge the surrounding islands
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                
                if(grid[i][j]==0){
                    
                    Set<Integer> parent=new HashSet<>();
                    for(int[] temp:direc){
                        int tempRow=i+temp[0];
                        int tempCol=j+temp[1];
                        
                        if(tempRow>=0 && tempRow<n && tempCol>=0 && tempCol<m && grid[tempRow][tempCol]==1){
                            int p=findPar(tempRow*m+tempCol,par);                     
                            parent.add(p);
                        }
                    }
                    
                    int tempAns=1;
                    for(int v:parent){
                        tempAns+=size[v];
                    }
                    
                    ans=Math.max(ans,tempAns);
                }
            }
        }
        
        return ans;
    }
    
    public int findPar(int u,int[] par){
        if(par[u]==u)
            return u;
        
        else{
            int temp=findPar(par[u],par);
            par[u]=temp;
            return temp;
        }
    }   

}
