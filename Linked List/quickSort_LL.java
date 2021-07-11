public class quickSort_LL{

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static int getLength(ListNode head){
        
        int count=0;

        while(head!=null){
            count++;
            head=head.next;
        }

        return count;
    }

    public static ListNode[] mergeLists(ListNode[] left,ListNode pivotNode,ListNode[] right){

        if(left[1]!=null){

            left[1].next=pivotNode;
            pivotNode.next=right[0];

            if(right[1]==null){
                return new ListNode[]{left[0],pivotNode};
            }

            else{
                return new ListNode[]{left[0],right[1]};
            }
        
        }

        else{

            pivotNode.next=right[0];

            if(right[1]==null){
                return new ListNode[]{pivotNode,pivotNode};
            }

            else{
                return new ListNode[]{pivotNode,right[1]};
            }

        }

    }
    
    public static ListNode[] segregate(ListNode head, int idx) {
        if (head == null || head.next == null)
          return new ListNode[]{head,head};
    
        int i = 0, data = 0;
        ListNode curr = head;
        while (curr != null) {
          if (i == idx)
            data = curr.val;
    
          i++;
          curr = curr.next;
        }
    
        ListNode smaller = new ListNode(-1);
        ListNode sp = smaller;
    
        ListNode greater = new ListNode(-1);
        ListNode gp = greater;
    
        i = 0;
        curr = head;
        ListNode pivot = null;
        while (curr != null) {
          if (i == idx) {
            pivot = curr;
          } else if (curr.val <= data) {
            sp.next = curr;
            sp = sp.next;
          } else {
            gp.next = curr;
            gp = gp.next;
          }
    
          curr = curr.next;
          i++;
        }
    
        sp.next = gp.next=pivot.next=null;
        
        // pivot.next = greater.next;
        // gp.next = null;
        // sp = sp.next;

        ListNode leftHead=smaller.next==pivot?null:smaller.next;
        ListNode rightHead=greater.next;

        return new ListNode[]{leftHead,pivot,rightHead};
      }

    public static ListNode[] quickSort_(ListNode head){

        if(head==null||head.next==null){
            return new ListNode[]{head,head};
        }

        else{
            
            int len=getLength(head);
            int pivotIndex=len-1;
            ListNode[] partition=segregate(head,pivotIndex);

            ListNode[] left=quickSort_(partition[0]);
            ListNode[] right=quickSort_(partition[2]);

            return mergeLists(left,partition[1],right);

        }
    }

    public static ListNode quickSort(ListNode head){
        return quickSort_(head)[0];
    }
    public static void main(String[] args){

    }
}