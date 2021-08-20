public class regions_cut_by_slashes_leetcode_959{

        public int regionsBySlashes(String[] grid) {
            
            int n=grid.length+1;
            int[] par=new int[n*n];
            
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    int idx=i*n+j;
                    if(i==0 || i==n-1 || j==0 || j==n-1){
                        par[idx]=0;
                    }
                    else{
                        par[idx]=idx;
                    }
                }
            }
            
            int ans=1;
            
            for(int i=0;i<grid.length;i++){
                String s=grid[i];
                for(int j=0;j<s.length();j++){
                    if(s.charAt(j)=='/'){
                        int t1=(i+1)*n+j;
                        int t2=(i)*n+(j+1);
                        
                        int p1=findPar(par,t1);
                        int p2=findPar(par,t2);
                        
                        if(p1==p2){
                            ans++;
                        }
                        else{
                            par[p1]=p2;
                        }
                    }
                    else if(s.charAt(j)=='\\'){
                        int t1=(i)*n+j;
                        int t2=(i+1)*n+(j+1);
                        
                        int p1=findPar(par,t1);
                        int p2=findPar(par,t2);
                        
                        if(p1==p2){
                            ans++;
                        }
                        else{
                            par[p1]=p2;
                        }
                    }
                }
            }
            
            return ans;
        }
        
            
        public int findPar(int[] par,int idx){
            if(par[idx]==idx){
                    return idx;
            }
                
            else{
                int temp=findPar(par,par[idx]);
                par[idx]=temp;
                return temp;
            }       
        }
    
}