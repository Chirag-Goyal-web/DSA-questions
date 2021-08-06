public class delete_leaves_with_a_given_value_leetcode_1325{
    
class Solution {
    
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        
        if(root==null){
            return null;
        }
        
        else{
            
            TreeNode left=removeLeafNodes(root.left,target);
            TreeNode right=removeLeafNodes(root.right,target);
            
            root.left=left;
            root.right=right;
            
            if(left==null && right==null){
                
                if(root.val==target){
                    return null;
                }
                
            }
            
            return root;
        }
        
    }
    }
}