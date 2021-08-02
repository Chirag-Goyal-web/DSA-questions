public class binary_tree_cameras{

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

    class Solution {
    
        static int count=0;
        
        public int minCameraCover(TreeNode root) {    
            
            count=0;
            
            if(root==null){
                return 0;
            }
            
            else{
                
                int temp=helper(root);
                
                if(temp==-1){
                    count++;
                }
                
                return count;
            }
            
        }
        
        public int helper(TreeNode root){
            
            if(root==null){
                return 0;
            }
            
            else{
                
                int l=helper(root.left);
                int r=helper(root.right);
                
                if(l==-1||r==-1){
                    count++;
                    return 1;
                }
                
                if(l==1 || r==1){
                    return 0;                
                }
                
                return -1;
            }
            
        }
        
    }

}