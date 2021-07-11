public class segregate_012_node_Of_linkedlist_over_swapping_nodes{

    public static class ListNode {
        
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode segregate012(ListNode head) {
        
        ListNode dummy_0=new ListNode(-1);
        ListNode dummy_1=new ListNode(-1);
        ListNode dummy_2=new ListNode(-1);
        
        ListNode p=dummy_0,q=dummy_1,r=dummy_2;
        
        while(head!=null){
            
            if(head.val==0){
                dummy_0.next=head;
                dummy_0=head;
            }
            
            else if(head.val==1){
                dummy_1.next=head;
                dummy_1=head;
            }
            
            else{
                dummy_2.next=head;
                dummy_2=head;
            }
            
            head=head.next;   
            
        }
        
        dummy_0.next=null;
        dummy_1.next=null;
        dummy_2.next=null;
        
        p=p.next;q=q.next;r=r.next;
        
        if(p!=null){
            
            if(q!=null){
                dummy_0.next=q;
                dummy_1.next=r;
            }
            
            else{
                dummy_0.next=r;    
            }
            
            return p;
        }
        
        else{
            
            if(q!=null){
                dummy_1.next=r;
            }
            
            else{
                return r;
            }
            
            return q;
        }
        
    }

    public static void main(String[] args){

    }

}