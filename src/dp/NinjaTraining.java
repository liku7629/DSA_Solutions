package dp;

import java.util.Arrays;

public class NinjaTraining {
        public static void main(String[] args) {
                int[][] matrix = {
                        {10, 40, 70},
                        {20, 50, 80},
                        {30, 60, 90}
                };

                NinjaTraining_Solution.ninjaTraining(matrix);
        }
}

class NinjaTraining_Solution {
        public static int ninjaTraining(int[][] matrix) {
                int[][] cache = new int[matrix.length][3];
                for (int[] row : cache) {
                        Arrays.fill(row, - 1);
                }
                return ninjaTrainingHelper(matrix, 0, -1, cache);
        }

        private static int ninjaTrainingHelper(int[][] matrix, int index, int prevActivity, int[][] cache) {
                if (index >= matrix.length)
                        return 0;

                if (prevActivity != -1 && cache[index][prevActivity] != -1)
                        return cache[index][prevActivity];


                int maxPoints = 0;

                for (int activity = 0; activity < 3; activity++) {
                        int currPoints = matrix[index][activity] + ninjaTrainingHelper(matrix, index + 1, activity, cache);
                        maxPoints = Math.max(currPoints, maxPoints);
                }

                if (prevActivity != -1)
                        cache[index][prevActivity] = maxPoints;

                return maxPoints;
        }
}
