package dataStructure;

import java.util.Scanner;

/**
 * 재귀방식 | 비재귀 스택 활용
 */
public class Recur {

    static void recur(int n) {
        //비재귀 스택 활용
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
                n = n - 2;
                continue;
            }
            break;
        }

//        재귀방식
//        if (n > 0) {
//            recur(n - 1);
//            System.out.println(n);
//            recur(n - 2);
//        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("정수입력 : ");

        int x = stdIn.nextInt();

        recur(x);
    }
}
