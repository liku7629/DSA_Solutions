package linkedlist;

// https://leetcode.com/problems/delete-node-in-a-linked-list/description/
public class DeleteNodeinaLinkedList {

}

// Input 1 -> 2 -> 3 -> 4 -> 5  delete 3
// Copy data of next node to current : 1 -> 2 -> 4 -> 4 -> 5
// point curr_node.next to curr_node.next.next : 1 -> 2 -> 4 -> 5
class DeleteNodeinaLinkedList_Solution {
    public void deleteNode(ListNode node) {
        ListNode nextNode = node.next;

        node.val = nextNode.val;
        node.next = nextNode.next;
    }
}
