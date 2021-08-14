import java.util.*;
class TestClass {
 
    public static int findPar(int[] par,int idx){
        if(par[idx]==idx){
                return idx;
        }
            
        else{
            int temp=findPar(par,par[idx]);
            par[idx]=temp;
            return temp;
        }       
    }
        
    public static long mst(ArrayList<ArrayList<Integer>> graph,int n,long k){
        
        int[] par=new int[n+1];
        
        for(int i=1;i<=n;i++)
            par[i]=i;
        
        long cost=0,components=n;
        ArrayList<Integer> weight=new ArrayList<>();
 
        for(ArrayList<Integer> temp:graph){
            int p1=findPar(par,temp.get(0));
            int p2=findPar(par,temp.get(1));
 
            if(p1!=p2){
                par[p1]=p2;
                cost+=temp.get(2);
                components--;
                weight.add(temp.get(2));
            }
        }
 
        if(components>1){
            return -1;
        }
 
        int idx=weight.size()-1;
        long ans=0;
 
        while(cost>k && idx>=0){
            cost=cost-weight.get(idx)+1;
            idx--;
            ans++;
        }
 
        if(cost>k){
            return -1;
        }
        else{
            return ans;
        }
 
    }
 
    public static void main(String args[] ) throws Exception {
 
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int m=scn.nextInt();
        long k=scn.nextLong();
        
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        
        for(int i=0;i<m;i++){
            ArrayList<Integer> temp=new ArrayList<>();
            temp.add(scn.nextInt());
            temp.add(scn.nextInt());
            temp.add(scn.nextInt());
            graph.add(temp);
        }
 
        Collections.sort(graph,(a,b)->{
            return a.get(2)-b.get(2);
        });
 
        long ans=mst(graph,n,k);
        System.out.println(ans);
    }
 
 
 
}