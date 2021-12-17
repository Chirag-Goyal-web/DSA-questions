public class WordDictionary_leetcode_211{
    
    private class Node{
        Node[] child;
        boolean isEnd;

        Node(){
            child=new Node[26];
        }
    }

    private Node root;

    public WordDictionary_leetcode_211() {
        root=new Node();
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
    
    public boolean search(String word) {
        return helper(root,word,0);
    }

    public boolean helper(Node cur,String word,int idx){
        if(idx==word.length()){
            if(cur.isEnd==true){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            char c=word.charAt(idx);

            if(c!='.'){
                if(cur.child[c-'a']==null){
                    return false;
                }
                else{
                    cur=cur.child[c-'a'];
                    if(helper(cur,word,idx+1)==true){
                        return true;
                    }  
                }
            }
            else{
                
                for(int i=0;i<26;i++){
                    if(cur.child[i]!=null){
                        if(helper(cur.child[i],word,idx+1)==true){
                            return true;
                        }
                    }
                }

            }

            return false;
        }
    }

}