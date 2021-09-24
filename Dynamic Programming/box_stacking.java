import java.util.*;
public class box_stacking{
    
    public static int maxHeight(int[] height, int[] width, int[] length, int n){
        
        int len=width.length;
        int[][] arr=new int[len*3][3];
        int idx=0;

        for(int i=0;i<len;i++){
            int h=height[i];
            int w=width[i];
            int l=length[i];
            makeArray(arr, idx, h, w, l);
            idx++;
            makeArray(arr, idx, w, h, l);
            idx++;
            makeArray(arr, idx, l, w, h);
            idx++;
        }

        Arrays.sort(arr,(a,b)->{
            return (a[1]*a[2]-b[1]*b[2]);
        });

        len*=3;
        int[] lis=new int[len];
        idx=0;
        int gAns=0;

        for(int i=0;i<len;i++){
            int ans=0;
            
            for(int j=i-1;j>=0;j--){
                if(arr[j][1]<arr[i][1] && arr[j][2]<arr[i][2]){
                    ans=Math.max(ans,lis[j]);
                }
            }

            ans+=arr[i][0];
            lis[idx++]=ans;
            gAns=Math.max(gAns,ans);
        }

        return gAns;
    }

    public static void makeArray(int[][] arr,int idx,int h,int w,int l){

        arr[idx][0]=h;
        
        if(w>l){
            arr[idx][1]=w;
            arr[idx][2]=l;
        }

        else{
            arr[idx][1]=l;
            arr[idx][2]=w;
        }

    }

    public static void main(String[] args) {
        int[] height=new int[]{4,1,4,10};
        int[] width=new int[]{6,2,5,12};
        int[] length=new int[]{7,3,6,32};

        System.out.println(maxHeight(height, width, length, 4));
    }

}