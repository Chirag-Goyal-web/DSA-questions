public class width_of_a_bt{

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }


    public static int width(TreeNode root) {
        int[] ans=new int[]{0,0};
        function(root,ans,0);
        return ans[1]-ans[0]+1;
    }
    
    public static void function(TreeNode root,int[] ans,int vl){
        
        if(root==null)
            return;
        
        else{
            
            if(vl<ans[0]){
                ans[0]=vl;
            }
            else if(vl>ans[1]){
                ans[1]=vl;
            }
            
            function(root.left,ans,vl-1);
            function(root.right,ans,vl+1);
            
        }
        
    }

    public static void main(String[] args) {
        
    }
}