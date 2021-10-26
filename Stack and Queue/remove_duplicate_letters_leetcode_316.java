public class remove_duplicate_letters_leetcode_316{
    public String removeDuplicateLetters(String s) {
        int len=s.length();
        boolean[] visited=new boolean[26];
        StringBuilder str=new StringBuilder("");
        int[] freq=new int[26];
        
        for(char c:s.toCharArray()){
            freq[c-'a']++;
        }
        
        for(char c:s.toCharArray()){
            if(visited[c-'a']==true){
                freq[c-'a']--;
                continue;
            }    
            else{
                while(str.length()>0 && str.charAt(str.length()-1)-'a'>c-'a' && freq[str.charAt(str.length()-1)-'a']>1){
                    freq[str.charAt(str.length()-1)-'a']--;
                    visited[str.charAt(str.length()-1)-'a']=false;
                    str.deleteCharAt(str.length()-1);
                }
                visited[c-'a']=true;
                str.append(c+"");
            }
        }
        
        return str.toString();
    }
}