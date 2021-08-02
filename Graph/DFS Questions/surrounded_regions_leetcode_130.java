public class surrounded_regions_leetcode_130{

    class Solution {
    
        public void solve(char[][] board) {
            
            int m=board.length;
            int n=board[0].length;
            int[][] dir=new int[][]{{1,0},{-1,0},{0,-1},{0,1}};
            
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(i==0||i==m-1||j==0||j==n-1){
                        if(board[i][j]=='O'){
                            dfs(i,j,board,dir,m,n);
                        }            
                    }
                }
            }
            
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(board[i][j]=='O'){
                        board[i][j]='X';
                    }
                    else if(board[i][j]=='$'){
                        board[i][j]='O';
                    }
                }
            }
        
        }
        
        public void dfs(int r,int c,char[][] board,int[][] dir,int m,int n){
            
            board[r][c]='$';
            
            for(int i=0;i<dir.length;i++){
                
                int tempr=r+dir[i][0];
                int tempc=c+dir[i][1];
                
                if(tempr>=0 && tempr<m && tempc>=0 && tempc<n && board[tempr][tempc]=='O'){
                    dfs(tempr,tempc,board,dir,m,n);
                }
                
            }
            
        }
        
    }
    
    public static void main(String[] args) {
        
    }
}