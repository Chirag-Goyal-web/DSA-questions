import java.util.*;
public class camelcase_matching_leetcode_1023{
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans=new ArrayList<>();
        
        for(String str:queries){
            int ptr1=0;
            int ptr2=0;
            boolean flag=false;
            
            while(ptr1<str.length() && ptr2<pattern.length()){
                char c1=pattern.charAt(ptr2);
                
                while(ptr1<str.length()){
                    char c2=str.charAt(ptr1);
                    if(c2==c1){
                        ptr1++;
                        ptr2++;
                        break;
                    }
                    else if(c2>='a' && c2<='z'){
                        ptr1++;
                    }
                    else{
                        flag=true;
                        break;
                    }
                }
                
                if(flag==true){
                    break;
                }
            }
            
            if(ptr2<pattern.length()){
                ans.add(false);
            }
            else{
                boolean f=true;
                for(int i=ptr1;i<str.length();i++){
                    if(str.charAt(i)>='A' && str.charAt(i)<='Z'){
                        f=false;
                        break;
                    }
                }
                
                if(f==true){
                    ans.add(true);
                }
                else{
                    ans.add(false);
                }
            }
        }
        
        return ans;
    }
}