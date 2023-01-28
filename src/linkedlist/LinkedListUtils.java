package linkedlist;

public class LinkedListUtils {
    public static void printList(ListNode list) {
        while (list != null) {
            System.out.print(list.val + " -> ");
            list = list.next;
        }
    }
}
