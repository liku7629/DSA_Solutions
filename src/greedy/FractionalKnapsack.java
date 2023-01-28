package greedy;


import java.util.Arrays;
import java.util.Comparator;

class Item {
    int value, weight;

    Item(int x, int y) {
        this.value = x;
        this.weight = y;
    }
}

class perWeight implements Comparator<Item> {
    public int compare(Item a, Item b) {
        double r1 = (double) a.value / (double) a.weight;
        double r2 = (double) b.value / (double) b.weight;
        if (r1 < r2)
            return 1;
        else if (r1 >= r2)
            return -1;
        else
            return 0;
    }
}

public class FractionalKnapsack {
    public static void main(String[] args) {

    }

    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item[] arr, int n) {
        // Your code here
        double profit = 0.0;
        Arrays.sort(arr, new perWeight());
        for (int i = 0; i < n; i++) {
            if (W > 0 && arr[i].weight <= W) {
                profit += arr[i].value;
                W -= arr[i].weight;
            } else if (W > 0) {
                profit += ((double) arr[i].value / (double) arr[i].weight) * W;
                break;
            }
        }
        return profit;
    }
}