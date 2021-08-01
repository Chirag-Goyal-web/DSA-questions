public class Longest_Univalue_Path{

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    //With static
    class Solution {
        
        int ans=0;
        
        public int longesthUnivaluePath(TreeNode root) {
            
            ans=0;
            helper(root);
            return ans;
            
        }
        
        public int helper(TreeNode root){
            
            if(root==null)
                return 0;
            
            int l=helper(root.left);
            int r=helper(root.right);
            
            int temp1=0,temp2=0;
            
            if(root.left!=null && root.left.val==root.val){
                temp1=l+1;
            }
            
            if(root.right!=null && root.right.val==root.val){
                temp2=r+1;
            }
    
            ans=Math.max(ans,temp1+temp2);
            
            return Math.max(temp1,temp2);
            
        }
        
    }

    //Without static
    class Solution_2{
    
        public int longestUnivaluePath(TreeNode root) {
            
            int[] ans=helper(root);
            
            return ans[1];
        }
        
        //{path,sum}
        public int[] helper(TreeNode root){
            
            if(root==null){
                return new int[]{0,0};
            }
            
            else{
                
                int[] left=helper(root.left);
                int[] right=helper(root.right);
                
                int ans=0;
                
                int temp1=0;
                int temp2=0;
                
                if(root.left!=null && root.left.val==root.val){
                    temp1=left[0]+1;
                }
                
                if(root.right!=null && root.right.val==root.val){
                    temp2=right[0]+1;
                }
        
                ans+=temp1;       
                ans+=temp2;
                
                ans=Math.max(ans,Math.max(left[1],right[1]));
                
                return new int[]{Math.max(temp1,temp2),ans};
                
            }
            
        }
           
    }
    public static void main(String[] args) {
        
    }
}