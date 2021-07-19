public class Recover_a_Tree_From_Preorder_Traversal{

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
    
        public TreeNode recoverFromPreorder(String traversal) {
            PTR=0;
            return helper(traversal,traversal.length(),0);
        }
        
        int PTR=0;
        
        public TreeNode helper(String traversal,int size,int depth){
            
            if(PTR>=size){
                return null;
            }
            
            else{
                
                int countDash=0;
                int t=PTR;
                while(traversal.charAt(PTR)=='-'){
                    countDash++;
                    PTR++;
                }
                
                if(countDash!=depth){
                    PTR=t;
                    return null;
                }
                
                else{
                    
                    int temp=PTR;
                    
                    while(PTR<size && traversal.charAt(PTR)!='-'){
                        PTR++;
                    }
                    
                    int val=Integer.parseInt(traversal.substring(temp,PTR));
                    
                    TreeNode node=new TreeNode(val);
                    
                    node.left=helper(traversal,size,depth+1);
                    node.right=helper(traversal,size,depth+1);
                    
                    return node;
                }
                
            }
            
        }
        
    }

    public static void main(String[] args) {
        
    }

}