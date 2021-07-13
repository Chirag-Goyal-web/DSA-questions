public class Remove_Nth_Node_From_End_of_List{

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    
class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        
            ListNode dummy1=new ListNode(-1);
            ListNode dummy2=new ListNode(-1);
            ListNode ans=dummy2;
            
            dummy1.next=head;
            dummy2.next=head;
            
            for(int i=0;i<n;i++){
                dummy1=dummy1.next;    
            }
            
            while(dummy1.next!=null){ 
                dummy1=dummy1.next;
                dummy2=dummy2.next;
            }
            
            dummy2.next=dummy2.next.next;
            
            return ans.next;
        }
        
    }

    public static void main(String[] args) {
        
    }
}