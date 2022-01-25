package algorithm;

import java.util.Scanner;

public class FibonacciNumbers {
    public void solution(int n) {
//    public int[] solution(int n) {
//        int[] answer = new int[n];
//        answer[0] = 1;
//        answer[1] = 1;
//        for (int i = 2; i < n; i++) {
//            answer[i] = answer[i - 2] + answer[i - 1];
//        }
//        return answer;
        int a = 1, b =1, c;
        System.out.println(a+" "+b+" ");
        for (int i = 2; i < n; i++) {
            c = a+b;
            System.out.print(c+" ");
            a = b;
            b = c;
        }
    }

    public static void main(String[] args) {
        FibonacciNumbers fn = new FibonacciNumbers();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        //for (int x : fn.solution(n)) System.out.print(x + " ");
        fn.solution(n);
    }
}
