package algorithm.inflearn._2;

/**
 * 2-9. 격자판 최대합
 */
public class Problem9 {
    public static void main(String[] args) {
        int[][] ints = {
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5}
        };
        int n = 5;
        int sum1, sum2, max = 0;

        for (int i = 0; i < n; i++) {
            sum1 = sum2 = 0;

            for (int j = 0; j < n; j++) {
                sum1 = sum1 + ints[i][j];
                sum2 = sum2 + ints[j][i];
            }

            max = Math.max(max, sum1);
            max = Math.max(max, sum2);
        }

        sum1 = sum2 = 0;

        for (int i = 0; i < 5; i++) {
            sum1 = sum1 + ints[i][i];
            sum2 = sum2 + ints[i][n - i - 1];
        }

        max = Math.max(max, sum1);
        max = Math.max(max, sum2);

        System.out.println(max);

    }
}