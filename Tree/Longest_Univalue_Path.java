public class Longest_Univalue_Path{

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    class Solution {
        
        int ans=0;
        
        public int longesthUnivaluePath(TreeNode root) {
            
            ans=0;
            helper(root);
            return ans;
            
        }
        
        public int helper(TreeNode root){
            
            if(root==null)
                return 0;
            
            int l=helper(root.left);
            int r=helper(root.right);
            
            int temp1=0,temp2=0;
            
            if(root.left!=null && root.left.val==root.val){
                temp1=l+1;
            }
            
            if(root.right!=null && root.right.val==root.val){
                temp2=r+1;
            }
    
            ans=Math.max(ans,temp1+temp2);
            
            return Math.max(temp1,temp2);
            
        }
        
    }

    public static void main(String[] args) {
        
    }
}