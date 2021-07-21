import java.util.*;
public class LRU_cache{

    //Approach-1 (Using hashmap)
    class LRUCache_1{

        HashMap<Integer,ListNode> hm;
        int size=0;
        int capacity=0;
        ListNode head=null;
        ListNode tail=null;
        
        public LRUCache_1(int capacity) {
            this.capacity=capacity;
            this.size=0;
            hm=new HashMap<>();
            head=null;
            tail=null;
        }
        
        public class ListNode{
            Integer key;
            Integer val;
            
            ListNode prev;
            ListNode next;
            
            ListNode(int key,int val){
                this.key=key;
                this.val=val;
            }
            
        }
        
        public int get(int key) {
            
            if(hm.containsKey(key)==false){
                return -1;
            }
            
            else{
                ListNode temp=hm.get(key);
                makeRecent(temp);
                return temp.val;
            }
        }
        
        public void removeHead(){
            this.size--;
            hm.remove(head.key);
            ListNode temp=head.next;
            temp.prev=null;
            head.next=null;
            head=temp;
        }
        
        public void makeRecent(ListNode node){
            
            if(node==tail){
                return;
            }
            
            else if(node==head){
                removeHead();
                addLast(node);
            }
            
            else{
                ListNode back=node.prev;
                ListNode front=node.next;
                back.next=front;
                front.prev=back;
                this.size--;
                node.next=null;
                node.prev=null;
                addLast(node);
            }
            
        }
        
        public void addLast(ListNode node){
            this.size++;
            node.next=null;
            node.prev=null;
            hm.put(node.key,node);
        
            if(head==null){
                head=tail=node;
            }
            
            else{
                tail.next=node;
                node.prev=tail;
                tail=node;
            }
            
        }
        
        public void put(int key, int value) {
            
            if(hm.containsKey(key)==true){
                ListNode temp=hm.get(key);
                temp.val=value;
                makeRecent(temp);
            }
            
            else{
                
                if(this.capacity==this.size){
                    ListNode node=new ListNode(key,value);
                    addLast(node);
                    removeHead();
                }
                
                else{
                    ListNode node=new ListNode(key,value);
                    addLast(node);
                }
                
            }
            
        }
    }
    
    class LRUCache_2 {

        //HashMap<Integer,ListNode> hm;
        ListNode[] storage=new ListNode[10000+1];
        int size=0;
        int capacity=0;
        ListNode head=null;
        ListNode tail=null;
        
        public LRUCache_2(int capacity) {
            this.capacity=capacity;
            this.size=0;
           // hm=new HashMap<>();
            storage=new ListNode[100001];
            head=null;
            tail=null;
        }
        
        public class ListNode{
            Integer key;
            Integer val;
            
            ListNode prev;
            ListNode next;
            
            ListNode(int key,int val){
                this.key=key;
                this.val=val;
            }
            
        }
        
        public int get(int key) {
            
            if(storage[key]==null){
                return -1;
            }
            
            else{
                ListNode temp=storage[key];
                makeRecent(temp);
                return temp.val;
            }
        }
        
        public void removeHead(){
            this.size--;
        //    hm.remove(head.key);
            storage[head.key]=null;
            ListNode temp=head.next;
            temp.prev=null;
            head.next=null;
            head=temp;
        }
        
        public void makeRecent(ListNode node){
            
            if(node==tail){
                return;
            }
            
            else if(node==head){
                removeHead();
                addLast(node);
            }
            
            else{
                ListNode back=node.prev;
                ListNode front=node.next;
                back.next=front;
                front.prev=back;
                this.size--;
                node.next=null;
                node.prev=null;
                addLast(node);
            }
            
        }
        
        public void addLast(ListNode node){
            this.size++;
            node.next=null;
            node.prev=null;
            storage[node.key]=node;
           // hm.put(node.key,node);
        
            if(head==null){
                head=tail=node;
            }
            
            else{
                tail.next=node;
                node.prev=tail;
                tail=node;
            }
            
        }
        
        public void put(int key, int value) {
            
            if(storage[key]!=null){
              //  ListNode temp=hm.get(key);
                ListNode temp=storage[key];
                temp.val=value;
                makeRecent(temp);
            }
            
            else{
                
                if(this.capacity==this.size){
                    ListNode node=new ListNode(key,value);
                    addLast(node);
                    removeHead();
                }
                
                else{
                    ListNode node=new ListNode(key,value);
                    addLast(node);
                }
                
            }
            
        }
    }
    public static void main(String[] args) {
        
    }
}