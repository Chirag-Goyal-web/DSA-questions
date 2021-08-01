import java.util.ArrayList;

public class root_to_leaf_path_sum_2{

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    
        TreeNode(int val) {
          this.val = val;
        }
        
      }

    public static ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int targetSum) {
    
        if(root==null){
            return new ArrayList<>();
        }
        
        else if(root.left==null && root.right==null){
            
            targetSum-=root.val;
            ArrayList<ArrayList<Integer>> temp=new ArrayList<>();
            
            if(targetSum==0){
                ArrayList<Integer> ans=new ArrayList<>();
                ans.add(root.val);
                temp.add(ans);
                return temp;
            }
            
            else{
                return temp;
            }
        }
        
        else{
            
            targetSum-=root.val;
            ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
            ArrayList<ArrayList<Integer>> left=pathSum(root.left,targetSum);
            
            for(ArrayList<Integer> temp:left){
                temp.add(0,root.val);
                ans.add(temp);
            }
            
            ArrayList<ArrayList<Integer>>right=pathSum(root.right,targetSum);
            
            for(ArrayList<Integer> temp:right){
                temp.add(0,root.val);
                ans.add(temp);
            }
            
            return ans;
        }
        
      }

    public static void main(String[] args) {
        
    }
}