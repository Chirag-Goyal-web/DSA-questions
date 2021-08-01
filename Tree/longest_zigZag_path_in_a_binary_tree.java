public class longest_zigZag_path_in_a_binary_tree{

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

    public int longestZigZag(TreeNode root) {
     
        int[] arr= helper(root);
         
         return arr[2];
     }
     
     //{left,right}
     public int[] helper(TreeNode root){
         
         if(root==null){
             return new int[]{-1,-1,-1};
         }
         
         else{
             
             int[] left=helper(root.left);
             int[] right=helper(root.right);
         
             int[]ans=new int[]{left[1]+1,right[0]+1};
             
             int max=Math.max(left[2],Math.max(right[2],Math.max(ans[0],ans[1])));
           
             return new int[]{ans[0],ans[1],max};
            
         }
         
     }
    

}