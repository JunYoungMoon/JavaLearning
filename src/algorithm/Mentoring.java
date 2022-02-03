package algorithm;

import java.util.Scanner;

public class Mentoring {
    public int solution(int n, int m, int[][] arr) {
        int answer = 0;
        return answer;
    }

    public static void main(String[] args) {
        Mentoring mt = new Mentoring();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = kb.nextInt();
            }
        }
        System.out.println(mt.solution(n, m, arr));
    }
}
