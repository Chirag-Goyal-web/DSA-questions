import java.util.*;
public class redundant_connection_2_leetcode_685{

    public int[] findRedundantDirectedConnection(int[][] edges) {
        
        int n=edges.length;
        n++;
        
        int[] par=new int[n];
        for(int i=1;i<n;i++)
            par[i]=i;
        
        int[] indegree=new int[n];
        Arrays.fill(indegree,-1);
        
        int bl1=-1,bl2=-1;
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            
            if(indegree[v]==-1){
                indegree[v]=i;
            }
            else{
                bl1=i;
                bl2=indegree[v];
            }
        }
        
        for(int i=0;i<edges.length;i++){
            
            if(bl1==i)
                continue;
            
            else{
                
                boolean b=merge(edges[i][0],edges[i][1],par);
                if(b==true){
                    if(bl1==-1){
                        return edges[i];//case 2
                    }
                    else{
                        return edges[bl2]; //case 3
                    }
                }
                
            }
        }
        
        return edges[bl1];//case1
    }
    
    public boolean merge(int u,int v,int[] par){
        
        int p1=findPar(u,par);
        int p2=findPar(v,par);
        
        if(p1!=p2){
            par[p1]=p2;
            return false;
        }
        
        return true;
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