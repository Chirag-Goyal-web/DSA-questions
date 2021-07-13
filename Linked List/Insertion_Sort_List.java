public class Insertion_Sort_List{

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    class Solution {
        public ListNode insertionSortList(ListNode head) {
            
            ListNode dummy=new ListNode(-10000);
            
            while(head!=null){
                
                ListNode temp=head;
                head=head.next;
                temp.next=null;
                insert(temp,dummy);
                
            }
            
            return dummy.next;
        }
        
        public void insert(ListNode temp,ListNode dummy){
            
            while(dummy.next!=null && dummy.next.val<temp.val){
                dummy=dummy.next;
            }
            
            ListNode t=dummy.next;
            dummy.next=temp;
            temp.next=t;
        }
        
    }

    public static void main(String[] args) {
        
    }
}