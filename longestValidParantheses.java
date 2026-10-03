import java.util.Stack;

public class longestValidParantheses {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // Base to handle the first valid substring
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i); // Push the index of '('
            } else {
                stack.pop(); // Pop for a matching ')'
                if (stack.isEmpty()) {
                    stack.push(i); // Reset the base index if stack is empty
                } else {
                    // Calculate valid length from the current top of the stack
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }
}



