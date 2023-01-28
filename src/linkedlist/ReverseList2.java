package linkedlist;

public class ReverseList2 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
//        new Solution().reverseList(head);

        Integer integer = new Integer(5);
        Integer integer2 = new Integer(5);
        System.out.println(integer.hashCode());
        System.out.println(System.identityHashCode(integer));
        System.out.println(System.identityHashCode(integer2));
    }


}

class Solution {

    //    1 -> 2 -> 3 -> 4 -> 5

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
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