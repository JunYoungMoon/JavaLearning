package algorithm.doIt._5;

/**
 * 5-3. 8퀸
 */
public class Problem3 {
    static int[] pos = new int[8];  //퀸의 위치를 표현하기 위한 일차원 배열
    //lock을 걸어야할 위치를 키로 갖는 배열을 생성한다.
    //퀸을 둔 행에는 다른 퀸이 올수 없으므로 만약 0번째에 퀸을 둔다면 다음 재귀에서는 0번째에 퀸을 두었다는걸 기억해야 하기 때문에 사용하는 배열
    static boolean[] flag_1 = new boolean[8];   //행
    static boolean[] flag_2 = new boolean[15];  //왼쪽에서 오른쪽 아래로
    static boolean[] flag_3 = new boolean[15];  //오른쪽에서 왼쪽 아래로

    // 퀸의 위치를 일차원 배열로 보여준다.
    static void print() {
        for (int i = 0; i < 8; i++) {
            System.out.printf("%2d", pos[i]);
        }
        System.out.println();
    }

    static void set(int i) {
        for (int j = 0; j < 8; j++) {
            //[i - j + 7], [i + j]는 대각선으로 이부분이 어려웠다.
            //대각선도 일정한 패턴이 있다. i,j 를 조합하여 중복되지 않는 고유값을 만들수만 있다면
            //일차원 배열에 대각선에 대한 값을 일차원 배열에 저장할수 있는 공식을 만들수 있다.
            if (flag_1[j] == false && flag_2[i - j + 7] == false && flag_3[i + j] == false) {
                pos[i] = j; // 현재 위치의 퀸을 배열에 저장
                if (i == 7) {
                    print();
                } else {
                    //직선,대각선을 lock 시킨다.
                    flag_1[j] = true;
                    flag_2[i - j + 7] = true;
                    flag_3[i + j] = true;
                    set(i + 1);
                    flag_1[j] = false;
                    flag_2[i - j + 7] = false;
                    flag_3[i + j] = false;
                }
            }

        }
    }

    public static void main(String[] args) {
        set(0);
    }
}