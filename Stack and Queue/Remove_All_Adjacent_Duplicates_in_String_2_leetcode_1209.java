import java.util.*;
public class Remove_All_Adjacent_Duplicates_in_String_2_leetcode_1209.java{
    public String removeDuplicates(String s, int k) {
        
        Stack<Pair> stk=new Stack<>();
        
        for(char c:s.toCharArray()){
            if(stk.size()>0 && stk.peek().c==c){
                stk.push(new Pair(stk.peek().count+1,c));
            }        
            else{
                stk.push(new Pair(1,c));
            }
            
            if(stk.peek().count==k){
                for(int i=0;i<k;i++){
                    stk.pop();
                }
            }
        }
        
        StringBuilder str=new StringBuilder("");
        
        while(stk.size()>0){
            str.append(stk.pop().c+"");
        }
        
        return str.reverse().toString();
    }
    
    public class Pair{
        char c;
        int count;
        
        Pair(int count,char c){
            this.count=count;
            this.c=c;
        }
    }
}