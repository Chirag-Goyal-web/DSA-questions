import java.util.Queue;
import java.util.LinkedList;

public class level_order_traversal_bt{

    
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }


    public static void levelOrder(TreeNode root){

        if(root==null){
            return;
        }

        Queue<TreeNode> que=new LinkedList<>();
        que.add(root);

        while(que.size()>0){
            
            int size=que.size();
           
            while(size>0){

                TreeNode cur=que.remove();
                System.out.print(cur.val);

                if(cur.left!=null)
                    que.add(cur.left);

                if(cur.right!=null)
                    que.add(cur.right);
                
                size--;
            }
        }

    }

    public static void main(String[] args) {
        
    }

}