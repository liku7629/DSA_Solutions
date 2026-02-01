package sub_sequences;

import java.util.ArrayList;
import java.util.List;

public class GeneratingAllSubSequences {
    public static void main(String[] args) {
        generateAllSubSequences(new int[]{3, 1, 2}, 0, new ArrayList<>());
    }

    public static void generateAllSubSequences(int[] array, int index, List<Integer> sequence) {
        if (index >= array.length) {
            System.out.println(sequence);
            return;
        }

        sequence.add(array[index]);
        generateAllSubSequences(array, index + 1, sequence);
        sequence.remove(index);
        generateAllSubSequences(array, index + 1, sequence);
    }
}
