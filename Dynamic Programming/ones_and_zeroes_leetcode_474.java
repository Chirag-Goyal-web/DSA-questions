public class ones_and_zeroes_leetcode_474{

    public int findMaxForm(String[] strs, int m, int n) {
        
        int len=strs.length;
        int[][] arr=new int[len][2];
        
        for(int i=0;i<strs.length;i++){
            String temp=strs[i];
            for(int j=0;j<temp.length();j++){
                if(temp.charAt(j)=='0')
                    arr[i][0]++;   
            }
            arr[i][1]=temp.length()-arr[i][0];
        }
        
        Integer[][][] dp=new Integer[len+1][m+1][n+1];
        return helper(arr,len,m,n,dp);
    }
    
    public int helper(int[][] arr,int idx,int m,int n,Integer[][][] dp){
        
        if(idx==0){
            return 0;   
        }
        
        else if(dp[idx][m][n]!=null){
            return dp[idx][m][n];
        }
        
        else{

            int temp1=helper(arr,idx-1,m,n,dp);
            int temp2=0;

            if(arr[idx-1][0]<=m && arr[idx-1][1]<=n)
                temp2=helper(arr,idx-1,m-arr[idx-1][0],n-arr[idx-1][1],dp)+1;

            return dp[idx][m][n]=Math.max(temp1,temp2);
        }

    }

}