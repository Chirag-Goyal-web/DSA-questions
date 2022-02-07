public class single_number_3{
    public int[] singleNumber(int[] nums) {
        int xor=0;
        
        for(int i:nums){
            xor^=i;
        }
        
        int[] ans=new int[2];
        int bit=(xor&(-xor));
        
        for(int i:nums){
            if(((bit&i)==0)){
                ans[0]^=i;
            }
            else{
                ans[1]^=i;
            }
        }
        
        return ans;
    }
}