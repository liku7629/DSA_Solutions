package string;

import java.util.Stack;

//https://leetcode.com/problems/remove-outermost-parentheses/solutions/2953073/without-stack-c-simple-100-fastest/
public class RemoveOuterMostParanthesis {
    public static void main(String[] args) {

    }
}

 class RemoveOuterMostParanthesis_Solution_SubOptimal {
     public String removeOuterParentheses(String s) {
         Stack<Character> stack = new Stack<>();
         StringBuilder ans = new StringBuilder();

         for (int i = 0; i < s.length(); i++) {
             if (s.charAt(i) == '(') {
                 stack.push('(');
             } else if (!stack.isEmpty() && s.charAt(i) == ')') {
                 stack.pop();
             }

             if (s.charAt(i) == '(' && stack.size() > 1) {
                 ans.append('(');
             }

             if (s.charAt(i) == ')' && !stack.isEmpty()) {
                 ans.append(')');
             }
         }

         return ans.toString();
     }
 }

class RemoveOuterMostParanthesis_Solution_Optimal {
    public String removeOuterParentheses(String s) {
        int counter = 0;
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') counter++;
            if (s.charAt(i) == ')') counter--;

            if (s.charAt(i) == '(' && counter != 1)
                ans.append('(');
            if (s.charAt(i) == ')' && counter != 0)
                ans.append(')');
        }

        return ans.toString();
    }
}