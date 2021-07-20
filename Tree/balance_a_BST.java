import java.util.*;
public class balance_a_BST{

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

    //Approach-1 (First insert all the value in a arraylist, then make a tree from that list)
    class Solution_1 {
    
        public TreeNode balanceBST(TreeNode root) {
            
            ArrayList<Integer> ls=new ArrayList<>();
            preorder(root,ls);
            
            return helper(ls,0,ls.size()-1);
        }
        
        public TreeNode helper(ArrayList<Integer> ls,int s,int e){
            
            if(s>e){
                return null;
            }
            
            else if(e==s){
                return new TreeNode(ls.get(s));
            }
            
            else{
                
                
                int mid=(s+e)/2;
                TreeNode n=new TreeNode(ls.get(mid));
                
                n.left=helper(ls,s,mid-1);
                n.right=helper(ls,mid+1,e);
                
                return n;
            }
            
        }
        
        public void preorder(TreeNode root,ArrayList<Integer> ls){
            
            if(root==null){
                return;
            }
            
            else{
                preorder(root.left,ls);
                ls.add(root.val);
                preorder(root.right,ls);
            }
            
        }
        
    }

    //Approach-2 (Convert tree to doubly linked list using morris traversal, then convert linked list to tree)
    class Solution_2 {
    
        public TreeNode balanceBST(TreeNode root) {
            root=morris(root);
            root.left=null;
            root=LLtoBT(root);
            return root;
        }
        
        public TreeNode LLtoBT(TreeNode root){
            
            if(root==null || root.right==null){
                return root;
            }
            
            else{
                
                TreeNode midNode=getMidNode(root);
    
                TreeNode back=midNode.left;
                TreeNode front=midNode.right;
                
                midNode.right=null;
                midNode.left=null;
                
                if(back!=null){
                    back.right=null;
                }
                
                if(front!=null){
                    front.left=null;
                }
                
                midNode.left=back==null?null:LLtoBT(root);
                midNode.right=LLtoBT(front);
                
                return midNode;
            }
            
        }
        
        public TreeNode getMidNode(TreeNode root){
            
            if(root==null || root.right==null){
                return root;
            }
            
            else{
                
                TreeNode slow=root,fast=root;
                
                while(fast.right!=null && fast.right.right!=null){
                    fast=fast.right.right;
                    slow=slow.right;
                }
                return slow;
            }
            
        }
        
        public TreeNode getRightMost(TreeNode node,TreeNode root){
            
            while(node.right!=null && node.right!=root){
                node=node.right;
            }
            
            return node;
        }
        
        public TreeNode getLeftMost(TreeNode root){
            while(root.left!=null){
                root=root.left;
            } 
            return root;
        }
        
        public TreeNode morris(TreeNode root){
            
            TreeNode head=getLeftMost(root);
            TreeNode prev=null;
            
            while(root!=null){
                
                TreeNode leftNode=root.left;
                
                if(leftNode==null){
                    
                    if(prev!=null)
                       prev.right=root;
        
                    root.left=prev;
                    prev=root;
                    root=root.right;
                }
                
                else{
                    
                    TreeNode rightMost=getRightMost(leftNode,root);
                    
                    if(rightMost.right==null){
                        rightMost.right=root;
                        root=root.left;
                    }
                    
                    else{
                        rightMost.right=null;
                        if(prev!=null){
                            prev.right=root;
                        }
                        root.left=prev;
                        prev=root;
                        root=root.right;
                    }
                    
                }
                
            }
            
            return head;
            
        }
        
    }


    //Approach-3 Using AVL rotations
    
class Solution_3{
    
    int[] height=new int[(int)1e6];
    
    public void updateHeight(TreeNode root){
        
        int lh=root.left!=null?height[root.left.val]:-1;
        int rh=root.right!=null?height[root.right.val]:-1;
        
        height[root.val]=Math.max(lh,rh)+1;
        
    }
    
    public int getBalanceFactor(TreeNode node){
        
        int l=node.left==null?-1:height[node.left.val];
        int r=node.right==null?-1:height[node.right.val];
    
        return l-r;
    }    
    
    public TreeNode leftRotation(TreeNode a){
        
        TreeNode b=a.right;
        TreeNode bKaLeft=b.left;
        
        b.left=a;
        a.right=bKaLeft;
        
        updateHeight(a);
        updateHeight(b);
        
        b.left=getRotation(a);
        
        return getRotation(b);
        
    }
    
    public TreeNode rightRotation(TreeNode a){
        
        TreeNode b=a.left;
        TreeNode bKaRight=b.right;
        
        b.right=a;
        a.left=bKaRight;
        
        updateHeight(a);
        updateHeight(b);
        
        b.right=getRotation(a);
        return getRotation(b);
        
    }
    
    public TreeNode getRotation(TreeNode root){
        
        updateHeight(root);
        
        if(getBalanceFactor(root)>=2){
            
            if(getBalanceFactor(root.left)>=1){
                return rightRotation(root);
            }
            
            else{
                root.left=leftRotation(root.left);
                return rightRotation(root);
            }
            
        }
        
        else if(getBalanceFactor(root)<=-2){
            
            if(getBalanceFactor(root.right)<=-1){
                return leftRotation(root);
            }
            
            else{
                root.right=rightRotation(root.right);
                return leftRotation(root);
            }
            
        }
        
        return root;
    }
    
    public TreeNode balanceBST(TreeNode root) {
        
        height=new int[(int)1e6];
        return helper(root);
        
    }
    
    public TreeNode helper(TreeNode root){
      
        if(root==null){
            return root;
        }
        
        else{
            
            root.left=helper(root.left);
            root.right=helper(root.right);
            
            return getRotation(root);
        }
        
    }
    
}

    public static void main(String[] args) {
        
    }
}