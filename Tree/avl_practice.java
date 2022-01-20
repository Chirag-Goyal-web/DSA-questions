public class avl_practice{

    public static class TreeNode{
        int height;
        int balance;
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val=val;
        }
    }

    public static void updateHeightAndBalance(TreeNode node){
        int t1=node.left==null?-1:node.left.height;
        int t2=node.right==null?-1:node.right.height;
        node.height=Math.max(t1,t2)+1;
        node.balance=t1-t2;
    }

    public static TreeNode getRotation(TreeNode node){
        updateHeightAndBalance(node);
        if(node.balance==2){
            if(node.left.balance==1){
               // System.out.println("Hlo");
                return rightRotation(node);
            }
            else{
                node.left=leftRotation(node.left);
                return rightRotation(node);
            }
        }
        else if(node.balance==-2){
            if(node.right.balance==-1){
                return leftRotation(node);
            }
            else{
                node.right=rightRotation(node.right);
                return leftRotation(node);
            }
        }
        else{
            return node;
        }
    }

    public static TreeNode rightRotation(TreeNode node){
        TreeNode temp=node.left;
        node.left=null;
        node.left=temp.right;
        temp.right=node;
        updateHeightAndBalance(node);
        updateHeightAndBalance(temp);
        return temp;
    }

    public static TreeNode leftRotation(TreeNode node){
        TreeNode temp=node.right;
        node.right=null;
        node.right=temp.left;
        temp.left=node;
        updateHeightAndBalance(node);
        updateHeightAndBalance(temp);
        return temp;
    }

    public static TreeNode add(TreeNode root,int val){
        if(root==null){
            return new TreeNode(val);
        }
        else{
            if(val>root.val){
                root.right=add(root.right,val);
                return getRotation(root);
            }
            else{
                root.left=add(root.left,val);
                return getRotation(root);
            }
        }
    }

    public static void preorder(TreeNode root){
        if(root==null){
            return ;
        }
        else{
            System.out.print(root.val+" ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    public static void inorder(TreeNode root){
        if(root==null){
            return ;
        }
        else{
            inorder(root.left);
            System.out.print(root.val+" ");
            inorder(root.right);
        }
    }
 
    public static TreeNode delete(TreeNode root,int val){
        if(root==null){
            return null;
        }
        else if(root.val==val){
            if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }
            else{
                TreeNode rmn=getRightMostNode(root.left);
                root.val=rmn.val;
                root.left=delete(root.left,rmn.val);
                return getRotation(root);
            }
        }
        else{
            if(root.val>val){
                root.left=delete(root.left, val);
                return getRotation(root);
            }
            else{
                root.right=delete(root.right, val);
                return getRotation(root);
            }
        }
    }

    public static TreeNode getRightMostNode(TreeNode root){
        while(root.right!=null){
            root=root.right;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root=null;
        
        for(int i=1;i<11;i++){
            root=add(root, i);
        }

        root=delete(root,4);
        root=delete(root,5);
        root=delete(root,6);
        root=delete(root,7);
        root=delete(root,8);
        root=delete(root,9);
        root=delete(root,10);

        preorder(root);
        System.out.println();
        inorder(root);
    }

}