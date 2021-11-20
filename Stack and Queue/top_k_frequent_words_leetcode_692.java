import java.util.*;
public class top_k_frequent_words_leetcode_692{
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> hm=new HashMap<>();
        
        for(String s:words){
            hm.put(s,hm.getOrDefault(s,0)+1);
        }
        
        PriorityQueue<String> pq=new PriorityQueue<>((a,b)->{
            if(hm.get(a)==hm.get(b)){
                return b.compareTo(a);
            }
            else{
                return hm.get(a)-hm.get(b);
            }
        });
        
        List<String> ans=new ArrayList<>();
        for(String s:hm.keySet()){
            pq.add(s);
            
            if(pq.size()>k){
                pq.remove();
            }
        }
        
        while(pq.size()>0){
            ans.add(pq.remove());
        }
        
        Collections.reverse(ans);
        return ans;
    }
}