package sliding_window;

public class CardPoints {
    public static void main(String[] args) {
//        System.out.println(new Solution().maxScore(new int[] {1, 2, 3, 4, 5, 6, 1}, 3));
        System.out.println(new Solution().maxScore(new int[] {96,90,41,82,39,74,64,50,30}, 8));

//        System.out.println(new Solution().maxScore(new int[] {2, 4, 5}, 2));
//        System.out.println(new Solution().maxScore(new int[] {1, 79, 80, 1, 1, 1}, 3));
    }
}

class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int maxScore = 0;

        int currScore = 0;
        for (int i = 0; i < k; i++) {
            currScore += cardPoints[i];
            maxScore = Math.max(maxScore, currScore);
        }

        for (int i = n - k; i < n; i++) {
            currScore = 0;

            for (int j = i; j < i + k; j++) {
                currScore += cardPoints[j >= n ? j % n : j];
                System.out.println("currentElement=" + cardPoints[j >= n ? j % n : j] + "  currScore: " + currScore + " j: " + j + " mod: " + (j >= n ? j % n : j));
            }
            System.out.println();
            maxScore = Math.max(currScore, maxScore);
        }

        return maxScore;
    }
}