//import java.util.*;

public class Populating_Next_Right_Pointers_in_Each_Node{

    //LINES ARE COMMENTED BCOZ THESE WERE GIVING ERRORS IN VSCODE for no reason(Working fine on leetcode)

    class Node {

        public int val;
        public Node left;
        public Node right;
        public Node next;
    
        public Node() {}
        
        public Node(int _val) {
            val = _val;
        }
    
        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    //Approach-1 (Using extra space && preorder)
    // class Solution_01 {

    //     public Node connect(Node root) {
            
    //         List<List<Node>> ls=new ArrayList<>();
            
    //         preorder(root,0,ls);
            
    //         for(int i=0;i<ls.size();i++){
                
    //             List<Node> temp=ls.get(i);
                
    //             for(int j=0;j<temp.size()-1;j++){                
    //                 temp.get(j).next=temp.get(j+1);
    //             }
                
    //         }
    //         return root;
            
    //     }
        
    //     public void preorder(Node root,int level,List<List<Node>> ans){
                
    //             if(root==null){
    //                 return;
    //             }
                
    //             else{
                    
    //                 if(ans.size()<=level){
    //                     ans.add(new ArrayList<>());
    //                 }
                    
    //                 ans.get(level).add(root);
                    
    //                 preorder(root.left,level+1,ans);
    //                 preorder(root.right,level+1,ans);
                    
    //             }
                
    //         }   
   
    // }
    
    //Approach-2 Using Rescursion
    class Solution_02 {
        
        public Node connect(Node root) {
            
            if(root==null || root.left==null){
                return root;
            }
            
            else{
                helper(root.left,root.right);
                return root;
            }
            
        }
        
        public void helper(Node leftTree,Node rightTree){
            
            leftTree.next=rightTree;
            
            if(leftTree.left!=null){
                
                helper(leftTree.left,leftTree.right);
                helper(rightTree.left,rightTree.right);
                helper(leftTree.right,rightTree.left);
                
            }
            
        }
        
    }
    
    //Iterative solution
    
    //void connect(Node *root) {
    //     if (root == NULL) return;
    //     TreeLinkNode *pre = root;
    //     TreeLinkNode *cur = NULL;
    //     while(pre->left) {
    //         cur = pre;
    //         while(cur) {
    //             cur->left->next = cur->right;
    //             if(cur->next) cur->right->next = cur->next->left;
    //             cur = cur->next;
    //         }
    //         pre = pre->left;
    //     }
    // }
    
    public static void main(String[] args) {
        
    }
}