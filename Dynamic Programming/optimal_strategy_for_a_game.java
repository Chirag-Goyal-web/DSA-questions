public class optimal_strategy_for_a_game{

    static long countMaximum(int arr[], int n){
        Pair[][] dp=new Pair[n][n];
        Pair ans=helper(arr,0,arr.length-1,dp,0);
        return ans.firstP;
    }
    
    public static Pair helper(int[] arr,int start,int end,Pair[][] dp,int turn){

        if(start==end){
            return dp[start][end]=new Pair(0,arr[start]);
        }
        
        else if(dp[start][end]!=null){
            return dp[start][end];
        }

        else{
            Pair p1=helper(arr,start,end-1,dp,(turn+1)%2);
            Pair p2=helper(arr,start+1,end,dp,(turn+1)%2);
            Pair ans;

            if(turn==0){
                if(p1.firstP+arr[end]>p2.firstP+arr[start]){
                    ans= new Pair(p1.firstP+arr[end],p1.secP);
                }
                else{
                    ans= new Pair(p2.firstP+arr[start],p2.secP);
                }
            }

            else{
                if(p1.secP+arr[end]>p2.secP+arr[start]){
                    ans= new Pair(p1.firstP,p1.secP+arr[end]);
                }
                else{
                    ans= new Pair(p2.firstP,p2.secP+arr[start]);
                }
            }

            return dp[start][end]=ans;
        }
    } 

    static class Pair{
        long firstP;
        long secP;
        
        Pair(long f,long s){
            this.firstP=f;
            this.secP=s;
        }
    }

    public static void main(String[] args) {
        int[] arr=new int[]{8,15,3,7};
        System.out.println(countMaximum(arr, 4));
    }

}