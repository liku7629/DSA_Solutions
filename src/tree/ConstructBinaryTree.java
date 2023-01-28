package tree;

import java.util.Arrays;
import java.util.HashMap;

public class ConstructBinaryTree {

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        TreeNode treeNode = new ConstructBinaryTree().buildTree(preorder, inorder);

        System.out.println();
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length < 1) {
            return new TreeNode();
        }

        HashMap<Integer, Integer> inMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }


        TreeNode root = constructTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);

        return root;
    }

    public TreeNode constructTree(int[] preOrder, int preStart, int preEnd,
                              int[] inOrder, int inStart, int inEnd,
                              HashMap<Integer, Integer> inMap) {

        if (preStart > preEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preOrder[preStart]);

        Integer inRoot = inMap.get(preOrder[preStart]);
        int numsLeft = inRoot - inStart;

        root.left = constructTree(preOrder, preStart + 1, preStart + numsLeft, inOrder, inStart, inRoot - 1, inMap);
        root.right = constructTree(preOrder, preStart + numsLeft + 1, preEnd, inOrder, inRoot + 1, inEnd, inMap);

        return root;
    }
}
