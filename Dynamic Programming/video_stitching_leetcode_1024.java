import java.util.*;
public class video_stitching_leetcode_1024{

    public int videoStitching(int[][] clips, int time) {
        
        int len=clips.length;
        Arrays.sort(clips,(a,b)->{
            if(a[0]!=b[0]){
                return a[0]-b[0];
            }
            else{
                return a[1]-b[1];   
            }
        });
        
        boolean flag1=false,flag2=false;
        for(int i=0;i<len;i++){
            if(clips[i][0]==0){
                flag1=true;
            }
            if(clips[i][1]>=time){
                flag2=true;
            }
        }
        
        if(!(flag1&&flag2)){
            return -1;
        }
        
        int[] dp=new int[len];
        
        for(int i=len-1;i>=0;i--){
            
            if(clips[i][1]>=time){
                dp[i]=1;
            }
            
            else{
                int min=(int)1e9;
                
                for(int j=i+1;j<len;j++){
                    if(clips[i][1]>=clips[j][0] && dp[j]!=(int)1e9){
                        min=Math.min(min,dp[j]+1);
                    }
                }   
                
                dp[i]=min;
            }
            
        }
        
        int ans=(int)1e9;
        //Get ans from clip with starting 0
        for(int i=0;i<len;i++){
            if(clips[i][0]!=0){
                break;
            }
            else{
                ans=Math.min(ans,dp[i]);
            }
        }
        
        return ans==(int)1e9?-1:ans;
    }

}