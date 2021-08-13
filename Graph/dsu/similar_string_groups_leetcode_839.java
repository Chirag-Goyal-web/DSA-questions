public class similar_string_groups_leetcode_839{

    class Solution {
    
        public int numSimilarGroups(String[] strs) {
            
            int len=strs.length;
            
            if(len==1){
                return 1;
            }
            
            int[] par=new int[len];
            
            for(int i=0;i<len;i++){
                par[i]=i;
            }
            
            int count=len;
            for(int i=0;i<len;i++){
                for(int j=i+1;j<len;j++){
                    if(similar(strs[i],strs[j])){
                        int p1=findPar(i,par);
                        int p2=findPar(j,par);
                        
                        if(p1!=p2){
                            par[p1]=p2;
                            count--;
                        }
                        
                    }
                }
            }
            
            return count;
        }
        
        public boolean similar(String str1,String str2){
            
            int count=0;
            int len=str1.length();
            
            for(int i=0;i<len;i++){
                if(str1.charAt(i)!=str2.charAt(i) && ++count>2){
                    return false;
                }
            }
            return true;
        }
        
        public int findPar(int u,int[] par) {
            if(par[u]==u){
                return u;
            }
            else{
                int t=findPar(par[u],par);
                par[u]=t;
                return t;
            }
        }
        
    }
    
    public static void main(String[] args) {
        
    }
}