import java.util.*;
public class Kth_Smallest_Element_in_a_Sorted_Matrix_leetcode_378{
    public int kthSmallest(int[][] matrix, int k) {
        int n=matrix.length;
        
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{
            return matrix[a/n][a%n]-matrix[b/n][b%n];
        });
        
        int t=0;
        for(int i=0;i<n;i++){
            pq.add(t);
            t+=n;
        }
        
        while(--k>0){
            int idx=pq.remove();            
            int row=idx/n;
            int col=idx%n;
            
            if(col+1<n){
                idx=row*n+col+1;
                pq.add(idx);
            }
        }
        
        return matrix[pq.peek()/n][pq.peek()%n];
    }
}