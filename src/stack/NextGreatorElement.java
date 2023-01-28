package stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreatorElement {

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new NextGreatorElement().nextGreaterElements(new int[]{1,2,1})));
    }

    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * nums.length - 1; i >= 0; --i) {
            while (!stack.empty() && nums[stack.peek()] <= nums[i % nums.length]) {
                stack.pop();
            }
            res[i % nums.length] = stack.empty() ? -1 : nums[stack.peek()];
            stack.push(i % nums.length);
        }
        return res;
    }
}
