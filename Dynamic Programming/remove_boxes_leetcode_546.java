public class remove_boxes_leetcode_546{
    
    public int removeBoxes(int[] boxes) {
        int len=boxes.length;
        Integer[][][] dp=new Integer[len][len][len+1];
        return helper(0,len-1,0,boxes,dp);
    }
    
    public int helper(int start,int end,int count,int[] boxes,Integer[][][] dp){
        
        if(start>end){
            return 0;
        }
        
        else if(dp[start][end][count]!=null){
            return dp[start][end][count];
        }
        
        else{
            int i;
            //Necessary to store result in dp, bcoz we are modifying count
            int prevC=count;
            
            for(i=start;i<end;i++){
                if(boxes[i]==boxes[i+1]){
                    count++;
                }
                else{
                    break;
                }
            }
            
            int ans=(count+1)*(count+1)+helper(i+1,end,0,boxes,dp);
            
            for(int m=i+1;m<=end;m++){
                if(boxes[m]==boxes[i]){
                    ans=Math.max(ans,helper(m,end,count+1,boxes,dp)+helper(i+1,m-1,0,boxes,dp));
                }
            }
            
            return dp[start][end][prevC]=ans;
        }
        
    }
}