public class segregate_01_node_of_linkedList_over_swapping_nodes{

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    //Same as segregate even-odd
    public static ListNode segregate01(ListNode head) {
         
         ListNode d1=new ListNode(-1);
         ListNode d2=new ListNode(-1);
         
         ListNode p=d1,q=d2;
         
         ListNode itr=head;
         
         while(itr!=null){
             
             int val=itr.val;
             
             if(val%2==0){
                 d1.next=itr;
                 d1=itr;
             }
             
             else{
                 d2.next=itr;
                 d2=itr;
             }
             
             itr=itr.next;
         }
         
         p=p.next;
         q=q.next;
         
         d1.next=null;
         d2.next=null;
         
         if(d1!=null){
             d1.next=q;
         }
         
         if(p!=null){
             return p;
         }
         
         else{
             return q;
         }
         
     }

    public static void main(String[] args){

    }
}