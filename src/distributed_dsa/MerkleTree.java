package distributed_dsa;

// Import necessary classes for hashing and list manipulation
import java.security.MessageDigest;       // Used for creating hash digests (like SHA-256)
import java.security.NoSuchAlgorithmException; // Handles cases where the requested algorithm doesn't exist
import java.nio.charset.StandardCharsets; // Defines standard character sets like UTF-8 for converting strings to bytes
import java.util.ArrayList;             // Used for creating dynamic lists
import java.util.List;                  // Interface for list collections

/**
 * Represents a Merkle Tree structure.
 * It calculates the Merkle Root for a given list of data blocks.
 */
public class MerkleTree {

    // --- Fields ---

    // The original list of data blocks (e.g., transactions, file chunks)
    private final List<String> dataBlocks;
    // The calculated Merkle Root hash
    private String root;

    // --- Constructor ---

    /**
     * Constructs a Merkle Tree for the given list of data blocks.
     * Immediately builds the tree and calculates the root upon instantiation.
     *
     * @param dataBlocks A List of Strings representing the data to include in the tree.
     *                   Cannot be null.
     */
    public MerkleTree(List<String> dataBlocks) {
        // 1. Input Validation: Ensure the provided list is not null.
        if (dataBlocks == null) {
            throw new IllegalArgumentException("Data blocks list cannot be null.");
        }
        // 2. Store Data: Assign the input list to the instance variable.
        //    Using new ArrayList<>(...) creates a copy, preventing external modification
        //    of the list from affecting the tree after construction.
        this.dataBlocks = new ArrayList<>(dataBlocks);

        // 3. Build Tree: Immediately call the method to construct the tree
        //    and calculate the Merkle Root.
        buildTree();
    }

    // --- Core Logic: Building the Tree ---

    /**
     * Constructs the Merkle Tree level by level, starting from the leaf nodes
     * (hashes of the initial data blocks) up to the single Merkle Root.
     */
    private void buildTree() {
        // 1. Handle Empty Input: If there are no data blocks, the root is undefined
        //    or could be a hash of an empty string, depending on requirements.
        //    Here, we set it to null and return.
        if (dataBlocks.isEmpty()) {
            this.root = null; // Or potentially hash("")
            return;
        }

        // 2. Create Leaf Nodes: Start with the hashes of the original data blocks.
        //    This list represents the first level (level 0) of the tree.
        List<String> currentLevelHashes = new ArrayList<>();
        for (String block : this.dataBlocks) {
            // Hash each data block using SHA-256 and add it to the list.
            currentLevelHashes.add(applySha256(block));
        }

        // 3. Handle Single Data Block Case: If there's only one data block,
        //    its hash is the Merkle Root.
        if (currentLevelHashes.size() == 1) {
            this.root = currentLevelHashes.get(0);
            return;
        }

        // 4. Build Levels Iteratively: Continue creating new levels until only one hash remains (the root).
        //    The loop continues as long as the current level has more than one hash.
        while (currentLevelHashes.size() > 1) {
            // Create a list to store the hashes for the next level up.
            List<String> nextLevelHashes = new ArrayList<>();

            // Iterate through the current level's hashes in pairs.
            // The loop increments by 2 because we process two hashes at a time.
            for (int i = 0; i < currentLevelHashes.size(); i += 2) {
                // Get the left hash of the pair.
                String leftHash = currentLevelHashes.get(i);
                // Get the right hash of the pair.
                String rightHash;

                // Handle Odd Number of Hashes: If 'i+1' is out of bounds, it means
                // we have an odd number of hashes at this level.
                // In this common approach, we duplicate the last hash to form a pair.
                if (i + 1 >= currentLevelHashes.size()) {
                    rightHash = leftHash; // Duplicate the left hash
                } else {
                    // Otherwise, get the adjacent hash.
                    rightHash = currentLevelHashes.get(i + 1);
                }

                // Combine Hashes: Concatenate the left and right hashes.
                // The order matters (usually left + right).
                String combinedHashData = leftHash + rightHash;

                // Calculate Parent Hash: Hash the combined string to get the parent node's hash.
                String parentHash = applySha256(combinedHashData);

                // Add Parent Hash to Next Level: Add the newly calculated hash to the list
                // representing the next level up in the tree.
                nextLevelHashes.add(parentHash);
            } // End of processing pairs for the current level

            // Move to the Next Level: Update currentLevelHashes to be the newly created
            // nextLevelHashes for the next iteration of the while loop.
            currentLevelHashes = nextLevelHashes;

        } // End of while loop (building levels)

        // 5. Set Root: After the loop, currentLevelHashes will contain exactly one hash,
        //    which is the Merkle Root. Assign it to the instance variable.
        this.root = currentLevelHashes.get(0);
    }

