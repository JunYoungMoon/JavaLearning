package algorithm;

import java.util.ArrayList;
import java.util.Scanner;

public class InvertedPrimeNumber {
    public boolean isPrime(int num){

    }
    public ArrayList<Integer> solutions(int n, int[] arr){
        ArrayList answer = new ArrayList();
        for (int i = 0; i < n; i++) {
            int tmp = arr[i];

        }

        return answer;
    }
    public static void main(String[] args) {
        InvertedPrimeNumber ipn = new InvertedPrimeNumber();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        for (int x:
             ipn.solutions(n, arr)) {
            System.out.print(x + " ");
        }
    }
}
