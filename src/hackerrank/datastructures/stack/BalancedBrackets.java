package hackerrank.datastructures.stack;
import java.util.*;

public class BalancedBrackets {
    static char closingEquivalent(char bracket) {
        if(bracket == '[') return ']';
        if(bracket == '(') return ')';
        if(bracket == '{') return '}';
        return 'X';
    }
    static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        char[] brackets = s.toCharArray();

        for(char bracket : brackets) {
            if(!stack.isEmpty() && closingEquivalent(stack.peek()) == bracket) stack.pop();
            else stack.push(bracket);
        }
        return stack.isEmpty();

    }

    public static void main(String[] args) {

        System.out.println(isBalanced("[(})]"));
        System.out.println(isBalanced("[({})]"));
    }
}
