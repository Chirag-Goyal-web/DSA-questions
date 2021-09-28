public class super_washing_machines_leetcode_517{
    
    public int findMinMoves(int[] machines) {
        
        int len=machines.length;
        int[] leftSum=new int[len];
        int[] rightSum=new int[len];
        int sum=0;
        
        for(int i:machines){
            sum+=i;
        }
        
        if(sum%len!=0){
            return -1;
        }
        
        int avg=sum/len;
        
        for(int i=1;i<len;i++){
            leftSum[i]=leftSum[i-1]+machines[i-1];
        }
        
        for(int i=len-2;i>=0;i--){
            rightSum[i]=rightSum[i+1]+machines[i+1];
        }
        
        int ans=0;
        for(int i=0;i<len;i++){
            int temp=0;
            int expLeft=i*avg;
            int expRight=(len-i-1)*avg;
            
            if(expLeft>leftSum[i]){
                temp+=expLeft-leftSum[i];
            }
            
            if(expRight>rightSum[i]){
                temp+=expRight-rightSum[i];
            }
            
            ans=Math.max(ans,temp);
        }
        
        return ans;
    }

}