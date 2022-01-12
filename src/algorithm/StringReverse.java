package algorithm;

import java.util.ArrayList;
import java.util.Scanner;

public class StringReverse {
    public ArrayList<String> solution(int n, String[] str) {
        ArrayList<String> answer = new ArrayList<>();
//        for (String x : str) {
//            char[] s = x.toCharArray();
//            int lt = 0, rt = x.length() - 1;
//            while (lt < rt) {
//                char tmp = s[lt];
//                s[lt] = s[rt];
//                s[rt] = tmp;
//                lt++;
//                rt--;
//            }
//            String tmp = String.valueOf(s);
//            answer.add(tmp);
//        }

        for (String x : str) {
            char[] s = x.toCharArray();
            int count = x.length();
            int m = count - 1;
            for (int j = (m - 1) >> 1; j >= 0; j--) {
                int k = m - j;
                char tmp = s[j];
                s[j] = s[k];
                s[k] = tmp;
            }
            String tmp = String.valueOf(s);
            answer.add(tmp);
        }
//        for (String x : str) {
//            String tmp = new StringBuilder(x).reverse().toString();
//            answer.add(tmp);
//        }
        return answer;
    }

    public static void main(String[] args) {
        StringReverse SR = new StringReverse();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = kb.next();
        }
        for (String x : SR.solution(n, str)) {
            System.out.println(x);
        }
    }
}
