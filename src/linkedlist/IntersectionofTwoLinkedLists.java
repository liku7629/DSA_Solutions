package linkedlist;

import java.util.HashSet;

//https://leetcode.com/problems/intersection-of-two-linked-lists
public class IntersectionofTwoLinkedLists {

}

// Simple solution add list1 all nodes to hashset
// then add nodes of list2 nodes while check for duplicate
// if duplicate found return it

// Note: its a simple soultion with extra space
// O(1) Solution https://leetcode.com/problems/intersection-of-two-linked-lists/solutions/1089148/intersection-of-two-linked-lists/
class IntersectionofTwoLinkedLists_Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();

        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (!set.add(headB)) {
                return headB;
            }

            headB = headB.next;
        }

        return null;
    }
}
