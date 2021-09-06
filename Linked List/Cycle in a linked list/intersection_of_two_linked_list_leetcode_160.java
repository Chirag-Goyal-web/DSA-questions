public class intersection_of_two_linked_list_leetcode_160{

    class ListNode {
        int val;
        ListNode next;
        
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //Difference in length method
    class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            
            if(headA==null || headB==null){
                return null;
            }
            
            else{
                int len1=findLen(headA);
                int len2=findLen(headB);
                
                int diff=Math.abs(len1-len2);
                
                if(len1>len2){
                    while(diff-->0){
                        headA=headA.next;
                    }
                }
                else{
                    while(diff-->0){
                        headB=headB.next;
                    }
                }
                
                while(headA!=null){
                    if(headA==headB){
                        return headA;
                    }
                    
                    headA=headA.next;
                    headB=headB.next;
                }
                
                return headA;
            }
        }
        
        public int findLen(ListNode node){
            int len=0;
            
            while(node!=null){
                len++;
                node=node.next;
            }
            
            return len;
        }
    }

    //Floyd cycle finding algorithm
    class Solution_{
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
             if(headA==null || headB==null)
                return null;
            
            else{
                ListNode ptr=headA;
            ListNode a=null;
                while(ptr.next!=null){
                    ptr=ptr.next;
                }
                
                ptr.next=headB;
                ListNode ans=detectCycle(headA);
                ptr.next=null;
                return ans;
            }
        
        }
        
        public ListNode detectCycle(ListNode head) {
            
            ListNode mid=intersection(head);
            
            if(mid==null || mid.next==null)
                return null;
            
            else{
                ListNode ptr=head;
                while(mid!=ptr){
                    mid=mid.next;
                    ptr=ptr.next;
                }
                
                return ptr;
            }
            
        }
        
        public ListNode intersection(ListNode head){
            
            ListNode fast=head,slow=head;
            
            while(fast!=null && fast.next!=null){
                fast=fast.next.next;
                slow=slow.next;
                
                if(fast==slow)
                    return fast;
            }
            
            return fast;
        }
        
    }

}