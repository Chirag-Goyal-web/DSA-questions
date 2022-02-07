public class single_number_2{
    public int singleNumber(int[] nums) {
        int t0=-1,t1=0,t2=0;
        
        for(int i:nums){
            int temp0=(i&t0);
            int temp1=(i&t1);
            int temp2=(i&t2);
            
            t0=(t0^temp0);
            t0=(t0|temp2);
            t1=(t1^temp1);
            t1=(t1|temp0);
            t2=(t2^temp2);
            t2=(t2|temp1);
        }
        
        return t1;
    }   
}