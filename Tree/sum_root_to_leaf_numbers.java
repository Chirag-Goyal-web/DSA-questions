public class sum_root_to_leaf_numbers{
    
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }


    //Approach-1 (Using static)
    class Solution {
        
        static int ans=0;
        
        public int sumNumbers(TreeNode root) {
            
            ans=0;
            getSum(root,0);
            return ans;
            
        }
        
        public void getSum(TreeNode root,int temp){
            
            if(root==null){
                return;
            }
            
            else if(root.left==null && root.right==null){
                
                temp*=10;
                temp+=root.val;
                ans+=temp;
                return;
            }
            
            else{
                
                temp*=10;
                temp+=root.val;
                getSum(root.left,temp);
                getSum(root.right,temp);
                
            }
            
        }
        
    }

    //Approach-2 (Withput static)

    
class Solution_2 {
    public int sumNumbers(TreeNode root) {
        
        return getSum(root,0);
        
    }
    
    public int getSum(TreeNode root,int sum){
        
        if(root==null){
            return 0;
        }
        
        else if(root.left==null && root.right==null){
            sum*=10;
            sum+=root.val;
                return sum;
        }
        
        else{
            
            sum*=10;
            sum+=root.val;
       
            return getSum(root.left,sum)+getSum(root.right,sum);
                
        }
        
    }
    
}

}