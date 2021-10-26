import java.util.*;
public class maximum_frequency_stack_leetcode_895{
    
    class FreqStack {
        
        HashMap<Integer,Integer> hm;
        PriorityQueue<pair> pq;
        static int count=0;

        private class pair implements Comparable<pair>{
            int val;
            int freq;
            int idx;

            pair(int val,int freq,int idx){
                this.val=val;
                this.freq=freq;
                this.idx=idx;
            }

            public int compareTo(pair o){
                if(this.freq==o.freq){
                    return o.idx-this.idx;
                }
                else{
                    return o.freq-this.freq;
                }
            }
        }

        public FreqStack() {
            hm=new HashMap<>();
            pq=new PriorityQueue<>();
        }
        
        public void push(int val) {
            count++;
            hm.put(val,hm.getOrDefault(val, 0)+1);
            pq.add(new pair(val,hm.get(val),count));
        }
        
        public int pop() {
            pair temp=pq.remove();
            if(hm.get(temp.val)>1){
                hm.put(temp.val,hm.get(temp.val)-1);
            }
            else{
                hm.remove(temp.val);
            }

            return temp.val;
        }
    }
    
    class FreqStack_{

        ArrayList<LinkedList<Integer>> arr;
        HashMap<Integer,Integer> hm=new HashMap<>();

        public FreqStack() {
            arr=new ArrayList<>();
            arr.add(new LinkedList<>());
            hm=new HashMap<>();
        }

        public void push(int val) {
            hm.put(val,hm.getOrDefault(val,0)+1);
            int f=hm.get(val);
            if(f>=arr.size()){
                arr.add(new LinkedList<>());
            }
            arr.get(f).addFirst(val);
        }

        public int pop() {
            int size=arr.size();
            int val=arr.get(size-1).getFirst();
            arr.get(size-1).removeFirst();
            if(arr.get(size-1).size()==0){
                arr.remove(size-1);
            }
            if(hm.get(val)==1){
                hm.remove(val);
            }
            else{
                hm.put(val,hm.get(val)-1);
            }
            return val;
        }
    }
    

}