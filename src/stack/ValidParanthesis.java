package stack;

import java.util.Stack;

// https://leetcode.com/problems/valid-parentheses/description/
public class ValidParanthesis {
    public static void main(String[] args) {
        System.out.println(Valid_Parantheses_Solution.isValid("()"));
    }
}

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}

class Valid_Parantheses_Solution {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if ((c == ')' || c == '}' || c == ']') && !stack.isEmpty()) {
                char opening = stack.pop();
                if (!isMatching(opening, c)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean isMatching(char opening, char closing) {
        boolean isMatching = false;

        if (opening == '(' && closing == ')') {
            isMatching = true;
        } else if (opening == '{' && closing == '}') {
            isMatching = true;
        } else if (opening == '[' && closing == ']') {
            isMatching = true;
        }

        return isMatching;
    }
}


