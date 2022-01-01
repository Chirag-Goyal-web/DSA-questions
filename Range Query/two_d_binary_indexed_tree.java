import java.util.*;
public class two_d_binary_indexed_tree{

    static int[][] arr;
    static int[][] farr;

	public static void main(String[] args){
        
        Scanner scn=new Scanner(System.in);
        int row=scn.nextInt();
        int col=scn.nextInt();
        
        arr=new int[row+1][col+1];
        farr=new int[row+1][col+1];
        
        for(int i=1;i<=row;i++){
            scn.nextLine();
            for(int j=1;j<=col;j++){
                arr[i][j]=scn.nextInt();
            }
        }
        
        preprocess();
        scn.nextLine();
        int q=scn.nextInt();
        
        for(int i=0;i<q;i++){
            scn.nextLine();
            
            char c=scn.next().charAt(0);
            
            if(c=='q'){
                int x1=scn.nextInt();
                int x2=scn.nextInt();
                int y1=scn.nextInt();
                int y2=scn.nextInt();
                
                int ans=query(x1,x2,y1,y2);
                System.out.println(ans);
            }
            else{
                int x1=scn.nextInt();
                int y1=scn.nextInt();
                int up=scn.nextInt();
                
                update(x1,y1,up);
            }
        }
        
        scn.close();
    }

    public static void preprocess(){
        for(int i=1;i<arr.length;i++){
            for(int j=1;j<arr[0].length;j++){
                update(i,j,arr[i][j]);
            }
        }
    }

    public static void update(int x,int y,int val){
        while(x<farr.length){
            int tempY=y;
            while(tempY<farr[0].length){
                farr[x][tempY]+=val;
                tempY+=(tempY&(-tempY));
            }
            x+=(x&(-x));
        }
    }

    public static int query(int x1,int y1,int x2,int y2){
        return prefixSum(x2,y2)-prefixSum(x1-1, y2)-prefixSum(x2, y1-1)
        +prefixSum(x1-1, y1-1);
    }

    public static int prefixSum(int x,int y){
        int sum=0;
        
        while(x>0){
            int tempY=y;
            while(tempY>0){
                sum+=farr[x][tempY];
                tempY=(tempY^(tempY&(-tempY)));
            }
            x=(x^(x&(-x)));
        }
        
        return sum;
    }

}