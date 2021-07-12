import java.util.List;
import java.util.ArrayList;
public class path_sum_2{

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }


    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        
        getSum(root,targetSum,0,ans,temp);
        
        return ans;
        
    }
    
    public void getSum(TreeNode root,int targetSum,int tempSum,List<List<Integer>> ans,List<Integer> temp){
        
        if(root==null){
            return;
        }
        
        else if(root.left==null && root.right==null){
            
            tempSum+=root.val;
            temp.add(root.val);
            
            if(tempSum==targetSum){
                
                List<Integer> deepCopy=new ArrayList<>(temp);
                
                ans.add(deepCopy);
            }
            
            temp.remove(temp.size()-1);
            return;
        }
        
        else{
            
            tempSum+=root.val;
            temp.add(root.val);
            
            getSum(root.left,targetSum,tempSum,ans,temp);
            getSum(root.right,targetSum,tempSum,ans,temp);
            
            temp.remove(temp.size()-1);
        }
        
    }

    public static void main(String[] args) {
        
    }
}