package arrays;

//https://leetcode.com/problems/container-with-most-water/
//shrinking window, left/right initially at endpoints, shift the pointer with min height;
//Brute force solution given below
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;

        int maxArea = 0;

        while (left < right) {
            int width = right - left;
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * width);

            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }

        return maxArea;
    }
}


class BruteForceSolution {
    public int maxArea(int[] height) {
        int maxarea = 0;
        for (int left = 0; left < height.length; left++) {
            for (int right = left + 1; right < height.length; right++) {
                int width = right - left;
                maxarea = Math.max(maxarea, Math.min(height[left], height[right]) * width);
            }
        }
        return maxarea;
    }
}
