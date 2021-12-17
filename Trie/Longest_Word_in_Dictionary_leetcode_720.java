import java.util.*;
public class Longest_Word_in_Dictionary_leetcode_720{
    Node root;
    int len=0;
    String ans="";
    
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
                if(i==word.length()-1){
                    cur.child[c-'a']=new Node();

                    if(word.length()>len){
                        ans=word;
                        len=word.length();
                    }
                    else if(word.length()==len && ans.compareTo(word)>0){
                        ans=word;
                        len=word.length();
                    }
                }
                
                else{
                    break;
                }
            }
            
            cur=cur.child[c-'a'];
        }   
        
        cur.isEnd=true;
    }
    
    public String longestWord(String[] words) {
        root=new Node();
        ans="";
        len=0;
        
        List<String> ls=new ArrayList<>();
        
        for(String s:words){
            ls.add(s);
        }   
        
        Collections.sort(ls,new Comparator<String>(){
            public int compare(String s1,String s2){
                return s1.length()-s2.length();
            }
        });
      
        for(String str:ls){
            addWord(str);
        }
        
        return ans;
    }
}