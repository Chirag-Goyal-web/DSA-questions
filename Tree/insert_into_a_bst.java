public class insert_into_a_bst{

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    //Appraoch-1 (Iterative)
    public static TreeNode insertIntoBST_1(TreeNode root, int val) {
        if(root==null){
            return new TreeNode(val);
        }
        
        else{
            
            TreeNode head=root,prev=null;
            int indicator=0;
            
            while(root!=null){
                
                prev=root;
                
                if(root.val<val){
                    indicator=1;
                    root=root.right;
                }
                
                else{
                    indicator=2;
                    root=root.left;
                }
                
            }
            
            if(indicator==1){
                TreeNode temp=new TreeNode(val);
                prev.right=temp;
            }
            
            else{
                TreeNode temp=new TreeNode(val);
                prev.left=temp;
            }
            
            return head;
        }
        
    }

    //Approach-2 (Recursive)
    public TreeNode insertIntoBST_2(TreeNode root, int val) {
        
        if(root==null){
            return new TreeNode(val);
        }
        
        else{
            
            if(root.val<val){
                root.right=insertIntoBST_2(root.right,val);
            }
            
            else{
                root.left=insertIntoBST_2(root.left,val);
            }
            
            return root;
            
        }
        
    }
    public static void main(String[] args) {
        
    }

}