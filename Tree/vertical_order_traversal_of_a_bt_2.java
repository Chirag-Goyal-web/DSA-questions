import java.util.*;
public class vertical_order_traversal_of_a_bt_2{

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    
        TreeNode(int val) {
          this.val = val;
        }
      }
    
        public static void width(TreeNode node,int level,int[] ans){
            
            if(node==null){
                return;
            }
            
            else{
                
                if(level>ans[1]){
                    ans[1]=level;
                }
                
                if(level<ans[0]){
                    ans[0]=level;
                }
                
                width(node.left,level-1,ans);
                width(node.right,level+1,ans);
            }
            
        }
    
        public static class vPair{
            
            int level;
            int h;
            TreeNode node;
            
            vPair(int level,TreeNode node,int h){
                this.level=level;
                this.node=node;
                this.h=h;
            }
            
        }
    
      public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {
          
            int[] ans=new int[2];
            width(root,0,ans);
            
            int w=ans[1]-ans[0]+1;
            
            PriorityQueue<vPair> que=new PriorityQueue<>(new vPairComparator());
            
            que.add(new vPair(Math.abs(ans[0]),root,0));
            
            ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
            
            for(int i=0;i<w;i++){
                arr.add(new ArrayList<>());
            }
            int hl=0;//horizontal level
        
            while(que.size()>0){
                hl++;
                int size=que.size();
                
                while(size>0){
                    
                    vPair temp=que.remove();
                    arr.get(temp.level).add(temp.node.val);
                    
                    
                    if(temp.node.left!=null){
                    que.add(new vPair(temp.level-1,temp.node.left,hl));
                    }
                    
                    if(temp.node.right!=null){
                    que.add(new vPair(temp.level+1,temp.node.right,hl));
                    }
                    
                    size--;
               
            }
            }
            return arr;
      }
      
     static class vPairComparator implements Comparator<vPair>{
          
          public int compare(vPair s1,vPair s2){
              
              if(s1.h!=s2.h){
                  return s1.h-s2.h;
              }
              
              else if(s1.level!=s2.level){
                  return s1.level-s2.level;
              }
              
              else{
                 return s1.node.val-s2.node.val;   
              }
              
          }
      }
    public static void main(String[] args) {
        
    }
}