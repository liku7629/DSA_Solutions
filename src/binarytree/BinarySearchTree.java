package binarytree;


import sun.reflect.generics.tree.Tree;
import tree.Node;
import tree.TreeNode;

public class BinarySearchTree {

    private TreeNode root;

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(4);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(7);
//
//        root.left.left = new TreeNode(1);
//        root.left.right = new TreeNode(3);

//        System.out.println(new BinarySearchTree().searchBST(root, 4));

        TreeNode root = new TreeNode(40);
        root.left = new TreeNode(20);
        root.right = new TreeNode(60);

        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(30);

        root.right.left = new TreeNode(50);
        root.right.right = new TreeNode(70);

//        System.out.println(new BinarySearchTree().findCeil(root, -9));
//        traverseTreeInOrder(root);
//        new BinarySearchTree().kthSmallest(root, 2);
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;

        if (root.val == val) return root;

        if (val > root.val) {
            return searchBST(root.right, val);
        } else {
            return searchBST(root.left, val);
        }
    }

    public TreeNode searchIterative(TreeNode root, int val) {
        if (root == null) return null;

        while (root != null) {

            if (val == root.val) {
                return root;
            } else if (val > root.val) {
                root = root.right;
            } else {
                root = root.left;
            }
        }

        return null;
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {

        if (root == null) return new TreeNode(val);

        if (val > root.val) {
            root.right = insertIntoBST(root.right, val);
        } else  {
            root.left =  insertIntoBST(root.left, val);
        }

        return root;
    }

    public TreeNode findFloor(TreeNode root, int val) {

        TreeNode floor = null;

        while (root != null) {

            if (val == root.val) {
                return root;
            } else if (val < root.val) {
                root = root.left;
            } else {
                floor = root;
                root = root.right;
            }

        }

        return floor;
    }

    public TreeNode findCeil(TreeNode root, int val) {
        TreeNode ceil = null;

        while (root != null) {
            if (root.val == val) {
                return root;
            } else if (root.val > val) {
                ceil = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return ceil;
    }

    static int n;

    public static void traverseTreeInOrder(TreeNode node) {
        if (node == null)
            return;

        traverseTreeInOrder(node.getLeft());
        System.out.println(node.getVal() + "  " + ++n);
        traverseTreeInOrder(node.getRight());
    }

    int pos;

    public int kthSmallest(TreeNode root, int k) {
        return kthSmallestInternal(root, k).val;
    }

    public TreeNode kthSmallestInternal(TreeNode root, int k) {
        if (root == null) return null;

        TreeNode left = kthSmallestInternal(root.left, k);

        if (left != null) return left;
        pos++;
        if (k == pos) return root;

        return kthSmallestInternal(root.right, k);
    }
}
