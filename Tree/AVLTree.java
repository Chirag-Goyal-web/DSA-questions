public class AVLTree{

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        int bal;
        int height;
        
        TreeNode(int val){
            this.val=val;
        }
            
    }

    public static void updateHeightAndBalance(TreeNode root){

        int lh=root.left!=null?root.left.height:-1;
        int rh=root.right!=null?root.right.height:-1;

        root.bal=lh-rh;
        root.height=Math.max(lh,rh)+1;        

    }

    public static TreeNode rightRotation(TreeNode root){
        TreeNode b=root.left;
        TreeNode bkaRight=b.right;
        b.right=root;
        root.left=bkaRight;
        updateHeightAndBalance(root);
        updateHeightAndBalance(b);
        return b;
    }

    public static TreeNode leftRotation(TreeNode root){
        TreeNode b=root.right;
        TreeNode bkaLeft=b.left;
        b.left=root;
        root.right=bkaLeft;
        updateHeightAndBalance(root);
        updateHeightAndBalance(b);
        return b;
    }

    public static TreeNode getRotation(TreeNode root){

        updateHeightAndBalance(root);
        int bal=root.bal;

        if(bal==2){
            if(root.left.bal==1){
                return leftRotation(root);
            }
            else{

            }
        }
        
        else if(bal==-2){
            if(root.right.bal==1){
                return rightRotation(root);
            }
            else{

            }
        }


    }

    public static TreeNode addNode(int node,TreeNode root){

        if(root==null){
            return new TreeNode(node);
        }

        else if(node<root.val){
            root.left=addNode(node,root.left);
        }

        else{
            root.right=addNode(node,root.right);
        }

        return getRotation(root);

    }

    // public static TreeNode removeNode(TreeNode node,TreeNode root){
        
    //     if(root==node){

    //         if(node.left==null && node.right==null){
    //             return null;
    //         }



    //     }
        
    //     else if(node.val<root.val){
    //          root.left=removeNode(node, root.left);
    //          return root;
    //     }

    //     else{
    //         root.right=removeNode(node, root.right);
    //         return root;
    //     }

    // }

}