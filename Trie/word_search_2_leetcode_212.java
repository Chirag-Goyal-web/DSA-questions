import java.util.*;
public class word_search_2_leetcode_212{
    Node root;
    
    private class Node{
        Node[] child;
        int isEnd=-1;

        Node(){
            child=new Node[26];
        }
    }
    
    public void addWord(String word,int idx) {
        Node cur=root;
        
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            
            if(cur.child[c-'a']==null){
                cur.child[c-'a']=new Node();
            }
            cur=cur.child[c-'a'];
        }   

        cur.isEnd=idx;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        int n=board.length,m=board[0].length;
        root=new Node();
        Set<Integer> ans=new HashSet<>();
        boolean[][] visited=new boolean[n][m];
        int[][] dir=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        
        for(int i=0;i<words.length;i++){
            addWord(words[i],i);
        }
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(root.child[board[i][j]-'a']!=null){
                    visited[i][j]=true;
                    helper(root,i,j,board,dir,visited,ans);
                    visited[i][j]=false;
                }
            }
        }
                
        List<String> ls=new ArrayList<>();
        for(int i:ans){
            ls.add(words[i]);
        }
        
        return ls;
    }
    
    public void helper(Node cur,int row,int col,char[][] board,int[][] dir,boolean[][] visited,Set<Integer> ans){
        char c=board[row][col];
        
        if(cur==null||cur.child[c-'a']==null){
            return;
        }
        else{
            cur=cur.child[board[row][col]-'a'];
            
            if(cur.isEnd!=-1){
                ans.add(cur.isEnd);
                cur.isEnd=-1;
            }
            
            for(int i=0;i<4;i++){
                int tempr=row+dir[i][0];
                int tempc=col+dir[i][1];
            
                if(tempr>=0 && tempr<board.length && tempc>=0 && tempc<board[0].length && visited[tempr][tempc]==false){
                    visited[tempr][tempc]=true;
                    helper(cur,tempr,tempc,board,dir,visited,ans);
                    visited[tempr][tempc]=false;
                }
                
            }
        }
        
    }
    
}