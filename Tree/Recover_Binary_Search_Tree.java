public class Recover_Binary_Search_Tree{

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

        public void recoverTree(TreeNode root) {
            
            TreeNode itr=root;
            
            TreeNode prev=null;
            TreeNode first=null;
            TreeNode second=null;
            
            while(itr!=null){
                
                TreeNode leftNode=itr.left;
                
                if(leftNode==null){
                   
                    if(prev!=null){
                        // System.out.println(prev.val+" "+root.val);
                        if(first==null && prev.val>itr.val){
                            first=prev;
                        }
                        
                        if(prev.val>itr.val){
                            second=itr;
                        }
                        
                    }
                    
                    prev=itr;
                    itr=itr.right;
                }
                
                else{
                   
                    
                    TreeNode rmn=getRightMost(leftNode,itr);
                    
                    if(rmn.right==null){
                        rmn.right=itr;
                        itr=itr.left;
                    }
                    
                    else{
                      
                        if(prev!=null){
                        
                            if(first==null && prev.val>itr.val){
                                first=prev;
                            }
    
                            if(prev.val>itr.val){
                                second=itr;
                            }
    
                        }
                    
                        prev=itr;
                        itr=itr.right;
                        rmn.right=null;
                    }
                    
                }
                
            }
            
            int temp=first.val;
            first.val=second.val;
            second.val=temp;
            
        }
        
        public TreeNode getRightMost(TreeNode node,TreeNode root){
            
            while(node.right!=null && node.right!=root){
                node=node.right;
            }
            
            return node;
        }
        
    }

    public static void main(String[] args) {
        
    }
}