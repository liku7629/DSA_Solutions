package linkedlist;

public class Remove_Duplicates_From_SortedList_II {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);

        head.next = new ListNode(1);
        head.next.next = new ListNode(1);

        Remove_Duplicates_From_SortedList_II_Solution.deleteDuplicates(head);
    }
}
// https://www.youtube.com/watch?v=R6-PnHODewY
class Remove_Duplicates_From_SortedList_II_Solution_Optimal_Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode curr = head, prev = dummy;

        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                while (curr.next != null && curr.val == curr.next.val) {
                    curr = curr.next;
                }
                prev.next = curr.next;
            } else {
                prev = prev.next;
            }

            curr = curr.next;
        }

        return dummy.next;
    }
}


class Remove_Duplicates_From_SortedList_II_Solution {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode prev = new ListNode(-1);
        ListNode dummy = prev;
        dummy.next = head;
        ListNode curr = head;

        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                while (curr.next != null && curr.val == curr.next.val) {
                    curr = curr.next;
                }
                dummy.next = curr.next;
            } else {
                dummy = dummy.next;
            }
            curr = curr.next;
        }

        return prev.next;
    }
}
