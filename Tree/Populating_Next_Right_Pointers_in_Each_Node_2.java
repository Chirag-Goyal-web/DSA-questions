public class Populating_Next_Right_Pointers_in_Each_Node_2{

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

    class Solution {
        public Node connect(Node root) {
            
            Node leftMost=null,prev=null,itr=root;
            
            while(itr!=null){
                
                leftMost=null;
                prev=null;
               
                while(itr!=null){
                    
                    Node l1=itr.left,l2=itr.right;
                    
                    if(l1!=null){
                        
                        if(leftMost==null){
                            leftMost=l1;
                        }
                        
                        if(prev==null){
                            prev=l1;
                        }else{
                            prev.next=l1;
                            prev=l1;
                        }
                        
                    }
                    
                    if(l2!=null){
                        if(leftMost==null){
                            leftMost=l2;
                        }
                        
                        if(prev==null){
                            prev=l2;
                        }
                        else{
                            prev.next=l2;
                            prev=l2;
                        }
                        
                    }
                    
                    itr=itr.next;
                    
                }
                
                itr=leftMost;
            }
            
            return root;
        }
    }

    public static void main(String[] args) {
        
    }
}