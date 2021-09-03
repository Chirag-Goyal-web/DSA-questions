import java.util.*;
public class accounts_merge_leetcode_721{
    
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        int size=accounts.size();
        int[] par=new int[size];
        
        for(int i=0;i<size;i++)
            par[i]=i;
        
        HashMap<String,Integer> email=new HashMap<>();
        //Apply union find
        for(int i=0;i<accounts.size();i++){
            String name="";
            for(String mail:accounts.get(i)){
                if(name==""){
                    name=mail;
                    continue;
                }
                if(email.containsKey(mail)){
                    int owner=email.get(mail);
                    int p1=findPar(i,par);
                    int p2=findPar(owner,par);
                    if(p1!=p2){
                        par[p1]=p2;
                    }
                }
                else{
                    email.put(mail,i);
                }
            }
        }
        
        HashMap<Integer,Set<String>> hm=new HashMap<>();
        //Separate emails in their corresponding parents
        for(int i=0;i<size;i++){
            int p=findPar(i,par);
            
            if(!hm.containsKey(p)){
                hm.put(p,new HashSet<>());
            }

            for(int k=1;k<accounts.get(i).size();k++){
                hm.get(p).add(accounts.get(i).get(k));
            }   
        }

        //Make the answer
        List<List<String>> ans=new ArrayList<>();
        
        for(int i:hm.keySet()){
            
            Set<String> s=hm.get(i);
            
            List<String> t1=new ArrayList<>();
            t1.add(accounts.get(i).get(0));
            
            List<String> t2=new ArrayList<>(s);
            Collections.sort(t2);
            
            for(String str:t2){
                t1.add(str);
            }
            
            ans.add(t1);
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