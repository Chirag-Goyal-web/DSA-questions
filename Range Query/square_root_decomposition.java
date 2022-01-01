import java.util.*;
public class square_root_decomposition{
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int[] arr=new int[n];
        scn.nextLine();

        for(int i=0;i<n;i++){
            arr[i]=scn.nextInt();
        }

        int len=(int)(Math.ceil(Math.sqrt(n)));
        int[] sqrtArr=new int[len];
        makeDecomArray(arr, sqrtArr);
        scn.nextLine();
        int q=scn.nextInt();
    
        for(int i=0;i<q;i++){
            scn.nextLine();
            int start=scn.nextInt();
            int end=scn.nextInt();
            int ans=helper(arr,sqrtArr,start,end);
            System.out.println(ans);
        }

        scn.close();
    }

    public static void makeDecomArray(int[] arr,int [] sqrtArr){
        Arrays.fill(sqrtArr,Integer.MAX_VALUE);
        int len=sqrtArr.length;
        
        for(int i=0;i<arr.length;i++){
            sqrtArr[i/len]=Math.min(arr[i],sqrtArr[i/len]);
        }
    } 

    public static int helper(int[] arr,int[] sqrtArr,int start,int end){
        int ans=Integer.MAX_VALUE;
        int len=sqrtArr.length;

        for(int i=start;i<=end;){
            if(i%len==0 && i+len<=end){
                ans=Math.min(ans,sqrtArr[i/len]);
                i+=len;
            }
            else{
                ans=Math.min(ans,arr[i]);
                i++;
            }
        }

        return ans;
    }

}