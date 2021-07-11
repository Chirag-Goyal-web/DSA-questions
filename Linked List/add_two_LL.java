public class add_two_LL{

    public static class ListNode {
       
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        l1=reverse(l1);
        l2=reverse(l2);
        
        int carry=0;
        
        ListNode dummy=new ListNode(-1);
        ListNode p=dummy;
        
        while(l1!=null || l2!=null){
            
            int val=0;
            
            if(l1!=null){
                val+=l1.val;
                l1=l1.next;
            }
            
            if(l2!=null){
                val+=l2.val;   
                l2=l2.next;
            }
            
            val+=carry;
            
            int temp=val%10;
            carry=val/10;
            
            ListNode nw=new ListNode(temp);
            dummy.next=nw;
            dummy=nw;
            
        }
        
       if(carry!=0){
           ListNode n=new ListNode(carry);
           dummy.next=n;
       }
        
        return reverse(p.next);
        
        
    }

    public static ListNode reverse(ListNode head) {
            
            if(head==null||head.next==null){
                return head;
            }
            
            ListNode prev=null;
            ListNode cur=head;
            
            while(cur!=null){
                
                ListNode forw=cur.next;
                cur.next=prev;
                prev=cur;
                cur=forw;
                
            }
            
            return prev;
    }

    public static void main(String[] args){
        
    }
}