import java.util.*;
public class Print_Binary_Tree{

    * public class TreeNode {
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

    class Solution {
    
        static int count=0;
        
        public List<List<String>> printTree(TreeNode root) {
    
            count=0;
            
            int h=height(root);
            int n=(int)(Math.pow(2,h)-1);
            
            List<List<String>> ls=new ArrayList<>();
            
            List<String> temp=new ArrayList<>();
            
            for(int i=0;i<n;i++){
                temp.add("");
            }
            
            for(int i=0;i<h;i++){
                ls.add(new ArrayList<>(temp));
            }
            
            preorder(root,h,0,ls,0,n-1);
            
            return ls;
        }
        
        public int height(TreeNode root){
            
            if(root==null){
                return 0;
            }
            
            else if(root.left==null && root.right==null){
                return 1;
            }
            
            else{
                
                int l=height(root.left);
                int h=height(root.right);
                
                return l>h?l+1:h+1;
                
            }
            
        }
        
        public void preorder(TreeNode root,int height,int depth,List<List<String>> ls,int left,int right){
            
            if(root==null){
                return;
            }
            
            else{
                
                int mid=(left+right)/2;
                
                ls.get(depth).set(mid,root.val+"");
                
                preorder(root.left,height-1,depth+1,ls,left,mid-1);
                preorder(root.right,height-1,depth+1,ls,mid+1,right);
                
            }
            
        }
        
    }

    public static void main(String[] args) {
        
    }
}