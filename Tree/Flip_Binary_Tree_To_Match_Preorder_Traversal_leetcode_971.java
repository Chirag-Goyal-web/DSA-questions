import java.util.*;
public class Flip_Binary_Tree_To_Match_Preorder_Traversal_leetcode_971{

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        
        int[] idx=new int[1];
        ArrayList<Integer> ls=new ArrayList<>();
        
        boolean ans=helper(root,idx,voyage,ls);
        
        if(ans==false){
            ls=new ArrayList<>();
            ls.add(-1);
            return ls;
        }
        
        else{
            return ls;    
        }
    }
    
    public boolean helper(TreeNode root,int[] idx,int[] voyage,ArrayList<Integer> ls){
        
        if(root==null)
            return true;
        
        else if(root.val!=voyage[idx[0]])
            return false;
        
        else{
            
            if(root.left!=null && root.right!=null){
                if(root.left.val!=voyage[idx[0]+1]){
                    ls.add(root.val);
                    TreeNode temp=root.left;
                    root.left=root.right;
                    root.right=temp;
                }
            }
            
            idx[0]++;
            return helper(root.left,idx,voyage,ls)&&helper(root.right,idx,voyage,ls);
        }
        
    }

}