public class delete_node_in_a_bst{

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    
    public TreeNode deleteNode(TreeNode root, int key) {
        
        if(root==null){
            return root;
        }
        
        else{
            
            if(key<root.val){
                root.left=deleteNode(root.left,key);
            }
            
            else if(key>root.val){
                root.right=deleteNode(root.right,key);
            }
            
            else{
                
                if(root.left==null || root.right==null){
                    return root.left!=null?root.left:root.right;
                }
                
                else{
                    
                    int val=getMin(root.left);
                    root.val=val;
                    root.left=deleteNode(root.left,val);
                    
                }
                
            }
            
            return root;
        }
        
    }
    
    
    public int getMin(TreeNode node){
        
        while(node!=null && node.right!=null){
            node=node.right;
        }
        
        return node.val;
    }


    public static void main(String[] args) {
        
    }

}