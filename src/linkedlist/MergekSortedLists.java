package linkedlist;

import java.util.*;

// https://leetcode.com/problems/merge-k-sorted-lists
public class MergekSortedLists {

}

 class MergekSortedLists_BrutForce_Solution {
     public ListNode mergeKLists(ListNode[] lists) {
         List<Integer> list = new ArrayList();

         for (int i = 0; i < lists.length; i++) {
             ListNode curr = lists[i];
             while (curr != null) {
                 list.add(curr.val);
                 curr = curr.next;
             }
         }

         Collections.sort(list);

         ListNode head = new ListNode(0);
         ListNode curr = head;

         for (int i = 0; i < list.size(); i++) {
             curr.next = new ListNode(list.get(i));
             curr = curr.next;
         }

         return head.next;
     }
 }



class MergekSortedLists_Optimal_Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;

        PriorityQueue<ListNode> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode node : lists) {
            if (node != null) heap.add(node);
        }

        ListNode head = new ListNode(0);
        ListNode current = head;

        while (!heap.isEmpty()) {
            ListNode next = heap.poll();
            current.next = next;
            if (next.next != null) heap.add(next.next);
            current = current.next;
        }

        return head.next;
    }
}
