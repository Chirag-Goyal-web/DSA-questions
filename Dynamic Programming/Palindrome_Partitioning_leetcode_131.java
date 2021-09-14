import java.util.*;
public class Palindrome_Partitioning_leetcode_131{

    public List<List<String>> partition(String s) {
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
        
        List<List<String>> ans=new ArrayList<>();
        List<String> temp=new ArrayList<>();
        
        func(s,0,ans,temp,dp);
        
        return ans;
    }
    
    public void func(String s,int idx,List<List<String>> ans,List<String> temp,boolean[][] dp){
        
        if(idx==s.length()){
            List<String> ls=new ArrayList<>(temp);
            ans.add(ls);
        }
        
        else{
            
            for(int i=idx;i<s.length();i++){
                if(dp[idx][i]==true){
                    temp.add(s.substring(idx,i+1));
                    func(s,i+1,ans,temp,dp);
                    temp.remove(temp.size()-1);
                }   
            }
        }   
    }
}