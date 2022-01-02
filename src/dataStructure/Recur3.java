package dataStructure;
import java.util.Scanner;

public class Recur3 {
    static void recur3(int n) {
        int[] nstk = new int[100];  //실제 값이 저장되는 공간
        int[] sstk = new int[100];  //nstk과 동일한 index를 가지면서 저장된 값이 1일때 출력
        int ptr = -1;
        int sw = 0;

        while (true) {
            if (n > 0) {
                ptr++;  //포인터 증가
                nstk[ptr] = n;  //값저장
                sstk[ptr] = sw;

                if (sw == 0)    //좌
                    n = n - 1;
                else if (sw == 1) { //우
                    n = n - 2;
                    sw = 0;
                }
                continue;
            }


            do {
                n = nstk[ptr];
                sw = sstk[ptr--] + 1;   //ptr을--해주면서 상위 노드를 가르킨다.

                if (sw == 2) {
                    System.out.println(n);
                    if (ptr < 0)
                        return;
                }
            } while (sw == 2);
        }
    }

    public static void main(String[] args) {
//        Scanner stdIn = new Scanner(System.in);

//        System.out.print("정수입력 : ");

//        int x = stdIn.nextInt();


        recur3(4);
    }
}
