import java.util.*;
public class walls_and_gates_leetcode_286{

    public class Solution {

        public void wallsAndGates(int[][] mat) {
            int m=mat.length;
            int n=mat[0].length;
            LinkedList<Integer> que=new LinkedList<>();
            int[][] dir=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(mat[i][j]==0){
                        que.add(i*n+j);
                    }
                }
            }
            
            while(que.size()>0){
                
                int idx=que.remove(0);
                int row=idx/n;
                int col=idx%n;
                    
                for(int i=0;i<dir.length;i++){
                    int tempr=row+dir[i][0];
                    int tempc=col+dir[i][1];
                    
                    if(tempr>=0 && tempr<m && tempc>=0 && tempc<n && mat[tempr][tempc]==2147483647){
                        mat[tempr][tempc]=mat[row][col]+1;
                        que.add(tempr*n+tempc);
                    }
                }
                    
                
            }
            
           
    
        }
    }

    public static void main(String[] args) {
        
    }
}