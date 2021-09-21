import java.util.*;
public class maximum_sum_bst_in_binary_tree_leetcode_1373{

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
    
    public int maxSumBST(TreeNode root) {
        SubTree s= helper(root);
        return s.maxSum;
    }
    
    public class SubTree{
        boolean isBST=true;
        int minVal=Integer.MAX_VALUE;
        int maxVal=Integer.MIN_VALUE;
        int sum=0;
        int maxSum=0;
    }
    
    public int findMax(int... arr){
        
        int max=arr[0];
        
        for(int i:arr){
            max=Math.max(i,max);
        }

        return max;
    }
    
    public SubTree helper(TreeNode root){
        
        if(root==null){
            return new SubTree();
        }
        
        else{
            SubTree leftSide=helper(root.left);
            SubTree rightSide=helper(root.right);
            
            SubTree s=new SubTree();
            s.isBST=leftSide.isBST && rightSide.isBST && (root.val<rightSide.minVal && root.val>leftSide.maxVal);
            
            s.minVal=Math.min(root.val,Math.min(leftSide.minVal,rightSide.minVal));
            s.maxVal=Math.max(root.val,Math.max(leftSide.maxVal,rightSide.maxVal));
            
            s.sum=leftSide.sum+rightSide.sum+root.val;
            
            int can1=leftSide.maxSum;
            int can2=rightSide.maxSum;
            int can3=Integer.MIN_VALUE;
            
            if(s.isBST==true){
                can3=root.val+leftSide.sum+rightSide.sum;
            }
            
            s.maxSum=findMax(can1,can2,can3);
            return s;
        }
    }

}