public class AVLTree{

    static class TreeNode{
        int height;
        int balance;
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val=val;
        }
    }

    public static void updateHeightAndBalance(TreeNode root){

        int lh=root.left==null?-1:root.left.height;
        int rh=root.right==null?-1:root.right.height;

        root.height=Math.max(lh,rh)+1;
        root.balance=lh-rh;

    }

    public static TreeNode rightRotation(TreeNode root){
        TreeNode b=root.left;
        TreeNode bRight=b.right;
        b.right=root;
        root.left=bRight;
        updateHeightAndBalance(root);
        updateHeightAndBalance(b);
        return b;
    }

    public static TreeNode leftRotation(TreeNode root){
        TreeNode b=root.right;
        TreeNode bLeft=b.left;
        b.left=root;
        root.right=bLeft;
        updateHeightAndBalance(root);
        updateHeightAndBalance(b);
        return b;
    }

    public static TreeNode getRotation(TreeNode root){

        updateHeightAndBalance(root);

        if(root.balance==2){
            
            if(root.left.balance==1){
                return rightRotation(root);
            }

            else{
                root.left=leftRotation(root.left);
                return rightRotation(root);
            }

        }

        else if(root.balance==-2){

            if(root.right.balance==-1){
                return leftRotation(root);
                
            }

            else{
                root.right=rightRotation(root.right);
                return leftRotation(root);
            }

        }

        return root;
    }

    public static TreeNode add(TreeNode root,int val){

        if(root==null){
            return new TreeNode(val);
        }

        else{
            
            if(val<root.val){
                root.left=add(root.left,val);
            }

            else{
                root.right=add(root.right,val);
            }

            return getRotation(root);
        }
    }

    public static int getRightMost(TreeNode root){

        while(root.right!=null){
            root=root.right;
        }

        return root.val;
    }

    public static TreeNode remove(TreeNode root,int val){

        if(root==null){
            return null;
        }

        else{
            
            if(val>root.val){
                root.right=remove(root.right,val);
            }
            
            else if(val<root.val){
                root.left=remove(root.left,val);
            }
            
            else{

                if(root.left==null||root.right==null){
                    return root.left!=null?root.left:root.right;
                }

                else{
                    root.val=getRightMost(root.left);
                    root.left=remove(root.left,root.val);
                }

            }

            return getRotation(root);
        }

    }

    public static void display(TreeNode root)
    {
        if (root == null)
            return;

        String ans = "";
        ans += root.left != null ? (root.left.val) : ".";
        ans += " -> " + (root.val) + " <- ";
        ans += root.right != null ? (root.right.val) : ".";

        // cout << ans << endl;

        System.out.println(ans);

        display(root.left);
        display(root.right);
    }

    public static void main(String[] args) {
        
        TreeNode root=null;
        
        for(int i=1;i<=15;i++){
            root=add(root,i);
        }

        remove(root,8);
        remove(root,4);
        remove(root,2);
        remove(root,7);
        remove(root,5);
        remove(root,10);
        display(root);

    }

}