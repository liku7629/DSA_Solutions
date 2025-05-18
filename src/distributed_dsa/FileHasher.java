package distributed_dsa;

import java.io.BufferedInputStream; // Efficiently reads byte streams using an internal buffer
import java.io.File;                // Represents a file path
import java.io.FileInputStream;     // Reads raw bytes from a file
import java.io.IOException;         // Handles input/output errors
import java.security.MessageDigest;   // Core class for calculating cryptographic hashes
import java.security.NoSuchAlgorithmException; // Handles cases where the hashing algorithm isn't available

/**
 * Calculates the hash (e.g., SHA-256) of a large file efficiently
 * by reading it in chunks.
 */
public class FileHasher {

    /**
     * Calculates the hash of a file using the specified algorithm.
     *
     * @param filePath  The path to the file to hash.
     * @param algorithm The hashing algorithm to use (e.g., "SHA-256", "MD5", "SHA-1").
     *                  "SHA-256" is recommended.
     * @return The hexadecimal representation of the file's hash, or null if an error occurs.
     */
    public static String calculateFileHash(String filePath, String algorithm) {
        // 1. Validate the chosen algorithm
        MessageDigest digest; // Declare MessageDigest object
        try {
            // Get an instance of the MessageDigest for the specified algorithm (e.g., "SHA-256")
            digest = MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            // Handle the case where the requested algorithm (e.g., "SHA-256") isn't supported by the Java environment
            System.err.println("Error: Algorithm '" + algorithm + "' not found.");
            // Print the stack trace for debugging purposes
            e.printStackTrace();
            // Return null to indicate failure
            return null;
        }

        // 2. Get the file object
        File file = new File(filePath); // Create a File object representing the path
        // Check if the file actually exists before trying to read it
        if (!file.exists()) {
            System.err.println("Error: File not found at path: " + filePath);
            return null; // Return null if the file doesn't exist
        }
        // Check if the path points to a directory instead of a file
        if (file.isDirectory()) {
            System.err.println("Error: The specified path is a directory, not a file: " + filePath);
            return null; // Return null if it's a directory
        }


        // 3. Read the file in chunks and update the hash
        // Use try-with-resources to ensure the streams are automatically closed
        // even if errors occur. This is crucial for resource management.
        try (FileInputStream fis = new FileInputStream(file); // Open a stream to read bytes from the file
             // Wrap the FileInputStream in a BufferedInputStream for efficiency.
             // This reads larger chunks from the disk into a buffer, reducing I/O overhead.
             BufferedInputStream bis = new BufferedInputStream(fis)) {

            // Create a byte array buffer to hold chunks of data read from the file.
            // A common size is 8192 bytes (8 KB), but this can be adjusted.
            byte[] buffer = new byte[8192];
            int bytesRead; // Variable to store the number of bytes read in each iteration

            // Loop that continues as long as data is being read from the file.
            // bis.read(buffer) attempts to fill the buffer and returns the number of bytes actually read,
            // or -1 if the end of the file has been reached.
            while ((bytesRead = bis.read(buffer)) != -1) {
                // Update the MessageDigest with the chunk of data just read.
                // We specify the buffer, the starting offset (0), and the number of bytes
                // that were actually read (bytesRead), not necessarily the full buffer size.
                // This is the core of processing the file without loading it all into memory.
                digest.update(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            // Handle potential errors during file reading (e.g., disk errors, permissions issues)
            System.err.println("Error reading file: " + filePath);
            // Print the stack trace for debugging
            e.printStackTrace();
            // Return null to indicate failure
            return null;
        }

        // 4. Finalize the hash calculation
        // After processing all the file chunks, finalize the hash computation.
        byte[] hashBytes = digest.digest(); // Returns the hash value as an array of bytes

        // 5. Convert the byte array hash to a hexadecimal string for easy display
        StringBuilder hexString = new StringBuilder(); // Use StringBuilder for efficient string concatenation
        // Iterate over each byte in the hash byte array
        for (byte b : hashBytes) {
            // Convert the byte to its hexadecimal representation.
            // String.format("%02x", b) ensures:
            //   - %x: format as hexadecimal
            //   - 02: pad with a leading zero if necessary to ensure two characters per byte (e.g., "0f" instead of "f")
            hexString.append(String.format("%02x", b));
        }

        // Return the final hexadecimal hash string
        return hexString.toString();
    }

    /**
     * Main method for demonstration.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        // --- IMPORTANT ---
        // Replace this with the ACTUAL path to your large movie file!
        // Example paths (use the correct one for your OS):
        // String movieFilePath = "C:/Users/YourUser/Videos/MyLargeMovie.mp4"; // Windows
        // String movieFilePath = "/home/youruser/Videos/MyLargeMovie.mkv";    // Linux
        String movieFilePath = "E:\\Algorithmic System Design - 1.mp4"; // << CHANGE THIS!!

        // Choose the hashing algorithm (SHA-256 is recommended)
        String algorithm = "MD5";

        System.out.println("Attempting to hash file: " + movieFilePath);
        System.out.println("Using algorithm: " + algorithm);

        // Record the start time
        long startTime = System.currentTimeMillis();

        // Call the hashing function
        String fileHash = calculateFileHash(movieFilePath, algorithm);

        // Record the end time
        long endTime = System.currentTimeMillis();
        // Calculate the duration
        long duration = endTime - startTime;

        // Check if the hashing was successful
        if (fileHash != null) {
            // Print the resulting hash
            System.out.println("\nSuccessfully calculated hash:");
            System.out.println(fileHash);
            // Print the time taken
            System.out.printf("Time taken: %d milliseconds (%.2f seconds)%n", duration, duration / 1000.0);
        } else {
            // Print an error message if hashing failed
            System.out.println("\nFailed to calculate hash for the file.");
        }
    }
}