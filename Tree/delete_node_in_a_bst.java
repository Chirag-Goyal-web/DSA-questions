public class delete_node_in_a_bst{

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    
    //Approach-1 (Recursive approach)
    public TreeNode deleteNode(TreeNode root, int key) {
        
        if(root==null){
            return root;
        }
        
        else{
            
            if(key<root.val){
                root.left=deleteNode(root.left,key);
            }
            
            else if(key>root.val){
                root.right=deleteNode(root.right,key);
            }
            
            else{
                
                if(root.left==null || root.right==null){
                    return root.left!=null?root.left:root.right;
                }
                
                else{
                    
                    int val=getMin(root.left);
                    root.val=val;
                    root.left=deleteNode(root.left,val);
                    
                }
                
            }
            
            return root;
        }
        
    }
    
    
    public int getMin(TreeNode node){
        
        while(node!=null && node.right!=null){
            node=node.right;
        }
        
        return node.val;
    }


    //Approach-2 (Iterative approach)
    public TreeNode deleteNode_2(TreeNode root, int key) {
        
        if(root==null){
            return root;
        }
        
        if(root.val==key){
            
            if(root.left==null||root.right==null){
                return root.left!=null?root.left:root.right;
            }
            
            else{
                
                TreeNode leftNode=root.left;
                
                if(leftNode.right==null){
                    root.val=leftNode.val;
                    root.left=leftNode.left;
                    return root;
                }
                
                else{
                    
                    int temp=getRightMost(leftNode);
                    root.val=temp;
                    return root;
                    
                }
                
            }
            
        }
        
        TreeNode cur=root,prev=null;
        int indicator=0;
        
        while(cur!=null){
            
            if(key>cur.val){
                indicator=2;
                prev=cur;
                cur=cur.right;
            }
            
            else if(key<cur.val){
                indicator=1;
                prev=cur;
                cur=cur.left;
            }
            
            else{
                break;
            }
            
        }
        
        if(cur==null){
            return root;
        }
        
        else{
            
            if(cur.left==null||cur.right==null){
                
                if(cur.left!=null){
                    
                    if(indicator==1){
                        prev.left=cur.left;
                    }
                    
                    else{
                        prev.right=cur.left;
                    }
                    
                }
                
                else {
                    
                    if(indicator==1){
                        prev.left=cur.right;
                    }
                    
                    else{
                        prev.right=cur.right;
                    }
                    
                }
                
                return root;
                
            }
            
            else{
                
                TreeNode leftNode=cur.left;
                
                if(leftNode.right==null){
                    cur.val=leftNode.val;
                    cur.left=leftNode.left;
                    return root;
                }
                
                else{
                    
                    int temp=getRightMost(leftNode);
                    cur.val=temp;
                    return root;
                    
                }
                
                
            }
            
        }
        
    }
    
    public int getRightMost(TreeNode leftNode){
        
        TreeNode prev=null;
        
        while(leftNode.right!=null){
            prev=leftNode;
            leftNode=leftNode.right;
        }
        
        int temp=leftNode.val;
        prev.right=leftNode.left;
        leftNode=null;
        return temp;
    }

    public static void main(String[] args) {
        
    }

}