public class Convert_BST_to_Greater_Tree{

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    //Using static
    class Solution {
    
        int sum=0;
        
        public TreeNode convertBST(TreeNode root) {
            sum=0;
            function(root);
            return root;
        }
        
        public void function(TreeNode root){
            
            if(root==null){
                return;
            }
            
            else{
                
                function(root.right);
                
                sum+=root.val;
                root.val=sum;
                
                function(root.left);
                
            }
            
        }
        
    }



    public static void main(String[] args) {

    }
}