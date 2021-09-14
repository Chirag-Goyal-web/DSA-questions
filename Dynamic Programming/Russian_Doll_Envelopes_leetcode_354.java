import java.util.*;
public class Russian_Doll_Envelopes_leetcode_354{

    public int maxEnvelopes(int[][] envelopes) {
        
        int len=envelopes.length;
        Pair[] p=new Pair[envelopes.length];
        
        
        for(int i=0;i<len;i++){
            p[i]=new Pair(envelopes[i][0],envelopes[i][1]);
        }
        
        Arrays.sort(p);

        int[]dp=new int[len];
        int omax=0;
        for(int i=len-1;i>=0;i--){
            int max=0;
            for(int j=len-1;j>i;j--){
                
                if(p[i].height<p[j].height && p[i].width<p[j].width){
                    max=Math.max(max,dp[j]);
                }
                
            }
            dp[i]=max+1;
            omax=Math.max(omax,dp[i]);
        }
        
        
        return omax;
    }
    
    public class Pair implements Comparable<Pair>{
        
        int height;
        int width;
        
        Pair(int w,int h){
            this.width=w;
            this.height=h;
        }
        
        public int compareTo(Pair e){
            return this.width-e.width;
        }
        
    }

}