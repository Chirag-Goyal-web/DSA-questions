public class validate_binary_tree_nodes_leetcode_1361{
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        
        int[] par=new int[n];
        int comp=n;
        boolean[] visited=new boolean[n];
        
        for(int i=0;i<n;i++)
            par[i]=i;
        
        for(int i=0;i<n;i++){
            
            int t1=leftChild[i];
            int t2=rightChild[i];    
            int p1=findPar(i,par);
            
            if(t1!=-1){
                if(visited[t1])
                    return false;
                
                visited[t1]=true;
                int p2=findPar(t1,par);
                
                if(p1!=p2){
                    comp--;
                    par[p1]=p2;
                }
                else{
                    return false;
                }
            }
            
            if(t2!=-1){
                
                if(visited[t2])
                    return false;
                
                visited[t2]=true;
                int p2=findPar(t2,par);
                
                if(p1!=p2){
                    comp--;
                    par[p1]=p2;
                }
                else{
                    return false;
                }
            }
            
        }

        return comp==1;
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