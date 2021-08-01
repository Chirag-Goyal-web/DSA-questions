public class Maximum_Path_Sum_of_Binary_Tree{

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

    public  int maxPathSum(TreeNode root) {

        ans = -(int)1e4;
        maxPathSum_(root);
    
        return ans;
    
      }
      static int ans = -(int)1e4;
    
      public  int maxPathSum_(TreeNode root) {
    
        if (root == null) {
          return -(int)1e4;
        }
    
        else {
    
          int left = maxPathSum_(root.left);
          int right = maxPathSum_(root.right);
    
          int temp = Math.max(root.val, Math.max(root.val + left + right,Math.max(root.val + left, root.val + right)));
    
          ans = Math.max(ans, temp);
    
          return Math.max(root.val, Math.max(left + root.val, right + root.val));
        }
    
      }

    public static void main(String[] args) {
        
    }

}