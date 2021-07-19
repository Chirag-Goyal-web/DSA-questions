import java.util.*;
public class top_view_of_a_binary_tree{

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static class tPair{
        int level;
        TreeNode node;
        tPair(int l,TreeNode node){
            this.level=l;
            this.node=node;
        }
    }
    
    public static ArrayList<Integer> TopView(TreeNode root) {
        
        if(root==null){
            return new ArrayList<>();
        }
        
        int[] ans=new int[2];
        
        width(root,ans,0);
        
        int w=ans[1]-ans[0]+1;
        
        Queue<tPair> que=new LinkedList<>();
       // que.add(new tPair(Math.abs(ans[0]),root));
        
        que.add(new tPair(Math.abs(ans[0]),root));
        
        ArrayList<Integer> arr=new ArrayList<>();
       
        for(int i=0;i<w;i++){
            arr.add(null);
        }
        
        while(que.size()>0){
            
            tPair temp=que.remove();
            
            if(arr.get(temp.level)==null){
                arr.set(temp.level,temp.node.val);
            }
            
            if(temp.node.left!=null){
                que.add(new tPair(temp.level-1,temp.node.left));    
            }
            
            if(temp.node.right!=null){
                que.add(new tPair(temp.level+1,temp.node.right));
            }
            
        }
     
     return arr;   
    }

    public static void width(TreeNode root,int[] ans,int level){
        
        if(root==null){
            return;
        }
        
        else{
            
            if(level<ans[0]){
                ans[0]=level;
            }
            
            if(level>ans[1]){
                ans[1]=level;
            }
            
            width(root.left,ans,level-1);
            width(root.right,ans,level+1);
            
        }
        
    }

    public static void main(String[] args) {
        
    }

}