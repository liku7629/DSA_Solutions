package binarytree;

import tree.TreeNode;

public class FloorInABst {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(40);
        root.left = new TreeNode(20);
        root.right = new TreeNode(60);

        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(30);

        root.right.left = new TreeNode(50);
        root.right.right = new TreeNode(70);

        System.out.println(new BinarySearchTree().insertIntoBST(root, 25));
    }
}
