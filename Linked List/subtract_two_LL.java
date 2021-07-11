public class subtract_two_LL{

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode subtractTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode bigger=null;
        ListNode smaller=null;
        
        int len1=length(l1);
        int len2=length(l2);
        
        if(len1>len2){
            bigger=l1;
            smaller=l2;
        }
        
        else if(len2>len1){
            bigger=l2;
            smaller=l1;
        }
        
        else{
            
            int d=decideBig(l1,l2);
            
            if(d==1){
                bigger=l1;
                smaller=l2;
            }
            
            else{
                bigger=l2;
                smaller=l1;
            }
            
        }
        
        bigger=reverse(bigger);
        smaller=reverse(smaller);
        
        ListNode dummy=new ListNode(-1);
        ListNode p=dummy;
        int sub=0,temp=0;
        
        while(bigger!=null){
            
            int val=bigger.val+sub;
            
            if(smaller!=null){
                
                if(val>=smaller.val){
                    temp=val-smaller.val;
                    sub=0;
                }
                
                else{
                    temp=val+10-smaller.val;
                    sub=-1;
                }
                smaller=smaller.next;
            }
            
            else{
                
                temp=val;
                sub=0;
            }
            
            ListNode nw=new ListNode(temp);
            dummy.next=nw;
            dummy=nw;
            
        }
        
        p=reverse(p.next);
        
        while(p!=null && p.val==0){
            p=p.next;
        }
        
        return p;
        
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
    
    public static int length(ListNode head){
        
        int count=0;
        
        while(head!=null){
            head=head.next;
        }
        
        return count;
    }
    
    public static int decideBig(ListNode head1,ListNode head2){
        
        while(head1!=null){
            
            if(head1.val>head2.val){
                return 1;
            }
            
            else if(head2.val>head1.val){
                return 2;
            }
            
            head1=head1.next;
            head2=head2.next;
                
        }
        return 1;
    }
    public static void main(String[] args){
        
    }
}