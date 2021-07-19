import java.util.*;
public class Find_Duplicate_Subtrees{

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

    class Solution {
    
        public ArrayList<TreeNode> findDuplicateSubtrees(TreeNode root) {
            
            HashMap<String,Integer> hm=new HashMap<>();
            ArrayList<TreeNode> ls=new ArrayList<>();
            
            preorder(root,hm,ls);
            
            return ls;
            
        }
        
        public String preorder(TreeNode root,HashMap<String,Integer> hm,ArrayList<TreeNode> ls){
            
            if(root==null){
                return "#";
            }
            
            else{
                
                String pre=root.val+","+preorder(root.left,hm,ls)+","+preorder(root.right,hm,ls);
                
                hm.put(pre,hm.getOrDefault(pre,0)+1);
                
                if(hm.get(pre)==2){
                    ls.add(root);
                }
                
                return pre;
            }
            
        }
        
    }

    public static void main(String[] args) {
        
    }

}