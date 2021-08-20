public class satisfiability_of_equality_equations_leetcode_990{

    class Solution {
    
        public boolean equationsPossible(String[] equations) {
            int[] par=new int[26];
            
            for(int i=0;i<26;i++)
                par[i]=i;
            
            for(String s:equations){
                
                if(s.charAt(1)=='='){
                    char c1=s.charAt(0);
                    char c2=s.charAt(3);
                    
                    int p1=findPar(par,c1-'a');
                    int p2=findPar(par,c2-'a');
                    
                    if(p1!=p2){
                        par[p1]=p2;
                    }
                }
            
            }
       
            for(String s:equations){
                
                if(s.charAt(1)=='!'){
                    char c1=s.charAt(0);
                    char c2=s.charAt(3);
                    
                    int p1=findPar(par,c1-'a');
                    int p2=findPar(par,c2-'a');
                    
                    if(p1==p2){
                        return false;
                    }
                }
            }
            
            return true;
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

}