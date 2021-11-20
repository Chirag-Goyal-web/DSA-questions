import java.util.*;
public class find_median_from_data_stream_leetcode_295{
    class MedianFinder {
        PriorityQueue<Integer> min;
        PriorityQueue<Integer> max;
        
        public MedianFinder() {
            min=new PriorityQueue<>();
            max=new PriorityQueue<>((a,b)->{
                return b-a;
            });
        }
        
        public void addNum(int num) {
            if(max.size()==0 || num>max.peek()){
                min.add(num);
            }
            else{
                max.add(num);
            }
            
            if(min.size()>max.size()){
                max.add(min.remove());
            }
            else if(max.size()-min.size()>1){
                min.add(max.remove());
            }
            
        }
        
        public double findMedian() {
            if(min.size()==max.size()){
                double d1=min.peek();
                double d2=max.peek();
                
                return (d1+d2)/2;
            }
            else{
                return max.peek();
            }
        }
    }
}