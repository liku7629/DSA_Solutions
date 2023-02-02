package linkedlist;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(2);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(3);

        ListNode head2 = new ListNode(5);
        head2.next = new ListNode(6);
        head2.next.next = new ListNode(4);

        ListNode listNode = new AddTwoNumbers_Solution().addTwoNumbers(head1, head2);

    }
}


//https://leetcode.com/problems/add-two-numbers/solutions/127833/add-two-numbers/
class AddTwoNumbers_Solution {
    // Add Two Numbers (Java improved)
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        return dummyHead.next;
    }
}
