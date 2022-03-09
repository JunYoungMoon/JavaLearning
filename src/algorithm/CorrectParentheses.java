package algorithm;

import java.util.Scanner;
import java.util.Stack;

public class CorrectParentheses {
    public String solution(String str) {
        String answer = "YES";
        Stack<Character> stack = new Stack<>();

        for (char x : str.toCharArray()) {
            if (x == '(') {
                stack.push(x);
            } else {
                if (stack.isEmpty()) {
                    return "NO";
                } else {
                    stack.pop();
                }
            }
        }
        if (!stack.isEmpty()) {
            return "NO";
        }
        return answer;
    }

    public static void main(String[] args) {
        CorrectParentheses cp = new CorrectParentheses();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(cp.solution(str));
    }
}
