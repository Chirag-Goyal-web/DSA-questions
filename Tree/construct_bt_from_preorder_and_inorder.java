public class construct_bt_from_preorder_and_inorder{

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        return buildTreeHelper(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
                
    }
            
    //psi-Preorder starting index
    //pei-Preorder ending index
    //isi-Inorder starting index
    //iei-Inorder ending index
    
    public TreeNode buildTreeHelper(int[] preorder,int[] inorder,int psi,int pei,int isi,int iei){
        
        if(psi>pei){
            return null;
        }
        
        else if(psi==pei){
            return new TreeNode(preorder[psi]);
        }
        
        else{
            
            int temp=isi;
            
            while(preorder[psi]!=inorder[temp]){
                temp++;
            }
            
            int len=temp-isi;
            
            TreeNode node=new TreeNode(preorder[psi]);
            
            node.left=buildTreeHelper(preorder,inorder,psi+1,psi+len,isi,temp-1);
            node.right=buildTreeHelper(preorder,inorder,psi+len+1,pei,temp+1,iei);
            
            return node;
            
        }
        
    }


}