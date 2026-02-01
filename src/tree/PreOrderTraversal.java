package tree;

import java.util.*;

public class PreOrderTraversal {
    public static void main(String[] args) {

//        Iterative_Pre_Order_Traversal_Using_Stack_Solution.preorderTraversal(TreeNode.getTestTree());
        List<Integer> list = Recursive_PreOrderTraversal_Solution.preorderTraversal(TreeNode.getTestTree());
        System.out.println(list);
    }
}

class Recursive_PreOrderTraversal_Solution {
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorderTraversal(root, list);
        return list;
    }

    public static void preorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        list.add(Integer.valueOf(root.val));
        preorderTraversal(root.left, list);
        preorderTraversal(root.right, list);
    }
}

class Iterative_Pre_Order_Traversal_Using_Stack_Solution {
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            result.add(Integer.valueOf(current.val));
            System.out.println(current.val);

            // Push right first so left is processed first
            if (current.right != null) stack.push(current.right);
            if (current.left != null) stack.push(current.left);
        }

        return result;
    }
}


class Iterative_Pre_Order_Traversal_Using_Deque_Solution {

    /**
     * Performs an iterative preorder traversal (Root, Left, Right) of a binary tree
     * using a Deque (implemented by LinkedList) to simulate stack behavior.
     *
     * @param root The root node of the binary tree.
     * @return A list containing the node values in preorder sequence.
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        // Use LinkedList as a Deque to simulate stack behavior
        // Deque allows adding/removing from both ends
        Deque<TreeNode> deque = new LinkedList<>();

        // Start by adding the root to the front
        deque.addFirst(root);

        while (!deque.isEmpty()) {
            // Remove the node from the front (like stack pop)
            TreeNode currentNode = deque.removeFirst();

            // Process (visit) the current node
            result.add(Integer.valueOf(currentNode.val));

            // Add the right child to the front (if exists)
            // We add right before left, so left is processed first (LIFO simulation)
            if (currentNode.right != null) {
                deque.addFirst(currentNode.right);
            }

            // Add the left child to the front (if exists)
            if (currentNode.left != null) {
                deque.addFirst(currentNode.left);
            }
        }

        return result;
    }
}