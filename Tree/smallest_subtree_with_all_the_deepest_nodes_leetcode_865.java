public class smallest_subtree_with_all_the_deepest_nodes_leetcode_865{
    class Solution {

        public static class TreeNode {
            int val = 0;
            TreeNode left = null;
            TreeNode right = null;
    
            TreeNode(int val) {
                this.val = val;
            }
        }
    
        public class Pair{
            int depth;
            TreeNode ans;
            
            Pair(int depth,TreeNode ans){
                this.depth=depth;
                this.ans=ans;
            }
        }
        
        public TreeNode subtreeWithAllDeepest(TreeNode root) {
            Pair p=helper(root,0);
            return p.ans;
        }
        
        public Pair helper(TreeNode root,int level){
            if(root==null){
                return new Pair(level,root);
            }
            
            else{
                
                Pair left=helper(root.left,level+1);
                Pair right=helper(root.right,level+1);
                
                if(left.depth==right.depth){
                    return new Pair(left.depth,root);
                }
                
                else if(left.depth>right.depth){
                    return new Pair(left.depth,left.ans);
                }
                
                else{
                    return new Pair(right.depth,right.ans);
                }
            }
        }
        
    }
    public static void main(String[] args) {
        
    }
}