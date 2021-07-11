public class inorder_predecessor_and_successor_in_bst{

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public void inorderPreSuc(TreeNode root,int val){
        
        TreeNode pred=null,succ=null;
        
        while(root!=null){
            
            if(root.val>val){
                succ=root;
                root=root.left;
            }
            
            else if(val>root.val){
                pred=root;
                root=root.right;
            }
            
            else{
                
                if(root.left!=null){
                    pred=getRightMost(root.left);
                }
                
                if(root.right!=null){
                    succ=getLeftMost(root.right);
                }
                
                break;
            }
            
        }
        
        if(pred!=null)
            System.out.println(pred.val);
        
        if(succ!=null)
            System.out.println(succ.val);
        
        
    }
    
    public TreeNode getRightMost(TreeNode root){
        
        while(root!=null && root.right!=null){
            root=root.right;
        }
        
        return root;
    }
    
    public TreeNode getLeftMost(TreeNode root){
        
        while(root!=null && root.left!=null){
            root=root.left;
        }
        
        return root;
    }

    public static void main(String[] args){

    }

}