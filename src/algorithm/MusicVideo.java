package algorithm;

import java.util.Scanner;

public class MusicVideo {
    public int count(int[] arr, int capacity){

    }
    public int solution(int n, int m, int[] arr){
        int answer = 0;

        return answer;
    }
    public static void main(String[] args) {
        MusicVideo mv = new MusicVideo();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(mv.solution(n,m,arr));
    }
}
