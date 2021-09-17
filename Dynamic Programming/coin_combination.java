import java.util.*;
public class coin_combination{

    //idx start from length

    //memoization, dp filled withn -1 initially
    public static int func(int target,int[] coins,int idx,int[][] dp){

        if(target==0){
            return dp[idx][target]=1;
        }
        
        else if(dp[idx][target]!=-1){
            return dp[idx][target];
        }

        else{
            int count=0;
            
            for(int i=idx;i>0;i--){
                if(target>=coins[i-1]){
                    count+=func(target-coins[i-1],coins,i,dp);
                }
            }

            return dp[idx][target]=count;
        }

    }

    //Tabulation using 2-d array, dp initially filled with 0
    public static int func_(int Target,int[] coins,int Idx,int[][] dp){

        for(int idx=1;idx<=Idx;idx++){

            for(int target=0;target<=Target;target++){

                if(target==0){
                    dp[idx][target]=1;
                }
                

                else{
                    int count=0;
                    
                    for(int i=idx;i>0;i--){
                        if(target>=coins[i-1]){
                            count+=func(target-coins[i-1],coins,i,dp);
                        }
                    }

                    dp[idx][target]=count;
                }
            
            }
        }
        return dp[Idx][Target];
    }

    //Tabulation using 1-d array, dp initially filled with 0
    public static int func__(int target,int[] coins,int[] dp){
        
        dp[0]=1;
        
        for(int j=0;j<coins.length;j++){
            for(int i=1;i<=target;i++){
                if(i>=coins[j]){
                    dp[i]+=dp[i-coins[j]];
                }
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        System.out.println(func__(10,new int[]{2,3,5},new int[11]));
    }

}