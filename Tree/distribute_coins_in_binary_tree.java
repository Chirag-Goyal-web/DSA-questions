public class distribute_coins_in_binary_tree{

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

    public int distributeCoins(TreeNode root) {
        ans=0;
        helper(root);
        return ans;
    }
    
    static int ans=0;
    
    public int helper(TreeNode root){
        
        if(root==null){
            return 0;
        }
        
        else{
            
            int left=helper(root.left);
            int right=helper(root.right);
            
            ans+=Math.abs(left)+Math.abs(right);
            
            return left+right+root.val-1;
        }
        
    }
    

    public static void main(String[] args) {
        
    }
}