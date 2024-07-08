package algorithm.inflearn;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 4. 단어 뒤집기
 */
public class Problem4 {
    static void solution(List<? extends CharSequence> list) {
        for (CharSequence item : list) {
            if (item instanceof StringBuffer) {
                ((StringBuffer) item).reverse();
            } else if (item instanceof String) {
                char[] charArray = ((String) item).toCharArray();
                int n = charArray.length;
                for (int i = 0; i < n / 2; i++) {
                    char temp = charArray[i];
                    charArray[i] = charArray[n - 1 - i];
                    charArray[n - 1 - i] = temp;
                }
                System.out.println(new String(charArray));
            } else if (item instanceof StringBuilder) {
                ((StringBuilder) item).reverse();
            }
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int size = kb.nextInt();

        List<StringBuilder> list = new ArrayList<>();

        while (list.size() < size) {
            list.add(new StringBuilder(kb.next()));
        }

        solution(list);
    }
}