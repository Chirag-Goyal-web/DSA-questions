import java.util.*;

public class clone_a_linked_list{

    class Node {
        int val;
        Node next;
        Node random;
    
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    //Without hashmap
    class Solution_1{
        public Node copyRandomList(Node head) {
            
            Node itr=head;
            Node ans=null;
            
            
            while(itr!=null){
                Node nw=new Node(itr.val);
                if(ans==null)
                    ans=nw;
                nw.next=itr.next;
                itr.next=nw;
                itr=itr.next.next;
            }
            
            itr=head;
            
            while(itr!=null){
                
                if(itr.random!=null){
                  itr.next.random=itr.random.next;    
                }
                
                itr=itr.next.next;
            
            }
            
            itr=head;
            
            while(itr!=null){
                Node temp=itr.next;
                itr.next=temp.next;
                itr=itr.next;
                
                if(itr!=null)
                    temp.next=itr.next;
            }
            
                    
            
            return ans;
            
        }
    }

    //With hashmap
    class Solution_2 {
        
        public Node copyRandomList(Node head) {
            
            if(head==null){
                return null;
            }
            
            else{
                
                HashMap<Node,Node> hm=new HashMap<>();
                Node dummy=new Node(-1);
                Node nhead=dummy;
                
                for(Node ptr=head;ptr!=null;ptr=ptr.next){
                    Node temp=new Node(ptr.val);
                    dummy.next=temp;
                    dummy=temp;
                    hm.put(ptr,temp);
                }
                
                nhead=nhead.next;
                
                for(Node ptr=head;ptr!=null;ptr=ptr.next){
                    Node n1=hm.get(ptr);
                    Node n2=hm.get(ptr.random);
                    n1.random=n2;
                }
                
                return nhead;
                
            }
            
        } 
        
    }

    public static void main(String[] args) {
        
    }

}