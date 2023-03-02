package linkedlist;

// https://leetcode.com/problems/remove-linked-list-elements/description/
public class RemoveLinkedListElements {

}



class RemoveLinkedListElements_Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode curr = head, prev = dummy;

        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
                curr = curr.next;
                continue;
            }

            prev = curr;
            curr = curr.next;
        }

        return dummy.next;
    }
}