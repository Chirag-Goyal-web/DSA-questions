import java.util.*;
public class longest_increasing_path_in_a_matrix_leetcode_329{

    //Using DFS+Mempization (Without memoization, it gives TLE)
    class Solution_1{
        public int longestIncreasingPath(int[][] matrix) {
            
            int m=matrix.length,n=matrix[0].length;
            
            int[][] dir=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

            int[][] cache=new int[m][n];
            
            int ans=0;
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(cache[i][j]==0){
                        int temp=dfs(i*n+j,matrix,m,n,dir,cache);
                        ans=Math.max(ans,temp); 
                    }
                }
            }
            
            return ans;
        }
        
        public int dfs(int src,int[][] matrix,int m,int n,int[][] dir,int[][] cache){
        
            int count=0;
            int row=src/n;
            int col=src%n;
            
            if(cache[row][col]!=0)
                return cache[row][col];
            
            for(int i=0;i<dir.length;i++){
                int tempr=row+dir[i][0];
                int tempc=col+dir[i][1];
                if(tempr>=0 && tempr<m && tempc>=0 && tempc<n && matrix[tempr][tempc]>matrix[row][col]){
                    int t=dfs(tempr*n+tempc,matrix,m,n,dir,cache);
                    count=Math.max(count,t);
                }
            }
            
            cache[row][col]=count+1;
            return count+1;
        }
        
    }

    class Solution_2{
        public int longestIncreasingPath(int[][] matrix) {
            
            int m=matrix.length,n=matrix[0].length;
            
            int[][] dir=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
            int[][] indegree=new int[m][n];
            
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    for(int k=0;k<4;k++){
                        int tempr=i+dir[k][0];
                        int tempc=j+dir[k][1];
                        if(tempr>=0 && tempr<m && tempc>=0 && tempc<n && matrix[tempr][tempc]<matrix[i][j]){
                            indegree[i][j]++;
                        }
                    }
                }
            }
    
            LinkedList<Integer> que=new LinkedList<>();
            
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(indegree[i][j]==0)
                        que.add(i*n+j);
                }
            }
            
            int level=0;
            while(que.size()>0){
                int size=que.size();
                while(size-->0){
                    int temp=que.remove(0);
                    int r=temp/n;
                    int c=temp%n;
                    
                    for(int k=0;k<4;k++){
                        int tempr=r+dir[k][0];
                        int tempc=c+dir[k][1];
                        if(tempr>=0 && tempr<m && tempc>=0 && tempc<n && matrix[tempr][tempc]>matrix[r][c]){
                            if(--indegree[tempr][tempc]==0)
                                que.add(tempr*n+tempc);
                        }
                    }
                    
                }
                level++;
            }
            
            return level;
        }
        
    }

}