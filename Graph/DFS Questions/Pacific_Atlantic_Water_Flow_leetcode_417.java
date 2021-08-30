import java.util.*;
public class Pacific_Atlantic_Water_Flow_leetcode_417{

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        int n=heights.length;
        int m=heights[0].length;
        
        boolean[][] pacific=new boolean[n][m];
        boolean[][] atlantic=new boolean[n][m];
        int[][] dir=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if((i==0 || j==0) && pacific[i][j]==false){
                    dfs(i,j,heights,pacific,dir,n,m);
                }
                if((i==n-1 || j==m-1) && atlantic[i][j]==false){
                    dfs(i,j,heights,atlantic,dir,n,m);
                }
            }
        }   
        
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    List<Integer> temp=new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    ans.add(temp);
                }
            }
        }
        
        return ans;
    }
    
    public void dfs(int row,int col,int[][] heights,boolean[][] visited,int[][] dir,int n,int m){
        
        visited[row][col]=true;
        
        for(int[] arr:dir){
            int tempr=row+arr[0];
            int tempc=col+arr[1];
            
            if(tempr>=0 && tempr<n && tempc>=0 && tempc<m && visited[tempr][tempc]==false && heights[tempr][tempc]>=heights[row][col]){
                dfs(tempr,tempc,heights,visited,dir,n,m);
            }
        }
        
    } 

}