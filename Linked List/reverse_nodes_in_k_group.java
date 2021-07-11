public class reverse_nodes_in_k_group{

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    //Approach-1 (Naive approach)
    public static ListNode reverseKGroup_1(ListNode head, int k) {
        
        ListNode dummy=new ListNode(-1);
        ListNode ans=dummy;
        int count=0;
        
        ListNode temp=head;
        ListNode extra=null;
        
        while(head!=null){
            
            count++;
            
            if(count==k){
                extra=head.next;
                head.next=null;
                temp=reverse(temp);
                dummy.next=temp;
                dummy=get_last(temp);
                temp=extra;
                head=extra;
                count=0;
            }
            
            else{
                head=head.next;
            }
            
        }
        
        if(extra!=null){
            dummy.next=extra;
        }
        
        return ans.next;
    }
    
    public static ListNode reverse(ListNode head) {
        
        if(head==null || head.next==null){
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
    
    public static ListNode get_last(ListNode k){
        
        while(k!=null && k.next!=null){
            k=k.next;
        }
        return k;
    }

    //Apporach-2 (Add first to reverse)

    static ListNode temp_head=null;
    static ListNode temp_tail=null;

    public static void add_first(ListNode node){
        
        if(temp_head==null && temp_tail==null){
            temp_head=node;
            temp_tail=node;
        }

        else{
            node.next=temp_head;
            temp_head=node;
        }
    }

    public static ListNode reverseKGroup_2(ListNode head,int k){
        
        int length=length(head);
        ListNode main_head=null,main_tail=null;
        
        while(length>=k){

            int tempK=k;
            
            while(tempK>0){
                ListNode n=head;
                head=head.next;
                add_first(n);
                k--;
            }

            if(main_head==null){
                main_head=temp_head;
                main_tail=temp_tail;
            }

            else{
                main_tail.next=temp_head;
                main_tail=temp_tail;
            }

            temp_head=null;
            temp_tail=null;        

            length-=k;
        }

        main_tail.next=head;

        return main_head;
    }


    public static int length(ListNode head){
       
        int count=0;
        
        while(head!=null){
            count++;
            head=head.next;
        }

        return count;
    }
    public static void main(String[] args){
        
    }

}