package algorithm;

import java.util.Scanner;
import java.util.Stack;

public class ClawMachineGame {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        return answer;
    }

    public static void main(String[] args) {
        ClawMachineGame cmg = new ClawMachineGame();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = kb.nextInt();
            }
        }
        int m = kb.nextInt();
        int[] moves = new int[m];
        for (int i = 0; i < m; i++) {
            moves[i] = kb.nextInt();
        }
        System.out.println(cmg.solution(board, moves));
    }
}
