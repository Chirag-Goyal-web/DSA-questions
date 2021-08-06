public class binary_tree_pruning_leetcode_814{

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    
    class Solution {
        
        public TreeNode pruneTree(TreeNode root) {
            
            if(root==null){
                return null;
            }
            
            else if(root.left==null && root.right==null){
                if(root.val==1){
                    return root;
                }
                else{
                    return null;
                }
            }
            
            else{
                
                root.left=pruneTree(root.left);
                root.right=pruneTree(root.right);
                
                if(root.left==null && root.right==null && root.val==0){
                    return null;
                }
                
                else{
                    return root;
                }
                
            }
        }
        
    }

    public static void main(String[] args) {
        
    }
    
}