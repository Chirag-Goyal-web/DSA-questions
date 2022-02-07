public class candy_leetcode_135{
    public int candy(int[] ratings) {
        int len=ratings.length;
        int[] ans=new int[len];
        
        ans[0]=1;
        
        for(int i=1;i<len;i++){
            if(ratings[i-1]<ratings[i]){
                ans[i]=ans[i-1]+1;
            }
            else{
                ans[i]=1;
            }
        }
        
        for(int i=len-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                ans[i]=Math.max(ans[i],ans[i+1]+1);
            }
        }
        
        int sum=0;
        for(int i:ans){
            sum+=i;
        }
        
        return sum;
    }
}