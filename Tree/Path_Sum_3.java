import java.util.HashMap;

public class Path_Sum_3{

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    class Solution {
    
        public int pathSum(TreeNode root, int targetSum) {
            count=0;
            HashMap<Integer,Integer> hm=new HashMap<>();
            hm.put(0,1);
            function(root,targetSum,0,hm);
            return count;
        }
        
        int count=0;
        
        public void function(TreeNode root,int targetSum,int temp,HashMap<Integer,Integer> hm){
            
            if(root==null){
                return;
            }
           
            else{
                
                temp+=root.val;
                
                count+=hm.getOrDefault(temp-targetSum,0);
                
                hm.put(temp,hm.getOrDefault(temp,0)+1);
                
                function(root.left,targetSum,temp,hm);
                function(root.right,targetSum,temp,hm);
                
                hm.put(temp,hm.getOrDefault(temp,0)-1);
            }
            
        }
        
    }

    public static void main(String[] args) {
        
    }
}