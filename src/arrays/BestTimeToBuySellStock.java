package arrays;

public class BestTimeToBuySellStock {
    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[] {7,1,5,3,6,4}));
    }
}


class SolutionBruteForce {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            int buyPrice = prices[i];

            for (int j = i + 1; j < prices.length; j++) {
                maxProfit = Math.max(maxProfit, prices[j] - buyPrice);
            }
        }

        return maxProfit;
    }
}

//Optimize O(n) solution
//start minPrice with index=0 and sellPrice i.e prices[i] with index=1
//  maxProfit = Math.max(maxProfit, prices[i] - minPrice); -> to update
//  profit for every transaction

//  minPrice = Math.min(minPrice, prices[i]);
//  update the minimum price to keep track of the lowest price
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0, minPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }

        return maxProfit;
    }
}
