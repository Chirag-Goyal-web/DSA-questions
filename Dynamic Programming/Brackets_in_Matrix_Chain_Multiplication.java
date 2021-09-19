public class Brackets_in_Matrix_Chain_Multiplication{

    static String matrixChainOrder(int arr[], int N){
        int[][] dp=new int[N][N];
        
        return helper(arr,dp,N-1);
    }
    
    static String helper(int[] arr,int[][] dp,int N){
        
        String[][] str=new String[N+1][N+1];
        
        for(int start=N;start>=0;start--){
            for(int end=start;end<=N;end++){
                
                if(Math.abs(start-end)==1){
                    dp[start][end]=0;
                    str[start][end]=((char)(start+'A'))+"";
                }

                else{
                    
                    int ans=Integer.MAX_VALUE;
                    String tempStr="";
                    
                    for(int i=start+1;i<=end-1;i++){
                        
                        int temp1=dp[start][i];
                        int temp2=dp[i][end];
                        
                        if(temp1+temp2+arr[start]*arr[i]*arr[end]<ans){
                            ans=temp1+temp2+arr[start]*arr[i]*arr[end];
                            tempStr="("+str[start][i]+str[i][end]+")";
                        }
                    }
                    
                    str[start][end]=tempStr;
                    dp[start][end]=ans;
                }
                
            }
        }
        
        return str[0][N];
    }

}