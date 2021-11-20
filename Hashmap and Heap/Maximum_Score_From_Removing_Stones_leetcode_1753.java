import java.util.*;
public class Maximum_Score_From_Removing_Stones_leetcode_1753{

    public int maximumScore(int a, int b, int c) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a1,a2)->{
            return a2-a1;
        });
        
        pq.add(a);
        pq.add(b);
        pq.add(c);
        
        int count=0;
        while(pq.size()>1){
            int t1=pq.remove()-1;
            int t2=pq.remove()-1;
            
            if(t1>0){
                pq.add(t1);
            }
            if(t2>0){
                pq.add(t2);
            }
            
            count++;
        }
        
        return count;
    }

    public int maximumScore_(int a, int b, int c) {
        if(b>a){
            return maximumScore_(b,a,c);
        }
        else if(c>b){
            return maximumScore_(a,c,b);
        }
        else if(b==0){
            return 0;
        }
        else{
            int temp=Math.max(1,b-c);//In case, b==c
            return temp+maximumScore_(a-temp,b-temp,c);
        }
    }

}