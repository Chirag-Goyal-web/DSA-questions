import java.util.*;
public class Maximum_Width_of_Binary_Tree_leetcode_662{

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

    public class Pair{
        TreeNode node;
        int idx;

        Pair(TreeNode node,int idx){
            this.node=node;
            this.idx=idx;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        
        int ans=1;
        
        Queue<Pair> que=new LinkedList<>();
        que.add(new Pair(root,0));
        
        while(que.size()>0){
            int size=que.size();
            Pair p1=null,p2=null;

            while(size-->0){
                Pair temp=que.remove();

                if(p1==null){
                    p1=temp;
                }
                
                if(size==0){
                    p2=temp;
                }

                if(temp.node.left!=null)
                    que.add(new Pair(temp.node.left,temp.idx*2+1));
                
                if(temp.node.right!=null)
                    que.add(new Pair(temp.node.right,temp.idx*2+2));
            }

            ans=Math.max(ans,p2.idx-p1.idx+1);
        }

        return ans;
    }

}