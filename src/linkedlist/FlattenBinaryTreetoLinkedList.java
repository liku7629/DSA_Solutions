package linkedlist;

import tree.TreeNode;

//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
public class FlattenBinaryTreetoLinkedList {

}


class FlattenBinaryTreetoLinkedList_Solution {

    TreeNode prev;

    public void flatten(TreeNode root) {
        if (root == null) return;

        TreeNode right = root.right;

        if (prev == null) {
            prev = root;
        } else {
            prev.right = root;
            prev = prev.right;
        }

        flatten(root.left);
        root.left = null;
        flatten(right);
    }
}
