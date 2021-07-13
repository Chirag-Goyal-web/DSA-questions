public class Add_One_Row_to_Tree{

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }


    class Solution {
        
        public TreeNode addOneRow(TreeNode root, int val, int depth) {
            
            if(depth==1){
                TreeNode n=new TreeNode(val);
                n.left=root;
                return n;
            }
            
            else{
                return helper(root,val,2,depth);
            }
            
        }
        
        public TreeNode helper(TreeNode root,int val,int temp,int depth){
            
            if(root==null){
                return null;
            }
            
            else if(temp==depth){
                
                TreeNode l=new TreeNode(val);
                TreeNode r=new TreeNode(val);
                
                l.left=root.left;
                r.right=root.right;
                root.left=l;
                root.right=r;
                
                return root;
            }
            
            else{
                
                helper(root.left,val,temp+1,depth);
                helper(root.right,val,temp+1,depth);
                return root;
                
            }
            
        }
        
    }

    public static void main(String[] args) {
        
    }
}