public class trim_a_binary_search_tree_leetcode_669{

    class Solution {

        public static class TreeNode {
            int val = 0;
            TreeNode left = null;
            TreeNode right = null;
    
            TreeNode(int val) {
                this.val = val;
            }
        }

        public TreeNode trimBST(TreeNode root, int low, int high) {
            
            if(root==null){
                return null;
            }
            
            else if(root.val>high){
                return trimBST(root.left,low,high);
            }
            
            else if(root.val<low){
                return trimBST(root.right,low,high);
            }
            
            else{
                
                root.left=trimBST(root.left,low,high);
                root.right=trimBST(root.right,low,high);
                
                return root;
            }
        }
    }

    public static void main(String[] args) {
        
    }
}