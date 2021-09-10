import java.util.*;
public class Minimize_Hamming_Distance_After_Swap_Operations_leetcode_1722{

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        
        int len=source.length;
        int[] par=new int[len];
        
        int ans=source.length;
        
        HashMap<Integer,Set<Integer>> hm=new HashMap<>();
        
        for(int i=0;i<len;i++){
            par[i]=i;   
        }
        
        for(int[] temp:allowedSwaps){
            int p1=findPar(temp[0],par);
            int p2=findPar(temp[1],par);
            
            if(p1!=p2){
                par[p1]=p2;
            }
        }
        
        for(int i=0;i<source.length;i++){
            if(!hm.containsKey(source[i])){
                hm.put(source[i],new HashSet<>());
            }
            hm.get(source[i]).add(i);
        }
        
        for(int i=0;i<target.length;i++){
            int val=target[i];
            
            if(hm.containsKey(val)){
                Set<Integer> indexes=hm.get(val);

                int p1=findPar(i,par);

                for(int k:indexes){
                    int p2=findPar(k,par);

                    if(p1==p2){
                        ans--;
                        indexes.remove(k);
                        int t=source[k];
                        source[k]=source[i];
                        source[i]=t;
                        break;
                    }
                }
            }
        }
        
        return ans;
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