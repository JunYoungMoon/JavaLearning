package dataStructure;

import java.util.Scanner;

/**
 * 하노이의탑 (미완성)
 */
public class Hanoi {

    static void move(int no, int x, int y) {
        if (no > 1) {
            move(no - 1, x, 6 - x - y);
        }
        System.out.println("원반[" + no + "]를 " + x + "기둥에서 " + y + "기둥으로 옮김");
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("원반 개수 : ");
        int n = stdIn.nextInt();

        move(n, 1, 3);
    }
}
