public class Longest_Chunked_Palindrome_Decomposition_leetcode_1147{
    
    public int longestDecomposition(String text) {
        int start1=0;
        int start2=text.length()-1;
        int end1=0;
        int end2=text.length()-1;
        int ans=0;        
        int lenOfAns=0;
        
        while(end1<start2){
            if(areEqual(text,start1,end1,start2,end2)){
                lenOfAns+=(end1-start1+1)*2;
                start1=end1+1;
                end2=start2-1;
                ans+=2;
            }
            
            end1++;
            start2--;
        }
        
        if(lenOfAns<text.length()){
            ans++;
        }
        
        return ans;
    }
    
    public boolean areEqual(String text,int start1,int end1,int start2,int end2){
        
        for(int i=start1;i<=end1;i++){
            if(text.charAt(i)!=text.charAt(start2)){
                return false;
            }
            
            start2++;
        }
        
        return true;
    }
    
}