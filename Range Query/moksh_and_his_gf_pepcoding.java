import java.util.*;
public class moksh_and_his_gf_pepcoding{
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);

        int n=scn.nextInt();
        int q=scn.nextInt();
        int m=scn.nextInt();
       
        int[]arr=new int[n+1];
        int[][] query=new int[q][2];
        
        for(int i=0;i<q;i++){
            scn.nextLine();
            int t1=scn.nextInt();
            int t2=scn.nextInt();
            
            query[i][0]=t1;
            query[i][1]=t2;
            
            arr[t1]+=1;
            if(t2<n)
               arr[t2+1]-=1;
        }
        
        scn.close();

        for(int i=1;i<=n;i++){
            arr[i]+=arr[i-1];
        }
        
        int[][] count=new int[2][n+1];
        
        for(int i=1;i<=n;i++){
            if((arr[i]-m)==0){
                count[0][i]=1;
            }
            else if((arr[i]-m)==1){
                count[1][i]=1;
            }
            
            if(i>1){
                count[1][i]+=count[1][i-1];
                count[0][i]+=count[0][i-1];
            }
            
        }
        
        int ans=0;
        int val=count[0][n];
       
        for(int[] temp:query){
            int t1=temp[0];
            int t2=temp[1];
            
            int add=count[1][t2];
            int sub=count[0][t2];
            
            if(t1>1){
                add-=count[1][t1-1];
                sub-=count[0][t1-1];
            }
            
           ans=Math.max(ans,val-sub+add);
        }
        
        System.out.println(ans);
    }
}