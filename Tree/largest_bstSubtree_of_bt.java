public class largest_bstSubtree_of_bt{
    
    class Node  
    { 
        int data; 
        Node left, right; 
    
        public Node(int d)  
        { 
            data = d; 
            left = right = null; 
        } 
    }

    public static class BSTPair{
        
        boolean isBST=true;
        int size=0;
        int minV=Integer.MAX_VALUE;
        int maxV=Integer.MIN_VALUE;
        
        BSTPair(boolean isBST,int size,int minV,int maxV){
            this.isBST=isBST;
            this.size=size;
            this.minV=minV;
            this.maxV=maxV;
        }
        
    }
    
    static int ans=0;
    
    // Return the size of the largest sub-tree which is also a BST
    public static int largestBst(Node root){
        ans=0;
        largestBst_(root);
        return ans;
    }
    
    public static BSTPair largestBst_(Node root){
        
        if(root==null){
            return new BSTPair(true,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }
        
        else{
            
            BSTPair left=largestBst_(root.left);
            BSTPair right=largestBst_(root.right);
            
            if(left.isBST==true && right.isBST==true && root.data>left.maxV && root.data<right.minV){
                //System.out.println(ans);
                ans=Math.max(left.size+right.size+1,ans);
                return new BSTPair(true,left.size+right.size+1,Math.min(root.data,left.minV),Math.max(root.data,right.maxV));
            }
            
            else{
                return new BSTPair(false,0,0,0);
            }
        }
        
    }
    
    public static void main(String[] args){
        System.out.println("Hey");
    }

}