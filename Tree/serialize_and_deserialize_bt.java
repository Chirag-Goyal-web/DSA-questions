import java.util.LinkedList;
import java.util.List;

public class serialize_and_deserialize_bt{

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    //Approach - 1 (Using levelorder)
    public static String serialize_01(TreeNode root) {
        
        if(root==null){
            return "";
        }
        
        StringBuilder ans=new StringBuilder("");
        List<TreeNode> ls=new LinkedList<>();
        
        ls.add(root);
        
        while(ls.size()>0){
            
            TreeNode temp=ls.remove(0);
            
            if(temp!=null){
                ans.append(temp.val+" ");
            }
            
            else{
                ans.append(-1001+" ");
            }
            
            if(temp!=null){
                ls.add(temp.left);
                ls.add(temp.right);   
            }
            
        }
        
        return ans.toString();
    }

    public static TreeNode deserialize_01(String data) {
        
        if(data.equals("")){
            return null;
        }
        
        else{
            
            String[] arr=data.split(" ");
            
            int [] array=new int[arr.length];
            
            for(int i=0;i<arr.length;i++){
                array[i]=Integer.parseInt(arr[i]);
            }
            
            return construct_from_levelOrder_01(array);
            
        }
        
    }
    
    public static TreeNode construct_from_levelOrder_01(int[] array){
        
        TreeNode root=new TreeNode(array[0]);
        
        List<TreeNode> que=new LinkedList<>();
        
        que.add(root);
        
        for(int i=1;i<array.length-1;){
            
            TreeNode temp=que.remove(0);
            
            int temp1=array[i];
            int temp2=array[i+1];
            
            if(temp1!=-1001){
                TreeNode n1=new TreeNode(temp1);
                temp.left=n1;
                que.add(n1);
            }
            
            if(temp2!=-1001){
                TreeNode n2=new TreeNode(temp2);
                temp.right=n2;
                que.add(n2);
            }
            
            i+=2;
        }
        
        return root;
    }

    //Approach - 2 (Using preorder)
    public static String serialize_02(TreeNode root) {
        
        if(root==null){
            return "";
        }
        
        StringBuilder str=new StringBuilder("");
        preorder_02(root,str);
        System.out.println(str);
        return str.toString();
        
    }
    
    public static void preorder_02(TreeNode root,StringBuilder str){
        
        if(root==null){
            str.append("#"+" ");
            return;
        }
        
        else{
            
            str.append(root.val+" ");
            preorder_02(root.left,str);
            preorder_02(root.right,str);
            
        }
        
    }

    public static TreeNode deserialize_02(String data) {
        
        if(data.equals("")){
            return null;
        }
        
        String[] arr=data.split(" ");
        
        int[]idx=new int[1];        
        
        return deserializeHelper_02(arr,idx);
        
    }
    
    public static TreeNode deserializeHelper_02(String[] data,int[] idx){
        
        
        if(data[idx[0]].equals("#")){
            idx[0]++;
            return null;
        }
        
        else{
            
            TreeNode node=new TreeNode(Integer.parseInt(data[idx[0]]));
            
            idx[0]++;
            
            node.left=deserializeHelper_02(data,idx);
            node.right=deserializeHelper_02(data,idx);
            
            return node;
        }
        
        
    }
    
}