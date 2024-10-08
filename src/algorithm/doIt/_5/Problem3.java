package algorithm.doIt._5;

/**
 * 5-3. 하노이의 탑
 * 1,2,3번의 3개의 기둥에서 1번에 쌓여져 있는 3개의 원반을 1번기둥에서 3번기둥으로 옮길때 가장 최소로 옮기는 횟수
 */
public class Problem3 {
    //                    (3,1,3)
    //        (2,1,2)                 (2,2,3)
    // (1,1,3)      (1,3,2)     (1,2,1)     (1,1,3)
    static void hanoi(int n, int x, int y) {
        if (n > 0) {
            //(1,1,3), (2,1,2), (1,2,1) 왼쪽 부분의 패턴을 봤을때 x는 그대로 하위 재귀에게 전달된다.
            //y는 6 - x - y 를 하위에게 전달한다.
            hanoi(n - 1, x, 6 - x - y);

            System.out.print("(" + n + ", " + x + ", " + y + ")");
            System.out.println();

            //(1,3,2), (2,2,3), (1,1,3) 오른쪽 부분의 패턴을 봤을때 x는 6 - x - y 를 하위에게 전달한다.
            //y는 y를 그대로 하위 재귀에게 전달된다.
            hanoi(n - 1, 6 - x - y , y);
        }
    }

    public static void main(String[] args) {
        // 패턴 찾기
        // (어떤원반이, 어디서, 어디로)
        // 원반이 2개일떄
        // (1,1,2), (2,1,3), (1,2,3)
        // 원반이 3개일때
        // (1,1,3), (2,1,2), (1,3,2), (3,1,3), (1,2,1), (2,2,3), (1,1,3)
        // 원반이 4개일때
        // (1,1,2), (2,1,3), (1,2,3), (3,1,2), (1,3,1), (2,3,2), (1,1,2), (4,1,3), (1,2,3), (2,2,1), (1,3,1), (3,2,3), (1,1,2), (2,1,3), (1,2,3)
        // 원반이 2,3,4개 혹은 그이상일때도 매번 3가지 단계를 반복적으로 거치면서 깊이있게 들어가는데 3가지 단계는 다음과 같다.
        // 1단계 : 1 ~ n-1 원반을 도움기둥으로 이동
        // 2단계 : n 원반을 목적기둥으로 이동
        // 3단계 : 1 ~ n-1 원반을 도움기둥에서 목적 기둥으로 이동
        // 원반의 갯수가 가변적으로 입력이 가능하고, 가장 하위의 문제 즉 1번 원반부터 해결하여 처음 문제에 대한 답을 구하게 되는것에 해결 방법으로는 재귀 방식이 있다.

        //원반이 3개일때
        hanoi(3, 1, 3);
    }
}