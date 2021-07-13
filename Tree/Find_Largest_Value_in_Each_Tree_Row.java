import java.util.ArrayList;
import java.util.List;

class Solution {
    
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public List<Integer> largestValues(TreeNode root) {
        
        List<Integer> ls=new ArrayList<>();
        
        function(root,0,ls);
        
        return ls;
    }
    
    public void function(TreeNode root,int depth,List<Integer> ls){
        
        if(root==null){
            return;
        }
        
        else if(depth>=ls.size()){
            ls.add(Integer.MIN_VALUE);
        }
        
            ls.set(depth,Math.max(ls.get(depth),root.val));
            
        
            function(root.left,depth+1,ls);
            function(root.right,depth+1,ls);    
        
        
    }
    
}