package dataStructure;

import java.util.Scanner;

/**
 * 하노이의 탑
 */
public class Hanoi {
    static int count;
    //no개의 원반을 x번 기둥에서 y번 기둥으로 옮김
    static void move(int no, int x, int y) {
        if (no > 1) {
            move(no - 1, x, 6 - x - y);
        }
        System.out.println("원반[" + no + "]를 " + x + "기둥에서 " + y + "기둥으로 옮김 그리고 횟수 :" +count++);
        if (no > 1) {
            move(no - 1, 6 - x - y, y);
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("원반 개수 : ");
        int n = stdIn.nextInt();

        move(n, 1, 3);  //1번 기둥의 n개의 원반을 3번 기둥으로 옮김
    }
}
