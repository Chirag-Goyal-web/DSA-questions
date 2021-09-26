import java.util.*;
public class unique_substrings_in_wraparound_string_leetcode_467{

    public int findSubstringInWraproundString(String p) {
        int[] arr=new int[26];        
        int maxLen=1;
        
        for(int i=0;i<p.length();i++){
            arr[p.charAt(i)-'a']=Math.max(maxLen,arr[p.charAt(i)-'a']);
            
            if(i+1<p.length()){
                
                if(p.charAt(i)=='z' && p.charAt(i+1)=='a'){
                    maxLen++;
                }
                else if(p.charAt(i)+1==p.charAt(i+1)){
                    maxLen++;
                }
                else{
                    maxLen=1;
                }
            }
        }
        
        int ans=0;
        
        for(int i=0;i<26;i++){
            ans+=arr[i];
        }
        
        return ans;
    }

}