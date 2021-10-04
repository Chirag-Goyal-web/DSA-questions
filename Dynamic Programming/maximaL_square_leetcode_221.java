public class maximaL_square_leetcode_221{

    //TLE- Memoization
    class Solution {
    
        public int maximalSquare(char[][] matrix) {
            int m=matrix.length;
            int n=matrix[0].length;
            
            if(m==n){
                Pair[][][] dp=new Pair[m+1][m+1][m+1];
                Pair ans=helper(0,0,m,matrix,dp);
                return ans.max;
            }
            
            else{
                if(m>n){
                    Pair[][][] dp=new Pair[m+1][n+1][n+1];
                    int ans=0;
                    
                    for(int i=0;i+n<=m;i++){
                        Pair temp=helper(i,0,n,matrix,dp);
                        ans=Math.max(ans,temp.max);
                    }
                    
                    return ans;
                }
                
                else{
                    Pair[][][] dp=new Pair[m+1][n+1][m+1];
                    int ans=0;
                    
                    for(int i=0;i+m<=n;i++){
                        Pair temp=helper(0,i,m,matrix,dp);
                        ans=Math.max(ans,temp.max);
                    }
                    
                    return ans;
                }
            }
        }
        
        public Pair helper(int row,int col,int len,char[][] matrix,Pair[][][] dp){
            
            if(len==1){
                if(matrix[row][col]=='1'){
                    return new Pair(true,1);
                }
                else{
                    return new Pair(false,0);
                }
            }
    
            else if(dp[row][col][len]!=null){
                System.out.println("HI");
                return dp[row][col][len];
            }
            
            else{
                Pair temp1=helper(row, col, len-1, matrix, dp);
                Pair temp2=helper(row+1,col,len-1,matrix,dp);
                Pair temp3=helper(row,col+1,len-1,matrix,dp);
                Pair temp4=helper(row+1,col+1,len-1,matrix,dp);
                
                boolean ans=false;
                ans=temp1.isSquare&&temp2.isSquare&&temp3.isSquare&&temp4.isSquare;
                
                int max=0;
                max=getMax(temp1.max,temp2.max,temp3.max,temp4.max);
                
                if(ans==true){
                    max=Math.max(max,len*len);
                }
    
                return dp[row][col][len]=new Pair(ans,max);
            }
        }
        
        public class Pair{
            boolean isSquare;
            int max;
    
            Pair(boolean isSquare,int max){
                this.isSquare=isSquare;
                this.max=max;
            }
        }
    
        public int getMax(int... arr){
            int max=arr[0];
            for(int i:arr){
                max=Math.max(max,i);
            }
            return max;
        }
    
    }

    //Memoization diiferent approach
    class Solution_ {
        public int maximalSquare(char[][] matrix) {
            int m=matrix.length;
            int n=matrix[0].length;
            Integer[][] dp=new Integer[m][n];
            
            helper(0,0,m,n,matrix,dp);
            
            int max=0;
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    max=Math.max(max,dp[i][j]);
                }
            }
            
            return max*max;
        }
        
        public int helper(int row,int col,int m,int n,char[][] matrix,Integer[][] dp){
            
            if(row>=m || col>=n){
                return 0;
            }
            
            else if(dp[row][col]!=null){
                return dp[row][col];
            }
            
            else{
                int temp1=helper(row,col+1,m,n,matrix,dp);
                int temp2=helper(row+1,col,m,n,matrix,dp);
                int temp3=helper(row+1,col+1,m,n,matrix,dp);
                
                int min=Math.min(temp1,Math.min(temp2,temp3));
                
                if(matrix[row][col]=='0'){
                    return dp[row][col]=0;
                }
                else{
                    return dp[row][col]=min+1;
                }   
            }
        }
    }

}