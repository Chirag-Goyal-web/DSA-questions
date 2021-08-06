public class binary_tree_coloring_game_leetcode_1145{

    class Solution {
    
        public static class TreeNode {
            int val = 0;
            TreeNode left = null;
            TreeNode right = null;
    
            TreeNode(int val) {
                this.val = val;
            }
        }

        public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
            
            TreeNode temp=find(root,x);
            
            int left=count(temp.left);
            int right=count(temp.right);
    
            //int count=blockCount(root,x);
            
            int count=n-left-right-1;
            
            if((count>(left+right+1))||(left>(count+right+1))||(right>(count+left+1))){
                return true;
            }
           
            return false;
        }
        
        public TreeNode find(TreeNode root,int x){
            
            if(root==null){
                return null;
            }
            
            else if(root.val==x){
                return root;
            }
            
            else{
                
                TreeNode temp=find(root.left,x);
                
                if(temp!=null){
                    return temp;
                }
                
                else{
                    return find(root.right,x);
                }
                
            }
            
        }
        
    //     public int blockCount(TreeNode root,int x){
            
    //         if(root==null){
    //             return 0;
    //         }
            
    //         else if(root.val==x){
    //             return 0;
    //         }
            
    //         else{
    //             return blockCount(root.left,x)+blockCount(root.right,x)+1;
    //         }
            
    //     }
        
        public int count(TreeNode root){
            if(root==null){
                return 0;
            }
            else{
                return count(root.left)+count(root.right)+1;
            }
        }
        
    }

}