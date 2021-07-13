
public class rotate_list{
    
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    class Solution {
    
        public ListNode rotateRight(ListNode head, int k) {
            
            int length=length(head);
            
            if(length<=1){
                return head;
            }
            
            k=k%length;
            
            if(k==0){
                return head;
            }
        
            ListNode p1=head,p2=head;
            
            int run=length-k-1;
            
            for(int i=0;i<run;i++){
                p1=p1.next;
            }
            
            p2=p1.next;
            p1.next=null;
            
            ListNode tail=getTail(p2);
            tail.next=head;
            
            return p2;
        }
        
        public ListNode getTail(ListNode head){
            
            while(head.next!=null){
                head=head.next;
            }
            
            return head;
        }
        
        public int length(ListNode head){
            
            int count=0;
            
            while(head!=null){
                count++;
                head=head.next;
            }
            
            return count;
        }
        
    }

    public static void main(String[] args) {
        
    }

}