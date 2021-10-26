import java.util.*;
public class largest_rectangle_in_histogram{
    
    //Using 2 extra array
    class Solution{
        public int largestRectangleArea(int[] heights) {    
            int[] ans1=seol(heights);
            int[] ans2=seor(heights);
            int max=0;
    
            for(int i=0;i<heights.length;i++){
                max=Math.max(max,heights[i]*(ans2[i]-ans1[i]-1));
            }
            
            return max;
        }
    
        public int[] seol(int[] arr){
            Stack<Integer> stk=new Stack<>();
            int[] ans=new int[arr.length];
            
            for(int i=0;i<arr.length;i++){
                while(stk.size()>0 && arr[stk.peek()]>=arr[i]){
                    stk.pop();
                }
                
                if(stk.size()==0){
                    ans[i]=-1;
                }
                else{
                    ans[i]=stk.peek();
                }
                stk.add(i);
            }
            
            return ans;
        }
        
        public int[] seor(int[] arr){
            Stack<Integer> stk=new Stack<>();
            int[] ans=new int[arr.length];
            
            for(int i=arr.length-1;i>=0;i--){
                while(stk.size()>0 && arr[stk.peek()]>=arr[i]){
                    stk.pop();
                }
                
                if(stk.size()==0){
                    ans[i]=arr.length;
                }
                else{
                    ans[i]=stk.peek();
                }
                
                stk.add(i);
            }
            
            return ans;
        }
    
    }
    //Using stack only
    class Solution_{
        public int largestRectangleArea(int[] arr) {
            
            int len=arr.length;
            Stack<Integer> stk=new Stack<>();
            int max=0;
            
            for(int i=0;i<len;i++){
                while(stk.size()>0 && arr[i]<=arr[stk.peek()]){
                    int temp=stk.pop();
                    
                    if(stk.size()>0){
                        max=Math.max(max,arr[temp]*(i-stk.peek()-1));
                    }
                    else{
                        max=Math.max(max,arr[temp]*(i-(-1)-1));
                    }
                }
                
                stk.push(i);
            }
            
            while(stk.size()>0){
                int temp=stk.pop();
                
                if(stk.size()>0){
                    max=Math.max(max,arr[temp]*(len-stk.peek()-1));
                }
                else{
                    max=Math.max(max,arr[temp]*(len-(-1)-1));
                }
            }
            
            return max;
        }
    }

}