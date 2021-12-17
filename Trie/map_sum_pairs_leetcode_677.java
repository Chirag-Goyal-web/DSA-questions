import java.util.*;
public class map_sum_pairs_leetcode_677{
    Node root;
    HashMap<String,Integer> hm;
    
    private class Node{
        Node[] child;
        int isEnd=0;

        Node(){
            child=new Node[26];
        }
    }
    
    public void addWord(String word,int val) {
        Node cur=root;
        
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            
            if(cur.child[c-'a']==null){
                cur.child[c-'a']=new Node();
            }
            cur=cur.child[c-'a'];
            cur.isEnd+=val;
        }   

    }
    
    public map_sum_pairs_leetcode_677() {
        root=new Node();
        hm=new HashMap<>();
    }
    
    public void insert(String key, int val) {
        if(hm.containsKey(key)){
            addWord(key,val-hm.get(key));
        }
        else{
            addWord(key,val);   
        }
        hm.put(key,val);
    }
    
    public int sum(String prefix) {
        Node cur=root;
        
        for(int i=0;i<prefix.length();i++){
            char c=prefix.charAt(i);
            
            if(cur.child[c-'a']!=null){
                cur=cur.child[c-'a'];
            }
            else{
                return 0;
            }
        }
        
        return cur.isEnd;
    }
}