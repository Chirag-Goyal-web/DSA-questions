public class inorder_predecessor_and_successor_in_bt{

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    //Approach - 1 (Using recursion)
    static TreeNode prev=null,pred=null,succ=null;

    public void inorderPreSuc_1(TreeNode root,int key){
        
        if(root==null){
            return;
        }
        
        else{
            
            inorderPreSuc_1(root.left,key);
            
            if(root.val==key){
                pred=prev;
            }
            
            if(prev!=null && prev.val==key){
                
                succ=root;
            }
            
            System.out.println(root.val);
            
            prev=root;
            
            inorderPreSuc_1(root.right,key);
            
        }
        
    }

    //Approach - 2 (Using Inorder morris traversal)
    public static void inorderPreSuc_2(TreeNode root,int key){

        TreeNode curr=root,prev=null,pred=null,succ=null;

        while(curr!=null){
            
            TreeNode left=curr.left;

            if(left==null){
               
                if(curr.val==key){
                    pred=prev;
                }

                if(prev!=null && prev.val==key){
                    succ=curr;
                }
                prev=curr;
                curr=curr.right;
            }

            else{
                
                TreeNode rmn=getRightMostNode(left,curr);

                if(rmn.right==null){
                    rmn.right=curr;
                    curr=curr.left;
                }

                else{
                    rmn.right=null;

                    if(curr.val==key){
                        pred=prev;
                    }
    
                    if(prev!=null && prev.val==key){
                        succ=curr;
                    }

                    prev=curr;
                    curr=curr.right;
                }

            }

        }

        if(pred!=null){
            System.out.println(pred.val);
        }

        if(succ!=null){
            System.out.println(succ.val);
        }
        
    }

    public static TreeNode getRightMostNode(TreeNode node,TreeNode curr){
        
        while(node.right!=null && node.right!=curr){
            node=node.right;
        }

        return node;
    }

    public static void main(String[] args){
        
    }

}