package tree;

public class RangeSumBst {

    int sum;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(40);
        root.left = new TreeNode(20);
        root.right = new TreeNode(60);

        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(30);

        root.right.left = new TreeNode(50);
        root.right.right = new TreeNode(70);

//        root.right.left.right = new TreeNode(80);
//        root.right.left.left = new TreeNode(90);
//
//        root.right.right.left = new TreeNode(100);
//        root.right.right.right = new TreeNode(110);

        System.out.println(new RangeSumBst().rangeSumBST(root, 20, 40));
//        int sum = 40;
//        sum += 10;
//
//        System.out.println(sum);
    }

//    public int rangeSumBST(TreeNode root, int low, int high) {
//        if (root == null) return 0;
//
//        if (root.val <= high && root.val >= low) {
//            sum += root.val;
//        }
//
//        rangeSumBST(root.right, low, high);
//        rangeSumBST(root.left, low, high);
//
//        return sum;
//    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;

        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        } else if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }

        return rangeSumBST(root.left, low, high) +
                rangeSumBST(root.right, low, high) +
                root.val;
    }

    public TreeNode invertBinaryTree(TreeNode root) {
        if (root == null) return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertBinaryTree(root.left);
        invertBinaryTree(root.right);

        return root;
    }
}
