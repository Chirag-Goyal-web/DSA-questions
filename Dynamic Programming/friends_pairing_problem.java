public class friends_pairing_problem{

    //Memoization
    public static long helper(int n,long[] dp){
        
        if(n==0 || n==1){
            return 1;
        }
        
        else if(dp[n]!=0){
            return dp[n];
        }
        
        else{
            
            long t1=helper(n-1,dp);
            long t2=helper(n-2,dp);
            long ans=t1+(n-1)*t2;
            
            ans=ans%1000000007;
            dp[n]=ans;
            return ans;
        }
        
    }

    //Tabulation
    public static long helper_(int N,long[] dp){
     
     
        for(int n=0;n<=N;n++){
           
           if(n==0 || n==1){
               dp[n]=1;
               continue;
           }

           else{
               
               long t1=dp[n-1];
               long t2=dp[n-2];
               long ans=t1+(n-1)*t2;
               
               ans=ans%1000000007;
               dp[n]=ans;
           }
        
        }
        return dp[N];
   }

   //Optimization
   public static long helper__(int N,long[] dp){
     
        long a=1,b=0;
        for(int n=1;n<=N;n++){
            
            if(n==1){
                a=1;
                b=1;
            }

            else{
            long ans=a+(n-1)*b;
            ans=ans%1000000007;
            b=a;
            a=ans;
            }
        
        }
     
        return a;
    }

}