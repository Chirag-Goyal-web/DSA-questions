public class basic{

    public static int mazePath(int crow,int ccol,int drow,int dcol,int[] dp){
        if(crow>drow || ccol>dcol){
            return 0;
        }

        else if(crow==drow && ccol==dcol){
            dp[crow*(dcol+1)+ccol]=1;
            return 1;
        }

        else{
            int v=mazePath(crow+1,ccol,drow,dcol,dp);
            int h=mazePath(crow,ccol+1,drow,dcol,dp);
            int d=mazePath(crow+1,ccol+1,drow,dcol,dp);
            dp[crow*(dcol+1)+ccol]=1;
            return v+h+d;
        }
    }

    public static int mazePathJump(int crow,int ccol,int drow,int dcol,int[] dp){
        if(crow>drow || ccol>dcol){
            return 0;
        }

        else if(crow==drow && ccol==dcol){
            dp[crow*(dcol+1)+ccol]=1;
            return 1;
        }

        else{
            int v=mazePath(crow+1,ccol,drow,dcol,dp);
            int h=mazePath(crow,ccol+1,drow,dcol,dp);
            int d=mazePath(crow+1,ccol+1,drow,dcol,dp);
            dp[crow*(dcol+1)+ccol]=1;
           
            int sum=0;

            for(int i=crow+1;i<=drow;i++){
                sum+=mazePathJump(i, ccol, drow, dcol, dp);
            }

            for(int i=ccol+1;i<=dcol;i++){
                sum+=mazePathJump(crow, ccol+1, drow, dcol, dp);
            }
            
            for(int i=crow+1,j=ccol+1; i<=drow && j<=dcol;i++,j++){
                sum+=mazePathJump(i, j, drow, dcol, dp);
            }

            dp[]=sum;
            
            return sum;
        }
    }


}