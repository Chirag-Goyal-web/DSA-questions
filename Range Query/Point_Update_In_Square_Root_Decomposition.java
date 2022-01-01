import java.util.*;
public class Point_Update_In_Square_Root_Decomposition{

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
            char c=scn.next().charAt(0);
            int start=scn.nextInt();
            int end=scn.nextInt();

            if(c=='f'){
                int ans=helper(arr,sqrtArr,start,end);
                System.out.println(ans);
            }
            else{
                arr[start]+=end;
                makeUpdate(start,end,sqrtArr);
            }
        }

        scn.close();
    }

    public static void makeDecomArray(int[] arr,int [] sqrtArr){       
        int len=sqrtArr.length;
        for(int i=0;i<arr.length;i++){
            sqrtArr[i/len]+=arr[i];
        }
    } 

    public static void makeUpdate(int i,int d,int[] sqrtArr){
        sqrtArr[i/sqrtArr.length]+=d;
    }

    public static int helper(int[] arr,int[] sqrtArr,int start,int end){
        int ans=0;
        int len=sqrtArr.length;

        for(int i=start;i<=end;){
            if(i%len==0 && i+len-1<=end){
                ans+=sqrtArr[i/len];
                i+=len;
            }
            else{
                ans+=arr[i];
                i++;
            }
        }

        return ans;
    }


}