public class skip_the_work{
    public int minAmount(int A[] , int N){
        int inc=0,exc=0;
        
        for(int i=0;i<N;i++){
            int temp1=Math.min(inc,exc)+A[i];
            int temp2=inc;
            inc=temp1;
            exc=temp2;
        }
        
        return Math.min(inc,exc);
    }
}