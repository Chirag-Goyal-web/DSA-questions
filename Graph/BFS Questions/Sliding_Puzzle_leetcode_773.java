import java.util.*;

public class Sliding_Puzzle_leetcode_773{

    class Solution {
    
        public class Pair{
            String str;
            int idx;
            
            Pair(String str,int idx){
                this.str=str;
                this.idx=idx;
            }
        }
        
        public int slidingPuzzle(int[][] board) {
            
            String ans="123450";
            Set<String> hm=new HashSet<>();
            int[][] dir=new int[][]{{1,3},{0,2,4},{1,5},{0,4},{1,3,5},{2,4}};
            
            Queue<Pair> que=new LinkedList<>();
            
            String s="";
            int idx=0;
            for(int i=0;i<2;i++){
                for(int j=0;j<3;j++){
                    s+=board[i][j];
                    if(board[i][j]==0)
                        idx=i*3+j;
                }
            }
            
            que.add(new Pair(s,idx));
            int swap=0;
            
            while(que.size()>0){    
                int size=que.size();
                
                while(size-->0){
                    
                    Pair p=que.remove();
                    
                    if(ans.equals(p.str)){
                        return swap;
                    }
                    
                    else{
                        
                        for(int i:dir[p.idx]){
                            String nstr=swapStr(p.str,p.idx,i);
                            
                            if(!hm.contains(nstr)){
                                hm.add(nstr);
                                que.add(new Pair(nstr,i));
                            }
                        }
                    }
                    
                }
                
                swap++;
            }
            
            return -1;
        }
        
        public String swapStr(String str,int cur,int pos){
            
            StringBuilder s=new StringBuilder(str);
            
            char temp=s.charAt(cur);
            s.setCharAt(cur,s.charAt(pos));
            s.setCharAt(pos,temp);
            
            return s.toString();
        }
        
    }
    

}