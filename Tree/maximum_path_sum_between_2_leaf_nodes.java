public class maximum_path_sum_between_2_leaf_nodes{
    
    class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            left=null;
            right=null;
        }
    }

    public static int maxPathSum(Node root)
    { 
        int[] ans=helper(root);
        return ans[1];
    } 
    
    public static int[] helper(Node root){
        
        if(root==null){
            return new int[]{0,-(int)1e9};
        }
        
        else{
            
            int[]left=helper(root.left);
            int[] right=helper(root.right);
            
            int temp1=root.data+left[0];
            int temp2=root.data+right[0];
            
            int ans=Math.max(Math.max(left[1],right[1]),left[0]+right[0]+root.data);
            
            return new int[]{Math.max(temp1,temp2),ans};
        }
        
    }

    public static void main(String[] args) {
        
    }

}