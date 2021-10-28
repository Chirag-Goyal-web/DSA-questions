public class Maximum_Score_From_Removing_Substrings_leetcode_1717{
    public int maximumGain(String s, int x, int y) {
        if(x>y){
            return helper(s,'a','b',x,y);
        }
        else{
            return helper(s,'b','a',y,x);
        }
    }
    
    public int helper(String s,char first,char second,int x,int y){
        Stack<Character> stk=new Stack<>();
        int ans=0;
        
        for(char c:s.toCharArray()){
            if(c==first){
                stk.push(c);
            }
            else if(c==second){
                if(stk.size()>0 && stk.peek()==first){
                    stk.pop();
                    ans+=x;            
                }
                else{
                    stk.push(c);
                }
            }
            else{
                Stack<Character> stk2=new Stack<>();
                while(stk.size()>0){
                    char ch=stk.pop();
                    if(stk2.size()>0 && stk2.peek()==first && ch==second){
                        ans+=y;
                        stk2.pop();
                    }
                    else{
                        stk2.push(ch);
                    }
                }
                
            }            
        }
        
        Stack<Character> stk2=new Stack<>();
        
        while(stk.size()>0){
            char ch=stk.pop();
            if(stk2.size()>0 && stk2.peek()==first && ch==second){
                ans+=y;
                stk2.pop();
            }
            else{
                stk2.push(ch);
            }
        }
        
        return ans;
    }
}