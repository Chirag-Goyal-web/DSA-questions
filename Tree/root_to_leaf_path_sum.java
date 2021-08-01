public class root_to_leaf_path_sum{

    class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left=null;
            right=null;
        }
    }
    
    boolean hasPathSum(Node root, int targetSum) {
        
        if(root==null){
            return false;
        }
        
        else if(root.left==null && root.right==null){
            targetSum-=root.data;
            if(targetSum==0){
                return true;
            }
            else{
                return false;
            }
        }
        
        else{
            
            targetSum-=root.data;
            
            if(hasPathSum(root.left,targetSum)==true){
                return true;
            }
            
            else if(hasPathSum(root.right,targetSum)==true){
                return true;
            }
            
            return false;
        }
    }

    public static void main(String[] args) {
        
    }
}