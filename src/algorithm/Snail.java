package algorithm;

import java.util.Scanner;

public class Snail {

    public static void main(String[] args) {

        System.out.println("크기 입력 : ");
        Scanner scanner = new Scanner(System.in);

        int k = scanner.nextInt();
        int arr[][] = new int[k][k];
        int i = 0, j = -1;
        int count = 1;
        int s = 1;  //회전변수
        int m, n;

        while (k > 0) {

            for (m = 0; m < k; m++) {
                j = j + s;
                arr[i][j] = count++;
            }
            k--;

            if (k == 0) {
                break;
            }

            for (n = 0; n < k; n++) {
                i = i + s;
                arr[i][j] = count++;
            }

            s = s * (-1);
        }

        for (i = 0; i < arr.length; i++) {
            for (j = 0; j < arr.length; j++) {
                System.out.print(String.format("%02d", arr[i][j]) + " ");
            }
            System.out.println();
        }
    }
}
