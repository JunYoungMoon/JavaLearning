package algorithm;

import java.util.Scanner;

public class ConsecutiveNumberSum2 {
    public int solution(int n) {
        int answer = 0, cnt = 1;
        n--;
        while (n > 0) {
            cnt++;
            n = n - cnt;
            if (n % cnt == 0) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        ConsecutiveNumberSum cns = new ConsecutiveNumberSum();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        System.out.print(cns.solution(n));
    }
}
