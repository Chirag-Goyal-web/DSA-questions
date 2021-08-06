import java.util.LinkedList;
public class matrix_01_leetcode_542{

    class Solution {
        public int[][] updateMatrix(int[][] mat) {
            
            int m=mat.length;
            int n=mat[0].length;
            boolean[][] visited=new boolean[m][n];
            int count=0;
            LinkedList<Integer> que=new LinkedList<>();
            int[][] dir=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
            
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(mat[i][j]==0){
                        visited[i][j]=true;
                        que.add(i*n+j);
                    }
                    else{
                        count++;
                    }
                }
            }
            
            
            while(que.size()>0){
                int size=que.size();
                
                while(size-->0){
                    int idx=que.remove(0);
                    int row=idx/n;
                    int col=idx%n;
                    
                    for(int i=0;i<dir.length;i++){
                        int tempr=row+dir[i][0];
                        int tempc=col+dir[i][1];
                        
                        if(tempr>=0 && tempr<m && tempc>=0 && tempc<n && visited[tempr][tempc]==false){
                            mat[tempr][tempc]=mat[row][col]+1;
                            visited[tempr][tempc]=true;
                            que.add(tempr*n+tempc);
                            count--;
                            if(count==0){
                                return mat;
                            }
                        }
                    }
                    
                }
            }
            
            return mat;
        }
    }
    
    public static void main(String[] args) {
        
    }
}