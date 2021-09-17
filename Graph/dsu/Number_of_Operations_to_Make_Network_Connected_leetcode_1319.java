public class Number_of_Operations_to_Make_Network_Connected_leetcode_1319{
    
    public int makeConnected(int n, int[][] connections) {
        
        int[] par=new int[n];
        int unUsed=0,compo=n;

        for(int i=0;i<n;i++){
            par[i]=i;
        }
        
        for(int[] arr:connections){
            int u=arr[0];
            int v=arr[1];
            int p1=findPar(u,par);
            int p2=findPar(v,par);

            if(p1!=p2){
                par[p1]=p2;
                compo--;
            }
            else{
                unUsed++;
            }

        }

        if(compo-1>unUsed){
            return -1;
        }
        else{
            return compo-1;
        }
    }

    public static int findPar(int u,int[] par){
        if(par[u]==u)
            return u;
        else{
            int temp=findPar(par[u],par);
            par[u]=temp;
            return temp;
        }
    }

}