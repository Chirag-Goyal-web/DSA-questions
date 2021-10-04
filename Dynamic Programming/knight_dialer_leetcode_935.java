import java.util.*;

public class knight_dialer_leetcode_935{
    int mod=(int)(1e9+7);
    
    public int knightDialer(int N) {
        
		int[][] dp=new int[12][N+1];
		
		for(int i=0;i<12;i++){
		    Arrays.fill(dp[i],-1);
		}
		
		long ans=0;
		int[][] dir=new int[][]{{2,1},{2,-1},{-2,1},{-2,-1},{1,2},{-1,2},{1,-2},{-1,-2}};
		
		for(int i=0;i<12;i++){
		    ans=(ans+helper(i,N,dp,dir))%mod;
		}
		
		return (int)ans;
    }
    
    public int helper(int idx,int k,int[][] dp,int[][] dir){
	    
	    if(idx==9 || idx==11){
	        return 0;
	    }
	    
	    else if(dp[idx][k]!=-1){
	        return dp[idx][k];
	    }
	    
	    else if(k==1){
	        return dp[idx][k]=1;
	    }
	    
	    else{  
	        int row=idx/3;
	        int col=idx%3;
	        long ans=0;
	        	        
	        for(int[] temp:dir){
	            int trow=row+temp[0];
	            int tcol=col+temp[1];
	            
	            if(trow>=0 && trow<4 && tcol>=0 && tcol<3){
                    ans=(ans+helper(trow*3+tcol,k-1,dp,dir))%mod;    
                }       
	        }
	        return dp[idx][k]=(int)ans;
	    }
	    
	}
}  