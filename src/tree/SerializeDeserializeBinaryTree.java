package tree;

public class SerializeDeserializeBinaryTree {
    public static void main(String[] args) {
        int  pos= 0;

    }
}

 class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "#";
        return root.val + " " + serialize(root.left) + " " + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return deserialize(data.split(" "), new int[1]);
    }

    public TreeNode deserialize(String[] data, int[] pos) {
        pos[0] += 1;
        if ("#".equals(data[pos[0]])) return null;

        TreeNode root = new TreeNode(Integer.valueOf(data[pos[0]]));
        root.left = deserialize(data, pos);
        root.right = deserialize(data, pos);

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
