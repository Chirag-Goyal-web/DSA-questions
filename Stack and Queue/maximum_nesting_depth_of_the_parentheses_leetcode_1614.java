public class maximum_nesting_depth_of_the_parentheses_leetcode_1614{
    public int maxDepth(String s) {
        
        int cur=0;
        int ans=0;
        
        for(char c:s.toCharArray()){
            if(c=='('){
                cur++;
                ans=Math.max(ans,cur);
            }
            else if(c==')'){
                cur--;
            }
        }
        
        return ans;
    }
}