package leetcode.meta;

import java.util.Stack;
import java.util.*;


// - Time Complexity: O(n)
//- Space Complexity: O(n)
public class Validparanthesis {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter parentheses string:");
        String s = sc.nextLine();

        boolean result = isValid(s);

        System.out.println(result ? "Valid" : "Invalid");
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            // Opening brackets → push
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                // Closing bracket but nothing to match
                if (stack.isEmpty()) return false;

                char top = stack.pop();

                // Check matching pairs
                if (c == ')' && top != '(') return false;
                if (c == '}' && top != '{') return false;
                if (c == ']' && top != '[') return false;
            }
        }

        // Valid only if no unmatched openings remain
        return stack.isEmpty();
    }
}