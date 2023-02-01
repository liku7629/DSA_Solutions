package linkedlist;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/palindrome-linked-list/description/
public class PalindromeLinkedList {

}

// Copy linked list to array and use two pointer algorithm to check for palindrome
// User one pointer at start of arraylist and one at end
 class PalindromeLinkedList_Solution {
     public boolean isPalindrome(ListNode head) {
         List<Integer> list = new ArrayList<>();

         while (head != null) {
             list.add(head.val);
             head = head.next;
         }

         int start = 0, end = list.size() - 1;

         while (start < end) {
             if (!list.get(start).equals(list.get(end))) {
                 return false;
             }

             start++;
             end--;
         }

         return true;
     }
 }

//Reverse second half of the linked list and compare using two pointers
// 1 -> 2 -> 3 ->  4 -> 5
// Reverse First Half  1 ->  2 -> 3 5 -> 4
class PalindromeLinkedList_Space_Optimized_Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        ListNode p1 = head, p2 = secondHalfStart;

        while (p2 != null) {
            if (p1.val != p2.val) {
                return false;
            }

            p1 = p1.next;
            p2 = p2.next;
        }

        return true;
    }

    public ListNode endOfFirstHalf(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public ListNode reverseList(ListNode head) {
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
