public class linked_list_random_node_leetcode_382{
    
    class Solution {
        private ListNode head;
        
        public static class ListNode {
            int val = 0;
            ListNode next = null;
    
            ListNode(int val) {
                this.val = val;
            }
        }
        
        public Solution(ListNode head) {
            this.head = head;
        }
    
        public int getRandom() {
            int scope = 1, chosenValue = 0;
            ListNode curr = this.head;
            while (curr != null) {
           
                if (Math.random() < 1.0 / scope)
                    chosenValue = curr.val;

                scope += 1;
                curr = curr.next;
            }
            return chosenValue;
        }
    }
}