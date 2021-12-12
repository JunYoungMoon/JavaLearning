package algorithm;

import java.util.Scanner;

/**
 * 선형 검색 (보초법 sentinel method)
 */
public class Search {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요소수:");
        int num = stdIn.nextInt();
        int[] x = new int[num + 1];

        for (int i = 0; i < num; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

        System.out.print("검색할 값 : ");
        int key = stdIn.nextInt();

        int result = seqSearch(x, num, key);

        if (result == -1) {
            System.out.println("찾는값 없음");
        } else {
            System.out.println("찾는값 x[" + result + "]에 있음");
        }
    }

    static int seqSearch(int[] a, int num, int key) {

        int i = 0;

        a[num] = key;   // 마지막 배열에 보초추가

//        기존코드
//        while (true) {
//
//            if (i == num) {
//                return -1;
//            }
//            if (a[i] == key) {
//                return i;
//            }
//            i++;
//        }

        // 보초 추가 수정코드
        while (a[i] != key) {
            i++;
        }

        return i == num ? -1 : i;
    }
}
