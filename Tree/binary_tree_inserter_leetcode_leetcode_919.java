import java.util.*;
public class binary_tree_inserter_leetcode_leetcode_919{
    class CBTInserter {
    
        public static class TreeNode {
            int val = 0;
            TreeNode left = null;
            TreeNode right = null;
    
            TreeNode(int val) {
                this.val = val;
            }
        }

        TreeNode node=null;
        LinkedList<TreeNode> que=new LinkedList<>();
    
        public CBTInserter(TreeNode root) {
            node=root;
            que=new LinkedList<>();
            
            LinkedList<TreeNode> temp=new LinkedList<>();
            temp.add(root);
            
            while(temp.size()>0){
                TreeNode n=temp.remove(0);
                que.add(n);
                
                if(n.left!=null){
                    temp.add(n.left);
                }
                
                if(n.right!=null){
                    temp.add(n.right);    
                }
                
            }
            
        }
        
        public int insert(int val) {
            int size=que.size()-1;
            
            TreeNode par=que.get(size/2);
            TreeNode nw=new TreeNode(val);
            
            if(par.left==null)
                par.left=nw;
            else
                par.right=nw;
            
            que.add(nw);
            return par.val;
        }
        
        public TreeNode get_root() {
            return this.node;
        }
    }
    
}