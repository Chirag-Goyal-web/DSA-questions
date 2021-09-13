public class Count_subsequences_of_type_a_i_b_j_c_k{

    public int fun(String s){
        int mod=1000000007;
        long a=0,b=0,c=0;
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='a'){
                a=(2*a+1)%mod;        
            }
            
            else if(s.charAt(i)=='b'){
                b=(2*b+a)%mod;
            }
            
            else{
                c=(2*c+b)%mod;
            }
        }
        
        return (int)c;
    }

}