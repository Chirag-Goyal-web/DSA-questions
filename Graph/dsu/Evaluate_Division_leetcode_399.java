import java.util.*;
public class Evaluate_Division_leetcode_399{
    class Solution {

        public class Pair{
            String par;
            double cost;
            
            Pair(String par,double cost){
                this.par=par;
                this.cost=cost;
            }
        }
         
        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            
            int idx=0;
            double[] ans=new double[queries.size()];
            HashMap<String,Pair> hm=new HashMap<>();
            
            for(List<String> temp:equations){
                
                String n=temp.get(0);
                String d=temp.get(1);
                
                //if variable is coming first time, put it into map
                if(hm.containsKey(n)==false){
                    hm.put(n,new Pair(n,1));
                }
                
                //if variable is coming first time, put it into map
                if(hm.containsKey(d)==false){
                    hm.put(d,new Pair(d,1));
                }
                
                Pair temp1=findPar(hm,n);
                Pair temp2=findPar(hm,d);
                
                //if parents are not equal, merge them
                if(!temp1.par.equals(temp2.par))
                    hm.put(temp2.par,new Pair(temp1.par,(temp1.cost/temp2.cost)*values[idx]));
                
                idx++;
            }
            
            idx=0;
            
            for(List<String> temp: queries){
                
                String n=temp.get(0);
                String d=temp.get(1);
                
                if(!hm.containsKey(n)||!hm.containsKey(d)){
                    ans[idx++]=-1;
                }
                
                else{
                    
                    Pair n1=findPar(hm,n);
                    Pair d1=findPar(hm,d);
                 
                    //If parents are not equal, then they belong to different set
                    if(n1.par.equals(d1.par)==false){
                        ans[idx++]=-1;
                    }
                    
                    
                    else{
                        ans[idx++]=d1.cost/n1.cost;    
                    }
                    
                }
                
            }
            
            return ans;
        }
    
        public Pair findPar(HashMap<String,Pair> hm,String str){
            
            if(hm.get(str).par.equals(str)){
                return hm.get(str);
            }
            
            else{
                
                Pair temp=findPar(hm,hm.get(str).par);
                
                //Data compression
                hm.get(str).par=temp.par;
                hm.get(str).cost*=temp.cost;
                
                return hm.get(str);
            }
            
        }
        
    }
}