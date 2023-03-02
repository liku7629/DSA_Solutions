package linkedlist;

// https://leetcode.com/problems/middle-of-the-linked-list/description/
public class MiddleoftheLinkedList {

}


// Count total nodes and divide by two and iterate
class MiddleoftheLinkedList_BruteF_Solution {
    public ListNode middleNode(ListNode head) {
        int nodeCount = 0;
        ListNode curr = head;

        while (curr != null) {
            nodeCount++;
            curr = curr.next;
        }

        int midIndex = nodeCount / 2;

        curr = head;

        while (midIndex > 0) {
            midIndex--;
            curr = curr.next;
        }

        return curr;
    }
}

class MiddleoftheLinkedList_BruteForce_Solution {
    public ListNode middleNode(ListNode head) {
        int nodeCount = 0;
        ListNode curr = head;

        while (curr != null) {
            nodeCount++;
            curr = curr.next;
        }

        int midIndex = nodeCount / 2;

        curr = head;

        while (midIndex > 0) {
            midIndex--;
            curr = curr.next;
        }

        return curr;
    }
}

// Use slow fast pointers and once fast reaches null
// return slow
class MiddleoftheLinkedList_Opt_Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}