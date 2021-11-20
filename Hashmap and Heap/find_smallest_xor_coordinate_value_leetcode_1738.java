import java.util.*;
public class find_smallest_xor_coordinate_value_leetcode_1738{
    public int kthLargestValue(int[][] matrix, int k) {
        int row=matrix.length;
        int col=matrix[0].length;
        int[][] dp=new int[row][col];
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                int temp=matrix[i][j];
                if(i-1>=0 && j-1>=0){
                    temp^=dp[i-1][j-1];
                }
                if(i-1>=0){
                    temp^=dp[i-1][j];
                }
                if(j-1>=0){
                    temp^=dp[i][j-1];
                }
                
                dp[i][j]=temp;
            }
        }
   
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                pq.add(dp[i][j]);
                if(pq.size()>k){
                    pq.remove();
                }
            }
        }
        
        return pq.peek();
    }
}