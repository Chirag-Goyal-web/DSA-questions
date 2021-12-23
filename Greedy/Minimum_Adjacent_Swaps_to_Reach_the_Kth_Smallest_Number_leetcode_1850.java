public class Minimum_Adjacent_Swaps_to_Reach_the_Kth_Smallest_Number_leetcode_1850{
    public int getMinSwaps(String num, int k) {
        int[] arr=new int[num.length()];
        int ptr=0;
        
        int[] nums=new int[num.length()];
        
        for(char c:num.toCharArray()){
            arr[ptr]=c-'0';
            nums[ptr]=arr[ptr];
            ptr++;
        }
        
        for(int i=0;i<k;i++){
            nextPermutation(arr);
        }
        
        int ans=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=arr[i]){
                
                int pt=0;
                for(int j=i+1;j<nums.length;j++){
                    if(nums[j]==arr[i]){
                        pt=j;
                        break;
                    }                
                }
                
                for(int ki=pt;ki>i;ki--){
                    nums[ki]=nums[ki-1];
                }
                
                nums[i]=arr[i];
                ans+=(pt-i);
            }
        }
        
        return ans;
    }
    
    public void nextPermutation(int[] nums) {
        int ptr=0;
        for(int i=nums.length-1;i>0;i--){
            if(nums[i-1]<nums[i]){
                ptr=i-1;
                break;
            }
        }
        
        int justGreater=0;
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]>nums[ptr]){
                justGreater=i;
                break;
            }
        }
        
        int temp=nums[justGreater];
        nums[justGreater]=nums[ptr];
        nums[ptr]=temp;
        
        reverse(nums,ptr+1,nums.length-1);
    }
    
    public void reverse(int[] nums,int start,int end){
        for(int i=start,j=end;i<j;i++,j--){
            int t=nums[i];
            nums[i]=nums[j];
            nums[j]=t;
        }
    }
    
}