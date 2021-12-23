public class stream_of_characters_leetcode_1032{
    Node root;
    StringBuilder str=new StringBuilder("");
    
    private class Node{
        Node[] child;
        boolean isEnd;

        Node(){
            child=new Node[26];
        }
    }
    
    public void addWord(String word) {
        Node cur=root;
        
        for(int i=word.length()-1;i>=0;i--){
            char c=word.charAt(i);
            
            if(cur.child[c-'a']==null){
                cur.child[c-'a']=new Node();
            }
            cur=cur.child[c-'a'];
        }   

        cur.isEnd=true;
    }
    

    public stream_of_characters_leetcode_1032(String[] words) {
        str=new StringBuilder("");
        root=new Node();
        
        for(String s:words){
            addWord(s);
        }
    }
    
    public boolean helper(StringBuilder s){
        Node cur=root;
        for(int i=s.length()-1;i>=0;i--){
            char c=s.charAt(i);
            
            if(cur.child[c-'a']!=null){
                cur=cur.child[c-'a'];
                if(cur.isEnd==true){
                    return true;
                }
            }
            else{
                return false;
            }
        }
        
        return false;
    }
    
    public boolean query(char letter) {
        str.append(letter+"");
        return helper(str);
    }
}