import java.util.*;
public class perfect_squares_leetcode_279{
    public int numSquares(int n) {
        if(n<3)
            return n;
        
        int[] dp=new int[n+1];
        Arrays.fill(dp,(int)1e9);
        
        dp[1]=1;
        dp[2]=2;
        
        for(int i=3;i<=n;i++){
            
            int sqrt=(int)Math.sqrt(i);
            if(sqrt*sqrt==i){
                dp[i]=1;
            }
            
            else{
                for(int j=1;j*j<i;j++){
                    dp[i]=Math.min(dp[i],1+dp[i-j*j]);
                }
            }
        }
        
        return dp[n];
    }
}