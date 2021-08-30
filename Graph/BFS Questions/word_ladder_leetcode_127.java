import java.util.*;
public class word_ladder_leetcode_127{

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        HashMap<Integer,Set<Character>> hm=new HashMap<>();
        Set<String> visited=new HashSet<>();
        Set<String> words=new HashSet<>();
        
        int len=beginWord.length();
        
        for(int i=0;i<len;i++){
            hm.put(i,new HashSet<>());
        }
        
        for(String s:wordList){
            words.add(s);
            
            for(int i=0;i<s.length();i++){
                hm.get(i).add(s.charAt(i));
            }
            
        }
        
        if(!words.contains(endWord)){
            return 0;
        }
        
        Queue<StringBuilder> que=new LinkedList<>();
        que.add(new StringBuilder(beginWord));
        visited.add(beginWord);
        
        int level=1;
        
        while(que.size()>0){
            int size=que.size();
            
            while(size-->0){
                StringBuilder temp=que.remove();
                
                if(endWord.equals(temp.toString())){
                    return level;
                }
                
                for(int i=0;i<len;i++){
                    for(char c:hm.get(i)){
                        StringBuilder nw=new StringBuilder(temp);
                        nw.setCharAt(i,c);
                        
                        String g=nw.toString();
                        if(words.contains(g) && !visited.contains(g)){
                            que.add(nw);
                            visited.add(g);
                        }
                        
                    }
                }
                
            }
            level++;
        }
 
        return 0;
    }

}