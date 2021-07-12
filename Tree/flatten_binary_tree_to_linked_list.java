public class flatten_binary_tree_to_linked_list{

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    //Approach-1 (Using recursion- Flatten left && right, then connect root,left part and right part)
    class Solution_01 {
    
        public void flatten(TreeNode root) {
            
            if(root==null){
                return;
            }
            
            TreeNode[] n=helper(root);
            root= n[0];
            
        }
        
        public TreeNode[] helper(TreeNode root){
            
            if(root==null){
                return new TreeNode[]{null,null};    
            }
            
            else if(root.left==null && root.right==null){
                return new TreeNode[]{root,root};
            }
            
            else{
                
                TreeNode[] t1=helper(root.left);
                TreeNode[] t2=helper(root.right);
                
                root.left=null;
                
                TreeNode tail=root;
                
                if(t1[0]!=null){
                    tail.right=t1[0];
                    tail=t1[1];
                }
                
                if(t2[0]!=null){
                    tail.right=t2[0];
                    tail=t2[1];
                }
                
                return new TreeNode[]{root,tail};
                
            }
        }
        
    }

    //Approach-2 (Iterative - Using morris traversal)
    class Solution_02 {
    
        public void flatten(TreeNode root) {
            
            if(root==null){
                return;
            }
            
            TreeNode dummy=new TreeNode(-1);
            TreeNode ans=dummy;
            
            while(root!=null){
                
                TreeNode leftNode= root.left;
                
                if(leftNode==null){
                    dummy.left=root;
                    dummy=root;
                    root=root.right;
                }
                
                else{
                    
                    TreeNode rmn=getRightMostNode(leftNode,root);
                    
                    if(rmn.right==null){
                        dummy.left=root;
                        dummy=root;
                        rmn.right=root;
                        root=root.left;
                    }
                    
                    else{
                        rmn.right=null;
                        root=root.right;
                    }
                    
                }
                
            }
            
            dummy.left=null;
            dummy.right=null;
            
            ans=ans.left;
            TreeNode p=ans;
            
            while(ans!=null){
                
                TreeNode t=ans.left;
                ans.left=null;
                ans.right=t;
                ans=ans.right;
                
            }
            
            root=p;
        }
        
        public TreeNode getRightMostNode(TreeNode node,TreeNode curr){
            
            while(node.right!=null && node.right!=curr){
                node=node.right;
            }
            
            return node;
        }
        
    }

    //Approach-3 (Using reverse preorder)
    class Solution_03 {
        
        private TreeNode prev = null;

        public void flatten(TreeNode root) {
            if (root == null)
                return;
            flatten(root.right);
            flatten(root.left);
            root.right = prev;
            root.left = null;
            prev = root;
        }
        
    }
    
    public static void main(String[] args) {
        
    }

}