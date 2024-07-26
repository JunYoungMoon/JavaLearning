package algorithm.inflearn._2;

/**
 * 2-10. 봉우리
 */
public class Problem10 {
    public static void main(String[] args) {
        int[][] ints = {
                {5, 3, 7, 2, 3},
                {3, 7, 1, 6, 1},
                {7, 2, 5, 3, 4},
                {4, 3, 6, 4, 1},
                {8, 7, 3, 5, 2},
        };

        int cnt = 0, n = 5;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = true;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && ints[nx][ny] >= ints[i][j]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}