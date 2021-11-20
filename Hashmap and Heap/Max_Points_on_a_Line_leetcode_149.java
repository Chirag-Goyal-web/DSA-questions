import java.util.*;
public class Max_Points_on_a_Line_leetcode_149{
    public int maxPoints(int[][] points) {
        int len=points.length;
        int ans=0;
        HashMap<String,Integer> hm=new HashMap<>();
        
        if(len<=2){
            return len;
        }
        
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                int xDiff=points[j][0]-points[i][0];
                int yDiff=points[j][1]-points[i][1];
                
                int gcd=getGCD(xDiff,yDiff);
                String str=(xDiff/gcd)+"@"+(yDiff/gcd);
                hm.put(str,hm.getOrDefault(str,0)+1);
                ans=Math.max(ans,hm.get(str)+1);
            }
            hm.clear();
        }
        
        return ans;
    }
    
    public int getGCD(int a,int b){
        if(a==0)
            return b;
        else
            return getGCD(b%a,a);
    }
}