import java.util.*;
public class created_sorted_array_through_instructions{
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int[] arr=new int[100001];
        int[] farr=new int[100001];
        int n=scn.nextInt();
        scn.nextLine();
        int cost=0;

        for(int i=1;i<=n;i++){
            int val=scn.nextInt();
            int temp=query(val,farr);
            
            int ans1=Math.min(temp-arr[val],i-(temp-arr[val])-1);
            int ans2=Math.min(temp,i-temp-1);
            
            cost+=Math.min(ans1,ans2);
            update(val,farr);
            arr[val]++;
        }

        scn.close();

        System.out.println(cost);
    }

    public static int query(int val,int[] arr){
        int total=0;
       
        while(val>0){
            total+=arr[val];
            val-=(val&(-val));
        }

        return total;
    }

    public static void update(int val,int[] arr){
        while(val<arr.length){
            arr[val]++;
            val+=(val&(-val));
        }
    }

}