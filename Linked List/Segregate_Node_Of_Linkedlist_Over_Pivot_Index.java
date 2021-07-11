public class Segregate_Node_Of_Linkedlist_Over_Pivot_Index{

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode segregate(ListNode head, int pivotIdx) {
      
        ListNode dummy1=new ListNode(-1);
        ListNode dummy2=new ListNode(-1);
        ListNode p=dummy1;
        ListNode q=dummy2;
        ListNode pivotNode=null;
        
        int pivot_val=get_val(head,pivotIdx);
        
        while(head!=null){
            
            if(pivotIdx--==0){
                pivotNode=head;
                head=head.next;
                continue;
            }
            
            else if(head.val<=pivot_val){
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
        
        dummy1.next=pivotNode;
        pivotNode.next=q.next;
        
        return p.next;
       
        
    }
    
    public static int get_val(ListNode head,int pivot){
        
        while(pivot-->0){
            head=head.next;
        }
        
        return head.val;
    }
    
    public static void main(String[] args){

    }

}