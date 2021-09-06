public class all_variables_in_Cycle{

    class ListNode {
        int val;
        ListNode next;
        
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void allVariablesOfCycle(ListNode head) {
        ListNode meetingPoint = isCyclePresentInLL(head);
        if (meetingPoint == null || meetingPoint.next == null)
            return;

        ListNode slow = head, fast = meetingPoint, intersectionPoint = null;
        ;
        int A = 0, mDash = 0;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;

            if (fast == meetingPoint)
                mDash++;
            A++;
        }

        intersectionPoint = slow;
        slow = meetingPoint;
        slow = slow.next;
        int cycleLen = 1;
        while (slow != meetingPoint) {
            slow = slow.next;
            cycleLen++;
        }

        int B = 0, C = 0, m = 0;
        if (A != 0 && mDash == 0 && meetingPoint == intersectionPoint) {
            B = cycleLen;
        } else {
            C = A - mDash * cycleLen;
            B = cycleLen - C;
            m = mDash + 1; // resolved. conclusion : A >= C
        }
    }

    
    public static ListNode isCyclePresentInLL(ListNode head) {
        if (head == null && head.next == null)
            return null;

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast)
                break;
        }

        return fast;
    }

    
}