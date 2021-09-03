import java.util.*;
public class Remove_Max_Number_of_Edges_to_Keep_Graph_Fully_Traversable_leetcode_1579{

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        
        List<int[]> both=new ArrayList<>();
        List<int[]> alice=new ArrayList<>();
        List<int[]> bob=new ArrayList<>();
        
        //Separate edges
        for(int[] temp:edges){
            if(temp[0]==1){
                alice.add(temp);
            }   
            else if(temp[0]==2){
                bob.add(temp);
            }
            else{
                both.add(temp);
            }
        }
        
        int[]par=new int[n+1];
        for(int i=1;i<=n;i++)
            par[i]=i;
        
        int components=n;
        int use=0;
        
        //Use the necessary blues edges
        for(int[]arr:both){
            int v1=arr[1];
            int v2=arr[2];
            
            int p1=findPar(v1,par);
            int p2=findPar(v2,par);
            
            if(p1!=p2){
                components--;
                use++;
                par[p1]=p2;
            }
        }
        
        if(components==1){
            return edges.length-use;
        }
        
        //Make a separate paent array for alice from original parent array
        int[] parA=new int[n+1];
        for(int i=1;i<=n;i++){
            parA[i]=par[i];
        }
        
        int aComp=components;
        
        //Use the necessary red edges
        for(int[] arr:alice){
            int v1=arr[1];
            int v2=arr[2];
            
            int p1=findPar(v1,parA);
            int p2=findPar(v2,parA);
            
            if(p1!=p2){
                aComp--;
                use++;
                parA[p1]=p2;
            }
        }
        
        if(aComp!=1){
            return -1;
        }
        
        //Make a separate parent array for bob from original parent array
        int bComp=components;
        int[] parB=new int[n+1];
        
        for(int i=1;i<=n;i++)
            parB[i]=par[i];
        
        //Use the necessary green edges
        for(int[] arr:bob){
            int v1=arr[1];
            int v2=arr[2];
            
            int p1=findPar(v1,parB);
            int p2=findPar(v2,parB);
            
            if(p1!=p2){
                bComp--;
                use++;
                parB[p1]=p2;
            }
        }
        
        if(bComp!=1){
            return -1;
        }
        
        return edges.length-use;
        
    }
    
    public int findPar(int u,int[] par){
        
        if(par[u]==u)
            return u;
        
        else{
            int temp=findPar(par[u],par);
            par[u]=temp;
            return temp;
        }   
    }

}