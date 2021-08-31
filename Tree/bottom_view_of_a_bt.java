import java.util.*;
public class bottom_view_of_a_bt{

    public static class Node {
        int data = 0;
        Node left = null;
        Node right = null;

        Node(int val) {
            this.data = val;
        }
    }

    public static class nNode{
        Node root;
        int level;
        
        nNode(Node root,int level){
            this.root=root;
            this.level=level;
        }
    } 
    
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root){
        
        int[] ans=new int[2];
        width(root,0,ans);
        int w=ans[1]-ans[0]+1;
        
        ArrayList<Integer> arr=new ArrayList<>();
        
        for(int i=0;i<w;i++){
            arr.add(0);
        }
        
        Queue<nNode> que=new LinkedList<>();
        que.add(new nNode(root,Math.abs(ans[0])));
        
        while(que.size()>0){
            
            nNode temp=que.remove();
            
            arr.set(temp.level,temp.root.data);
            
            if(temp.root.left!=null){
                que.add(new nNode(temp.root.left,temp.level-1));
            }
            
            if(temp.root.right!=null){
                que.add(new nNode(temp.root.right,temp.level+1));
            }
            
        }
        
        
        return arr;
    }
    
    public void width(Node root,int v,int[] ans){
        if(root==null){
            return;
        }
        
        else{
            if(v<ans[0]){
                ans[0]=v;
            }
            
            if(v>ans[1]){
                ans[1]=v;
            }
            
            width(root.left,v-1,ans);
            width(root.right,v+1,ans);
        }
        
    }

}