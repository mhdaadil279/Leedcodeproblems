import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            // Push corresponding closing bracket onto the stack
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } 
            // If stack is empty or character doesn't match top element, invalid
            else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        
        // Valid if no unmatched opening brackets remain
        return stack.isEmpty();
    }
}
