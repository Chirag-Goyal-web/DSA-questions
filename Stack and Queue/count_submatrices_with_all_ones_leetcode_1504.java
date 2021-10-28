public class count_submatrices_with_all_ones_leetcode_1504{
    public int numSubmat(int[][] mat) {
        int ans=0;
        int row=mat.length;
        int col=mat[0].length;
        
        int[] temp=new int[col];
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(mat[i][j]==0){
                    temp[j]=0;
                }
                else{
                    temp[j]++;
                }
            }
            
            ans+=helper(temp);
        }
        
        return ans;
        
    }
    
    public int helper(int[] arr){
        
        int len=arr.length;
        Stack<Integer> stk=new Stack<>();
        int[] sum=new int[len];
        
        for(int i=len-1;i>=0;i--){
        
            while(stk.size()>0 && arr[stk.peek()]>=arr[i]){
                stk.pop();
            }
            
            if(stk.size()>0){
                int idx=stk.peek();
                sum[i]=sum[idx];
                sum[i]+=arr[i]*(idx-i);
            }
            else{
                sum[i]=(len-i)*arr[i];
            }

            stk.push(i);
        }
        
        int ans=0;
        for(int i=0;i<len;i++){
            ans+=sum[i];
        }
        
        return ans;
    }
}