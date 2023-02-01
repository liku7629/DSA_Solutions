package linkedlist;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/linked-list-cycle/
public class LinkedListCycle {

}

class LinkedListCycle_Solution {
    public boolean hasCycle(ListNode head) {
        Set<Integer> set = new HashSet<>();

        while (head != null) {
            if (!set.add(System.identityHashCode(head))) {
                return true;
            }
            head = head.next;
        }

        return false;
    }
}

class LinkedListCycle_Constant_Space_Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;
        boolean firstNode = false;

        while (fast != null && fast.next != null && slow != null) {
            if (firstNode && fast == slow) {
                return true;
            }

            firstNode = true;

            fast = fast.next.next;
            slow = slow.next;
        }

        return false;
    }
}