import java.util.*;

public class unique_binary_search_tree_2_leetcode_95{

    class Solution {

        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode() {}
            TreeNode(int val) { this.val = val; }
            TreeNode(int val, TreeNode left, TreeNode right) {
                this.val = val;
                this.left = left;
                this.right = right;
            }
        }
    
        public List<TreeNode> generateTrees(int n) {
            return helper(1,n);
        }
        
        public List<TreeNode> helper(int start,int end){
            
            if(start>end){
                List<TreeNode> temp=new ArrayList<>();
                temp.add(null);
                return temp;
            }
            
            else if(start==end){
                List<TreeNode> temp=new ArrayList<>();
                temp.add(new TreeNode(start));
                return temp;
            }
            
            else{
                
                List<TreeNode> ans=new ArrayList<>();
                
                for(int i=start;i<=end;i++){
                    
                    List<TreeNode> leftSide=helper(start,i-1);
                    List<TreeNode> rightSide=helper(i+1,end);
                    
                    for(int l=0;l<leftSide.size();l++){
                        for(int r=0;r<rightSide.size();r++){
                            TreeNode node=new TreeNode(i);
                            node.left=leftSide.get(l);
                            node.right=rightSide.get(r);
                            ans.add(node);
                        }
                    }    
                    
                }
                
                return ans;
            }
            
        }
        
    }

    class Solution_ {

        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode() {}
            TreeNode(int val) { this.val = val; }
            TreeNode(int val, TreeNode left, TreeNode right) {
                this.val = val;
                this.left = left;
                this.right = right;
            }
        }
            
        public List<TreeNode> generateTrees(int n) {
            List<TreeNode>[][] dp=new ArrayList[n+1][n+1];
            for(int i=0;i<=n;i++){
                for(int j=0;j<=n;j++){
                    dp[i][j]=new ArrayList<>();
                }
            }
            return helper(1,n,dp);
        }
        
        public List<TreeNode> helper(int start,int end,List<TreeNode>[][] dp){
            
            if(start>end){
                List<TreeNode> temp=new ArrayList<>();
                temp.add(null);
                return temp;
            }
            
            else if(start==end){
                List<TreeNode> temp=new ArrayList<>();
                temp.add(new TreeNode(start));
                return temp;
            }
            
            else if(dp[start][end].size()>0){
                return dp[start][end];    
            }   
            
            else{
                
                List<TreeNode> ans=new ArrayList<>();
                
                for(int i=start;i<=end;i++){
                    
                    List<TreeNode> leftSide=helper(start,i-1,dp);
                    List<TreeNode> rightSide=helper(i+1,end,dp);
                    
                    for(int l=0;l<leftSide.size();l++){
                        for(int r=0;r<rightSide.size();r++){
                            TreeNode node=new TreeNode(i);
                            node.left=leftSide.get(l);
                            node.right=rightSide.get(r);
                            ans.add(node);
                        }
                    }    
                    
                }
                
                dp[start][end]=ans;
                return ans;
            }
            
        }
    
    }

}