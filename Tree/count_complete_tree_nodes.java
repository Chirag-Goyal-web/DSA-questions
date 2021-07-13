public class count_complete_tree_nodes{

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    class Solution {
        public int countNodes(TreeNode root) {
            
            if(root==null){
                return 0;
            }
            
            else{
                
                int leftH=heightLeft(root);
                int rightH=heightRight(root);
                
                if(leftH==rightH){
                    return (1<<leftH)-1;
                }
                
                else{
                    return countNodes(root.left)+countNodes(root.right)+1;
                }
                
            }
            
        }
        
        public int heightLeft(TreeNode root){
            int count=1;
            while(root.left!=null){
                count++;
                root=root.left;
            }
            return count;
        }
        
        public int heightRight(TreeNode root){
            
            int count=1;
            
            while(root.right!=null){
                count++;
                root=root.right;
            }
            
            return count;
        }
        
    }

    public static void main(String[] args) {
        
    }

}