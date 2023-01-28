package arrays;

public class TrappingRainWater {
    public static void main(String[] args) {
//        System.out.println(getWater(new int[] {7, 7, 7,7,7,7 }));
        System.out.println(getWater(new int[] {0, 7, 5, 7,9,8,7 }));
    }

    public static int getWater(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = height[left], rightMax = height[right];

        int res = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                int currHeight = height[left];
                if (currHeight > leftMax) leftMax = currHeight;
                res += leftMax - currHeight;
                left++;
            } else {
                int currHeight = height[right];
                if (currHeight > rightMax) rightMax = currHeight;
                res += rightMax - currHeight;
                right--;
            }
        }

        return res;
    }
}
