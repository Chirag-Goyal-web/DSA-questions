import java.util.*;
public class concatenated_words_leetcode_472{
    Node root;
    
    private class Node{
        Node[] child;
        boolean isEnd;

        Node(){
            child=new Node[26];
        }
    }
    
    public void addWord(String word) {
        Node cur=root;
        
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            
            if(cur.child[c-'a']==null){
                cur.child[c-'a']=new Node();
            }
            cur=cur.child[c-'a'];
        }   

        cur.isEnd=true;
    }
    
    public boolean helper(String s,int idx){
        if(idx==s.length()){
            return true;
        }
        else{
            Node cur=root;
            for(int i=idx;i<s.length();i++){
                char c=s.charAt(i);
                if(cur.child[c-'a']==null){
                    return false;
                }
                else{
                    cur=cur.child[c-'a'];
                }
                
                if(cur.isEnd==true){
                    if(helper(s,i+1)==true){
                        return true;
                    }
                }
            }
            
            return false;
        }
    }
    
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> ls=new ArrayList<>();
        root=new Node();
        
        for(String s:words){
            ls.add(s);
        }
        
        Collections.sort(ls,new Comparator<String>(){
            public int compare(String s1,String s2){
                return s1.length()-s2.length();
            }
        });
        
        List<String> ans=new ArrayList<>();
        for(String s:ls){
            if(s.equals("")){
                continue;
            }
            
            if(helper(s,0)==true){
                ans.add(s);
            }
            else{
                addWord(s);
            }
        }
        
        return ans;
    }

}