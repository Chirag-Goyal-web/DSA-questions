import java.util.*;
public class k_string_strings_leetcode_854{

    public int kSimilarity(String s1, String s2) {
        
        Set<String> visited=new HashSet<>();
        int len=s1.length();
        int ans=0;
        
        Queue<String> que=new LinkedList<>();
        que.add(s1);
        visited.add(s1);
        
        while(que.size()>0){
            int size=que.size();
            
            while(size-->0){    
                String temp=que.remove();
                if(temp.equals(s2)){
                    return ans;
                }   
                
                int idx=0;
                
                while(temp.charAt(idx)==s2.charAt(idx))
                    idx++;
                
                for(int i=idx+1;i<len;i++){
                    if(temp.charAt(i)!=temp.charAt(idx) && s2.charAt(i)==temp.charAt(idx) ){
                        String nw=swap(temp,idx,i);
                        
                        if(!visited.contains(nw)){
                            visited.add(nw);
                            que.add(nw);
                        }
                    }
                }
                
            }    
            ans++;
        }
        
        return ans;
    }
    
    public String swap(String str,int a,int b){
        char[] arr=str.toCharArray();
        char temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
        return new String(arr);
    }

}