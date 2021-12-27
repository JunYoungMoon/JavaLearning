package dataStructure;

import java.util.Scanner;

/**
 * 재귀방식 | 비재귀 스택 활용
 */
public class Recur {

    static void recur(int n) {
        //비재귀 스택 활용
//        Gstack<Integer> gs = new Gstack<>(n);
//
//        while (true) {
//            if (n > 0) {
//                gs.push(n);
//                n = n - 1;
//                continue;
//            }
//            if (!gs.isEmpty()) {
//                n = gs.pop();
//                System.out.println(n);
//                n = n - 1;
//                continue;
//            }
//            break;
//        }

        //재귀방식
        if (n > 0) {
            //하향식분석 (위에서 아래로)
            //1. 파라미터를 넘겨 받으면 n > 0까지 n - 1을 하면서 1번을 반복한다.
            //2. 더이상 조건문을 만족하지 못하면 호출한 위치로 다시 돌아가 츨력을하고
            //3. 이어서 일련의 작업 n - 2 호출하여 1부터 다시 실행한다.
            //하향식 분석을 하게 되면 recur(1),recur(2)와 같이 여러번 호출되는 메서드가 많아질수 있다.

            //상향식분석 (아래에서 위로)
            //1. recur(-1), recur(0)은 아무것도 하지 않는다.
            //2. recur(1) : recur(0) > 1출력 > recur(-1) => 결과 1
            //3. recur(2) : recur(1) > 2출력 > recur(0) => 결과 1,2
            //4. recur(3) : recur(2) > 3출력 > recur(1) => 결과 1,2,3,1
            //5. recur(4) : recur(3) > 4출력 > recur(2) => 결과 1,2,3,1,4,1,2

            //두개의 재귀함수로 이진트리를 만들수 있다.
            recur(n - 1);
            System.out.println(n);
            recur(n - 1);
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("정수입력 : ");

        int x = stdIn.nextInt();

        recur(x);
    }
}
