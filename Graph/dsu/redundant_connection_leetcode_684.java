public class redundant_connection_leetcode_684{
    class Solution {
        public int[] findRedundantConnection(int[][] edges) {
            
            int n=edges.length;
            int[] par=new int[n+1];
           
            for(int i=1;i<par.length;i++){
                par[i]=i;
            }
            
            for(int[] temp:edges){
                int v1=temp[0];
                int v2=temp[1];
                int p1=findPar(v1,par);
                int p2=findPar(v2,par);
                if(p1==p2){
                    return temp;
                }
                else{
                    par[p1]=p2;
                }
            }
            
            
            
            return new int[2];
        }
        
        public int findPar(int u,int[] par){
            if(par[u]==u){
                return u;
            }
            else{
                int getPar=findPar(par[u],par);
                par[u]=getPar;
                return getPar;
            }
        }
        
    }
}