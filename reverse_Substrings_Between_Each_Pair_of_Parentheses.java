import java.util.*;

public class reverse_Substrings_Between_Each_Pair_of_Parentheses {
    public String reverseParentheses(String s) {
        Stack<StringBuilder> stack = new Stack<>();
        stack.push(new StringBuilder()); 

        for (char c : s.toCharArray()) {
            if (c == '(') {
                
                stack.push(new StringBuilder());
            } else if (c == ')') {
                
                StringBuilder top = stack.pop();
                top.reverse();
                stack.peek().append(top);
            } else {
                
                stack.peek().append(c);
            }
        }

        return stack.pop().toString();
    }
}
