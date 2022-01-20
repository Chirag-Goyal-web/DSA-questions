import java.util.*;
public class course_schedule_3_leetcode_630{
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses,(a,b)->a[1]-b[1]);
        int totalTime=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{
            return b-a;
        });

        for(int[] temp:courses){
            int endDate=temp[1];
            int dur=temp[0];
            
            if(dur+totalTime<=endDate){
                totalTime+=dur;
                pq.add(dur);
            }
            else if(pq.size()>0 && pq.peek()>dur){
                totalTime-=(pq.peek()-dur);
                pq.remove();
                pq.add(dur);
            }
        }

        return pq.size();
    }
}