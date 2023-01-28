package tree;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class LowestCommonAncestor {
    public static void main(String[] args) {


        TreeNode node40 = new TreeNode(40);
        TreeNode node70 = new TreeNode(70);
        TreeNode node80 = new TreeNode(80);

        TreeNode node50 = new TreeNode(50);
        node50.setLeft(node70);
        node50.setRight(node80);

        TreeNode node20 = new TreeNode(20, node40, node50);


        TreeNode node100 = new TreeNode(100);

        TreeNode node90 = new TreeNode(90);
        node90.setRight(node100);

        TreeNode node60 = new TreeNode(60);
        node60.setRight(node90);

        TreeNode node30 = new TreeNode(30);
        node30.setRight(node60);



        TreeNode root = new TreeNode(10);
        root.setRight(node30);
        root.setLeft(node20);

//        new LowestCommonAncestor().lowestCommonAncestor(root, new TreeNode(40), new TreeNode(50));
        List<List<Integer>> lists = new LowestCommonAncestor().levelOrder(root);
        System.out.println(lists);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> pCommons = findAllCommonAnc(root, p, new ArrayList<TreeNode>());
        return null;
    }

    public ArrayList<TreeNode> findAllCommonAnc(TreeNode root, TreeNode n, ArrayList<TreeNode> list) {
        if (root == null) return list;

        findAllCommonAnc(root.left, n, list);
        findAllCommonAnc(root.right, n , list);

        if (root.val == n.val || list.size() > 0) {
            list.add(root);
        }



        return list;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return null;

        List<List<Integer>> levels = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        queue.add(null);

        List<Integer> curr = new ArrayList<>();
        levels.add(curr);

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();

            if (temp == null) {
                if (queue.size() > 0) {
                    curr = new ArrayList<>();
                    levels.add(curr);
                    queue.add(null);
                }
                continue;
            }

            curr.add(temp.val);

            if (temp.left != null) queue.add(temp.left);
            if (temp.right != null) queue.add(temp.right);
        }

        return levels;
    }
}
