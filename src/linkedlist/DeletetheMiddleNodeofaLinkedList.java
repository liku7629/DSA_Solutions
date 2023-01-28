package linkedlist;

// https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/
public class DeletetheMiddleNodeofaLinkedList {

}

class DeletetheMiddleNodeofaLinkedList_Solution {
    public ListNode deleteMiddle(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        int totalNodeCount = 0;

        ListNode curr = head;

        while (curr != null) {
            curr = curr.next;
            totalNodeCount++;
        }

        System.out.println("total: " + totalNodeCount);

        int middleNodeInd = (totalNodeCount / 2) - 1;

        System.out.println("middle: " + middleNodeInd);

        curr = head;

        while (middleNodeInd != 0) {
            curr = curr.next;
            middleNodeInd--;
        }

        curr.next = curr.next.next;

        return head;
    }
}
