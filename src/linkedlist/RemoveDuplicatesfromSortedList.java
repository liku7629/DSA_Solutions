package linkedlist;

// https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
public class RemoveDuplicatesfromSortedList {

}

// Time Complexity: O(n)
// Space Complexity: O(1)

class RemoveDuplicatesfromSortedList_Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;

        while (curr != null) {
            if (curr.next != null && curr.next.val == curr.val) {
                curr.next = curr.next.next;
                continue;
            }
            curr = curr.next;
        }

        return head;
    }
}
