import java.util.*;
public class diagonal_view_of_a_binary_tree{

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    
    public static class vPair{
        
        int level;
        TreeNode node;
        
        vPair(int l,TreeNode n){
            level=l;
            node=n;
        }
        
    }

    public static ArrayList<ArrayList<Integer>> diagonalOrder(TreeNode root) {
        
        if(root==null){
            return new ArrayList<>();
        }
        
        else{
            
            ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
            
            Queue<vPair> que=new LinkedList<>();
            que.add(new vPair(0,root));
            
            while(que.size()>0){
                
                vPair temp=que.remove();
                
                if(temp.level>=arr.size()){
                    arr.add(new ArrayList<>());
                }
                
                arr.get(temp.level).add(temp.node.val);
                
                if(temp.node.left!=null){
                    que.add(new vPair(temp.level+1,temp.node.left));
                }
                
                if(temp.node.right!=null){
                    que.add(new vPair(temp.level,temp.node.right));
                }
                
            }
            
            return arr;
        }
        
    }

    public static void main(String[] args) {
        
    }
}