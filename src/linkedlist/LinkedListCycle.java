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

//https://leetcode.com/problems/linked-list-cycle/solutions/127823/linked-list-cycle/
class LinkedListCycle_Constant_Space_Solution {
    public class Solution {
        public boolean hasCycle(ListNode head) {
            ListNode fast = head, slow = head;

            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;

                if (fast == slow) {
                    return true;
                }
            }

            return false;
        }
    }
}
