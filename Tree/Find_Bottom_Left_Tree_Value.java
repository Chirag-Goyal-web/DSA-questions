public class Find_Bottom_Left_Tree_Value{
    
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    class Solution {
    
        public class Our{
            
            int height;
            int lmn;
            
            Our(int height,int lmn){
                this.height=height;
                this.lmn=lmn;
            }
            
        }
        
        public int findBottomLeftValue(TreeNode root) {
            
            if(root==null || (root.left==null && root.right==null)){
                return root.val;
            }
            
            else{
                Our o=function(root);
                return o.lmn; 
            }
            
        }
        
        public Our function(TreeNode root){
            
            if(root==null){
                return new Our(0,0);
            }
            
            else if(root.right==null && root.left==null){
                return new Our(1,root.val);
            }
            
            else{
                
                Our o1=function(root.left);
                Our o2=function(root.right);
                
                if(o1.height>=o2.height){
                    return new Our(o1.height+1,o1.lmn);
                }
                
                else{
                    return new Our(o2.height+1,o2.lmn);
                }
                
            }
            
        }
        
    }
    public static void main(String[] args) {
        
    }
}