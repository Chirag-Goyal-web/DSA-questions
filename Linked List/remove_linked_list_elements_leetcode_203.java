public class remove_linked_list_elements_leetcode_203{

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        
        if(head==null)
            return null;
        
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        
        ListNode forw=head;
        ListNode prev=dummy;
        
        while(forw!=null){
            if(forw.val==val){
                prev.next=forw.next;
                forw=forw.next;
            }
            
            else{
                forw=forw.next;
                prev=prev.next;
            }
        }
        
        return dummy.next;
    }

}