package tree;

import java.util.LinkedList;
import java.util.Queue;

public class IsChildrenSum {

    static TreeNode prev;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(5);
        root.left = new TreeNode(2);

        root.right.right = new TreeNode(6);
//        root.right.left = new TreeNode(5);

        root.left.right = new TreeNode(4);
        root.left.left = new TreeNode(3);

//        System.out.println(maxWidthOfBinaryTree(root));
//        flatten(root);
        System.out.println();
    }

    public static boolean isSum(TreeNode root) {
        if (root == null) return true;

        if (root.left == null && root.right == null) return true;

        int sum = 0;

        if (root.right != null)
            sum += root.right.val;

        if (root.left != null) {
            sum += root.left.val;
        }

        return root.val == sum &&
                isSum(root.left) &&
                isSum(root.right);
    }

//    public static boolean isSumIterative(Node root) {
//
//    }

    public static int checkBalancedTree(TreeNode root) {
        if (root == null) return 0;

        int lth = checkBalancedTree(root.left);

        if (lth == -1) {
            return -1;
        }

        int rth = checkBalancedTree(root.right);

        if (rth == -1 ) {
            return -1;
        }

        int diff = Math.abs(lth - rth);

        if (diff > 1) {
            return -1;
        }

        return Math.max(lth, rth) + 1;
    }

    public static int maxWidthOfBinaryTree(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int maxWidth = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();
            maxWidth = Math.max(maxWidth, size);

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node == null || (node.right == null && node.left == null))
                    continue;

                queue.add(node.left);
                queue.add(node.right);
            }
        }

        return maxWidth;
    }

    public static void flatten(TreeNode root) {
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
