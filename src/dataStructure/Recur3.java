package dataStructure;
import java.util.Scanner;

public class Recur3 {
    static void recur3(int n) {
        int[] nstk = new int[100];  //실제 값이 저장되는 공간
        int[] sstk = new int[100];  //nstk 배열의 값을 구분하기 위해 사용
        int ptr = -1;   //포인터 -1을 준 이유는 선 포인터 증가로 do-while문에서 현재 포인터를 유지 하기 위함.
        int sw = 0;     //구분값

        while (true) {
            if (n > 0) {
                ptr++;  //포인터 증가
                //nstk, sstk는 항상 동일하게 포인트를 가르킨다.
                nstk[ptr] = n;
                sstk[ptr] = sw;

                if (sw == 0)    //좌
                    n = n - 1;
                else if (sw == 1) { //우
                    n = n - 2;
                    sw ^= sw;   //xor 비트연산 0 초기화 그냥해봄
                }
                continue;   //계속해서 depth를 가지기 위함.
            }

            do {
                n = nstk[ptr];
                sw = sstk[ptr--] + 1;   //대입이 끝나고 ptr-- 하면서 상위 노드를 가르킨다.

                if (sw == 2) {
                    System.out.println(n);
                    if (ptr < 0)
                        return;
                }
            } while (sw == 2);
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        System.out.print("정수입력 : ");
        int x = stdIn.nextInt();
        recur3(x);
    }
}
