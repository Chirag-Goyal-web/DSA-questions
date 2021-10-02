public class pyramid_form{
    
    static int pyramidForm(int[] a, int n) {
        int[] left=new int[n];
        int[] right=new int[n];
        left[0]=1;
        right[n-1]=1;
        long sum=0;

        for(int i:a)
            sum=sum+i;

        for(int i=1;i<n;i++){
            left[i]=Math.min(left[i-1]+1,a[i]);       
        }

        for(int i=n-2;i>=0;i--){
            right[i]=Math.min(right[i+1]+1,a[i]);        
        }

        int maxHeight=0;
        for(int i=0;i<n;i++){
            maxHeight=Math.max(maxHeight,Math.min(left[i],right[i]));
        }

        return (int)(sum-(long)(((maxHeight-1)*maxHeight)+maxHeight));
    }
}
