import java.util.List;
import java.util.ArrayList;
public class Binary_Tree_Level_Order_Traversal_2{
    
    class Solution {
    
        public static class TreeNode {
            int val = 0;
            TreeNode left = null;
            TreeNode right = null;
    
            TreeNode(int val) {
                this.val = val;
            }
        }

        
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            
            List<List<Integer>> ans=new ArrayList<>();
            
            preorder(root,0,ans);
            
            for(int l=0,h=ans.size()-1;l<h;l++,h--){
                
                List<Integer> temp=ans.get(l);
                ans.set(l,ans.get(h));
                ans.set(h,temp);
                
            }
            
            return ans;
        }
        
        public void preorder(TreeNode root,int level,List<List<Integer>> ans){
            
            if(root==null){
                return;
            }
            
            else{
                
                if(ans.size()<=level){
                    ans.add(new ArrayList<>());
                }
                
                ans.get(level).add(root.val);
                
                preorder(root.left,level+1,ans);
                preorder(root.right,level+1,ans);
                
            }
            
        }
        
    }

    public static void main(String[] args) {
        
    }

}