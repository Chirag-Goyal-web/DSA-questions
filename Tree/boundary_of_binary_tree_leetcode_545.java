import java.util.*;
public class boundary_of_binary_tree_leetcode_545{

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> boundaryOfBinaryTree(TreeNode root) {
        ArrayList<Integer> ans=new ArrayList<>();
        
        if(root==null){
            return ans;
        }

        ans.add(root.val);
        leftSide(root.left,ans);
        leave(root,ans);
        rightSide(root.right,ans);
        return ans;
    }
    
    public void leftSide(TreeNode root,ArrayList<Integer> ans){
        if(root==null){
            return;
        }
        else{
            if(root.left!=null || root.right!=null){
                ans.add(root.val);
            }
            
            if(root.left!=null){
                leftSide(root.left,ans);
            }
            else if(root.right!=null){
                leftSide(root.right,ans);
            }
        }
    }

    public void rightSide(TreeNode root,ArrayList<Integer> ans){
        if(root==null){
            return;
        }
        else{
            
            if(root.right!=null){
                rightSide(root.right,ans);
            }
            else if(root.left!=null){
                rightSide(root.left,ans);
            }
            
            if(root.left!=null || root.right!=null){
                ans.add(root.val);
            }
            
        }
    }

    public void leave(TreeNode root,ArrayList<Integer> ans){

        if(root==null){
            return;
        }

        else if(root.left==null && root.right==null){
            ans.add(root.val);
        }

        else{
            leave(root.left,ans);
            leave(root.right,ans);
        }
    }


}