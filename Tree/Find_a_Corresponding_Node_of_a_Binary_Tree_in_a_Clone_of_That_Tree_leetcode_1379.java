public class Find_a_Corresponding_Node_of_a_Binary_Tree_in_a_Clone_of_That_Tree_leetcode_1379{

    class Solution {

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
    
        public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
            
            StringBuilder str=new StringBuilder();
            helper(original,target,str);
            
            TreeNode itr=cloned;
            
            for(int i=0;i<str.length();i++){
                if(str.charAt(i)=='l'){
                    itr=itr.left;
                }
                else{
                    itr=itr.right;
                }
            }
            
            return itr;
            
        }
        
        public boolean helper(TreeNode root,TreeNode target,StringBuilder str){
            
            if(root==null)
                return false;
            
            else if(root==target)
                return true;
            
            else{
                
                boolean b=helper(root.left,target,str);
                
                if(b==true){
                    str.insert(0,"l");
                    return true;
                }
                
                b=helper(root.right,target,str);
                
                if(b==true){
                    str.insert(0,"r");
                    return true;
                }
                
                return false;
            }
            
        }
        
    }

}