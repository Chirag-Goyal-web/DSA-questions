import java.util.*;
public class Construct_Bst_From_Levelorder_Traversal{

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static class LevelNode{
        
        TreeNode node;
        int leftRange;
        int rightRange;
        
        LevelNode(TreeNode node,int lR,int rR){
            this.node=node;
            this.leftRange=lR;
            this.rightRange=rR;
        }
    }

    public static TreeNode constructBSTFromLevelOrder(int[] LevelOrder){
        
        Queue<LevelNode> que=new LinkedList<>();
        TreeNode root=null;
        
        que.add(new LevelNode(null,Integer.MIN_VALUE,Integer.MAX_VALUE));
            
            int ptr=0;
            
            while(ptr<LevelOrder.length){
                
                int tempVal=LevelOrder[ptr];
                
                LevelNode bn=que.remove();
                
                if(bn.leftRange>tempVal || bn.rightRange<tempVal){
                    continue;
                }
                
                TreeNode n=new TreeNode(tempVal);
                
                if(root==null){
                    root=n;
                }
                
                else{
                    
                    if(tempVal<bn.node.val){
                        bn.node.left=n;
                    }else{
                        bn.node.right=n;
                    }
                    
                }
                
                que.add(new LevelNode(n,bn.leftRange,tempVal));
                que.add(new LevelNode(n,tempVal,bn.rightRange));
                ptr++;
                
            }
            
            return root;
        }

    public static void main(String[] args) {
        
    }
}