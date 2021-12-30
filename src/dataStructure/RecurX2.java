package dataStructure;

import java.util.Scanner;

/**
 * 비재귀 스택
 */
public class RecurX2 {
    static void recur(int n) {
        Gstack<Integer> gs = new Gstack<>(n);

        while (true) {
            if (n > 0) {
                gs.push(n);
                n = n - 1;
                continue;
            }
            if (!gs.isEmpty()) {
                n = gs.pop();
                System.out.println(n);
                n = n - 1;
                continue;
            }
            break;
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("정수입력 : ");

        int x = stdIn.nextInt();

        recur(x);
    }
}
