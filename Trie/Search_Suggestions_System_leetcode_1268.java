import java.util.*;
public class Search_Suggestions_System_leetcode_1268{
    private class Node{
        Node[] child;
        List<Integer> index;
        
        Node(){
            child=new Node[26];
            index=new ArrayList<>();
        }
    }
    
    Node root;
    
    public void addWord(String word,int idx){
        Node cur=root;
        
        for(char c:word.toCharArray()){
            if(cur.child[c-'a']==null){
                cur.child[c-'a']=new Node();
            }    
            
            cur=cur.child[c-'a'];
            cur.index.add(idx);
        }
    }
    
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        root=new Node();
        Arrays.sort(products);
        
        for(int i=0;i<products.length;i++){
            addWord(products[i],i);
        }
        
        List<List<String>> ans=new ArrayList<>();
        Node cur=root;
        
        for(int i=0;i<searchWord.length();i++){
            char c=searchWord.charAt(i);
            
            if(cur.child[c-'a']==null){
                break;
            }
            else{
                cur=cur.child[c-'a'];
                
                if(cur.index.size()<=3){
                    List<String> temp=new ArrayList<>();
                    
                    for(int k:cur.index){
                        temp.add(products[k]);
                    }
                    ans.add(temp);
                }
                else{
                    List<Integer> g=cur.index.subList(0,3);
                    List<String> temp=new ArrayList<>();
                    
                    for(int k:g){
                        temp.add(products[k]);
                    }
                    ans.add(temp);
                }
            }
        }
        
        for(int i=ans.size();i<searchWord.length();i++){
            ans.add(new ArrayList<>());
        }
        
        return ans;
    }


}