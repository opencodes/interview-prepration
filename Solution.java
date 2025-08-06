// Definition for a Linked List node
class ListNode {
    int val;
    ListNode next;

    // Constructor
    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Solution {
    public static int countCycleLength(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            System.out.println("Slow: " + slow.val + ", Fast: " + fast.val);
            if (slow == fast) {
                // Step 2: Calculate cycle length
                return getLength(slow);
            }
        }

        return 0;
    }

    private static int getLength(ListNode nodeInCycle) {
        int length = 1;
        ListNode current = nodeInCycle.next;

        while (current != nodeInCycle) {
            current = current.next;
            length++;
        }

        return length;
    }

    public static void main(String[] args) {
        // 2,4,6,8,10
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = head.next; // Creating a cycle (10 -> 4)

        int cycleLength = countCycleLength(head);
        System.out.println("Cycle Length: " + cycleLength); // Output: Cycle Length: 3
    }
}