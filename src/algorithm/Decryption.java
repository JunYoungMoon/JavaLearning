package algorithm;

import java.util.Scanner;

public class Decryption {
    public static String solutions(int n, String str) {
        String answer = "";
        for (int i = 0; i < n; i++) {
            String tmp = str.substring(0, 7).replace('#', '1').replace('*', '0');
            int num = Integer.parseInt(tmp, 2);
            answer = answer + (char) num;
            str = str.substring(7);
        }
        return answer;
    }

    public static void main(String[] args) {
        Decryption d = new Decryption();
        Scanner kb = new Scanner(System.in);
        System.out.println(d.solutions(kb.nextInt(), kb.next()));
    }
}
