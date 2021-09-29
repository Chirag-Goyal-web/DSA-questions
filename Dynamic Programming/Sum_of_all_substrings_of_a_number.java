public class Sum_of_all_substrings_of_a_number{
 
    public static long sumSubstrings(String s){
        int l=s.length();
        long ans=0;
        int mod=((int)1e9)+7;
        long prev=0;
        
        for(int i=0;i<l;i++){
            long temp=((s.charAt(i)-'0')*(i+1)+prev*10)%mod;
            prev=temp;
            ans=(ans+temp)%mod;
        }
        
        return ans;
    }
    
}