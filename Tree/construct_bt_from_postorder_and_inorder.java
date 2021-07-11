public class construct_bt_from_postorder_and_inorder{
    
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree_(postorder,inorder,0,postorder.length-1,0,inorder.length-1);

    }
   
    public  static TreeNode buildTree_(int[] postorder, int[] inorder,int psi,int pei,int isi,int iei){
        
        if(psi>pei || isi>iei){
            return null;
        }

        else{

            int idx=isi;

            while(postorder[pei]!=inorder[idx]){
                idx++;
            }

            TreeNode root=new TreeNode(postorder[pei]);
            int len=idx-isi-1;
            root.left=buildTree_(postorder,inorder,psi,psi+len,isi,idx-1);
            root.right=buildTree_(postorder,inorder,psi+len+1,pei-1,idx+1,iei);

            return root;
        }

    }


}