import java.util.*;
public class Path_In_Zigzag_Labelled_Binary_tree_leetcode_1104{
    
    //Recursive approach
    class Solution{
    
        public ArrayList<Integer> pathInZigZagTree(int label) {
            ArrayList<Integer> ans=new ArrayList<>();
            helper(label,ans);
            return ans;
        }
        
        public void helper(int n,ArrayList<Integer> ls){
            
            if(n==1)
                ls.add(n);
            
            else{
                int temp=(int)(Math.log(n) / Math.log(2));
                int nodeCount=(int)Math.pow(2,temp);
                
                helper(nodeCount-((n-nodeCount)/2+1),ls);
                
                ls.add(n);
            }
        }
        
    }

    //Iterative approach
    class Solution_{
        public ArrayList<Integer> pathInZigZagTree(int label) {
            ArrayList<Integer> ans=new ArrayList<>();
            
            int level=(int)(Math.log(label) / Math.log(2));
            int nodeCount=(int)Math.pow(2,level);
                    
            while(level>=0){
                ans.add(label);
                label=nodeCount-((label-nodeCount)/2+1);
                level--;
                nodeCount/=2;
            }
            
            Collections.reverse(ans);
            return ans;
        }
    }

}