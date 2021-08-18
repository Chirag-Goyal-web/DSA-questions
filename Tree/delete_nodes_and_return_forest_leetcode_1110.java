import java.util.*;
public class delete_nodes_and_return_forest_leetcode_1110{

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if(root==null){
            return new ArrayList<>();
        }
        
        else if(to_delete.length==0){
            ArrayList<TreeNode> ls=new ArrayList<>();
            ls.add(root);
            return ls;
        }
        
        else{
            
            HashMap<Integer,Integer> hm=new HashMap<>();
            
            for(int i:to_delete)
                hm.put(i,1);
            
            ArrayList<TreeNode> ls=new ArrayList<>();
            
            if(helper(root,hm,ls)!=null)
                ls.add(root);
            
            return ls;
        }
    }

    public TreeNode helper(TreeNode root,HashMap<Integer,Integer> hm,ArrayList<TreeNode> ls){
        
        if(root==null)
            return null;
        
        root.left=helper(root.left,hm,ls);
        root.right=helper(root.right,hm,ls);
        
        if(hm.containsKey(root.val)){
            if(root.left!=null)
                ls.add(root.left);
        
            if(root.right!=null)
                ls.add(root.right);
            
            return null;
        }
        
        else{
            return root;   
        }
    }
    public static void main(String[] args) {
        
    }
}