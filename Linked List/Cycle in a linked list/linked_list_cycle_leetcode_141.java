public class linked_list_cycle_leetcode_141{

    class ListNode {
        int val;
        ListNode next;
        
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        
        if(head==null)
            return false;
        
        ListNode slow=head;
        ListNode fast=head;
        
        while(fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            
            if(fast==slow)
                return true;
            
        }
        
        return false;
    }

}