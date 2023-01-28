package tree;

import java.sql.Array;
import java.util.*;

public class TreeTraversal {
    public static void main(String[] args) {


        Node node40 = new Node(40);
        Node node70 = new Node(70);
        Node node80 = new Node(80);

        Node node50 = new Node(50);
        node50.setLeft(node70);
        node50.setRight(node80);

        Node node20 = new Node(20, node40, node50);


        Node node100 = new Node(100);

        Node node90 = new Node(90);
        node90.setRight(node100);

        Node node60 = new Node(60);
        node60.setRight(node90);

        Node node30 = new Node(30);
        node30.setRight(node60);



        Node root = new Node(10);
        root.setRight(node30);
        root.setLeft(node20);

        levelOrderTraversal(root);
    }

    public static void iterativeInOrder(Node root) {
        Node curr = root;

        Stack<Node> nodes = new Stack<>();

        while (curr != null || !nodes.isEmpty()) {
            while (curr != null) {
                nodes.push(curr);
                curr = curr.getLeft();
            }

            curr = nodes.pop();
            System.out.println(curr.getData() + "  ");
            curr = curr.getRight();
        }
    }

    public static void iterativePreOrder(Node root) {
        Node curr = root;

        Stack<Node> nodes = new Stack<>();

        while (curr != null || !nodes.isEmpty()) {
            while (curr != null) {
                System.out.println(curr.getData() + "  ");
                nodes.push(curr);
                curr = curr.getLeft();
            }

            curr = nodes.pop();
            curr = curr.getRight();
        }
    }

    public static void traverseTreeInOrder(Node node) {
        if (node == null)
            return;

        traverseTreeInOrder(node.getLeft());
        System.out.print(node.getData() + "  ");
        traverseTreeInOrder(node.getRight());
    }


    public static void traverseTreePreOrder(Node node) {
        if (node == null)
            return;

        System.out.print(node.getData() + "  ");

        traverseTreePreOrder(node.getLeft());
        traverseTreePreOrder(node.getRight());
    }


    public static void traverseTreePostOrder(Node node) {
        if (node == null)
            return;

        traverseTreePostOrder(node.getLeft());
        traverseTreePostOrder(node.getRight());
        System.out.print(node.getData() + "  ");
    }

    public static int findHeightOfBinaryTree(Node node) {
        if (node == null)
            return 0;

        return Math.max(findHeightOfBinaryTree(node.getLeft()), findHeightOfBinaryTree(node.getRight())) + 1;
    }

    public static void printKthNode(Node node, int currentlevel, int level) {
        if (node == null) {
            return;
        }

        printKthNode(node.getLeft(), ++currentlevel, level);
        printKthNode(node.getRight(), ++currentlevel, level);

        if (currentlevel == level) {
            System.out.print(node.getData() + "  ");
        }
    }

    public static void levelOrderTraversal(Node node) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();

            System.out.println(tempNode.getData());

            if (tempNode.getLeft() != null) {
                queue.add(tempNode.getLeft());
            }

            if (tempNode.getRight() != null) {
                queue.add(tempNode.getRight());
            }
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> pCommons = findAllCommonAnc(root, p, new ArrayList<TreeNode>());
        return null;
    }

    public ArrayList<TreeNode> findAllCommonAnc(TreeNode root, TreeNode n, ArrayList<TreeNode> list) {
        if (root == null) return list;

        findAllCommonAnc(root.left, n, list);
        findAllCommonAnc(root.right, n , list);

        if (root.val == n.val || list.size() > 1) {
            list.add(root);
        }

        return list;
    }
}
