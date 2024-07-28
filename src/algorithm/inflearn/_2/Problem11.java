package algorithm.inflearn._2;

/**
 * 2-11. 임시반장
 */
public class Problem11 {
    public static void main(String[] args) {
        int[][] ints = {
                {2, 3, 1, 7, 3},
                {4, 1, 9, 6, 8},
                {5, 5, 2, 4, 4},
                {6, 5, 2, 6, 7},
                {8, 4, 2, 2, 2},
        };

        int n = 5, cnt, max = 0, result = 0;

        for (int i = 0; i < n; i++) {
            cnt = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (i != k && ints[i][j] == ints[k][j]) {
                        cnt++;
                        break;
                    }
                }
            }

            if(cnt > max){
                max = cnt;
                result = i + 1;
            }
        }

        System.out.println(result);
    }
}