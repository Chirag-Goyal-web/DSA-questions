public class Segregate_Node_Of_Linkedlist_Over_Last_Index{

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    

    public static ListNode segregateOnLastIndex(ListNode head) {
        
        ListNode dummy1=new ListNode(-1);
        ListNode dummy2=new ListNode(-1);
        
        ListNode p=dummy1;
        ListNode q=dummy2;
        
        int last=get_last(head);
        
        while(head!=null){
            
            if(head.val<=last){
                dummy1.next=head;
                dummy1=head;
            }
            
            else{
                dummy2.next=head;
                dummy2=head;
            }
            
            head=head.next;
        }
        
        dummy1.next=null;
        dummy2.next=null;
        
        p=p.next;
        q=q.next;
       
       ListNode nw=new ListNode(last);
       nw.next=q;
       return nw;
        
    }
    
    
    public static int get_last(ListNode head){
        
        while(head!=null && head.next!=null){
            head=head.next;
        }
        
        return head.val;
    }

    public static void main(String[] args){
        
    }

}