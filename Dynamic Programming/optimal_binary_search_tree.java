public class optimal_binary_search_tree{
    
    public static int optimalTree(int[] arr,int[] freq){

        int len=arr.length;
        Integer[][] dp=new Integer[len][len];

        return helper(0,len-1,dp,freq);
    }

    public static int helper(int start,int end,Integer[][] dp,int[] freq){
        
        if(start>end){
            return 0;
        }
        
        else if(dp[start][end]!=null){
            return dp[start][end];
        }

        else{
            int sum=0;
            int ans=Integer.MAX_VALUE;
            
            for(int i=start;i<=end;i++){
                int left=helper(start,i-1,dp,freq);
                int right=helper(i+1,end,dp,freq);
                ans=Math.min(ans,left+right);
                sum+=freq[i];
            }

            return dp[start][end]=ans+sum;
        }
        
    }

    public static void main(String[] args) {
        int[] arr=new int[]{10,12};
        int[] freq=new int[]{34,50};

        int ans=optimalTree(arr,freq);
        System.out.println(ans);
    }

}