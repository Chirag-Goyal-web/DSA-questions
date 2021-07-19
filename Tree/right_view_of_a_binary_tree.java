import java.util.*;

public class right_view_of_a_binary_tree{

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    //Approach-1 using DFS- same as left view, just call the right child first, then left child

    //Approach-2
    public static ArrayList<Integer> rightView(TreeNode root) {

        ArrayList<Integer> ans=new ArrayList<>();

        levelOrder(root,ans);

        return ans;
    }
    
    public static void levelOrder(TreeNode root,ArrayList<Integer> ans){

        if(root==null){
            return;
        }

        Queue<TreeNode> que=new LinkedList<>();
        que.add(root);

        while(que.size()>0){
            
            int size=que.size();
           
            ans.add(que.peek().val);

            while(size>0){

                TreeNode cur=que.remove();

                if(cur.right!=null)
                    que.add(cur.right);

                if(cur.left!=null)
                    que.add(cur.left);
                
                size--;
            }
        }

    }

    public static void main(String[] args) {
        
    }
}