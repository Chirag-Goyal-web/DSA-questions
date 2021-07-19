public class Image_Multiplication{

    class Node{
        public int data;
        public Node left,right;
        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    class Solution {
    
        public long imgMultiply(Node root)
        {
            
            if(root==null){
                return 0;
            }
            
            else{
                
                long val=function(root.left,root.right);
                
                return (val+(root.data*root.data))%1000000007;
                
            }
            
        }
        
        public long function(Node root1,Node root2){
            
            if(root1==null || root2==null){
                return 0;
            }
            
            else{
                
                long l1=function(root1.left,root2.right);
                long l2=function(root1.right,root2.left);
                
                return l1+l2+(root1.data*root2.data);
                
            }
            
        }
        
    }

    public static void main(String[] args) {
        
    }

}