public class maximum_product_of_splitted_binary_tree{

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

    //Without using static
    class Solution_01 {
    
        public int maxProduct(TreeNode root) {
            int sum=getSum(root);
            long[] ans=helper(root,sum);
            return (int)(ans[1]%1000000007);
        }
        
        public int getSum(TreeNode root){
            
            if(root==null){
                return 0;
            }
            
            else{
                return getSum(root.left)+getSum(root.right)+root.val;
            }
            
        }
        
        //{sum,ans}
        public long[] helper(TreeNode root,int totalSum){
            
            if(root==null){
                return new long[]{0,0};
            }
            
            else{
                
                long[] leftSum=helper(root.left,totalSum);
                long[] rightSum=helper(root.right,totalSum);
                
                long ans=0;
                
                if(root.left!=null){
                    ans=Math.max(ans,leftSum[0]*(totalSum-leftSum[0]));
                }
                
                if(root.right!=null){
                    ans=Math.max(ans,rightSum[0]*(totalSum-rightSum[0]));
                }
                
                return new long[]{leftSum[0]+rightSum[0]+root.val,Math.max(ans,Math.max(leftSum[1],rightSum[1]))};
                    
            }
            
        }
        
    }

    //With static
    class Solution_02{
    
        public int maxProduct(TreeNode root) {
            ans=0;
            int sum=getSum(root);
            helper(root,sum);
            return (int)(ans%1000000007);
        }
        
        public int getSum(TreeNode root){
            
            if(root==null){
                return 0;
            }
            
            else{
                return getSum(root.left)+getSum(root.right)+root.val;
            }
            
        }
        
        long ans=0;
        
        public long helper(TreeNode root,int totalSum){
            
            //System.out.println(ans);
            
            if(root==null){
                return 0;
            }
            
            else{
                
                long leftSum=helper(root.left,totalSum);
                long rightSum=helper(root.right,totalSum);
                
                if(root.left!=null){
                    ans=Math.max(ans,leftSum*(totalSum-leftSum));
                }
                
                if(root.right!=null){
                    ans=Math.max(ans,rightSum*(totalSum-rightSum));
                }
                
                return leftSum+rightSum+root.val;
                    
            }
            
        }
        
    }

}