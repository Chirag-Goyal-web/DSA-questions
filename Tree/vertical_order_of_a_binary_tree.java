import java.util.*;
public class vertical_order_of_a_binary_tree{

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    
    public static class vPair{
        
        int vl;
        TreeNode node;
        
        vPair(int vl,TreeNode node){
            this.vl=vl;
            this.node=node;
        }
        
    }

    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {
        
        int[] arr=new int[]{0,0};
        width(root,arr,0);
        
        int size=arr[1]-arr[0]+1;
        int min=arr[0];
        
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        
        for(int i=0;i<size;i++){
            ans.add(new ArrayList<>());
        }
        
        Queue<vPair> que=new LinkedList<>();
        que.add(new vPair(Math.abs(min),root));
        
        while(que.size()>0){
            
            vPair cur=que.remove();
            ans.get(cur.vl).add(cur.node.val);
            
            if(cur.node.left!=null)
                que.add(new vPair(cur.vl-1,cur.node.left));
            
            if(cur.node.right!=null)
                que.add(new vPair(cur.vl+1,cur.node.right));
        }
        
        return ans;
    }
    
    public static void width(TreeNode root,int[] ans,int vl){
        
        if(root==null)
            return;
        
        else{
            
            if(vl<ans[0]){
                ans[0]=vl;
            }
            if(vl>ans[1]){
                ans[1]=vl;
            }
            
            width(root.left,ans,vl-1);
            width(root.right,ans,vl+1);
            
        }
        
    }

    public static void main(String[] args) {
        
    }
}