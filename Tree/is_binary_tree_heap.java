import java.util.Queue;
import java.util.LinkedList;

public class is_binary_tree_heap{

    class Node{
        int data;
        Node left,right;
        Node(int d){
            data=d;
            left=right=null;
        }
    }

    class Our{
        
        boolean b;
        int max;
        
        Our(boolean b,int max){
            this.b=b;
            this.max=max;
        }
        
    }
    
	boolean isHeap(Node tree)
	{
	    Our o=isHeap_(tree);
	    boolean b=isCompleteTree(tree);
	    return o.b&&b;
	}
	
	Our isHeap_(Node tree){
	    
	    if(tree==null){
	        return new Our(true,Integer.MIN_VALUE);
	    }
	    
	    else{
	        
	        Our left=isHeap_(tree.left);
	        Our right=isHeap_(tree.right);
	        
	        if(left.b==false || right.b==false){
	            return new Our(false,0);
	        }
	        
	        else{
	            
	            if(tree.data>=left.max && tree.data>=right.max){
	                return new Our(true,tree.data);
	            }
	            
	            else{
	                return new Our(false,0);
	            }
	            
	        }
	        
	    }
	    
	}
	
	boolean isCompleteTree(Node root) {
        
        if(root==null){
            return true;
        }
        
        else{
            
            boolean end=false;
            
            Queue<Node> queue=new LinkedList<>();
            queue.add(root);
            
            while(queue.size()>0){
                
                Node temp=queue.remove();
                
                if(temp==null)
                    end=true;
                
                else{
                    
                    if(end){
                        return false;
                    }
                    
                    else{
                        queue.add(temp.left);
                        queue.add(temp.right);
                    }
                    
                }
                
            }
            
            return true;
        }
         
    }

    public static void main(String[] args) {
        
    }

}