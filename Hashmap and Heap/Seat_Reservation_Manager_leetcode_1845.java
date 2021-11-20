import java.util.*;
public class Seat_Reservation_Manager_leetcode_1845{
    class SeatManager {
        int count=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        
        public SeatManager(int n) {
            count=0;
            pq=new PriorityQueue<>();
        }
        
        public int reserve() {
            if(pq.size()>0){
                return pq.remove();
            }
            else{
                return ++count;
            }
        }
        
        public void unreserve(int seatNumber) {
            pq.add(seatNumber);
        }
    }
}