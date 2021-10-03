public class maximize_the_cut_segments{

    public int maximizeCuts(int n, int x, int y, int z){
        Integer[] dp=new Integer[n+1];
        int ans=helper(n,x,y,z,dp);
        
        if(ans==Integer.MIN_VALUE){
            return 0;
        }
        else{
            return ans;
        }
    }
    
    public int helper(int n,int x,int y,int z,Integer[] dp){
        
        if(n==0){
            return 0;
        }
        
        else if(dp[n]!=null){
            return dp[n];
        }
        
        else{
            
            int seg1=Integer.MIN_VALUE;
            int seg2=Integer.MIN_VALUE;
            int seg3=Integer.MIN_VALUE;
            
            if(x<=n){
                seg1=helper(n-x,x,y,z,dp);
            }
               
            if(y<=n){
                seg2=helper(n-y,x,y,z,dp);
            }
             
            if(z<=n){
                seg3=helper(n-z,x,y,z,dp);
            }
            
            int ans=Math.max(seg1,Math.max(seg2,seg3));
            
            if(ans==Integer.MIN_VALUE){
                return dp[n]=ans;
            }        
            else{
                return dp[n]=ans+1;
            }
               
        }
    }

}