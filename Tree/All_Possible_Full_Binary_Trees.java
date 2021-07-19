import java.util.*;
public class All_Possible_Full_Binary_Trees{

    public static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
         }
        }

    public ArrayList<TreeNode> allPossibleFBT(int N) {
        
        if(N%2==0){
            return new ArrayList<>();
        }
        
        else if(N==1){
            ArrayList<TreeNode> temp=new ArrayList<>();
            temp.add(new TreeNode(0));
            return temp;
        }
        
        else{
            
            N=N-1;
            ArrayList<TreeNode> ls=new ArrayList<>();
            for(int i=1;i<=N;i+=2){
                
                ArrayList<TreeNode> l1=allPossibleFBT(i);
                ArrayList<TreeNode> l2=allPossibleFBT(N-i);
                
                for(TreeNode n1:l1){
                    for(TreeNode n2:l2){
                        TreeNode nw=new TreeNode(0,n1,n2);
                        ls.add(nw);
                    }
                }
                
            }
            
            return ls;
        }
        
    }

    public static void main(String[] args) {
        
    }

}