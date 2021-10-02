public class shortest_uncommon_subsequence{

    static int shortestUnSub(String S, String T) {
        int len1=S.length();
        int len2=T.length();
        
        Pair[][] dp=new Pair[len1+1][len2+1];
        
        Pair ans=helper(S,T,len1,len2,dp);
        
        if(ans.bool==false){
            return -1;
        }
        else{
            return ans.len;
        }
    }
    
    static class Pair{
        boolean bool;
        int len;
        
        Pair(boolean bool,int len){
            this.bool=bool;
            this.len=len;
        }
    }
    
    static Pair helper(String str1,String str2,int idx1,int idx2,Pair[][] dp){
        
        if(idx1==0 && idx2==0)
            return new Pair(false,0);
        
        else if(idx1==0)
            return new Pair(false,0);
        
        else if(idx2==0)
            return new Pair(true,0);
            
        else{
            
            boolean ans=false;
            int len=(int)1e9;
        
            Pair temp1=helper(str1,str2,idx1-1,idx2,dp);
            
            if(temp1.bool==true){
                ans=true;
                len=temp1.len;
            }
            
            char c=str1.charAt(idx1-1);
            
            boolean flag=false;
            int i;
            
            for(i=idx2;i>0;i--){
                if(str2.charAt(i-1)==c){
                    flag=true;
                    break;
                }
            }
            
            Pair temp2=new Pair(false,0);
            if(flag==true){
                temp2=helper(str1,str2,idx1-1,i-1,dp);
                temp2.len+=1;
            }
            
            else{
                temp2=new Pair(true,1);
            }
            
            if(temp2.bool==true){
                ans=true;
                if(temp2.len<len)
                    len=temp2.len;
            }
            
            return new Pair(ans,len);
        }
        
    }

    public static void main(String[] args) {
        System.out.println(shortestUnSub("babhi", "babij"));
    }

}