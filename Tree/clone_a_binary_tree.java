public class clone_a_binary_tree{

class Solution{
    
    class Tree{
        int data;
        Tree left,right,random;
        Tree(int d){
            data=d;
            left=null;
            right=null;
            random=null;
        }
    }

    public static Tree cloneTree(Tree tree){
       
       preorder(tree);
      
       rightConnect(tree);
       connect(tree);
       
      Tree ans=tree.left; 
       
       separate(tree);
       
       return ans;
     }
     
     public static void preorder(Tree tree){
         
         if(tree==null){
             return;
         }
         
         else{
             
             Tree nw=new Tree(tree.data);
             
             nw.left=tree.left;
             tree.left=nw;
             
             preorder(tree.left.left);
             preorder(tree.right);
             
         }
         
     }
     
     public static void rightConnect(Tree root){
         
         if(root==null){
             return;
         }
         
         else{
             
             if(root.right!=null){
                 root.left.right=root.right.left;
             }
             
             rightConnect(root.left.left);
             rightConnect(root.right);
         }
         
     } 
     
     public static void connect(Tree root){
         
         if(root==null){
             return;
         }
         
         else{
             
             if(root.random!=null){
                 root.left.random=root.random.left;
             }
             
             connect(root.left.left);
             connect(root.right);
         }
         
     }
     
     public static void separate(Tree root){
         
         if(root==null){
             return;
         }
         
         else{
             
             Tree temp=root.left;
             root.left=temp.left;
             
             if(root.left!=null){
                 temp.left=root.left.left;
             }
             
             separate(root.left);
             separate(root.right);
             
         }
         
     }
     
}

    
}