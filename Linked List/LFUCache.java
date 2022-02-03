import java.util.*;
public class LFUCache {
    HashMap<Integer,DoubleLinkedList> freqMap;
    HashMap<Integer,DLLNode> cache;
    int maxCapacity=0;
    int givenCapacity=0;
    int minFreq=0;
    
    public LFUCache(int capacity) {
        maxCapacity=capacity;
        givenCapacity=capacity;
        freqMap=new HashMap<>();
        cache=new HashMap<>();
        minFreq=0;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)==false){
            return -1;
        }
        else{
            DLLNode node=cache.get(key);
            updateNode(node);
            return node.value;
        }
    }
    
    public void put(int key, int value) {
        if(givenCapacity==0){
            return;
        }
        else if(cache.containsKey(key)){
            DLLNode node=cache.get(key);
            node.value=value;
            updateNode(node);
        }
        else{
            if(maxCapacity==0){
                DoubleLinkedList temp=freqMap.get(minFreq);
                DLLNode removableNode=temp.tail.prev;
                cache.remove(removableNode.key);
                temp.removeNode(removableNode);
                maxCapacity++;
            }
            
            DLLNode node=new DLLNode(key,value);
            DoubleLinkedList list=freqMap.getOrDefault(1,new DoubleLinkedList());
            list.addFirst(node);
            freqMap.put(1,list);
            cache.put(key,node);
            minFreq=1;
            maxCapacity--;
        }
    }
    
    public void updateNode(DLLNode node){
        DoubleLinkedList list=freqMap.get(node.freq);
        list.removeNode(node);
        node.freq++;
        
        if(minFreq==node.freq-1 && list.size==0)
            minFreq=node.freq;
    
        DoubleLinkedList temp=freqMap.getOrDefault(node.freq,new DoubleLinkedList());
        temp.addFirst(node);
        freqMap.put(node.freq,temp);
    }
    
    class DLLNode{
        int key;
        int value;
        int freq;
        DLLNode next;
        DLLNode prev;
        
        DLLNode(int key,int value){
            this.key=key;
            this.value=value;
            this.freq=1;
        }
    }
    
    class DoubleLinkedList{
        DLLNode head;
        DLLNode tail;
        int size=0;
        
        DoubleLinkedList(){
            this.size=0;
            head=new DLLNode(0,0);
            tail=new DLLNode(0,0);
            head.next=tail;
            tail.prev=head;
        }
        
        public void addFirst(DLLNode node){
            DLLNode temp=head.next;
            node.next=temp;
            temp.prev=node;
            node.prev=head;
            head.next=node;
            size++;
        }
        
        public void removeNode(DLLNode node){
            DLLNode temp=node.next;
            temp.prev=node.prev;
            node.prev.next=temp;
            node.next=null;
            node.prev=null;
            size--;
        }
    }
    
}