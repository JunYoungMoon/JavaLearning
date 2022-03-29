package algorithm;

import java.util.Scanner;

class SortingSelection {
    public int[] solution(int n, int[] arr){
        return arr;
    }

    public static void main(String[] args) {
        SortingSelection ss = new SortingSelection();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=kb.nextInt();
        }
        for (int x: ss.solution(n,arr)
             ) {
            System.out.println(x + " ");
        }
    }
}
