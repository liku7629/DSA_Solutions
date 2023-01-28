package linkedlist;

//https://leetcode.com/problems/middle-of-the-linked-list/
//https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/submissions/
public class MiddleNodeLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(6);
//        head.next.next.next.next.next.next = new ListNode(7);

        ListNode listNode = deleteMiddleNodeTwoPointers(head);
        printList(listNode);
    }

    //https://leetcode.com/problems/middle-of-the-linked-list/
    //First find the total no of elements and then divide it by 2 to find the middle node
    //then traverse to middle node and print
    public static ListNode printMiddleNodeIterative(ListNode head) {

        int totalNodeCount = 0;

        ListNode curr = head;

        while (curr != null) {
            curr = curr.next;
            totalNodeCount++;
        }

        System.out.println("total: " + totalNodeCount);

        int middleNode = (totalNodeCount / 2);

        System.out.println("middle: " + middleNode);

        curr = head;

        while (middleNode != 0) {
            curr = curr.next;
            middleNode--;
        }

        System.out.println("Middle Node: " + curr);

        return curr;
    }

    //https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
    //First find the total no of elements and then (divide it by 2 - 1) to find the middle node
    // - 1 to find the node previous to middle node so that we can do node.next = node.next.next
    // to delete it
    public static ListNode deleteMiddleNodeIterative(ListNode head) {
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

    public static ListNode printMiddleNodeTwoPointers(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slowPt = head;
        ListNode fastPt = head;

        while (slowPt != null && fastPt != null && fastPt.next != null) {
            slowPt = slowPt.next;
            fastPt = fastPt.next.next;
        }

        System.out.println("middle node: " + slowPt.val);

        return head;
    }

    public static ListNode deleteMiddleNodeTwoPointers(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slowPt = head;
        ListNode fastPt = head.next.next;

        while (slowPt != null && fastPt != null && fastPt.next != null) {
            slowPt = slowPt.next;
            fastPt = fastPt.next.next;
        }

        System.out.println("middle node: " + slowPt.val);

        slowPt.next = slowPt.next.next;

        return head;
    }

    public static void printList(ListNode head) {
        if (head == null) return;

        ListNode curr = head;

        while (curr != null) {
            System.out.println("Node: " + curr.val);
            curr = curr.next;
        }
    }


}
