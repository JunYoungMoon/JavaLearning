package algorithm;

import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class HowManyBigNumberK {
    public int solution(int[] arr, int n, int k) {
        int answer = 0;
        TreeSet<Integer> Tset = new TreeSet<>(Collections.reverseOrder());

        return answer;
    }

    public static void main(String[] args) {
        HowManyBigNumberK hmbn = new HowManyBigNumberK();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(hmbn.solution(arr, n, k));
    }
}
