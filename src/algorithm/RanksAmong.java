package algorithm;

import java.util.Scanner;

public class RanksAmong {
    public int[] solution(int n, int[] arr) {
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 0; j < n; j++) {
                if (arr[j] > arr[i]) cnt++;
            }
            answer[i] = cnt;
        }

        return answer;
    }

    public static void main(String[] args) {
        RanksAmong ra = new RanksAmong();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        for (int x : ra.solution(n, arr)) {
            System.out.print(x + " ");
        }
    }
}
