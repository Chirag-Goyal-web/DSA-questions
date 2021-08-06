public class flip_equivalent_binary_tree_leetcode_951{

    class Solution {
        public static class TreeNode {
            int val = 0;
            TreeNode left = null;
            TreeNode right = null;
    
            TreeNode(int val) {
                this.val = val;
            }
        }

        public boolean flipEquiv(TreeNode root1, TreeNode root2) {
            
            if(root1==null && root2==null){
                return true;
            }
            
            else if(root1==null||root2==null){
                return false;
            }
            
            else{
                
                if(root1.val!=root2.val){
                    return false;
                }
                
                if(root1.left!=null && root2.left!=null && root1.left.val==root2.left.val){
                    return flipEquiv(root1.left,root2.left)&&flipEquiv(root1.right,root2.right);
                }
                
                else if(root1.right!=null && root2.right!=null && root1.right.val==root2.right.val){
                    return flipEquiv(root1.left,root2.left)&&flipEquiv(root1.right,root2.right);
                }
                
                else{
                    return flipEquiv(root1.left,root2.right)&&flipEquiv(root1.right,root2.left);
                }
                
            }
        }
    }

    public static void main(String[] args) {
        
    }
}