public class maximal_rectangle_leetcode_85{

    public int maximalRectangle(char[][] matrix) {
        
        if(matrix.length==0){
            return 0;
        }
        
        int m=matrix.length,n=matrix[0].length;
        int[] arr=new int[n];
        int max=0;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='0'){
                    arr[j]=0;
                }
                else{
                    arr[j]+=1;
                }
            }
            
            int temp=largestRectangleArea(arr);
            max=Math.max(max,temp);
        }
        
        return max;
    }
    
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