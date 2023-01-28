package tree;

public class SizeOfBinaryTree {
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

        System.out.println(getMaxValue(root));
    }

    public static int getSizeOfBinaryTree(Node node) {
        if (node == null) return 0;
        return getSizeOfBinaryTree(node.getLeft()) + getSizeOfBinaryTree(node.getRight()) + 1;
    }

    public static int getMaxValue(Node node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }

        return Math.max(
                    Math.max(getMaxValue(node.getLeft()), getMaxValue(node.getRight())),
                    node.getData()
               );
    }
}
