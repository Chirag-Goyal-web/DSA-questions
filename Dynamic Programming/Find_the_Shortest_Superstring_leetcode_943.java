import java.util.*;
public class Find_the_Shortest_Superstring_leetcode_943{
    public String shortestSuperstring(String[] words) {
        HashMap<String,String> hm=new HashMap<>();
        int bit=Integer.MAX_VALUE;
        return helper(hm,bit,words,"");
    }
    
    public String helper(HashMap<String,String> hm,int bit,String[] words,String startingWord){
        String key=startingWord+"$"+bit;
        
        if(hm.containsKey(key)==true){
            return hm.get(key);
        }
        else{
            String ans="";
            
            for(int i=0;i<words.length;i++){
                int bitMask=(1<<i);
                
                if((bitMask&bit)>0){
                    bit=(bit^bitMask);
                    String str=helper(hm,bit,words,words[i]);
                    bit=(bit^bitMask);
                    
                    String temp=makeString(startingWord,str);
                    if(ans.equals("")){
                        ans=temp;
                    }
                    else if(ans.length()>temp.length()){
                        ans=temp;
                    }
                }
            }
            
            if(ans.equals("")){
                ans=startingWord;
            }
            hm.put(key,ans);
            return ans;
        }
    }
    
    public String makeString(String s1,String s2){        
        if(s1.length()==0){
            return s2;
        }
        else if(s2.length()==0){
            return s1;
        }
        else{
            int len1=s1.length();
            int len2=s2.length();
            
            if(s1.contains(s2)){
                return s1;
            }
            else{
                for(int i=0;i<len1;i++){
                    int j=i,k=0;
                    
                    while(j<len1){
                        if(s1.charAt(j)==s2.charAt(k)){
                            j++;
                            k++;
                        }
                        else{
                            break;
                        }
                    }
                    
                    if(j==len1){
                        return s1.substring(0,i)+s2;
                    }
                }
                
                return s1+s2;
            }
        }
    }   
    
}