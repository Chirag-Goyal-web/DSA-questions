public class range_sum_query_leetcode_304{

    class NumMatrix {
    
        int[][] prefix;
        
        public NumMatrix(int[][] matrix) {
            int m=matrix.length;
            int n=matrix[0].length;
            prefix=new int[m][n];
            
            for(int i=0;i<m;i++){
                prefix[i][0]=matrix[i][0];
                
                for(int j=1;j<n;j++){
                    prefix[i][j]+=(prefix[i][j-1]+matrix[i][j]);
                }
            }
            
            for(int j=0;j<n;j++){
                for(int i=1;i<m;i++){
                    prefix[i][j]+=prefix[i-1][j];
                }
            }
            
        }
        
        
        public int sumRegion(int row1, int col1, int row2, int col2) {
            int totalSum=prefix[row2][col2];
     
            if(col1>0){
                totalSum-=prefix[row2][col1-1];
            }
            
            if(row1>0){
                totalSum-=prefix[row1-1][col2];
            }
            
            if(row1>0 && col1>0){
                totalSum+=prefix[row1-1][col1-1];
            }
            
            return totalSum;
        }
    }

}