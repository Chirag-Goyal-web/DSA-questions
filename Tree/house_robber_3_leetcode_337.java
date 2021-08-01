public class house_robber_3_leetcode_337{

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

    public int rob(TreeNode root) {
        
        int[] ans=helper(root);
        return Math.max(ans[0],ans[1]);
            
    }
    
    //{included,excluded}
    public int[] helper(TreeNode root){
        
        if(root==null){
            return new int[]{0,0};
        }
        
        else{
            
            int[] left=helper(root.left);
            int[] right=helper(root.right);
            
            return new int[]{left[1]+right[1]+root.val,Math.max(left[0],left[1])+Math.max(right[0],right[1])};
            
        }
        
    }

    public static void main(String[] args) {
        
    }
}