package tree;
public class MorrisTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(40);
        root.left = new TreeNode(20);
        root.right = new TreeNode(60);

        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(30);

        root.right.left = new TreeNode(50);
        root.right.right = new TreeNode(70);

        inorder(root);
    }

    public static void inorder(TreeNode root) {
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left == null) {
                System.out.println(curr.val + " ");
                curr = curr.right;
            } else {
                TreeNode predecessor = curr.left;

                while (predecessor.right != null && predecessor.right != curr) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    predecessor.right = curr;
                    curr = curr.left;
                } else {
                    predecessor.right = null;
                    System.out.println(curr.val + " ");
                    curr = curr.right;
                }
            }
        }
    }
}
