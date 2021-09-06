public class linked_list_cycle_2_leetcode_142{

    class ListNode {
        int val;
        ListNode next;
        
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        
        ListNode mid=intersection(head);
        
        if(mid==null || mid.next==null)
            return null;
        
        else{
            ListNode ptr=head;
            while(mid!=ptr){
                mid=mid.next;
                ptr=ptr.next;
            }
            
            return ptr;
        }
        
    }
    
    public ListNode intersection(ListNode head){
        
        ListNode fast=head,slow=head;
        
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            
            if(fast==slow)
                return fast;
        }
        
        return fast;
    }

}