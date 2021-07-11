public class reverse_in_range{

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    static ListNode temp_head=null;
    static ListNode temp_tail=null;

    public void add_first(ListNode node){
        
        node.next=null;
        
        if(temp_head==null && temp_tail==null){
            temp_head=node;
            temp_tail=node;
        }

        else{
            node.next=temp_head;
            temp_head=node;
        }
    }
    
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        temp_head=null;
        temp_tail=null;
        
        ListNode h=head,t=null;
        ListNode itr=head;
        int count=1;
        
        while(count<left){
            count++;
            t=itr;
            itr=itr.next;
        }
        
        while(count<=right){
            count++;
            ListNode temp=itr;
            itr=itr.next;
            add_first(temp);
        }
        
        if(left>1){
           t.next=temp_head;
           temp_tail.next=itr; 
           return h;   
        }
        
        else{
            temp_tail.next=itr;
            return temp_head;
        }
        
    }

    public static void main(String[] args){
        
    }
}