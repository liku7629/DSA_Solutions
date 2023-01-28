package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintLevelOfTree {

    private static int maxLevel = 0;

    public static void main(String[] args) {
        Node node40 = new Node(40);
        Node node50 = new Node(50);

        Node node20 = new Node(20, node40, node50);


        Node node60 = new Node(60);
        Node node70 = new Node(70);
        Node node30 = new Node(30, node60, node70);


        Node root = new Node(10);
        root.setRight(node30);
        root.setLeft(node20);

//        printKthNode(root, 2);
//        levelOrderTraversal(root);

//        List<Integer> list = new ArrayList<>();

//        rightSideView(root, 1, list);

//        System.out.println(list);
        printLevelOrderTraversalIterative(root);
    }

    public static void printKthNode(Node node, int level) {
        if (node == null) {
            return;
        }

        if (level == 0) {
            System.out.print(node.getData() + "  ");
            return;
        }

        printKthNode(node.getLeft(), level - 1);
        printKthNode(node.getRight(), level - 1);
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

    public static void printLeftView(Node node, int currLevel) {
        if (node == null) return;

        if (maxLevel < currLevel) {
            System.out.println(node.getData());
            maxLevel = currLevel;
        }

        printLeftView(node.getLeft(), currLevel + 1);
        printLeftView(node.getRight(), currLevel + 1);
    }

    public static void printRightView(Node node, int currLevel) {
        if (node == null) return;

        if (maxLevel < currLevel) {
            System.out.println(node.getData());
            maxLevel = currLevel;
        }

        printRightView(node.getRight(), currLevel + 1);
        printRightView(node.getLeft(), currLevel + 1);
    }

    public static void findRightSideView(TreeNode node, int currLevel, List<Integer> list) {
        if (node == null) return;

        if (maxLevel < currLevel) {
            list.add(node.val);
            maxLevel = currLevel;
        }

        findRightSideView(node.right, currLevel + 1, list);
        findRightSideView(node.left, currLevel + 1, list);
    }

    public static void printLevelOrderTraversalIterative(Node root) {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node currentNode = queue.poll();

                if (currentNode == null) {
                    System.out.println();
                    continue;
                }

                System.out.print(currentNode.getData() + "  ");

                if (currentNode.getLeft() != null) {
                    queue.add(currentNode.getLeft());
                }

                if (currentNode.getRight() != null) {
                    queue.add(currentNode.getRight());
                }

                if ((currentNode.getLeft() != null || currentNode.getRight() != null) && queue.peek() == null) {
                    queue.add(null);
                }
            }
        }
    }

    public static void printLeftViewIterative(Node root) {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node currNode = queue.poll();
                if (i == 0) {
                    System.out.println(currNode.getData());
                }

                if (currNode.getLeft() != null) {
                    queue.add(currNode.getLeft());
                }

                if (currNode.getRight() != null) {
                    queue.add(currNode.getRight());
                }
            }
        }

    }
}


