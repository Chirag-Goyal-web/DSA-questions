import java.util.LinkedList;
import java.util.Queue;

public class check_completeness_of_a_bt{

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    
    public boolean isCompleteTree(TreeNode root) {
        
        if(root==null){
            return true;
        }
        
        else{
            
            boolean end=false;
            
            Queue<TreeNode> queue=new LinkedList<>();
            queue.add(root);
            
            while(queue.size()>0){
                
                TreeNode temp=queue.remove();
                
                if(temp==null)
                    end=true;
                
                else{
                    
                    if(end){
                        return false;
                    }
                    
                    else{
                        queue.add(temp.left);
                        queue.add(temp.right);
                    }
                    
                }
                
            }
            
            return true;
        }
        
        
    }    

    public static void main(String[] args) {
        
    }

}