public class Remove_Duplicates_from_Sorted_List_II{

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            
            int prev=-101;
            ListNode dummy=new ListNode(-1);
            ListNode p=dummy;
            
            while(head!=null){
                
            if(!(head.val==prev || (head.next!=null && head.next.val==head.val))){
                    dummy.next=head;
                    dummy=head;
                }
                    prev=head.val;
                    head=head.next;
            }
            
            dummy.next=null;
            
            return p.next;
        }
    }

    public static void main(String[] args) {
        
    }
}