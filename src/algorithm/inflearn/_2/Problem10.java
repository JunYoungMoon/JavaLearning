package algorithm.inflearn._2;

/**
 * 2-10. 봉우리
 */
public class Problem10 {
    public static void main(String[] args) {
        int[][] ints = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 5, 3, 7, 2, 3, 0},
                {0, 3, 7, 1, 6, 1, 0},
                {0, 7, 2, 5, 3, 4, 0},
                {0, 4, 3, 6, 4, 1, 0},
                {0, 8, 7, 3, 5, 2, 0},
                {0, 0, 0, 0, 0, 0, 0},
        };

        int cnt = 0;

        for (int i = 1; i < ints.length -1; i++) {
            for (int j = 1; j < ints.length -1; j++) {
                for (int k = 0; k < 4; k++) {

                    if (ints[i - 1][j] > ints[i][j] &&
                            ints[i][j - 1] > ints[i][j] &&
                            ints[i + 1][j] > ints[i][j] &&
                            ints[i][j + 1] > ints[i][j]) {
                        cnt++;
                    }
                }

            }
        }
        System.out.println(cnt);
    }
}