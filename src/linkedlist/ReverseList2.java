package linkedlist;

import java.util.Stack;

public class ReverseList2 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode listNode = new Solution().reverseList(head);

        while (listNode != null) {
            System.out.print(listNode.val + " -> ");
            listNode = listNode.next;
        }
    }


}

class Solution {

    //    1 -> 2 -> 3 -> 4 -> 5

    // we will got till (n - 1)th node i.e. 4
    // then we will call head.next.next = head means 4.5.next = head, currently head is pointing to 4
    // then head.next = null means 4.next = null to avoid cycle in the list


    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // This will be the new head it will be returned
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public ListNode reverseListUsingStack(ListNode head) {
        Stack<ListNode> stack = new Stack<>();

        ListNode curr = head;
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }

        ListNode newHead = stack.pop();
        newHead.next = null;

        curr = newHead;

        while (!stack.isEmpty()) {
            curr.next = stack.pop();
            curr = curr.next;
        }

        return newHead;
    }
}

class Solution_ReverseList2_Iterative {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null, curr = head, next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}