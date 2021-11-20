public class string_without_aaa_or_bbb_leetcode_984{
    public String strWithout3a3b(int a, int b) {
        StringBuilder ans=new StringBuilder();
        boolean writeA=false;
        
        while(a>0 || b>0){
            writeA=false;
            
            if(ans.length()>1 && ans.charAt(ans.length()-1)==ans.charAt(ans.length()-2)){
                if(ans.charAt(ans.length()-1)=='b'){
                    writeA=true;
                }
            }
            else{
                if(a>b){
                    writeA=true;
                }
            }
            
            if(writeA==true){
                ans.append("a");
                a--;
            }
            else{
                ans.append("b");
                b--;
            }
            
        }
        
        return ans.toString();
    }
}