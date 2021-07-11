class merge_k_linkedList{

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    //1st approach- Merge Lists one by one
    public static ListNode mergeKSortedLists_1(ListNode[] lists) {

        ListNode res=null;
        ListNode cur=null;

        for(int i=0;i<lists.length;i++){
            cur=lists[i];
            res=mergeTwoLists(cur,res);
        }
        return res;
    }

    //2nd approach- Connect all the lists and then apply mergeSort

    public static ListNode mergeKSortedLists_2(ListNode[] lists){

        ListNode dummy=new ListNode(-1);
        ListNode p=dummy;
        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null){
                ListNode cur=lists[i];
                ListNode last=getLast(cur);
                dummy.next=cur;
                dummy=last;
            }
        }

        return mergeSort(p.next);

    }

    //3rd approach- Apply mergeSort on array

    public static ListNode mergeKSortedList_3(ListNode[] lists,int start,int end){
        
        if(start>end){
            return null;
        }

        else if(start==end){
            return lists[start];
        }

        else{
            int mid=(start+end)/2;
            return mergeTwoLists(mergeKSortedList_3(lists,start,mid),mergeKSortedList_3(lists,mid+1,end));
        }

    }

    public static ListNode getLast(ListNode head){
        while(head!=null && head.next!=null){
            head=head.next;
        }
        return head;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        ListNode ans=new ListNode(10);
        ListNode temp=ans;
        while(l1!=null && l2!=null){
            
            if(l1.val<l2.val){
                ans.next=l1;
                ans=l1;
                l1=l1.next;
            }else{
                ans.next=l2;
                ans=l2;
                l2=l2.next;
            }
            
        }
        
        if(l1!=null){
            ans.next=l1;
        }else{
            ans.next=l2;
        }
        
        return temp.next;
    }

    public static ListNode mergeSort(ListNode head) {
        if(head==null||head.next==null){
           return head;
       }
       
       else{
           
           ListNode mid=middleNode(head);
           
           ListNode nhead=mid.next;
           
           mid.next=null;
           
           return mergeTwoLists(mergeSort(head),mergeSort(nhead));
           
       }
       
   }

   public static ListNode middleNode(ListNode head) {
       
       if(head==null||head.next==null){
           return head;
       }
       
       else{
           
           ListNode slow=head;
           ListNode fast=head;
           
           while(fast.next!=null && fast.next.next!=null){
               slow=slow.next;
               fast=fast.next.next;
           }
           return slow;
       }
       
   }


   public static void main(String[] args){
        
    }

}