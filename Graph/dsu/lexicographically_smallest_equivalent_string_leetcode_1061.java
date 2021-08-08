public class lexicographically_smallest_equivalent_string_leetcode_1061{
    
    public String smallestEquivalentString(String s1, String s2, String baseStr){

        int[] par=new int[26];
        for(int i=0;i<26;i++)
            par[i]=i;
        
        for(int i=0;i<s1.length();i++){
            int p1=findPar(s1.charAt(i)-'a',par);
            int p2=findPar(s2.charAt(i)-'a',par);
            par[p1]=Math.min(p1,p2);//Make the small one parent
            par[p2]=Math.min(p1,p2);//Make the small one parent
        }

        String ans="";
        
        for(char c:baseStr.toCharArray())
            ans+=(char)(findPar(c-'a',par));

        return ans;
    }

    public int findPar(int v1,int[] par){
        if(par[v1]==v1){
            return v1;
        }
        else{
            int temp=findPar(par[v1],par);
            par[v1]=temp;
            return temp;
        }
    }

}