package algorithm.inflearn._2;

/**
 * 2-12. 멘토링
 */
public class Problem12 {
    public static void main(String[] args) {
        int[][] ints = {
                {3, 4, 1, 2},
                {4, 3, 2, 1},
                {3, 1, 4, 2},
        };

        int n = 4, m = 3, pi= 0 , pj = 0, cnt, result = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                cnt = 0;
                System.out.println("[" + ints[0][i] + "," + ints[0][j] + "]");
                for (int k = 1; k < m; k++) {
                    for (int l = 0; l < n; l++) {
                        if (ints[0][i] == ints[k][l]) {
                            pi = l;
                        }

                        if (ints[0][j] == ints[k][l]) {
                            pj = l;
                        }
                    }

                    if (pi < pj){
                        cnt++;
                        pi = pj = 0;
                    }
                }

                if (cnt == m - 1) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}