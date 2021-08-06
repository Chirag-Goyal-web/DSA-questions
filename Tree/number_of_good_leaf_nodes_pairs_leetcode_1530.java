import java.util.*;
public class number_of_good_leaf_nodes_pairs_leetcode_1530{

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    class Solution {
    
        public class Pair{
            int count=0;
            ArrayList<Integer> ls=new ArrayList<>();
        }
        
        public int countPairs(TreeNode root, int distance) {
            Pair ans=dfs(root,distance);
            return ans.count;
        }
        
        public Pair dfs(TreeNode root,int dis){
            
            if(root==null){
                return new Pair();
            }
            
            else if(root.left==null && root.right==null){
                Pair temp=new Pair();
                temp.count=0;
                temp.ls.add(1);
                return temp;
            }
            
            else{
                
                Pair ans=new Pair();
                
                Pair left=dfs(root.left,dis);
                Pair right=dfs(root.right,dis);
                
                ArrayList<Integer> temp1=left.ls;
                ArrayList<Integer> temp2=right.ls;
                
                Collections.sort(temp2);
                
                int sum=0;
                
                for(int i:temp1){
                    if(i<dis)
                        sum+=rightInsert(dis-i,temp2);;
                }
                
                for(int i:temp1){
                    if((i+1)<=10)
                       ans.ls.add(i+1);
                }
                
                for(int j:temp2){
                    if((j+1)<=10)
                        ans.ls.add(j+1);
                }
                
                ans.count=left.count+right.count+sum;
                return ans;
            }
            
        }
        
        public int rightInsert(int val,ArrayList<Integer> ls){
            
            int l=0,h=ls.size()-1;
            
            while(l<=h){
                int mid=(l+h)/2;
                
                if(val>=ls.get(mid)){
                    l=mid+1;
                }
                else{
                    h=mid-1;
                }
            }
            return l;
        }
        
    }

    public static void main(String[] args) {
        
    }
}