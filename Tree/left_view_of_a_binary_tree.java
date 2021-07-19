import java.util.*;
public class left_view_of_a_binary_tree{

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    //Approach-1 (DFS- Recursion)

    public static ArrayList<Integer> leftView_1(TreeNode root) {
        ArrayList<Integer> ans=new ArrayList<>();
        helper_1(root,0,ans);
        return ans;
    }

    public static void helper_1(TreeNode root,int depth,ArrayList<Integer> ans){

        if(root==null)
            return;
        
        else{

            if(depth>=ans.size())
                ans.add(root.val);

            helper_1(root.left,depth+1,ans);
            helper_1(root.right,depth+1,ans);

        }

    }

    //Apporach-1 ENDS

    //Approach-2 (Using BFS- Iterative solution)

    public static ArrayList<Integer> leftView_2(TreeNode root){

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