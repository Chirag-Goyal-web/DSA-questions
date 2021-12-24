public class Maximum_Matrix_Sum_leetcode_1975{
    public long maxMatrixSum(int[][] matrix) {
        long count=0;
        long sum=0;
        long min=(long)Integer.MAX_VALUE;
        
        for(int[] arr:matrix){
            for(int i:arr){
                if(i<0){
                    count++;
                }
                i=Math.abs(i);
                sum+=i;
                min=Math.min(min,i);
            }
        }
        
        if((count&1)==0){
            return sum;
        }
        else{
            return sum-2*min;
        }
    }
}