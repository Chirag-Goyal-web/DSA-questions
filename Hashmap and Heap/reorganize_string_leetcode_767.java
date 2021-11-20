import java.util.*;
public class reorganize_string_leetcode_767{
    public String reorganizeString(String s) {
        int[] freq=new int[26];
        StringBuilder str=new StringBuilder();
        
        for(char c:s.toCharArray()){
            freq[c-'a']++;
        }
        
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{
            return freq[b]-freq[a];
        });
        
        for(int i=0;i<26;i++){
            if(freq[i]!=0){
                pq.add(i);
            }
        }
        
        int coolDown=-1;
        
        while(str.length()<s.length()){
            if(pq.size()==0){
                return "";
            }
            
            int t=pq.remove();
            freq[t]--;
            str.append((char)(t+'a')+"");                
            
            if(coolDown!=-1){
                pq.add(coolDown);
            }
            if(freq[t]>0){
                coolDown=t;
            }
            else{
                coolDown=-1;
            }
        }
        
        return str.toString();
    }
}