public class construct_bt_from_preorder_and_postorder{

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    //psi- preorder starting index
    //pei- preorder ending index
    //sip- postorder starting index
    //eip- postorder ending index

    public static TreeNode constructFromPrePost(int[] pre, int[] post) {
        return constructFromPrePostHelper(pre,post,0,pre.length-1,0,post.length-1);
    }

    public static TreeNode constructFromPrePostHelper(int[] pre,int[] post,int psi,int pei,int sip,int eip){

        if(psi>pei){
            return null;
        }

        else if(psi==pei){
            return new TreeNode(pre[psi]);
        }

        else{

            int temp=sip;

            while(pre[psi+1]!=post[temp]){
                temp++;
            }

            int len=temp-sip+1;

            TreeNode root=new TreeNode(pre[psi]);

            root.left=constructFromPrePostHelper(pre,post,psi+1,psi+len,sip,sip+len-1);
            root.right=constructFromPrePostHelper(pre,post,psi+len+1,pei,sip+len,eip-1);
            
            return root;
        }

    }

}