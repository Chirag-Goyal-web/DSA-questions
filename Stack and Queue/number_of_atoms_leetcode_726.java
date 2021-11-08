import java.util.*;
public class number_of_atoms_leetcode_726{
    public String countOfAtoms(String formula) {
        HashMap<String,Integer> hm=new HashMap<>();
        int i=0;
        Stack<Pair> stk=new Stack<>();
        int len= formula.length();
        
        while(i<len){
            
            if(formula.charAt(i)-'0'>0 && formula.charAt(i)-'0'<=9){
                int temp=i;
                while(temp<len && formula.charAt(temp)-'0'>=0 && formula.charAt(temp)-'0'<=9){
                    temp++;
                }
                
                int digit=Integer.parseInt(formula.substring(i,temp));
                
                if(stk.peek().name.equals(")")){
                    stk.pop();
                    Stack<Pair> stk2=new Stack<>();
                    
                    while(!stk.peek().name.equals("(")){
                        Pair p=stk.pop();
                        hm.put(p.name,hm.get(p.name)-p.count+p.count*digit);
                        p.count*=digit;
                        stk2.push(p);
                    }
                    stk.pop();
                    
                    while(stk2.size()>0){
                        stk.push(stk2.pop());
                    }
                }
                
                else{
                    Pair p=stk.peek();
                    hm.put(p.name,hm.get(p.name)-p.count+p.count*digit);
                    p.count*=digit;
                }
                
                i=temp;
            }
            
            else if(formula.charAt(i)=='(' || formula.charAt(i)==')'){
                stk.push(new Pair(formula.charAt(i)+"",0));
                i++;
            }
            
            else{
                int temp=i;
                temp++;
                while(temp<len && formula.charAt(temp)-'a'>=0 && formula.charAt(temp)-'a'<=25){
                    temp++;
                }
                String s=formula.substring(i,temp);
                hm.put(s,hm.getOrDefault(s,0)+1);
                stk.push(new Pair(s,1));
                i=temp;
            }
        }
       
        String[] arr=new String[hm.size()];
        int idx=0;
        for(String st:hm.keySet()){
            arr[idx++]=st;
        }
        
        Arrays.sort(arr);
        StringBuilder ans=new StringBuilder("");
        
        for(int t=0;t<arr.length;t++){
            ans.append(arr[t]);
            
            if(hm.get(arr[t])>1){
                ans.append(hm.get(arr[t])+"");
            }
        }
        
        return ans.toString();
    }
    
    public class Pair{
        String name;
        int count;
        
        Pair(String name,int count){
            this.name=name;
            this.count=count;
        }
    }
}