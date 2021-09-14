public class Palindrome_Partitioning_4_leetcode_1745{

    public boolean checkPartitioning(String s) {
        
        int len=s.length();

        boolean[][] dp=new boolean[len][len];
        
        for(int i=len-1;i>=0;i--){
            for(int j=i;j<len;j++){
                if(i==j){
                    dp[i][j]=true;
                }
                
                else if(s.charAt(i)!=s.charAt(j)){
                    dp[i][j]=false;
                }
                
                else{
                    if(j-i==1){
                        dp[i][j]=true;
                    }
                    else{
                        dp[i][j]=dp[i+1][j-1];
                    }
                }
            }
        }
        
        Boolean[][] arr=new Boolean[len+1][4];
        
        return func(s,0,3,arr,dp,s.length());
    }
    
    public boolean func(String s,int idx,int k,Boolean[][] arr,boolean[][] dp,int len){
        
        if((len-idx)<k){
            return arr[idx][k]=false;
        }
        
        else if(k==1){
            return arr[idx][k]=dp[idx][s.length()-1];
        }
        
        else if(arr[idx][k]!=null){
            return arr[idx][k];
        }

        else{
            
            boolean ans=false;
            for(int i=idx;i<s.length();i++){
                if(dp[idx][i]==true){
                    ans=ans||func(s,i+1,k-1,arr,dp,len);
                }
            }
            
            arr[idx][k]=ans;
            return ans;
        }
        
    }
    

}