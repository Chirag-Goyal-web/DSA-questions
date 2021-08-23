import java.util.HashMap;

public class Remove_Zero_Sum_Consecutive_Nodes_from_Linked_List_leetcode_1171{

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode removeZeroSumSublists(ListNode head) {
        
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        HashMap<Integer,ListNode> hm=new HashMap<>();
        hm.put(0,dummy);
        
        ListNode itr=head;
        int prefixSum=0;
        
        while(itr!=null){
            
            prefixSum+=itr.val;
            
            if(hm.containsKey(prefixSum)){
                ListNode forw=itr.next;
                itr.next=null;
                
                ListNode node=hm.get(prefixSum);
                ListNode temp=node.next;
                node.next=forw;
                
                int tempSum=prefixSum;
                
                while(temp!=itr){
                    tempSum+=temp.val;
                    hm.remove(tempSum);
                    temp=temp.next;
                }
                
                itr=forw;
            }
            
            else{
                hm.put(prefixSum,itr);
                itr=itr.next;            
            }
    
        }
        
        return dummy.next;
    }

}