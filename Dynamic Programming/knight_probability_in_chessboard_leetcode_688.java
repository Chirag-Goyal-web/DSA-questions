public class knight_probability_in_chessboard_leetcode_688{

    public double knightProbability(int n, int k, int row, int column) {
        int[] dx=new int[]{2,2,-2,-2,1,-1,1,-1};
        int[] dy=new int[]{-1,1,-1,1,2,2,-2,-2};
        Double[][][] dp=new Double[n+1][n+1][k+1];
        
        double count=helper(row,column,dx,dy,n,k,dp);
        return (count)/(Math.pow(8,k));
    }
    
    public double helper(int row,int col,int[] dx,int[] dy,int n,int k,Double[][][] dp){
        
        if(k==0){
            return dp[row][col][k]=1.0;
        }
        
        else if(dp[row][col][k]!=null){
            return dp[row][col][k];
        }
        
        else{
            
            double count=0;
            
            for(int i=0;i<8;i++){
                int tempr=row+dx[i];
                int tempc=col+dy[i];
                
                //This check is necessary bcoz one we move out of board, then we can't move in
                if(tempr>=0 && tempr<n && tempc>=0 && tempc<n){
                    count+=helper(tempr,tempc,dx,dy,n,k-1,dp);   
                }
            }
            
            dp[row][col][k]=count;
            return count;
        }
        
    }

}