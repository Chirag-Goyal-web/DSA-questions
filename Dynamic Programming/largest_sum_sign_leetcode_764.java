import java.util.*;
public class largest_sum_sign_leetcode_764{

    public int orderOfLargestPlusSign(int N, int[][] arr) {
        int m=N;
        int n=N;
        
        int[][] mines=new int[N][N];
        for(int i=0;i<N;i++){
            Arrays.fill(mines[i],1);
        }
        for(int[] k:arr){
            mines[k[0]][k[1]]=0;
        }
        
        int[][] left=new int[m][n];
        int[][] right=new int[m][n];
        int[][] top=new int[m][n];
        int[][] bottom=new int[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(j==0){
                    left[i][j]=mines[i][j];
                }
                else{
                    if(mines[i][j]==0){
                        left[i][j]=0;
                    }
                    else{
                        left[i][j]=left[i][j-1]+1;
                    }
                }
            }
        }
        
        for(int i=0;i<m;i++){
            for(int j=n-1;j>=0;j--){
                if(j==n-1){
                    right[i][j]=mines[i][j];
                }
                else{
                    if(mines[i][j]==0){
                        right[i][j]=0;
                    }
                    else{
                        right[i][j]=right[i][j+1]+1;
                    }
                }
            }
        }
        
        for(int j=0;j<n;j++){
            for(int i=0;i<m;i++){
                if(i==0){
                    top[i][j]=mines[i][j];
                }
                else{
                    if(mines[i][j]==0){
                        top[i][j]=0;
                    }
                    else{
                        top[i][j]=top[i-1][j]+1;
                    }
                }
            }
        }
        
        for(int j=0;j<n;j++){
            for(int i=m-1;i>=0;i--){
                if(i==m-1){
                    bottom[i][j]=mines[i][j];
                }
                else{
                    if(mines[i][j]==0){
                        bottom[i][j]=0;
                    }
                    else{
                        bottom[i][j]=bottom[i+1][j]+1;
                    }
                }
            }
        }
     
        int max=0;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || i==n-1 || j==0||j==m-1){
                    max=Math.max(max,mines[i][j]);
                }
                else{
                    if(mines[i][j]==1){
                        int min=getMin(left[i][j-1],right[i][j+1],bottom[i+1][j],top[i-1][j]);
                        max=Math.max(max,min+1);
                    }
                }
            }         
        }
        
        return max;
    }
    
    public int getMin(int... arr){
        int min=arr[0];
        
        for(int i:arr){
            min=Math.min(min,i);
        }
        
        return min;
    }

}