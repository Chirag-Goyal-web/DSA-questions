import java.util.*;
public class Form_Largest_Integer_With_Digits_That_Add_up_to_Target{

    public String largestNumber(int[] cost, int target) {
        
        String[] dp=new String[target+1];
        Arrays.fill(dp,"");
        String ans= helper(cost,target,dp);

        return ans;
    }
    
    public String helper(int[] cost,int target,String[] dp){
        
        if(target==0){
            return "";
        }
        
        else if(dp[target]!=""){
            return dp[target];
        }
        
        else{
            
            String ans="0";
            
            for(int i=0;i<9;i++){
                
                if(target>=cost[i]){
                    String temp=helper(cost,target-cost[i],dp);
                    
                    if(!temp.equals("0")){
                        temp=temp+(i+1);
                        
                        if(temp.length()>ans.length()){
                            ans=temp;
                        }
                        
                        else if(temp.length()==ans.length() && temp.compareTo(ans)>0){
                            ans=temp;       
                        }
                    }
                }
                
            }
            
            dp[target]=ans;
            return ans;
        }
        
    }

}