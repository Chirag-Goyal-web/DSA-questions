import java.util.*;
public class reconstruct_Itinerary_leetcode_332{

    public List<String> findItinerary(List<List<String>> tickets) {
        
        HashMap<String,List<String>> graph=new HashMap<>();
        
        for(List<String> temp:tickets){
            if(!graph.containsKey(temp.get(0))){
                graph.put(temp.get(0),new ArrayList<>());
            }
            graph.get(temp.get(0)).add(temp.get(1));
        }

        for(String s:graph.keySet()){
            Collections.sort(graph.get(s));
        }
        
        List<String> ans=new ArrayList<>();
        ans.add("JFK");
        int count=tickets.size();
        
        dfs(graph,"JFK",ans,count);
        
        return ans;   
    }
    
    public boolean dfs(HashMap<String,List<String>> graph,String src,List<String> ans,int count){
        
        if(count==0){
            return true;
        }
        
        else{
            if(graph.containsKey(src)){ 
                for(int i=0;i<graph.get(src).size();i++){
                    String temp=graph.get(src).get(i);
                    graph.get(src).remove(i);
                    ans.add(temp);
                    count--;

                    if(dfs(graph,temp,ans,count)==true){
                        return true;
                    }
                    graph.get(src).add(i,temp);
                    ans.remove(ans.size()-1);
                    count++;
                }
            }
        }
        
        return false;
    }

}