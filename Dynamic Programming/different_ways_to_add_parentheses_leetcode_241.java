import java.util.*;
public class different_ways_to_add_parentheses_leetcode_241{

    public List<Integer> diffWaysToCompute(String expression) {
        
        int len=expression.length();
        List<Integer>[][] dp=new ArrayList[len][len];
        
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                dp[i][j]=new ArrayList<>();
            }
        }
        
        return helper(expression,0,len-1,dp);
    }
    
    public List<Integer> helper(String expression,int start,int end,List<Integer>[][] dp){
        
        if(dp[start][end].size()>0){
            return dp[start][end];
        }
        
        else{
            
            List<Integer> ans=new ArrayList<>();
            
            for(int cut=start+1;cut<end;cut++){  
                if(expression.charAt(cut)=='+' || expression.charAt(cut)=='-' || expression.charAt(cut)=='*'){
                    
                    List<Integer> left=helper(expression,start,cut-1,dp);
                    List<Integer> right=helper(expression,cut+1,end,dp);

                    for(int l=0;l<left.size();l++){
                        for(int r=0;r<right.size();r++){
                            int eva=evaluate(left.get(l),right.get(r),expression.charAt(cut));
                            ans.add(eva);
                        }
                    }
                    
                }
            }
            
            if(ans.size()==0){
                ans.add(Integer.parseInt(expression.substring(start,end+1)));
            }
            
            dp[start][end]=ans;
            return ans;
        }
    }
    
    public int evaluate(int left,int right,char operator){
        
        if(operator=='+'){
            return left+right;
        }
        
        else if(operator=='-'){
            return left-right;
        }
        
        else{
            return left*right;
        }
        
    }

}