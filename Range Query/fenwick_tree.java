import java.util.*;
public class fenwick_tree{    
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        
        int n=scn.nextInt();
        int[] arr=new int[n+1];
        scn.nextLine();

        for(int i=0;i<n;i++){
            arr[i+1]=scn.nextInt();
        }

        int[] fenwick=new int[n+1];

        for(int i=1;i<=n;i++){
            update(fenwick,i,arr[i]);
        }
    
        scn.nextLine();
        int q=scn.nextInt();
    
        for(int i=0;i<q;i++){
            scn.nextLine();
            char c=scn.next().charAt(0);
            int start=scn.nextInt();
            int end=scn.nextInt();

            if(c=='q'){
                int ans=sum(fenwick,end)-sum(fenwick,start-1);
                System.out.println(ans);
            }
            else{
                arr[start]+=end;
                update(fenwick,start,end);
            }
        }

        scn.close();
    }

    public static int sum(int[] arr,int idx){
        int sum=0;
        while(idx>0){
            sum+=arr[idx];
            int lastSetBit=(idx&(-idx));
            idx=(idx^lastSetBit);
        }
        return sum;
    }
    
    public static void update(int[] arr,int idx,int val){  
        while(idx<arr.length){
            arr[idx]+=val;
            int lastSetBit=(idx&(-idx));
            idx=(idx+lastSetBit);
        }
    }

}