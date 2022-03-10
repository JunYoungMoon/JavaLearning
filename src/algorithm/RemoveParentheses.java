package algorithm;

import java.util.Scanner;
import java.util.Stack;

public class RemoveParentheses {
    public String solution(String str) {
        String answer = "";
        Stack<Character> stack = new Stack<>();

        for(char x : str.toCharArray()){
            if(x==')'){

            }else{
                stack.push(x);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        RemoveParentheses rp = new RemoveParentheses();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(rp.solution(str));
    }
}
