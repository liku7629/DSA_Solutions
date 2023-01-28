package string;

import java.util.ArrayList;
import java.util.UUID;

public class CassandraLimitUpdate {

    private static final int MAX_BUFFER_SIZE = 10;

    public static void main(String[] args) {
        ArrayList<String> records = new ArrayList<>();
        initialize(records);

        ArrayList<String> queries = new ArrayList<>();

        StringBuilder currentQuery = null;

        for (int i = 0; i < records.size(); i++) {
            if (i % MAX_BUFFER_SIZE == 0) {
                if (i > 0) {
                    String query = currentQuery.toString();
                    queries.add(query);
                    currentQuery = null;
                }
                currentQuery = new StringBuilder(MAX_BUFFER_SIZE);
            }

            currentQuery.append(records.get(i) + ", ");
        }

        if (currentQuery != null) {
            queries.add(currentQuery.toString());
        }

        System.out.println(records);
        System.out.println("\n\n\n\n");

        System.out.println(queries);
    }

    public static void initialize(ArrayList<String> records) {
        for (int i = 0; i < 34; i++) {
            records.add(String.valueOf(i));
        }

        System.out.println("CassandraLimitUpdate.initialize");
    }

}