    // --- Hashing Utility ---

    /**
     * Applies the SHA-256 hashing algorithm to an input string.
     *
     * @param input The String to hash.
     * @return The hexadecimal representation of the SHA-256 hash, or null if an error occurs.
     */
    private String applySha256(String input) {
        try {
            // 1. Get Instance: Obtain a MessageDigest object for the SHA-256 algorithm.
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // 2. Convert to Bytes: Convert the input string into a byte array using UTF-8 encoding.
            //    Hashing algorithms operate on bytes, not directly on strings.
            byte[] hashBytes = digest.digest(input.getBytes(StandardCharsets.UTF_8));

            // 3. Convert to Hex: Convert the resulting byte array (the hash) into a hexadecimal string.
            //    This is a common way to represent hash values.
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                // Convert each byte to its hex representation.
                // String.format("%02x", b) ensures each byte is represented by two hex characters (e.g., 0F, not F).
                String hex = String.format("%02x", b);
                hexString.append(hex);
            }
            // Return the complete hexadecimal string representation of the hash.
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            // 4. Handle Error: If the SHA-256 algorithm is not available on the system
            //    (which is highly unlikely for standard Java environments), print an error
            //    and potentially throw a runtime exception or return null.
            System.err.println("Error getting SHA-256 instance: " + e.getMessage());
            // Throwing a RuntimeException might be better in production code
            // to signal a critical configuration error.
            throw new RuntimeException("SHA-256 algorithm not found", e);
            // return null; // Alternative: return null, but requires careful handling later
        }
    }

    // --- Getter ---

    /**
     * Returns the calculated Merkle Root hash of the tree.
     *
     * @return The Merkle Root as a hexadecimal String, or null if the tree was built
     *         with no data blocks.
     */
    public String getRoot() {
        // Simply return the value stored in the 'root' instance variable.
        return root;
    }

    /**
     * Returns the original list of data blocks used to build the tree.
     * Note: This returns a reference to the internal list copy.
     *
     * @return The list of data blocks.
     */
    public List<String> getDataBlocks() {
        // Return the list stored during construction.
        return dataBlocks; // Consider returning a copy if immutability is critical: new ArrayList<>(dataBlocks)
    }


    // --- Main Method for Demonstration ---

    /**
     * Main method to demonstrate the MerkleTree class usage.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        // 1. Example Data (Even Number): Create a list of sample data blocks.
        List<String> data1 = new ArrayList<>();
        data1.add("Transaction 1");
        data1.add("Transaction 2");
        data1.add("Transaction 3");
        data1.add("Transaction 4");

        // 2. Create Tree: Instantiate the MerkleTree with the sample data.
        //    The constructor will automatically call buildTree().
        System.out.println("Building Merkle Tree for: " + data1);
        MerkleTree tree1 = new MerkleTree(data1);

        // 3. Get and Print Root: Retrieve the calculated Merkle Root and print it.
        System.out.println("Merkle Root (Even Data): " + tree1.getRoot());
        System.out.println("--------------------");

        // 4. Example Data (Odd Number): Create another list with an odd number of blocks.
        List<String> data2 = new ArrayList<>();
        data2.add("Block A");
        data2.add("Block B");
        data2.add("Block C");

        // 5. Create Tree: Instantiate the MerkleTree with the odd-numbered data.
        System.out.println("Building Merkle Tree for: " + data2);
        MerkleTree tree2 = new MerkleTree(data2);

        // 6. Get and Print Root: Retrieve and print the root for the second tree.
        //    This demonstrates the handling of the odd node case.
        System.out.println("Merkle Root (Odd Data):  " + tree2.getRoot());
        System.out.println("--------------------");

        // 7. Example Data (Single Block):
        List<String> data3 = new ArrayList<>();
        data3.add("Only One Block");
        System.out.println("Building Merkle Tree for: " + data3);
        MerkleTree tree3 = new MerkleTree(data3);
        System.out.println("Merkle Root (Single Data): " + tree3.getRoot());
        System.out.println("--------------------");

        // 8. Example Data (Empty Block):
        List<String> data4 = new ArrayList<>();
        System.out.println("Building Merkle Tree for empty list: " + data4);
        MerkleTree tree4 = new MerkleTree(data4);
        System.out.println("Merkle Root (Empty Data): " + tree4.getRoot()); // Should be null based on our implementation
        System.out.println("--------------------");
    }
}