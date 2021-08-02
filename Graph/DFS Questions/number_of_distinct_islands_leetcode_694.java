import java.util.HashMap;

public class number_of_distinct_islands_leetcode_694{

    public class Solution {
    
        public int numberofDistinctIslands(int[][] grid) {
    
            String[] name=new String[]{"R","D","L","U"};
            int[][] dir=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    
            int m=grid.length;
            int n=grid[0].length;
            int count=0;
    
            HashMap<String,Integer> hm=new HashMap<>();
    
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
    
                    if(grid[i][j]==1){
                        
                        StringBuilder str=new StringBuilder("");
                        dfs(i,j,grid,name,dir,m,n,str);
                        
                        String temp=str.toString();
    
                        if(!hm.containsKey(temp)){
                            count++;
                            hm.put(temp,1);
                        }
    
                    }
                }
            }
    
            return count;
    
        }
    
        public void dfs(int r,int c,int[][] grid,String[] name,int[][] dir,int m,int n,StringBuilder str){
    
            grid[r][c]=0;
    
            for(int i=0;i<dir.length;i++){
    
                int tempr=r+dir[i][0];
                int tempc=c+dir[i][1];
    
                if(tempr>=0 && tempr<m && tempc>=0 && tempc<n && grid[tempr][tempc]==1){
                    str.append(name[i]);
                    dfs(tempr,tempc,grid,name,dir,m,n,str);
                }
    
            }
    
            str.append("N");
    
        }
    
    }

    public static void main(String[] args) {
        
    }
}