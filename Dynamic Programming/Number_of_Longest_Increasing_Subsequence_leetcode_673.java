public class Number_of_Longest_Increasing_Subsequence_leetcode_673{

    public int findNumberOfLIS(int[] nums) {
        
        int len=nums.length;
        int[][] arr=new int[2][len];
        int overAllMax=0;
        
        for(int i=0;i<len;i++){
            int maxVal=0;
            
            for(int j=i-1;j>=0;j--){
                if(nums[j]<nums[i]){
                    maxVal=Math.max(arr[0][j],maxVal);    
                }
            }
            
            arr[0][i]=maxVal+1;
            overAllMax=Math.max(overAllMax,arr[0][i]);
            int count=0;
            
            for(int j=i-1;j>=0;j--){
                if(nums[j]<nums[i] && arr[0][j]==maxVal){
                    count+=arr[1][j];
                }
            }
            
            arr[1][i]=count==0?1:count;
        }
        
        int ans=0;
        for(int i=0;i<len;i++){
            if(overAllMax==arr[0][i]){
                ans+=arr[1][i];
            }
        }
        
        return ans;
    }

}