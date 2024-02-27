import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class _020_ValidParentheses {
    public static void main(String[] args) {
        boolean result = isValid("([])");
        System.out.println(result);
    }
    private static boolean isValid(String s) {
        if (s.length() % 2 != 0)
            return false;

        Stack<Character> stack = new Stack<>();
        for (char chr : s.toCharArray()) {
            if (chr == '(' || chr == '[' || chr == '{')
                stack.push(chr);
            else if (stack.size() == 0)
                return false;
            else {
                char lastElement = stack.pop();
                switch (chr) {
                    case ')':
                        if (lastElement != '(')
                            return false;
                        break;
                    case '}':
                        if (lastElement != '{')
                            return false;
                        break;
                    case ']':
                        if (lastElement != '[')
                            return false;
                        break;
                }
            }
        }

        if (stack.size() != 0)
            return false;

        return true;
    }
}

